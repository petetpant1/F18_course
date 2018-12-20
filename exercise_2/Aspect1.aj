public aspect Aspect1{

	private static final int WRITE_LOCKED = -1, FREE = 0;
	private int numberOfReaders = FREE;


	public synchronized void acquireReadLock() throws InterruptedException {
		while ( numberOfReaders == WRITE_LOCKED) wait();
		numberOfReaders++;
	}

	public synchronized void releaseReadLock(){
		numberOfReaders--;
		if ( numberOfReaders == FREE ) notifyAll();
	}

	public synchronized void acquireWriteLock() throws InterruptedException {
		while ( numberOfReaders != FREE ) wait();
		numberOfReaders = WRITE_LOCKED;
	}

	public synchronized void releaseWriteLock(){
		numberOfReaders = FREE;
		notifyAll();
	}

	pointcut write_Operations(): call (void BinaryTree.insert(int) ) ||
				     call (void BinaryTree.remove(int) );

	before() : write_Operations() {
		try{
			acquireWriteLock();
		} catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}

	}

	after() returning : write_Operations() {
		releaseWriteLock();
	}

	pointcut read_Operations(): call ( void BinaryTree.lookup(int) );

	before() : read_Operations() {
		try{
			acquireReadLock();
			long threadId = Thread.currentThread().getId();
			System.out.println("Thread #"+ threadId +" acquired lock and printing");
		} catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}

	}

	after() returning : read_Operations() {
		releaseReadLock();
	} 

}

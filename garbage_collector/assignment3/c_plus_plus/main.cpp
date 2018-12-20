#include<iostream>


using namespace std;


class Node{

	//the number of the insert that created this node
	protected:
		int number_of_node;

	public:
		virtual void insert_node( ) = 0;	
		virtual void delete_node() = 0;
};



class LinkedList_Node : Node {

	LinkedList_Node *next;
	long i;

	public:
		LinkedList_Node(int number_of_node, int i) {
			this->number_of_node = number_of_node;
			this->next = NULL;
			this->i = i;
		}

		void insert_node(){
		
			if ( this->next == NULL ){
				this->next = new LinkedList_Node(this->number_of_node+1, this->number_of_node+1);
			}else{
				this->next->insert_node();
			}

			return;
		}

		void delete_node(){
			cout<<"dummy deleting\n";
		}


		void print(){
			cout<< "number of node: "<< this->number_of_node << "\n";

			cout << "anothe number" << this->i << "\n";

			if ( this->next != NULL){
				this->next->print();
			}	
			return;
		}


};


int main ( int argc , char* argv[] ) {

	LinkedList_Node *node = new LinkedList_Node(0,0);
	
	node->insert_node();
	node->insert_node();

	node->print();

	cout << sizeof(node) << "\n";


	return 0;	

}

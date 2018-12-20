CC=g++
FLAGS= -c -O2

%.o : %.cpp
	$(CC) $(FLAGS) main.cpp

build: main.o 
	$(CC) -o exe_c++ main.o


clean:
	rm *o exe_c++

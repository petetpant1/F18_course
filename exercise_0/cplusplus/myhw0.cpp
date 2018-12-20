#include<map>
#include<iostream>
#include<vector>

using namespace std;


typedef struct InfoStruct_s{
	
	int dividend;
	map< int, int > OccurenceMap; 
	vector<int> divisors;
	int number_of_occurences;
	int current_index;

}InfoStruct_t;

int main(int argc, char*argv[]){
	
	map< int, InfoStruct_t > InfoMap; 
	vector<InfoStruct_t *> printing_vector; 
	int dividend,divisor,vector_index, divisor_occurence;
	char backslash;

	while ( cin >> dividend >> backslash >> divisor ){

		InfoMap[dividend].dividend = dividend;	

		InfoMap[dividend].divisors.push_back(divisor);	
		
		if ( InfoMap[dividend].OccurenceMap[divisor] == 0 ){
			InfoMap[dividend].number_of_occurences++;
			InfoMap[dividend].OccurenceMap[divisor] = InfoMap[dividend].number_of_occurences;
		}
			 
		printing_vector.push_back(&InfoMap[dividend]);
	}
	
	for ( int i = 0; i < printing_vector.size(); i++ ){

		vector_index = printing_vector[i]->current_index;

		divisor = printing_vector[i]->divisors[vector_index];

		divisor_occurence = printing_vector[i]->OccurenceMap[divisor]; 

		cout << printing_vector[i]->dividend << "|" << divisor <<  "[" << divisor_occurence << 
			" of " << printing_vector[i]->number_of_occurences << "]\n";
		printing_vector[i]->current_index++;
	}	
	return 0;
}




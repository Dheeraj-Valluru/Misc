#include <iostream>
using namespace std;

int main() {

	cout << "array of integers: " << endl;
	int values[3];

	values[0]=88;
	values[1] = 123;
	values[2] = 7;

	cout << values[0] << endl;
	cout << values[1] << endl;
	cout << values[2] << endl;

	cout << endl << "array of doubles: " << endl;

	double numbers[4] = { 4.5, 2.3, 7.2, 8.1 };
	for (int i = 0; i < 4; i++) {
		cout << "Element at index " << i << ": " << numbers[i] << endl;
	}
	 
	int array[5] = { 1,2,3,4,5 };
	for (int i = 0; i < 5; i++) {
		cout << "Calling array position " << i << "Which is " << array[i] << endl;
	}

	string letters[3] = { "hello", "hi", "hey"};
	cout << letters[0] << endl;


	return 0;
}
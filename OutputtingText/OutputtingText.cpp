#include <iostream>

using namespace std;

int main() {

	cout << "Starting program..." << flush; //prints 'Starting program...' BUT it does not create a new line

	cout << "text" << endl; //prints 'text' and ends the line

	cout << "Banana. " << "Apple. " << "Orange. " << endl; //prints 'Banana. Apple. Orange. ' in a new line

	cout << "more text" << endl; //prints 'more text' in next line

	return 0;
}
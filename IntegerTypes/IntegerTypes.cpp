#include <iostream>
#include <limits>

using namespace std;

int main() {
	
	int value = 646464;
	cout << value << endl;
	cout << "Max INT value: " << INT_MAX << endl;
	cout << "Min INT value: " << INT_MIN << endl;

	long int lValue = 234353637;
	cout << lValue << endl;

	short int sValue = -2292;
	cout << sValue << endl;

	cout << "Size of int: " << sizeof(short int) << endl;

	unsigned int uValue = 2929292;

	cout << uValue << endl;

	return 0;

}
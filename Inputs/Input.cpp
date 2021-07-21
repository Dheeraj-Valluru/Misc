#include<iostream>
using namespace std;

int main() {
	
	cout << "Enter you name: " << flush;

	string input;

	cin >> input;

	cout << "You entered: " << input << endl;

	//--------------------------------------------------------

	cout << "Enter your favorite number: " << flush;

	int value;

	cin >> value;

	cout << "You entered: " << value << endl;

	return 0;
}
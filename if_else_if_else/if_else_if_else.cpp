#include <iostream>
using namespace std;

int main() {

	// menu options
	cout << "1. \tAdd new record." << endl;
	cout << "2. \tDelete record." << endl;
	cout << "3. \tView record." << endl;
	cout << "4. \tSearch record." << endl;
	cout << "5. \tQuit record." << endl;

	cout << "Enter your selection: " << flush;

	//number inputted by integer
	int value;
	cin >> value;

	// start of conditionals
	if (value == 1) {
		cout << "Adding new record..." << endl;
	}else if (value == 2) {
		cout << "Deleting record..." << endl;
	}else if (value == 3) {
		cout << "Viewing record..." << endl;
	}else if (value == 4) {
		cout << "Searching for record..." << endl;
	}else if (value == 5) {
		cout << "Quitting..." << endl;
	}else {
		cout << "Invalid input" << endl;
	}

	return 0;
}
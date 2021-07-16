#include <iostream>
using namespace std;

const string password = "hello";
string input;

int main() {


	do {
		cout << "Enter password: " << flush;
		cin >> input;

		if (input != password) {
			cout << "Access denied." << endl;
			cout << "Please try again." << endl;
		}

	} while (input != password);

	cout << "Password accepted." << endl;

	

	return 0;
}

/*
do {
		cout << "Enter password: " << flush;
		cin >> input;

		if (input != password) {
			cout << "Access denied" << endl;

		}

	} while (input != password);

	cout << "Password Accepted" << endl;
*/
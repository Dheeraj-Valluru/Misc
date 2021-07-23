#include <iostream>
using namespace std;

int main() {

	string password = "pass";


	cout << "Enter password: " << flush;

	string input;
	cin >> input;

	cout << "Your input was: " << input << endl;

	if (password == input) {
		cout << "Access granted" << endl;
	}

	if (password != input) {
		cout << "Access denied" << endl;
	}

	return 0;
}
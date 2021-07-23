#include <iostream>
using namespace std;

int main() {
	cout << "1. quit" << endl;
	cout << "2. restart" << endl;
	cout << "3. questions" << endl;


	cout << "Enter which opion you select: " << flush;
	int value;
	cin>>value;

	switch (value) {
	case 1:
		cout << "Quitting..." << endl;
		break;
	case 2:
		cout << "Restarting..." << endl;
		break;
	case 3:
		cout << "One sec..." << endl;
		break;
	default:
		cout << "Please enter a viable menu option" << endl;
	}

	return 0;
}
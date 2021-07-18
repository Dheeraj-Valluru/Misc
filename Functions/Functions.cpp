#include <iostream>
using namespace std;

void showMenu() {
	cout << "1. quit" << endl;
	cout << "2. restart" << endl;
	cout << "3. questions" << endl;
}


int userInput() {
	cout << "Enter which opion you select: " << flush;
	int value;
	cin >> value; 

	return value; //this is the value returned by the function userInput
}

void processSelection(int value) {
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
}




int main() {

	showMenu();
	int value= userInput(); // sets "value" equal to whatever userInput returns
	processSelection(value);

	return 0;
}
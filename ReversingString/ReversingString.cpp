#include <iostream>
using namespace std;

int main() {
	char text[] = { "hello" };

	for (int i = 0; i < sizeof(text); i++) {
		//cout << text[((sizeof(text)) - 1)-i] << flush;
	}

	int k = 0;
	while (true) {
		if (text[k] == 0) {
			break;
		}
		cout << text[((sizeof(text)-2) - k)] << flush;
		k++;
	}

	return 0;
}


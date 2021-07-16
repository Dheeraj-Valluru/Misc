#include <iostream>
#include "Cat.h"
using namespace std;

int main() {

	Cat jim;
	jim.speak();
	jim.makeHappy();

	Cat bob;
	bob.speak();
	bob.makeSad();

	return 0;
}
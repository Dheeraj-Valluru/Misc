#include <iostream>
#include "Cat.h"
using namespace std;

int main() {

	Cat jim;
	jim.makeSad();
	jim.speak();
	
	Cat bob;
	bob.makeHappy();
	bob.speak();

	return 0;
}
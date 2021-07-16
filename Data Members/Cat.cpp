#include <iostream>
#include "Cat.h"
using namespace std;

void Cat::speak() {

	if (happy) {
		cout << "meow" << endl;
	}
	else
		cout << "ssssss!" << endl;
} 

void Cat::makeHappy() {
	happy = true;
}

void Cat::makeSad() {
	happy = false;
}
#include <iostream>
#include <iomanip>
using namespace std;

int main() {

	float fvalue = 76.4;
	cout << sizeof(float) << endl;
	cout << setprecision(20) << fixed << fvalue << endl;

	double dValue = 76.4;
	cout << sizeof(double) << endl;
	cout << setprecision(20) << fixed << dValue << endl;

	long double lValue = 123.456789876543210;
	cout << sizeof(long double) << endl;
	cout << setprecision(20) << fixed << lValue << endl;


	
	return 0;
}
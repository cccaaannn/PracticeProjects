#pragma once
class Calculator {
public:
	Calculator();
	double sum(double num1, double num2);
	double subtract(double num1, double num2);
	double multiply(double num1, double num2);
	double divide(double num1, double num2);
};

Calculator::Calculator() {}

double Calculator::sum(double num1, double num2) {
	return num1 + num2;
}

double Calculator::subtract(double num1, double num2) {
	return num1 - num2;
}

double Calculator::multiply(double num1, double num2) {
	return num1 * num2;
}

double Calculator::divide(double num1, double num2) {
	return num1 / num2;
}

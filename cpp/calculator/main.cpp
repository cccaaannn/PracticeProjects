#include <iostream>
#include "calculator.h"

void menu();

int main() {

    menu();

    std::cin.get();
    return 0;
}

void menu() {
    std::cout << "---------- ---------- Welcome to calculator ---------- ----------" << std::endl << std::endl;

    Calculator calculator = Calculator();

    while (1) {
        int operation;
        double num1;
        double num2;
        double result;

        std::cout << "---------- Please choose operation ----------\n0-exit\n1-sum\n2-subtract\n3-multiply\n4-divide\n: ";
        std::cin >> operation;

        if (!operation) {
            break;
        }
        else {
            std::cout << "Enter num1: ";
            std::cin >> num1;

            std::cout << "Enter num2: ";
            std::cin >> num2;

            switch (operation) {
            case 1:
                result = calculator.sum(num1, num2);
                break;
            case 2:
                result = calculator.subtract(num1, num2);
                break;
            case 3:
                result = calculator.multiply(num1, num2);
                break;
            case 4:
                result = calculator.divide(num1, num2);
                break;
            default:
                continue;
            }

            std::cout << "Result is: " << result << std::endl;
            std::cout << "---------- ---------- ---------- ---------- ----------" << std::endl << std::endl;

        }
    }
}
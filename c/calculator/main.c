#include <stdio.h>
#include <stdlib.h>

void menu();

int main() {
	
    menu();
   
    return 0;
}


void menu() {
    printf("---------- ---------- Welcome to calculator ---------- ----------\n\n");

    while (1) {
        int operation;
        double num1;
        double num2;
        double result;

        printf("---------- Please choose operation ----------\n0-exit\n1-sum\n2-subtract\n3-multiply\n4-divide\n: ");
        int operation_result = scanf("%d", &operation);

        if (operation_result != 1) {
            break;
        }
        else {
            printf("Enter num1: ");
            int num1_result = scanf("%lf", &num1);

            printf("Enter num2: ");
            int num2_result = scanf("%lf", &num2);

            if (num1_result != 1 || num2_result != 1) {
                break;
            }

            switch (operation) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                result = num1 / num2;
                break;
            default:
                continue;
            }

            printf("Result is: %lf\n", result);
            printf("---------- ---------- ---------- ---------- ----------\n\n");

        }
    }

}
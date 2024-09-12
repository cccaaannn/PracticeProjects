package com.can;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void menu() {
        System.out.println("---------- ---------- Welcome to calculator ---------- ----------\n");
        int[] validOperations = {0, 1, 2, 3, 4};

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                int operation;
                double num1;
                double num2;
                double result;

                System.out.print("---------- Please choose operation ----------\n0-exit\n1-sum\n2-subtract\n3-multiply\n4-divide\n: ");

                try {
                    operation = scanner.nextInt();
                    if(IntStream.of(validOperations).noneMatch(x -> x == operation)){
                        throw new IllegalArgumentException();
                    }
                }
                catch (Exception e) {
                    System.out.println("Invalid value entered\n");
                    continue;
                }
                finally {
                    scanner.nextLine();
                }

                if(operation == 0) {
                    break;
                }
                else {
                    try {
                        System.out.print("Enter num1: ");
                        num1 = scanner.nextDouble();

                        System.out.print("Enter num1: ");
                        num2 = scanner.nextDouble();
                    }
                    catch (Exception e) {
                        System.out.println("Invalid value entered\n");
                        continue;
                    }
                    finally {
                        scanner.nextLine();
                    }

                    switch (operation){
                        case 1:
                            result = Calculator.add(num1, num2);
                            break;
                        case 2:
                            result = Calculator.subtract(num1, num2);
                            break;
                        case 3:
                            result = Calculator.multiply(num1, num2);
                            break;
                        case 4:
                            result = Calculator.divide(num1, num2);
                            break;
                        default:
                            continue;
                    }

                    System.out.printf("Result is: %s\n", result);
                    System.out.println("---------- ---------- ---------- ---------- ----------\n");
                }
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }

}

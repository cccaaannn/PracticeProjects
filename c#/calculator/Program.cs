using System;

namespace calculator {
    class Program {

        public static void Menu() {
            Console.WriteLine("---------- ---------- Welcome to calculator ---------- ----------\n");
            int[] validOperations = { 0, 1, 2, 3, 4 };

            while (true) {
                int operation;
                double num1;
                double num2;
                double result;

                Console.Write("---------- Please choose operation ----------\n0-exit\n1-sum\n2-subtract\n3-multiply\n4-divide\n: ");

                try {
                    operation = Convert.ToInt32(Console.ReadLine());
                    if (Array.IndexOf(validOperations, operation) == -1) {
                        throw new ArgumentOutOfRangeException();
                    }
                }
                catch (Exception e) {
                    Console.WriteLine("Invalid value entered\n");
                    continue;
                }

                if (operation == 0) {
                    break;
                }
                else {
                    try {
                        Console.Write("Enter num1: ");
                        num1 = Convert.ToDouble(Console.ReadLine());

                        Console.Write("Enter num1: ");
                        num2 = Convert.ToDouble(Console.ReadLine());
                    }
                    catch (Exception e) {
                        Console.WriteLine("Invalid value entered\n");
                        continue;
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

                    Console.WriteLine("Result is: {0}", result);
                    Console.WriteLine("---------- ---------- ---------- ---------- ----------\n");
                }
            }
        }

        static void Main(string[] args) {
            Menu();
        }
    }
}

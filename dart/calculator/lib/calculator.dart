import 'dart:io';

void menu() {
  print("---------- ---------- Welcome to calculator ---------- ----------\n");
  var validOperations = {0, 1, 2, 3, 4};

  while (true) {
    int operation;
    double num1;
    double num2;
    double result;

    stdout.write(
        "---------- Please choose operation ----------\n0-exit\n1-sum\n2-subtract\n3-multiply\n4-divide\n: ");

    try {
      operation = int.parse(stdin.readLineSync()!);
      if (!validOperations.contains(operation)) {
        print("Invalid operation entered\n");
        continue;
      }
    } on Exception {
      print("Invalid value entered\n");
      continue;
    }

    if (operation == 0) {
      break;
    } else {
      try {
        stdout.write("Enter num1: ");
        num1 = double.parse(stdin.readLineSync()!);

        stdout.write("Enter num1: ");
        num2 = double.parse(stdin.readLineSync()!);
      } on Exception {
        print("Invalid value entered\n");
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

      print("Result is: $result\n");
      print("---------- ---------- ---------- ---------- ----------\n");
    }
  }
}

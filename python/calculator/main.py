def menu():
    print("---------- ---------- Welcome to calculator ---------- ----------\n")
    valid_operations = (0, 1, 2, 3, 4)

    while True:
        operation = input("---------- Please choose operation ----------\n0-exit\n1-sum\n2-subtract\n3-multiply\n4-divide\n: ")
        print()

        try:
            operation = int(operation)
            if(operation not in valid_operations):
                raise ValueError
        except:
            print("Invalid value entered\n")
            continue

        if(operation == 0):
            break
        else:
            try:
                num1 = float(input("Enter num1: "))
                num2 = float(input("Enter num2: "))
            except:
                print("Invalid value entered\n")
                continue

            result = "unknown"
            match operation:
                case 1:
                    result = num1 + num2
                case 2:
                    result = num1 - num2
                case 3:
                    result = num1 * num2
                case 4:
                    result = num1 / num2
                case _:
                    continue

            print(f"Result is: {result}")
            print("---------- ---------- ---------- ---------- ----------\n")

if __name__ == '__main__':
    menu()

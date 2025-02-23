func readMenu() -> Int {
    let validOperations = [0, 1, 2, 3, 4]

    print("---------- Please choose operation ----------\n0-exit\n1-sum\n2-subtract\n3-multiply\n4-divide")
    print(": ", terminator: "")

    if let input = readLine(strippingNewline: true), let unwrappedOperation = Int(input) {
        let operation: Int = unwrappedOperation

        if(!validOperations.contains(operation)) {
            print("Invalid value entered\n")
            return -1
        }

        return operation
    } 
    else {
        print("Invalid value entered\n")
        return -1
    }
}

func readNum(text: String) -> (num: Float, error: Bool) {
    print(text, terminator: "")

    if let input = readLine(strippingNewline: true), let unwrappedNum = Float(input) {
        return (unwrappedNum, false)
    } 
    else {
        return (0, true)
    }
}

enum Operation: Int {
    case sum = 1
    case subtract = 2
    case multiply = 3
    case divide = 4
}

func calculate(num1: Float, num2: Float, operation: Operation) -> Float {
    switch(operation) {
        case .sum:
            return num1 + num2
        case .subtract:
            return num1 - num2
        case .multiply:
            return num1 * num2
        case .divide:
            return num1 / num2
    }
}

func menu() {
    print("---------- ---------- Welcome to calculator ---------- ----------\n")

    while(true) {
        let menuSelection: Int = readMenu()

        if(menuSelection == -1) {
            continue
        }
        if(menuSelection == 0) {
            break
        }

        guard let operation = Operation(rawValue: menuSelection) else {
            print("Invalid operation")
            continue
        }

        let (num1, error1) = readNum(text: "Enter num1: ")
        let (num2, error2) = readNum(text: "Enter num2: ")
        if(error1 || error2) {
            print("Invalid value entered\n")
            continue
        }

        let result: Float = calculate(num1: num1, num2: num2, operation: operation)

        print("Result is: \(result)")
        print("---------- ---------- ---------- ---------- ----------\n")
    }
}

menu()

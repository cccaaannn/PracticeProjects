const prompt = require('prompt-sync')();

function menu() {
    console.log("---------- ---------- Welcome to calculator ---------- ----------\n")
    const validOperations = [0, 1, 2, 3, 4]

    while(true) {
        let num1;
        let num2;
        let operation;
        let result;

        console.log("---------- Please choose operation ----------\n0-exit\n1-sum\n2-subtract\n3-multiply\n4-divide")
        operation = prompt(": ")
        console.log("\n")

        try {
            operation = parseInt(operation)
            if(!(operation in validOperations)) {
                throw new Error
            }
        }    
        catch(e) {
            console.log("Invalid value entered\n")
            continue
        }

        if(operation === 0) {
            break
        }
        else {
            try {
                num1 = parseFloat(prompt("Enter num1: "))
                num2 = parseFloat(prompt("Enter num2: "))
            }
            catch(e) {
                console.log("Invalid value entered\n")
                continue
            }

            result = "unknown"
            switch(operation) {
                case 1:
                    result = num1 + num2
                    break
                case 2:
                    result = num1 - num2
                    break
                case 3:
                    result = num1 * num2
                    break
                case 4:
                    result = num1 / num2
                    break
                default:
                    continue
                }

            console.log(`Result is: ${result}`)
            console.log("---------- ---------- ---------- ---------- ----------\n")
        }
    }
}


menu()
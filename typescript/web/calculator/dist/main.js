"use strict";
function menu() {
    alert("---------- ---------- Welcome to calculator ---------- ----------\n");
    const validOperations = [0, 1, 2, 3, 4];
    while (true) {
        let num1;
        let num2;
        let num1Str;
        let num2Str;
        let operationStr;
        let operation;
        let result = 0;
        operationStr = prompt("---------- Please choose operation ----------\n0-exit\n1-sum\n2-subtract\n3-multiply\n4-divide");
        try {
            if (operationStr == null) {
                throw new Error;
            }
            operation = parseInt(operationStr);
            if (!(operation in validOperations)) {
                throw new Error;
            }
        }
        catch (e) {
            console.log("Invalid value entered\n");
            continue;
        }
        if (operation === 0) {
            break;
        }
        else {
            try {
                num1Str = prompt("Enter num1: ");
                num2Str = prompt("Enter num2: ");
                if (num1Str == null || num2Str == null) {
                    throw new Error;
                }
                num1 = parseFloat(num1Str);
                num2 = parseFloat(num2Str);
            }
            catch (e) {
                console.log("Invalid value entered\n");
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
            alert(`Result is: ${result}\n---------- ---------- ---------- ---------- ----------\n`);
        }
    }
}
menu();

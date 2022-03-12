import promptSync from 'prompt-sync';
const prompt = promptSync();


function menu() {
    console.log("---------- ---------- Welcome to calculator ---------- ----------\n");
    const validOperations: number[] = [0, 1, 2, 3, 4];

    while(true) {
        let num1: number;
        let num2: number;
        let operationStr: string;
        let operation: number;
        let result: number = 0;

        console.log("---------- Please choose operation ----------\n0-exit\n1-sum\n2-subtract\n3-multiply\n4-divide");
        operationStr = prompt(": ");
        console.log("\n");

        try {
            operation = parseInt(operationStr);
            if(!(operation in validOperations)) {
                throw new Error;
            }
        }    
        catch(e) {
            console.log("Invalid value entered\n");
            continue;
        }

        if(operation === 0) {
            break;
        }
        else {
            try {
                num1 = parseFloat(prompt("Enter num1: "));
                num2 = parseFloat(prompt("Enter num2: "));
            }
            catch(e) {
                console.log("Invalid value entered\n");
                continue;
            }

            switch(operation) {
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

            console.log(`Result is: ${result}`);
            console.log("---------- ---------- ---------- ---------- ----------\n");
        }
    }
}


menu();

// npx ts-node main.ts

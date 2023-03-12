use std::io;
use std::io::Write;

fn main() {
    println!("---------- ---------- Welcome to calculator ---------- ----------\n");

    loop {
        print!("---------- Please choose operation ----------\n0-exit\n1-sum\n2-subtract\n3-multiply\n4-divide\n: ");
        let valid_operation_range = 0..5;

        // print does not flushes
        std::io::stdout().flush().expect("Could not flush stdout");
        let mut operation = String::new();
        
        io::stdin()
            .read_line(&mut operation)
            .expect("Failed to read line");

        let operation: u32 = match operation.trim().parse() {
            Ok(num) => num,
            Err(_) => {
                println!("Invalid value entered\n");
                continue;
            },
        };

        if !valid_operation_range.contains(&operation) {
            println!("Invalid value entered\n");
            continue;
        }
        if operation == 0 {
            break;
        }


        print!("\nEnter num1: ");
        std::io::stdout().flush().expect("Could not flush stdout");
        let mut num1 = String::new();

        io::stdin()
            .read_line(&mut num1)
            .expect("Failed to read line");

        let num1: f64 = match num1.trim().parse() {
            Ok(num) => num,
            Err(_) => {
                println!("Invalid value entered\n");
                continue;
            },
        };

        print!("Enter num2: ");
        std::io::stdout().flush().expect("Could not flush stdout");
        let mut num2 = String::new();

        io::stdin()
            .read_line(&mut num2)
            .expect("Failed to read line");

        let num2: f64 = match num2.trim().parse() {
            Ok(num) => num,
            Err(_) => {
                println!("Invalid value entered\n");
                continue;
            },
        };


        let result: f64;
        match operation {
            1 => result = num1 + num2,
            2 => result = num1 - num2,
            3 => result = num1 * num2,
            4 => result = num1 / num2,
            0 | 5..=u32::MAX => {
                println!("Invalid value entered\n");
                continue;
            }
        }

        print!("\nResult is: {result}\n");
        println!("---------- ---------- ---------- ---------- ----------\n");

    }


}

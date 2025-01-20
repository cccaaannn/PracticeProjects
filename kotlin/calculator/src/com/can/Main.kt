package com.can

import kotlin.text.toInt

fun main() {
    println("---------- ---------- Welcome to calculator ---------- ----------\n")
    val validOperations = setOf(0, 1, 2, 3, 4)

    while (true) {
        var operation: Int
        var num1: Double
        var num2: Double
        var result: Double

        print(
                "---------- Please choose operation ----------\n0-exit\n1-sum\n2-subtract\n3-multiply\n4-divide\n: "
        )

        try {
            operation = readLine()?.toIntOrNull() ?: throw IllegalArgumentException()
            if (operation.toInt() !in validOperations) {
                throw IllegalArgumentException()
            }
        } catch (e: Exception) {
            println("Invalid value entered\n")
            continue
        }

        if (operation == 0) {
            break
        } else {
            try {
                print("Enter num1: ")
                num1 = readLine()?.toDoubleOrNull() ?: throw IllegalArgumentException()

                print("Enter num2: ")
                num2 = readLine()?.toDoubleOrNull() ?: throw IllegalArgumentException()
            } catch (e: Exception) {
                println("Invalid value entered\n")
                continue
            }

            result =
                    when (operation) {
                        1 -> num1 + num2
                        2 -> num1 - num2
                        3 -> num1 * num2
                        4 -> num1 / num2
                        else -> continue
                    }

            println("Result is: $result")
            println("---------- ---------- ---------- ---------- ----------\n")
        }
    }
}

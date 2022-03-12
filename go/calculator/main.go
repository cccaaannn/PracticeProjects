package main

import (
	"fmt"
)

func main() {
	menu()
}

func in(itemToCompare uint, items []uint) bool {
	for _, item := range items {
		if itemToCompare == item {
			return true
		}
	}
	return false
}

func menu() {
	fmt.Print("---------- ---------- Welcome to calculator ---------- ----------\n\n")
	validOperations := []uint{0, 1, 2, 3, 4}

	for {
		var operation uint
		var num1 float32
		var num2 float32
		var result float32

		fmt.Print("---------- Please choose operation ----------\n0-exit\n1-sum\n2-subtract\n3-multiply\n4-divide\n: ")
		_, err := fmt.Scan(&operation)

		if !in(operation, validOperations) || err != nil {
			fmt.Print("Invalid value entered\n")
			continue
		}

		if operation == 0 {
			break
		}

		fmt.Print("Enter num1: ")
		_, err2 := fmt.Scan(&num1)

		fmt.Print("Enter num2: ")
		_, err3 := fmt.Scan(&num2)

		if err2 == nil || err3 == nil {
			fmt.Print("Invalid value entered\n")
			continue
		}

		switch operation {
		case 1:
			result = num1 + num2
		case 2:
			result = num1 - num2
		case 3:
			result = num1 * num2
		case 4:
			result = num1 / num2
		default:
			fmt.Print("Invalid value entered\n")
			continue
		}

		fmt.Printf("Result is: %v\n", result)
		fmt.Print("---------- ---------- ---------- ---------- ----------\n\n")
	}
}

// go run .

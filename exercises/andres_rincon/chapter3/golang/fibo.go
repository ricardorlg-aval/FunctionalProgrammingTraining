package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func imperativeFibo(n int) int {
	if n == 0 {
		fmt.Printf("current: %d \n", n)
		return 0
	} else if n == 1 {
		fmt.Printf("current: %d \n", n)
		return 1
	} else {
		fmt.Printf("current: %d, n-1 = %d, n-2 = %d \n", n, n-1, n-2)
		result := imperativeFibo(n-1) + imperativeFibo(n-2)
		fmt.Printf("current: %d, n-1 = %d, n-2 = %d, sum = %d \n", n, n-1, n-2, result)
		return result
	}

}

func main() {
	var input int = 0
	scanner := bufio.NewScanner(os.Stdin)
	fmt.Print("Enter Number: ")
	scanner.Scan()
	text := scanner.Text()
	if len(text) != 0 {
		input, _ = strconv.Atoi(text)
	}
	println(imperativeFibo(input))
}

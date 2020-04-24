package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func loop(n int, first int, second int) int {
	fmt.Printf("current: %d, first = %d, second = %d \n", n, first, second)
	if n == 0 {
		return first
	} else if n == 1 {
		return second
	} else {
		result := loop(n-1, second, (second + first))
		return result
	}

}
func fibo(n int) int {
	return loop(n, 0, 1)
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
	println(fibo(input))
}

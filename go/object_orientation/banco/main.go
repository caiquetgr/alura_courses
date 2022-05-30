package main

import "fmt"

type ContaCorrente struct {
	titular       string
	numeroAgencia int
	numeroConta   int
	saldo         float64
}

func main() {
	contaCorrente := ContaCorrente{titular: "Caique",
		numeroAgencia: 123,
		numeroConta:   321,
		saldo:         5000.30}

	fmt.Println(contaCorrente)
}

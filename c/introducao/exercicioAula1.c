#include <stdio.h>

int main() {

    int primeiroValor;
    int segundoValor;
    
    printf("Digite o primeiro valor: ");
    scanf("%d", &primeiroValor);

    printf("\nDigite o segundo valor: ");
    scanf("%d", &segundoValor);

    printf("\nA soma de %d * %d é %d", primeiroValor, segundoValor, primeiroValor * segundoValor);

}
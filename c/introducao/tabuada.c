#include <stdio.h>

int main() {

    int numero;
    printf("Digite o número até onde a tabuada deve ir: ");
    scanf("%i", &numero);

    for(int i = 1; i <= numero; i++) {
        for (int j = 1; j <= 10; j++) {
            printf("%i x %i = %i\n", i, j, i * j);
        }
        printf("\n");
    }

}
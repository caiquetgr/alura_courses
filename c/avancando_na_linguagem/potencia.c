#include <stdio.h>
#include <math.h>

int potencia(int* resultado, int base, int power) {
    *resultado = pow((double) base, (double) power);
}

int main() {
    int resultado;
    potencia(&resultado, 10, 5);

    printf("%d\n", resultado);
}
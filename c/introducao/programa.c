#include <stdio.h>

int main() {

    printf("******************************************\n");
    printf("* Bem vindo ao nosso jogo de adivinhação *\n");
    printf("******************************************\n");

    int numeroSecreto = 24;

    //printf("O número secreto é %i", numeroSecreto);

    int chute;

    printf("Qual o seu chute? ");
    scanf("%i", &chute);

    printf("Seu chute foi %i\n", chute);

    if (chute == numeroSecreto) {
        printf("Parabéns! Você acertou!");
    } else {
 
        if (chute > numeroSecreto) {
            printf("Seu chute foi maior que o número secreto");
        }

        if (chute < numeroSecreto) {
            printf("Seu chute foi menor que o número secreto");
        }

        printf("Você errou!");
    }

}
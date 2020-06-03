#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define NUMERO_DE_TENTATIVAS 5

int main()
{

    printf("******************************************\n");
    printf("* Bem vindo ao nosso jogo de adivinhação *\n");
    printf("******************************************\n");

    int segundosDesde01Jan1970 = time(0);
    srand(segundosDesde01Jan1970);

    int numeroSecreto = rand() % 100;

    int tentativas = 1;
    double pontos = 1000;
    //printf("O número secreto é %i", numeroSecreto);

    int chute;
    printf("chute: %i\n", chute);

    while (1)
    {
        printf("Tentativa %i\n", tentativas);
        printf("Qual o seu chute? ");
        scanf("%i", &chute);

        printf("Seu chute foi %i\n", chute);

        if (chute < 0)
        {
            printf("Não é permitido chutar número negativo!\n");
            continue;
        }

        int acertou = chute == numeroSecreto;
        int maior = chute > numeroSecreto;

        if (acertou)
        {
            printf("Parabéns! Você acertou!\n");
            break;
        }
        else if (maior)
        {
            printf("Seu chute foi maior que o número secreto\n");
        }
        else
        {
            printf("Seu chute foi menor que o número secreto\n");
        }

        tentativas++;

        //int pontos_perdidos = (chute - numeroSecreto) / 2;
        //double pontos_perdidos = (chute - numeroSecreto) / 2.0;
        double pontos_perdidos = abs(chute - numeroSecreto) / (double) 2;
        pontos -= pontos_perdidos;

    }

    printf("Fim de jogo!\n");
    printf("Você acertou em %i tentativas\n", tentativas);
    printf("Total de pontos: %.2f\n", pontos);

}
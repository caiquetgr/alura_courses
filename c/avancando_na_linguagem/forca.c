#include <stdio.h>
#include <string.h>

// variáveis globais
/*char palavraSecreta[20];
/char chutes[26];
int tentativas = 0;*/

void abertura()
{
    printf("/****************/\n");
    printf("/ Jogo de Forca */\n");
    printf("/****************/\n\n");
}

void chuta(char chutes[], int *tentativas)
{
    char chute;
    printf("Qual letra? ");
    scanf(" %c", &chute);

    chutes[*tentativas] = chute;

    (*tentativas)++;
}

int ja_chutou(char letra, char chutes[], int tentativas)
{

    for (int j = 0; j < tentativas; j++)
    {
        if (chutes[j] == letra)
        {
            return 1;
        }
    }

    return 0;
}

void desenha_forca(char palavraSecreta[], char chutes[], int tentativas)
{

    for (int i = 0; i < strlen(palavraSecreta); i++)
    {

        if (ja_chutou(palavraSecreta[i], chutes, tentativas))
        {
            printf("%c ", palavraSecreta[i]);
        }
        else
        {
            printf("_ ");
        }
    }
}

int main()
{

    abertura();

    char palavraSecreta[20];

    sprintf(palavraSecreta, "MELANCIA");

    int acertou = 0;
    int enforcou = 0;

    char chutes[26];
    int tentativas = 0;

    do
    {
        desenha_forca(palavraSecreta, chutes, tentativas);
        chuta(chutes, &tentativas);

    } while (!acertou && !enforcou);
}

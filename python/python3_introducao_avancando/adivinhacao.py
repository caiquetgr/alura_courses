import random

def jogar():

    print('*********************************')
    print('Bem vindo ao jogo de adivinhação!')
    print('*********************************')

    print('Qual nível deseja jogar?')
    print('1 - Fácil / 2 - Médio / 3 - Difícil')

    nivel = int(input('Escolha: '))

    if(nivel == 1):
        total_de_tentativas = 20
    elif(nivel == 2):
        total_de_tentativas = 10
    else:
        total_de_tentativas = 5

    numero_secreto = random.randrange(1,101)
    pontos = 1000


    for rodada in range(1, total_de_tentativas + 1):
        print('Tentativa {} de {}'.format(rodada, total_de_tentativas))
        chute_str = input('Digite um número entre 1 e 100: ')
        chute = int(chute_str)

        if(chute < 1 or chute > 100):
            print('Você deve digitar um número entre 1 e 100')
            continue

        acertou = chute == numero_secreto
        maior   = chute > numero_secreto
        menor   = chute < numero_secreto

        if(acertou):
            print('Você ganhou! E fez {} pontos!'.format(pontos))
            break
        else:
            if(maior):
                print('Você chutou alto!')
            elif(menor):
                print('Você chutou baixo!')
            pontos -= abs(numero_secreto - chute)


    print('Fim do jogo!')


if(__name__ == "__main__"):
    jogar()
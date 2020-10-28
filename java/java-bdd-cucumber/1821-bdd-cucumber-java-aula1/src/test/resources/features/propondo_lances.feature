#language: pt

Funcionalidade: Propondo lances ao leilao

  Cenario: Propondo um lance valido
    Dado um lance valido
    Quando propoe um lance ao leilao
    Entao o lance eh aceito

  Cenario: Propondo varios lances validos
    Dado um lance de 10.00 reais do usuario "fulano"
    E um lance de 15.00 reais do usuario "beltrano"
    Quando propoe varios lances ao leilao
    Entao os lances sao aceitos

  Esquema do Cenario: Propondo um lance invalido
    Dado um lance inválido de <valor> reais do usuário '<nomeUsuario>'
    Quando propoe um lance ao leilao
    Entao o lance nao eh aceito

    Exemplos:
      | valor |
      | 0     |
      | -1    |

  Cenario: Propondo uma sequência de lances
    Dado dois lances
      | valor | nomeUsuario |
      | 10.0     | fulano      |
      | 15.0    | fulano      |
    Quando propoe varios lances ao leilao
    Entao o segundo lance não é aceitos

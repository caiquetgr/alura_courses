from collections import Counter

import pandas as pd

df = pd.read_csv('busca.csv')

X_df = df[['home', 'busca', 'logado']]
Y_df = df['comprou']

X_dummies = pd.get_dummies(X_df)

X = X_dummies.values
Y = Y_df.values

porcentagem_treino = 0.9
total_dados = len(Y)

quantidade_treino = int(porcentagem_treino * total_dados)
quantidade_teste = int(total_dados - quantidade_treino)

treino_dados = X[:quantidade_treino]
treino_marcacoes = Y[:quantidade_treino]

teste_dados = X[-quantidade_teste:]
teste_marcacoes = Y[-quantidade_teste:]

from sklearn.naive_bayes import MultinomialNB

modelo = MultinomialNB()

modelo.fit(treino_dados, treino_marcacoes)

resultado = modelo.predict(teste_dados)

acertos = resultado == teste_marcacoes

total_de_acertos = sum(acertos)

porcentagem_de_acertos = 100.0 * total_de_acertos / quantidade_teste

print("Acerto: %f (%i/%i)" % (porcentagem_de_acertos, total_de_acertos, quantidade_teste))

#eficacia do algoritmo que chuta tudo o mesmo valor
acertos_base = max(Counter(teste_marcacoes).values())

taxa_de_acerto_base = 100.0 * acertos_base / len(teste_marcacoes)

print('Taxa de acerto base: %.2f' % taxa_de_acerto_base)
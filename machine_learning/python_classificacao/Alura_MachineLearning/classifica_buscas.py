from collections import Counter

import pandas as pd

df = pd.read_csv('busca2.csv')

X_df = df[['home', 'busca', 'logado']]
Y_df = df['comprou']

X_dummies = pd.get_dummies(X_df)

X = X_dummies.values
Y = Y_df.values

porcentagem_treino = 0.8
porcentagem_teste = 0.1
total_dados = len(Y)

quantidade_treino = int(porcentagem_treino * total_dados)
quantidade_teste = int(porcentagem_teste * total_dados)
quantidade_validacao = int(total_dados - porcentagem_treino - porcentagem_teste)

#0 - 799
treino_dados = X[:quantidade_treino]
treino_marcacoes = Y[:quantidade_treino]

#800 - 899
fim_de_teste = quantidade_treino + quantidade_teste

teste_dados = X[quantidade_treino:fim_de_teste]
teste_marcacoes = Y[quantidade_treino:fim_de_teste]

#900 - 999
fim_de_valicadao = fim_de_teste + quantidade_validacao
validacao_dados = X[fim_de_teste:fim_de_valicadao]
validacao_marcacoes =  Y[fim_de_teste:fim_de_valicadao]

def fit_and_predict(nome, modelo, treino_dados, treino_marcacoes, teste_dados, teste_marcacoes):
	modelo.fit(treino_dados, treino_marcacoes)

	resultado = modelo.predict(teste_dados)

	acertos = resultado == teste_marcacoes

	total_de_acertos = sum(acertos)

	porcentagem_de_acertos = 100.0 * total_de_acertos / quantidade_teste

	print("Taxa de acerto do {0}: {1}".format(nome, porcentagem_de_acertos))

	return porcentagem_de_acertos


from sklearn.naive_bayes import MultinomialNB
modelo_nb = MultinomialNB()

acerto_nb = fit_and_predict("MultinomialNB", modelo_nb, treino_dados, treino_marcacoes, teste_dados, teste_marcacoes)

from sklearn.ensemble import AdaBoostClassifier
model_ada = AdaBoostClassifier()

acerto_ada = fit_and_predict("AdaBoost", model_ada, treino_dados, treino_marcacoes, teste_dados, teste_marcacoes)

if acerto_nb > acerto_ada:
	vencedor = modelo_nb
else:
	vencedor = model_ada

resultado = vencedor.predict(validacao_dados)
total_de_acertos_vencedor = sum(resultado == validacao_marcacoes)
taxa_de_acerto_vencedor = 100.0 * total_de_acertos_vencedor / len(validacao_marcacoes)

print('Taxa de acerto do vencedor no mundo real: ', taxa_de_acerto_vencedor)

#eficacia do algoritmo que chuta tudo o mesmo valor
acertos_base = max(Counter(validacao_marcacoes).values())

taxa_de_acerto_base = 100.0 * acertos_base / len(validacao_marcacoes)

print('Taxa de acerto base: %.2f' % taxa_de_acerto_base)
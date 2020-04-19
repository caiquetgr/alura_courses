from collections import Counter
from sklearn.multiclass import OneVsRestClassifier
from sklearn.svm import LinearSVC
from sklearn.cross_validation import cross_val_score

import pandas as pd
import numpy as np

df = pd.read_csv('situacao_cliente.csv')

X_df = df[['recencia', 'frequencia', 'semanas_de_inscricao']]
Y_df = df['situacao']

X_dummies = pd.get_dummies(X_df)

X = X_dummies.values
Y = Y_df.values

porcentagem_treino = 0.8
total_dados = len(Y)

quantidade_treino = int(porcentagem_treino * total_dados)
quantidade_validacao = int(total_dados - porcentagem_treino)

#0 - 799
treino_dados = X[:quantidade_treino]
treino_marcacoes = Y[:quantidade_treino]

validacao_dados = X[quantidade_treino:]
validacao_marcacoes =  Y[quantidade_treino:]

print(len(treino_dados))
print(len(validacao_dados))

modelo = OneVsRestClassifier(LinearSVC(random_state=0))
k = 3
scores = cross_val_score(modelo, treino_dados, treino_marcacoes, cv=k)
print(scores)
print(np.mean(scores))


def fit_and_predict(nome, modelo, treino_dados, treino_marcacoes):
	
	k = 10
	scores = cross_val_score(modelo, treino_dados, treino_marcacoes, cv=k)
	taxa_de_acerto = np.mean(scores)
	
	msg = "Taxa de acerto do {0}: {1}".format(nome, taxa_de_acerto)
	
	print(msg)
	return taxa_de_acerto



resultados = {}

from sklearn.multiclass import OneVsRestClassifier
from sklearn.svm import LinearSVC
modelo = OneVsRestClassifier(LinearSVC(random_state = 0))
modelo.fit(treino_dados, treino_marcacoes)

modelo_oneVsRest = OneVsRestClassifier(LinearSVC(random_state=0))
resultado_oneVsRest = fit_and_predict("OneVsRestClassifier", modelo_oneVsRest, treino_dados, treino_marcacoes)

resultados[resultado_oneVsRest] = modelo_oneVsRest


from sklearn.multiclass import OneVsOneClassifier
modelo_oneVsOne = OneVsOneClassifier(LinearSVC(random_state = 0))
resultado_oneVsOne = fit_and_predict("OneVsOne", modelo_oneVsOne, treino_dados, treino_marcacoes)

resultados[resultado_oneVsOne]  = modelo_oneVsOne


from sklearn.naive_bayes import MultinomialNB
modelo_nb = MultinomialNB()

resultado_multinomialNB = fit_and_predict("MultinomialNB", modelo_nb, treino_dados, treino_marcacoes)

resultados[resultado_multinomialNB] = modelo_nb

from sklearn.ensemble import AdaBoostClassifier
model_ada = AdaBoostClassifier()
 
resultado_adaBoost = fit_and_predict("AdaBoost", model_ada, treino_dados, treino_marcacoes)

resultados[resultado_adaBoost] = model_ada 

maximo = max(resultados)

vencedor = resultados[maximo]

vencedor.fit(treino_dados, treino_marcacoes)

resultado = vencedor.predict(validacao_dados)
total_de_acertos_vencedor = sum(resultado == validacao_marcacoes)
taxa_de_acerto_vencedor = 100.0 * total_de_acertos_vencedor / len(validacao_marcacoes)

print('Taxa de acerto do vencedor no mundo real: ', taxa_de_acerto_vencedor)

#eficacia do algoritmo que chuta tudo o mesmo valor
acertos_base = max(Counter(validacao_marcacoes).values())

taxa_de_acerto_base = 100.0 * acertos_base / len(validacao_marcacoes)

print('Taxa de acerto base: %.2f' % taxa_de_acerto_base)
#!-*- coding: utf-8 -*-

texto1 = "Se eu comprar 5 anos antecipados, eu ganho algum desconto?"
texto2 = "O exercício 15 do curso de Java está com a resposta errada. Pode conferir por favor?"
texto3 = "Existe algum curso para cuidar do marketing da minha empresa?"

import pandas as pd
import numpy as np
from sklearn.model_selection import cross_val_score
import nltk

#nltk.download('punkt')

classificacoes = pd.read_csv("emails.csv")

textos_puros = classificacoes['email']
frases = textos_puros.str.lower()
textos_quebrados = [nltk.tokenize.word_tokenize(frase) for frase in frases]

print(textos_quebrados)

#nltk.download('stopwords')
stopwords = nltk.corpus.stopwords.words('portuguese')

#nltk.download('rslp')
stemmer = nltk.stem.RSLPStemmer()

dicionario = set()

for lista in textos_quebrados:
	validas = [stemmer.stem(palavra) for palavra in lista if palavra not in stopwords and len(palavra) > 2]
	dicionario.update(validas)

total_de_palavras = len(dicionario)

print('total de palavras: ' , total_de_palavras)

tuplas = zip(dicionario, range(total_de_palavras))
tradutor = {palavra: indice for palavra, indice in tuplas}

def vetorizar_texto(texto, tradutor):
	vetor = [0] * len(tradutor)

	for palavra in texto:
		if len(palavra) > 0:
			raiz = stemmer.stem(palavra)
			if raiz in tradutor:
				posicao = tradutor[raiz]
				vetor[posicao] += 1

	return vetor

vetor = [0] * total_de_palavras

texto = textos_quebrados[0]

for palavra in texto:
	if palavra in tradutor:
		posicao = tradutor[palavra]
		vetor[posicao] += 1

vetores_de_texto = [vetorizar_texto(texto, tradutor) for texto in textos_quebrados]

marcas = classificacoes['classificacao']

X = np.array(vetores_de_texto)
Y = np.array(marcas.tolist())

porcentagem_de_treino = 0.8

tamanho_de_treino = int(len(marcas) * porcentagem_de_treino)
tamanho_de_validacao = len(marcas) - tamanho_de_treino

treino_dados = X[:tamanho_de_treino]
treino_marcacoes = Y[:tamanho_de_treino]

validacao_dados = X[tamanho_de_treino:]
validacao_marcacoes = Y[tamanho_de_treino:] 

def fit_and_predict(nome, modelo, treino_dados, treino_marcacoes):
	k = 10
	scores = cross_val_score(modelo, treino_dados, treino_marcacoes, cv=k)
	taxa_de_acerto = np.mean(scores)

	print("Taxa de acerto do {0}: {1}".format(nome, taxa_de_acerto))

	return taxa_de_acerto

from sklearn.multiclass import OneVsRestClassifier
from sklearn.multiclass import OneVsOneClassifier
from sklearn.svm import LinearSVC

from sklearn.naive_bayes import MultinomialNB
from sklearn.ensemble import AdaBoostClassifier

resultados = {}

modeloOneVsRest = OneVsRestClassifier(LinearSVC(random_state = 0))
resultadoOneVsRest = fit_and_predict("OneVsRest", modeloOneVsRest, treino_dados, treino_marcacoes)
resultados[resultadoOneVsRest] = modeloOneVsRest

modeloOneVsOne = OneVsOneClassifier(LinearSVC(random_state = 0))
resultadoOneVsOne = fit_and_predict("OneVsOne", modeloOneVsOne, treino_dados, treino_marcacoes)
resultados[resultadoOneVsOne] = modeloOneVsOne

modeloMultinomialNB = MultinomialNB()
resultadoMultinomial = fit_and_predict("MultinomialNB", modeloMultinomialNB, treino_dados, treino_marcacoes)
resultados[resultadoMultinomial] = modeloMultinomialNB

modeloAdaBoost = AdaBoostClassifier()
resultadoAdaBoost = fit_and_predict("AdaBoost", modeloAdaBoost, treino_dados, treino_marcacoes)
resultados[resultadoAdaBoost] = modeloAdaBoost

print(resultados)

modelo = resultados[max(resultados)]
modelo.fit(treino_dados, treino_marcacoes)

teste_dados = X[-tamanho_de_validacao:]
teste_marcacoes = Y[-tamanho_de_validacao:]

resultado_teste = modelo.predict(teste_dados)

taxa_de_acerto = sum(resultado_teste == teste_marcacoes) * 100 / len(teste_marcacoes)
print('Taxa de acerto do algoritmo vencedor: {0}'.format(taxa_de_acerto))

from collections import Counter

acertos_base = max(Counter(teste_marcacoes).values())

taxa_de_acerto_base = acertos_base * 100 / len(teste_marcacoes)

print('Taxa de acerto base: {0}'.format(taxa_de_acerto_base))
print('Total de elementos testados: {0}'.format(len(teste_marcacoes)))
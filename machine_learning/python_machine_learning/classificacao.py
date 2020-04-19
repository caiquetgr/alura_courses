#eh gordinho? perninha curta? faz auau?
porco1 =    [1, 1, 0]
porco2 =    [1, 1, 0]
porco3 =    [1, 1, 0]
cachorro1 = [1, 1, 1]
cachorro2 = [0, 1, 1]
cachorro3 = [0, 1, 1]

dados = [porco1, porco2, porco3, cachorro1, cachorro2, cachorro3]

marcacoes = [1, 1, 1, -1, -1, -1]

from sklearn.naive_bayes import MultinomialNB

modelo = MultinomialNB()
modelo.fit(dados, marcacoes)

misterioso = [1, 1, 1]
misterioso2 = [1, 0, 0]
misterioso3 = [0, 0, 1]

testes = [misterioso, misterioso2, misterioso3]
marcacoes_teste = [-1, 1, -1]

resultado = modelo.predict(testes)

print(resultado)

diferenca = resultado - marcacoes_teste
print(diferenca)

acertos = [d for d in diferenca if d == 0]
print(acertos)

total_de_acertos = len(acertos)
print('acertos: ', total_de_acertos)

total_de_elementos = len(testes)
print('total de elementos: ', total_de_elementos)

taxa_acerto = 100.0 * total_de_elementos / total_de_acertos
print(taxa_acerto, '%')
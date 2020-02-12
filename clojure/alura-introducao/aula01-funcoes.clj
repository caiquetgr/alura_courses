(defn imprime-mensagem []
  (println "------------------------")
  (println "Bem vindo(a) ao estoque!"))

(imprime-mensagem)

;; Utilizar nomes que deixem claro que a função é pura
;; Ao invés de usar aplicar-desconto, usar valor-descontado, pois dá impressão
;; que terá o mesmo resultado desde que o parâmetro seja o mesmo
(defn valor-descontado 
  "Retorna 90% do valor bruto"
  [valor-bruto]
  (* valor-bruto 0.9))

(defn valor-descontado 
  "Retorna o valor bruto com 10% de desconto"
  [valor-bruto]
  (* valor-bruto (- 1 0.10)))
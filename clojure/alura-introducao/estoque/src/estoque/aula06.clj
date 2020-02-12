(ns estoque.aula06)


(def pedido {:mochila  {:quantidade 2 :preco 10}
             :camiseta {:quantidade 5 :preco 15}})

(defn imprime-e-15
  [valor]
  (println (class valor) "valor" valor)
  15)

(println (map imprime-e-15 pedido))

;(defn imprime-e-15
;  [chave valor]
;  (println chave "e" valor)
;  15)

(defn imprime-e-15
  [[chave valor]]
  (println chave "e" valor)
  15)

(println (map imprime-e-15 pedido))

(defn preco-dos-produtos [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))
(println (reduce + (map preco-dos-produtos pedido)))

(defn preco-dos-produtos [[_ valor]]
  (* (:quantidade valor) (:preco valor)))

(println (reduce + (map preco-dos-produtos pedido)))

; THREADING LAST
; Necessário usar last pois o pedido será passado no final do map/reduce,
; diferentemente do threading first, que ficaria (map ,,, preco-dos-produtos)
(defn total-do-pedido
  [pedido]
  (->> pedido
       (map preco-dos-produtos)
       (reduce +)))

(println (total-do-pedido pedido))

(defn preco-total-do-produto
  [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +)))

(println (total-do-pedido pedido))


; Filtrando
(println "Filtrando")

(def pedido {:mochila  {:quantidade 2, :preco 10}
             :camiseta {:quantidade 2, :preco 15}
             :chaveiro {:quantidade 1}})

(defn gratuito?
  [[_ item]]
  (<= (get item :preco 0) 0))

(println (filter gratuito? pedido))

(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println (filter (fn [[_ item]] (gratuito? item)) pedido))
(println (filter #(gratuito? (second %)) pedido))

(defn pago?
  [item]
  (not (gratuito? item)))

(println (filter #(pago? (second %)) pedido))

; Composição
(println ((comp not gratuito?) {:preco 10}))

(def pago? (comp not gratuito?))

(println (pago? {:preco 10}))
(println (pago? {:preco 0}))

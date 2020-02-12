(ns estoque.aula05)

(def estoque {"Mochila" 10, "Camiseta" 5})

(def estoque {"Mochila"  10
              "Camiseta" 5})

(println estoque)

(println "Temos" (count estoque) "elementos")
(println "Chaves:" (keys estoque))
(println "Valores:" (vals estoque))


; utilizar keywords para chaves

(def estoque {:mochila  10,
              :camiseta 5})

(println (assoc estoque :cadeira 9))
(println (update estoque :mochila inc))
(println (update estoque :mochila #(- % 5)))

(println (dissoc estoque :mochila))



(def pedido {:mochila  {:quantidade 2 :preco 10}
             :camiseta {:quantidade 5 :preco 15}})

(println "\n\n")
(println pedido)
(println (pedido :mochila))
(println (get pedido :mochila))
(println (get pedido :cadeira))
(println (get pedido :cadeira {}))
(println (:mochila pedido))
(println (:cadeira pedido))
(println (:cadeira pedido {}))

(println (:quantidade (:mochila pedido)))

(println (update-in pedido [:mochila :quantidade] inc))

;THREADING FIRST
(println (-> pedido
             :mochila
             :quantidade))
(-> pedido
    :mochila
    :quantidade
    println)

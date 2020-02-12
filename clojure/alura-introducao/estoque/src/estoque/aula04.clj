(ns estoque.aula04)

(def precos [30 700 1000])

(println (precos 0))

;;(println (precos 8)) exception
(println (get precos 8))
(println "valor padrão 0:" (get precos 8 0))

(println (+ 5 1))
(println (inc 5))

(println (update precos 0 inc))
(println (update precos 0 dec))

(defn soma-3
  "Realiza soma de 3 no valor"
  [valor]
  (+ 3 valor))

(println (update precos 0 soma-3))
(println (update precos 0 #(+ 10 %)))

;; map / filter

(println (range 10))
(println (filter even? (range 10)))

(defn aplica-desconto?
  [valor]
  (> valor 100))

(defn valor-descontado
  [valor-bruto]
  (let [taxa-de-desconto (/ 10 100)
        desconto (* valor-bruto taxa-de-desconto)]
    (- valor-bruto desconto)))

(println precos)
(println "filter" (filter aplica-desconto? precos))

(println "map apos o filter" (map valor-descontado (filter aplica-desconto? precos)))

;; reduce

(println (reduce + precos))

(defn soma
  [valor-1 valor-2]
  (println "somando " valor-1 valor-2)
  (+ valor-1 valor-2))

(println (reduce soma precos))
(println (reduce soma 0 precos))


(println (reduce soma [5]))
(println (reduce soma 0 []))
;(println (reduce soma []))

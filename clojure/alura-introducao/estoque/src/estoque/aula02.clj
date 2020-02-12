(ns estoque.aula02)

(defn valor-descontado
  "Retorna o valor descontado que é 90% do valor bruto, se o valor bruto for estritamente maior que 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [desconto (* valor-bruto 0.1)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 1000))

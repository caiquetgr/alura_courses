(defn valor-descontado
  "Retorna o valor bruto com 10% de desconto"
  [valor-bruto]
  (let [desconto 0.10]
    (println "Calculando desconto de" desconto)
    (* valor-bruto desconto)))



(defn valor-descontado
  "Retorna o valor bruto com 10% de desconto"
  [valor-bruto]
  (let [taxa-de-desconto (/ 10 100)
        desconto         (* valor-bruto taxa-de-desconto)]
    (println "Calculando desconto de" (* desconto 100) "%")
    (- valor-bruto desconto)))



(defn valor-descontado
  "Retorna o valor bruto com 10% de desconto se o valor bruto for estritamente maior que 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
      desconto         (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de" (* desconto 100) "%")
      (- valor-bruto desconto)))
   valor-bruto)
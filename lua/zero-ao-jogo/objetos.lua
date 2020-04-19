ultimaCopa = {
    ["ano"] = 2002,
    sede = "Japao",
    jogadores = {"Cafu", "Ronaldo"},
    imprime = function(self)
        for i, v in ipairs(self.jogadores) do
            print(i, v);
        end
    end
}

print(ultimaCopa.ano)
print(ultimaCopa["sede"])

table.insert(ultimaCopa.jogadores, "Ronaldinho")
table.insert(ultimaCopa.jogadores, "Pelé")

table.remove(ultimaCopa.jogadores, 4)

ultimaCopa.imprime(ultimaCopa)
ultimaCopa:imprime()

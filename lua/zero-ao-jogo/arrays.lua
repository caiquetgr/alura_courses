copas = { 1958, 1962, 1970, 1994, 2002 }

print(copas[1])
print(#copas)
copas[10] = 2022
print(#copas)

--for i = 1, #copas do
--    print(i, copas[i])
--end

for indice, valor in pairs(copas) do
    print(indice, valor)
end

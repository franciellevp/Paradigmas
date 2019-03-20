-- Crie uma função isVowel :: Char -> Bool que verifique se um caracter é uma vogal ou não.
isVowel :: Char -> Bool
isVowel c = length (filter (\x -> x == c) "aeiouAEIOU") > 0

-- Escreva uma função addComma, que adicione uma vírgula no final de cada string contida numa lista.
addComma :: [String] -> [String]
addComma listString = map (\string -> string ++ ",") listString

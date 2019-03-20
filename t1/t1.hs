-- 1. Crie uma função isVowel :: Char -> Bool que verifique se um caracter é uma vogal ou não.
isVowel :: Char -> Bool
isVowel c = length (filter (\x -> x == c) "aeiouAEIOU") > 0

-- 2. Escreva uma função addComma, que adicione uma vírgula no final de cada string contida numa lista.
addComma :: [String] -> [String]
addComma listString = map (\string -> string ++ ",") listString

-- 3. Crie uma função htmlListItems :: [String] -> [String], que receba uma lista
-- de strings e retorne outra lista contendo as strings formatadas como itens de lista em HTML.
htmlListItems :: [String] -> [String]
htmlListItems listString = map (\string -> "<LI>" ++ string ++ "</LI>") listString

addHtmlLITag :: String -> String -- função auxiliar para htmlListItemsSemLambda
addHtmlLITag string = "<LI>" ++ string ++ "</LI>"

htmlListItemsSemLambda :: [String] -> [String]
htmlListItemsSemLambda listString = map addHtmlLITag listString

-- 4. Defina uma função que receba uma string e produza outra retirando as vogais,
-- conforme os exemplos abaixo.
removeVowel :: String -> String
removeVowel string = filter (\c -> not(elem c "aeiouAEIOU")) string

removeVowelSemLambda :: String -> String
removeVowelSemLambda string = filter (`notElem` "aeiouAEIOU") string

-- 5. Defina uma função que receba uma string, possivelmente contendo espaços,
-- e que retorne outra string substituindo os demais caracteres por '-', mas mantendo os espaços.
addHyphen :: String -> String
addHyphen string = map (\c -> if c /= ' ' then '-' else ' ') string

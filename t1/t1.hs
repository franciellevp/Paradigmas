import Data.List.Split -- usado no ex 8
import Data.Char -- usada no ex 9

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

-- 6.Escreva uma função que, dado o nome completo de uma pessoa, obtenha seu primeiro nome.
-- Suponha que cada parte do nome seja separada por um espaço e que
-- não existam espaços no início ou fim do nome.
firstName :: String -> String
firstName nome = takeWhile (/= ' ') nome

-- 7.Escreva uma função isInt :: String -> Bool que verifique se uma dada string só contém dígitos de 0 a 9
isInt :: String -> Bool
isInt string = length (filter (\c -> not(elem c "0123456789")) string) == 0

-- 8.Escreva uma função lastName :: String -> String que, dado o nome completo de uma pessoa, obtenha seu último sobrenome.
--Suponha que cada parte do nome seja separada por um espaço e que não existam espaços no início ou fim do nome. 
lastName :: String -> String
lastName nome = last (splitOn " " nome)

-- 9.Escreva uma função que, dado o nome completo de uma pessoa, crie um nome de usuário (login) da pessoa, formado por:
-- primeira letra do nome seguida do sobrenome, tudo em minúsculas.
userName :: String -> String
userName nome = [toLower (head nome)] ++ map toLower (lastName nome)
--[toLower (head (lastName nome))]
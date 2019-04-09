-- Ex1: calcula a soma dos quadrados de dois números x e y.
sumSquares :: Int -> Int -> Int -- funcao que recebe 2 int's e retorna um int
sumSquares x y = x^2 + y^2

-- Ex2: verifica se 2 listas possuem o mesmo primeiro elemento.
hasEqHeads :: [Int] -> [Int] -> Bool -- recebe 2 listas de int's e retorna um bool
-- head::[x] -> x retorna o primeiro elemento de uma lista
hasEqHeads x y = head x == head y -- estrutura condicional if else

-- Ex3: recebe uma lista de nomes e adiciona a string "Super " no início de cada nome.
addSuperAux :: String -> String -- cria uma func auxiliar que add Super à uma string
addSuperAux stringSuper = "Super " ++ stringSuper

addSuper :: [String] -> [String] -- cria a função que usa a auxiliar para add Super em toda a lista
addSuper listNames = map addSuperAux listNames

-- Ex4: retorna o número de espaços em uma string
getSpace :: Char -> Bool
getSpace c = c == ' '
returnSpaces :: String -> String -- recebe uma string e retorna um int
returnSpaces string = filter getSpace string
countSpaces :: String -> Int
countSpaces string = length (returnSpaces string)

-- Ex5: reliza um calculo em todos elementos de uma lista
calc :: [Float] -> [Float] -- buscar convert int to float para 2/n
calc list = map(\n -> 3*n^2 + 2/n + 1) list -- usando lambda p/ calculo

-- Ex6: seleciona só os que negativos de uma lista de nros.
isNegative :: [Float] -> [Float]
isNegative list = filter (\x -> x < 0) list -- usando lambda para testar negativos

-- Ex7: retorna os nros que estao no intervalo [1, 100]
listInterval :: [Float] -> [Float]
listInterval list = filter (\x -> x >= 1 && x <= 100) list

-- Ex8: retorna uma lista com as idades de quem nasceu depois de 1980
returnAges :: [Int] -> [Int]
returnAges list = filter (\x -> 2019 - x == 1980) list

-- Ex9: retorna apenas os nros pares
returnEven :: [Int] -> [Int]
returnEven list = filter (\x -> mod x 2 == 0) list

-- Ex10: verifica se caracter está contido na string
charFound :: Char -> String -> Bool
charFound c string = if (length (filter (\x -> x == c) string) > 0) then True else False

-- Ex11: retorna só os nomes que terminam com a letra 'a'
nameWithA :: [String] -> [String]
nameWithA nomes = filter (\c -> last c == 'a') nomes

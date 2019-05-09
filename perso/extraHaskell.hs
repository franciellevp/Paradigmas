import Control.Monad
-- Problema 1: Primo Rápido
-- Descrição: https://www.urionlinejudge.com.br/judge/pt/problems/view/1221
-- Sieve of Eratosthenes
isPrime :: Int -> String
isPrime n
  | n <= 2 = "Prime"
  | otherwise = if odd n && func 3 then "Prime" else "Not Prime"
  where
    func factor
      | factor > upperLim = True
      | otherwise = n `mod` factor /= 0 && func (factor+2)
      where
        upperLim = (floor.sqrt.fromIntegral) n 

primoRapido :: IO()
primoRapido = do 
    line1 <- getLine
    let nCases = (read line1 :: Int)
    if(nCases >= 1 && nCases <= 200)
        then forM_ [1..nCases] $ \_ -> do
                line2 <- getLine
                let n = read line2 :: Int
                if(n >= 1 && n <= 2^31)
                    then putStrLn $ isPrime n
                    else putStrLn ""
        else putStrLn ""

-- Problema2: Trigo no Tabuleiro
-- Descrição: https://www.urionlinejudge.com.br/judge/pt/problems/view/1169
countGraos :: Int -> Int -> Int -> Int
countGraos i nrCasas graos = 
    if i < nrCasas 
        then graos + countGraos (i + 1) nrCasas graos * 2
    else graos

getKg :: Int -> String
getKg nrCasas = show ( (countGraos 1 nrCasas 1) `quot` 12 `quot` 1000 ) ++ " Kg"

trigoNoTabuleiro :: IO()
trigoNoTabuleiro = do 
    line1 <- getLine
    let nCases = (read line1 :: Int)
    if(nCases >= 1 && nCases <= 100)
        then forM_ [1..nCases] $ \_ -> do
                line2 <- getLine
                let n = read line2 :: Int
                if(n >= 1 && n <= 64)
                    then putStrLn $ getKg n
                    else putStrLn ""
        else putStrLn ""

-- Problema 3: Angry Ducks
-- Descrição: https://www.urionlinejudge.com.br/judge/pt/problems/view/1163
alcanceMaximo :: Float -> Float -> Float -> Float
alcanceMaximo h a v = dx * t
    where dx = v * cos(toRad a) -- distancia horizontal
          g =  9.80665::Float -- aceleração da gravidade
          t = v / g * (sin(toRad a) + sqrt(sin(toRad a) * sin(toRad a) + 2 * (g * h / v ^ 2) )) -- tempo de delocamento

toRad :: Float -> Float
toRad angle = angle * pi / 180.0

testAcerto :: Float -> Int -> Int -> String
testAcerto alcance p1 p2 = if(alcance >= fromIntegral(p1) && alcance <= fromIntegral(p2))
    then show (alcance) ++ " -> DUCK"
    else show (alcance) ++ " -> NUCK"

angryDucks :: IO()
angryDucks = do
    line1 <- getLine
    let h = (read line1 :: Float) -- altura do bodoque
    line2 <- getLine
    let p1 = (read line2 :: Int) -- p1, onde começa Nlogonia
    line3 <- getLine
    let p2 = (read line3 :: Int) -- p2, onde termina Nlogonia
    line4 <- getLine
    let nCases = (read line4 :: Int)  -- tentativas de acertar Nlogonia
    if(nCases >= 1 && nCases <= 100 && h>=1 && h<=150 && p1 >=1 && p1 <= 9999 && p2 >=1 && p2 <= 9999 )
       --  ângulo α (1 ≤ α ≤ 180) e a velocidade V (1 ≤ V ≤ 150) do disparo.
        then forM_ [1..nCases] $ \_ -> do
                line5 <- getLine
                let a = read line5 :: Float -- angulo do disparo
                line6 <- getLine
                let v = read line6 :: Float -- velocidade do disparo
                if(a >= 1 && a <= 180 && v >=1 && v <= 150)
                    then putStrLn( testAcerto (alcanceMaximo h a v ) p1 p2 )
                    else putStrLn "Entrada Inválida"
        else putStrLn ""

-- Problema 3: A Câmara Secreta
-- Descrição: https://www.urionlinejudge.com.br/judge/pt/problems/view/1839

-- Problema 4: Vampiros
-- Descrição: https://www.urionlinejudge.com.br/judge/pt/problems/view/1093
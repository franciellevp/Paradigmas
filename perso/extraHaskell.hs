import Control.Monad

-- Problema 1: Primo Rápido
-- Descrição: https://www.urionlinejudge.com.br/judge/pt/problems/view/1221

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

-- Problema 10: Integral
-- Descrição: https://www.urionlinejudge.com.br/judge/pt/problems/view/1230
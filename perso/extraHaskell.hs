-- Problema 1: Primo Rápido
-- Descrição: https://www.urionlinejudge.com.br/judge/pt/problems/view/1221

-- Problema2: Trigo no Tabuleiro
-- Descrição: https://www.urionlinejudge.com.br/judge/pt/problems/view/1169
countGraos :: Int -> Int -> Int -> Int
countGraos i nrCasas graos = 
    if i < nrCasas 
        then graos + countGraos (i + 1) nrCasas graos * 2
    else graos

trigoNoTabuleiro :: Int -> IO()
trigoNoTabuleiro nrCasas = putStrLn (show ( (countGraos 1 nrCasas 1) `quot` 12 `quot` 1000 ) ++ " Kg")

-- Problema 3: Angry Ducks
-- Descrição: https://www.urionlinejudge.com.br/judge/pt/problems/view/1163

-- Problema 4: Blobs
-- Descrição: https://www.urionlinejudge.com.br/judge/pt/problems/view/1170

-- Problema 10: Integral
-- Descrição: https://www.urionlinejudge.com.br/judge/pt/problems/view/1230
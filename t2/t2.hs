import Text.Printf

type Point     = (Float,Float)
type Rect      = (Point,Float,Float)
type Circle    = (Point,Float)

-------------------------------------------------------------------------------
-- Paletas
-------------------------------------------------------------------------------
rgbPalette :: Int -> [(Int,Int,Int)]
rgbPalette n = take n $ cycle [(255,0,0),(0,255,0),(0,0,255)]

greenPalette :: Int -> [(Int,Int,Int)] -- desenha as cores dos circulos em RGB
greenPalette n = [(0, c + i * 10, 0) | i <- [0..n], c <- take 5 (iterate (20+) 80) ]

bluePalette :: Int -> [(Int,Int,Int)]
bluePalette n = [(0, 0, c) | c <- take n (iterate (10+) 80) ]

redPalette :: Int -> [(Int,Int,Int)] -- desenha as cores dos circulos em RGB
redPalette n = [(c, 0, 0) | c <- take n (iterate (10+) 80) ]

greenPalette2 :: Int -> [(Int,Int,Int)] -- desenha as cores dos circulos em RGB
greenPalette2 n = [(0, c, 0) | c <- take n (iterate (10+) 80) ]

hslPalette :: Int -> [(Int,String,String)] -- desenha as cores dos circulos em HSL
hslPalette n = [(x, "100%", "50%") | x <- take n (iterate (-31+) 448) ]

-------------------------------------------------------------------------------
-- Geração de Lista de retângulos em suas posições
-------------------------------------------------------------------------------
-- (m*(w+gap), n*(w+gap)) -> é o ponto x y q o retangulo é desenhado
-- m <- [0..fromIntegral (n-1)] -> faz com que 'm' varie de 0 a 9 (nesse caso)
genRectsInLine :: Int -> [Rect]
genRectsInLine n = [((m*(w+gap), n*(w+gap)), w, h) | m <- [0..fromIntegral (n-1)], n <- [0..fromIntegral(4)]]
  where (w,h) = (50,50) -- determina dimensões dos retângulos 50x50
        gap = 10

-------------------------------------------------------------------------------
-- Geração de Lista de círculos que formam um círculo
-------------------------------------------------------------------------------
genCirclesInCircle :: Int -> [Circle] -- bolinhas separadas por um angulo de 30 graus
genCirclesInCircle n = [( (px + 50 * sin((graus * x) * divRad), py + 50 * cos((graus * x) * divRad) ), r ) | x <- [0..fromIntegral(n-1)]]
  where r = 10 -- tamanhao do raio dos círculos
        graus = fromIntegral(360) / fromIntegral(n) -- de qts em qts graus cada bolinha vai "andar"
        divRad = pi / fromIntegral(180) -- divisão para obter angulo em radianos
        px = 100 -- coordenadas xy do circulo central
        py = 100

-------------------------------------------------------------------------------
-- Geração de Lista de círculos que formam uma curva cossenoide
-------------------------------------------------------------------------------
genCirclesInCurve :: Int -> [Circle] -- bolinhas separadas por um angulo de 30 graus
genCirclesInCurve n = [(( 0 * y + x, px * y - a * cos((graus + x) * divRad) ), r) | y <- [1..3], x <- take n (iterate (30+) 80)]
  where r = 20 -- tamanhao do raio dos círculos
        graus = fromIntegral(360) / fromIntegral(n) -- de qts em qts graus cada bolinha vai "andar"
        divRad = pi / fromIntegral(180) -- divisão para obter angulo em radianos
        px = 100 -- distancia entre as ondas
        a = 50 -- amplitude da onda

-------------------------------------------------------------------------------
-- Strings SVG
-------------------------------------------------------------------------------
-- Gera string representando retângulo SVG 
-- dadas coordenadas e dimensoes do retângulo e uma string com atributos de estilo
svgRect :: Rect -> String -> String 
svgRect ((x,y),w,h) style = 
  printf "<rect x='%.3f' y='%.3f' width='%.2f' height='%.2f' style='%s' />\n" x y w h style

-- Gera string representando um círculo SVG
-- dadas coordenadas e raio de um círculo e uma string com atributos de estilo
svgCirc :: Circle -> String -> String 
svgCirc ((x,y),r) style = 
  printf "<circle cx='%.3f' cy='%.3f' r='%.2f' style='%s'/>\n" x y r style

-- String inicial do SVG
svgBegin :: Float -> Float -> String -- passa o width e height do arquivo
svgBegin w h = printf "<svg width='%.2f' height='%.2f' xmlns='http://www.w3.org/2000/svg'>\n" w h 

-- String final do SVG
svgEnd :: String
svgEnd = "</svg>"

-- Gera string com atributos de estilo para uma dada cor
-- Atributo mix-blend-mode permite misturar cores
svgStyle :: (Int,Int,Int) -> String
svgStyle (r,g,b) = printf "fill:rgb(%d,%d,%d); mix-blend-mode: screen;" r g b

-- Gera string com atributos de estilo para uma dada cor
svgStyle2 :: (Int,String,String) -> String
svgStyle2 (h,s,l) = printf "fill:hsl(%d,%s,%s); mix-blend-mode: screen;" h s l

-- Gera strings SVG para uma dada lista de figuras e seus atributos de estilo
-- Recebe uma funcao geradora de strings SVG, uma lista de círculos/retângulos e strings de estilo
svgElements :: (a -> String -> String) -> [a] -> [String] -> String
svgElements func elements styles = concat $ zipWith func elements styles

-------------------------------------------------------------------------------
-- Função principal que gera arquivo com imagem SVG
-------------------------------------------------------------------------------
-- pallete => RGB de cada quadradinho
-- rects => Lista dos retangulos em suas posições
-- svgRect => retorna a string com o codigo de retangulo em SVG
genCase1 :: IO ()
genCase1 = do
  writeFile "case1.svg" $ svgstrs
  where svgstrs = svgBegin w h ++ svgfigs ++ svgEnd -- tam da img svg + toda a string da figura + svgEnd
        svgfigs = svgElements svgRect rects (map svgStyle palette)
        rects = genRectsInLine nrects
        palette = greenPalette nrects
        nrects = 10 -- nro de retangulos
        (w,h) = (1500,500) -- width,height da imagem SVG


genCase2 :: IO ()
genCase2 = do
  writeFile "case2.svg" $ svgstrs
  where svgstrs = svgBegin w h ++ svgfigs ++ svgEnd -- tam da img svg + toda a string da figura + svgEnd
        svgfigs = svgElements svgCirc circles (map svgStyle2 palette)
        circles = genCirclesInCircle nCircles
        palette = hslPalette nCircles
        nCircles = 12 -- nro de círculos
        (w,h) = (1500,500) -- width,height da imagem SVG

genCase4 :: IO ()
genCase4 = do
  writeFile "case4.svg" $ svgstrs
  where svgstrs = svgBegin w h ++ svgfigs ++ svgEnd -- tam da img svg + toda a string da figura + svgEnd
        svgfigs = svgElements svgCirc circles (map svgStyle palette)
        circles = genCirclesInCurve nCircles
        palette = redPalette nCircles ++ greenPalette2 nCircles ++ bluePalette nCircles
        nCircles = 14 -- nro de círculos
        (w,h) = (1500,500) -- width,height da imagem SVG
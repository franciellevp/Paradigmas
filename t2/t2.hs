import Text.Printf

type Point     = (Float,Float)
type Rect      = (Point,Float,Float)
type Circle    = (Point,Float)

-------------------------------------------------------------------------------
-- Paletas
-------------------------------------------------------------------------------
rgbPalette :: Int -> [(Int,Int,Int)]
rgbPalette n = take n $ cycle [(255,0,0),(0,255,0),(0,0,255)]

greenPalette :: Int -> [(Int,Int,Int)] -- desenha as cores dos retangulos em RGB
greenPalette n = [(0, c + i * 10, 0) | i <- [0..n], c <- take 5 (iterate (20+) 80) ]

-------------------------------------------------------------------------------
-- Geração de Lista de retângulos em suas posições
-------------------------------------------------------------------------------
-- (m*(w+gap), n*(w+gap)) -> é o ponto x y q o retangulo é desenhado
-- m <- [0..fromIntegral (n-1)] -> faz com que 'm' varie de 0 a 9 (nesse caso)
genRectsInLine :: Int -> [Rect]
genRectsInLine n = [((m*(w+gap), n*(w+gap)), w, h) | m <- [0..fromIntegral (n-1)], n <- [0..fromIntegral (4)]]
  where (w,h) = (50,50) -- determina dimensões dos retângulos 50x50
        gap = 10

-------------------------------------------------------------------------------
-- Strings SVG
-------------------------------------------------------------------------------

-- Gera string representando retângulo SVG 
-- dadas coordenadas e dimensoes do retângulo e uma string com atributos de estilo
svgRect :: Rect -> String -> String 
svgRect ((x,y),w,h) style = 
  printf "<rect x='%.3f' y='%.3f' width='%.2f' height='%.2f' style='%s' />\n" x y w h style

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
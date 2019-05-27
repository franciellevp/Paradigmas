1. Quais os nomes de classes definidas nos arquivos DesktopLauncher.java e Drop.java?
R: DesktopLauncher e Drop, respectivamente.

2. Explique como o conceito de herança se aplica a ambas as classes.
Em DesktopLauncher:
O método main consegue acessar diretamente os atributos da classe LwjglApplicationConfiguration

Em Drop:
A classe extende ApplicationAdapter, herdando todos os métodos e atributos public e protected.
Como na classe ApplicationAdapter já existe os métodos com as assinaturas
public void create(); public void render() e public void dispose(), é necessário subscrevê-los usando '@Override' para modificar os métodos na classe Drop.

3. Em qual classe estão os atributos que representam as gotas que "caem" no balde?
Na classe Drop, sendo os atributos setados no método spawnRaindrop().

4. Quais são os atributos do jogo que representam a imagem e a posição das gotas?
dropImage e bucketImage, na classe Drop.

5. O que significam as anotações @Override em Drop.java?
Subscrita, alterar métodos/atributos sem modificar os métodos originais ou criar um novo.

6. Em Drop.java, no método spawnRaindrop():
7. É possível deduzir qual a visibilidade (public, private, protected) do atributo raindrop.x?
A visibilidade é public, pois se fosse private só seria possível acessar através de getters/setters e para ser protected a classe Drop deveria extender a classe Rectangle().

8. Ainda no método spawnRaindrop(), MathUtils é um nome de classe ou uma referência para um objeto?
É uma classe.

9. raindrop é um nome de classe ou uma referência para um objeto?
É uma referência à um objeto Rectangle().

10. Em spawnRaindrop(), por que lastDropTime pode ser usado sem estar declarado dentro deste método?
Porque lastDropTime é um atributo da própria classe.






















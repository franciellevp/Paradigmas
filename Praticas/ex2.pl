% obs: onde tem warning substituir por _
  % variǘel n utilizada

% A faz parte da Lista L??
is_member(A, [A|T]).
is_member(A, [_|T]) :- % qqlr coisa menos o A, procura o tail
  is_member(A, T).

% A e B estão juntos? esquerda ou direita
ao_lado(A, B, [A|[B|T]]). % A é head da lista e B é head do Tail da lista de A
ao_lado(A, B, [B|[A|T]]).
ao_lado(X, Y, [H|T]) :-
  ao_lado(X, Y, T).

aoLadoDireito(A, B, [A|[B|T]]).
aoLadoDireito(X, Y, [H|T]) :- aoLadoDireito(X, Y, T).

% A e B possuem um elemento entre eles?
um_entre(A, B, [A|[_| [B|T] ]]).% B é head do tail do elemento head do Tail de A
um_entre(A, B, [B|[_| [A|T] ]]).
um_entre(X, Y, [H|T]) :-
  um_entre(X, Y, T).

% Esquadrilha de Aviões
solucao(Avioes, Piloto, Cor, Anomalia, Bebida, Esporte) :-
  avioes = [_, _, _, _, _], %  Piloto  Cor  Anomalia  Bebida  Esporte
  is_member(aviao(milton, vermelha, _, _, _), avioes), % O avião do Cel. Milton solta fumaça vermelha.
  is_member(aviao(walter, _, radio, _, _), avioes), % O rádio transmissor do Ten. Walter está com problemas.
  is_member(aviao(_, verde, _, _, pesca), avioes), % O piloto do avião que solta fumaça verde adora pescar.
  is_member(aviao(rui, _, _, _, futebol), avioes), % O Major Rui joga futebol nos finais de semana.
  aoLadoDireito( aviao(_, verde, _, _, _), aviao(_, branca, _, _, _)), % O avião que solta fumaça verde está imediatamente à direita do avião que solta fumaça branca.
  is_member(aviao(_, _, altimetro, leite, _), avioes), % O piloto que bebe leite está com o altímetro desregulado.
  is_member(aviao(_, preta, _, cerveja, _), avioes), % O piloto do avião que solta fumaça preta bebe cerveja.
  is_member(aviao(_, vermelha, _, _, natacao), avioes), % O praticante de natação pilota o avião que solta fumaça vermelha.
  [aviao(farfarelli, _, _, _, _)|_] = Avioes, % O Cap. Farfarelli está na ponta esquerda da formação.
  ao_lado( aviao(_, _, _, cafe, _), aviao(_, _, hidraulco, _, _), avioes ), % O piloto que bebe café voa ao lado do avião que está com pane no sistema hidráulico.
  ao_lado( aviao(_, _, _, cerveja, _), aviao(_, _, bussola, _, _), avioes ), % O piloto que bebe cerveja voa ao lado do piloto que enfrenta problemas na bússola.
  is_member(aviao(_, _, _, cha, equitacao), avioes), % O homem que pratica equitação gosta de beber chá.
  is_member(aviao(nascimento, _, _, agua, _), avioes), % O Cap. Nascimento bebe somente água.
  aoLadoDireito( aviao(farfarelli, _, _, _, _), (_, azul, _, _, _), avioes ), % O Cap. Farfarelli voa ao lado do avião que solta fumaça azul.
  um_entre( aviao(_, _, hidraulico, _, _), aviao(_, _, altimetro, _, _), avioes ). % Na formação, há um avião entre o que tem problema hidráulico e o com pane no altímetro.

localizado_em(santa_maria, rs).
localizado_em(salvador, bahia).
localizado_em(rs, brasil).
localizado_em(bahia, brasil).
localizado_em(paris, franca).
localizado_em(franca, europa).

nasceu_em(andre, santa_maria).
nasceu_em(joao, salvador).
nasceu_em(joana, salvador). %"Joana nasceu em Salvador."
nasceu_em(michel, paris).

nasceu_em(X, Y) :- localizado_em(Z, Y), nasceu_em(X, Z).

mora_em(andre, paris).
mora_em(joao, salvador).
mora_em(X, Y) :- localizado_em(Z, Y), mora_em(X, Z).

idade(andre, 25).
idade(joao, 32).
idade(joana, 22). %"Joana tem 22 anos."
idade(michel, 40).

gaucho(X) :- nasceu_em(X, rs).
brasileiro(X) :- nasceu_em(X, brasil).
europeu(X) :- nasceu_em(X, europa).

% EX 3
%"José nasceu no Brasil?"
%%%nasceu_em(jose, brasil).

%"Quais são as pessoas nascidas na Europa?"
%%europeu(X).

%"Quais são as pessoas com mais de 30 anos?"
%%idade(X, Y), X > 30.

%"Quem são os brasileiros com menos de 30 anos?"
%%brasileiro(X), idade(X, I), I < 30.


%EX 4
maisVelho(A, B) :- idade(A, Idade1), idade(B, Idade2), Idade1 > Idade2.

%EX 5
soma(A, B, C) :- C is A + B.
pred(A, B, C) :- X is (A+B)^2, C is X*2+1.

%EX 6
% OBS: ñ usar predicado como função que retorna alguma coisa.
anoNasc(P, A) :- idade(P, Y), A is 2019 - Y.

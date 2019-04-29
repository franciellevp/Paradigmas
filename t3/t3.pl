% Ex 1
odd(N) :- mod(N, 2) =\= 0 .

% Ex 2
hasN([],0).
hasN([_|T],N) :-
  N > 0,
  I is N - 1,
  hasN(T, I) .

% Ex 3
inc99([], []).
inc99([H|T], [C|R]) :-
  inc99(T, R),
  C is H + 99 .

% Ex 4
incN([], [], _).
incN([H|T], [C|R], N) :-
  incN(T, R, N),
  C is H + N .

% Ex 5
comment([], []).
comment([H|T], [C|R]) :-
  comment(T, R),
	atom_concat("%%", H, C) .

% Ex 6
onlyEven([], []).
onlyEven([H|T], L) :- odd(H), onlyEven(T, L).
onlyEven([H|T], [H|R]) :- % o head deve estar na Lista Resultante
  mod(H, 2) =:= 0,
  onlyEven(T, R) .

% Ex 7
countdown(0, []).
countdown(N, [H|T]) :-
  N > 0,
  H is N,
  I is N - 1,
  countdown(I, T) .

% Ex 8
nRandoms(0, []).
nRandoms(N, [H|T]) :-
  N > 0,
  random(-999, 999, H),
  I is N - 1,
  nRandoms(I, T) .

% Ex 9
potN0(0, [1]).
potN0(N, [H|T]) :-
  N > 0,
  H is 2 ^ N,
  I is N - 1,
  potN0(I, T) .

% Ex 10
zipmult([], [], []).
zipmult([H|T], [C|R], [Head, Tail]) :-
  Head is H * C,
  zipmult(T, R, Tail) .

% Ex 9
count(0, 0).
count(I, N) :-
  I < N,
  R is I + 1,
  count(R, N) .

potencias(0, []).
potencias(N, [H|T]) :-
  N > 0,
  I is N - 1,
  H is 2 ^ I,
  potencias(I, T) .

% Ex 1
odd(N) :- mod(N, 2) \= 0 .


% Ex 2
hasN([],0).
hasN([_|T],N) :-
  N > 0,
  I is N - 1,
  hasN(T, I) .

% Ex 3
inc99([], _).
inc99([H,T], L2) :-
  R is H+99,
  L2 = [R|T].

% Ex 4
incN([], _, _).
incN([H|T], L2, _) :-
  R is H+99,
  L2 = [R|T].

% Ex 5
comment([], []).
comment([H|T], L2) :-
  atom_concat("%%", H, R),
  L2 = [R|T].

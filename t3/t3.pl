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
    C is H + 99.

% Ex 4
incN([], [], _).
incN([H|T], [C|R], N) :- 
    incN(T, R, N), 
    C is H + N.

% Ex 5
comment([], []).
comment([H|T], [C|R]) :- 
    comment(T, R), 
	atom_concat("%%", H, C).

onlyEven([], []).
onlyEven([H|T], L) :- odd(H), onlyEven(T, L).
onlyEven([H|T], [H|R]) :- 
    mod(H, 2) =:= 0,
    onlyEven(T, R).

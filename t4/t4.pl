vitima(anita).
insano(adriano).
insano(maria).
pobre(bia).
pobre(pedro).
pobre(maria).
temDinheiro(caren).
temDinheiro(alice).
temDinheiro(henrique).
temDinheiro(adriano).

relacionamento(anita, bernardo).
relacionamento(bernardo, caren).
relacionamento(anita, pedro).
relacionamento(pedro, alice).
relacionamento(alice, henrique).
relacionamento(henrique, maria).
relacionamento(maria, adriano).
relacionamento(adriano, caren).

% Locais
segunda(pedro, santaMaria).
segunda(caren, portoAlegre).
segunda(henrique, apartamento).
segunda(bia, apartamento).
segunda(adriano, apartamento).
segunda(alice, apartamento).
segunda(bernardo, santaMaria).
segunda(maria, apartamento).

terca(pedro, santaMaria).
terca(caren, portoAlegre).
terca(henrique, portoAlegre).
terca(bia, portoAlegre).
terca(adriano, apartamento).
terca(alice, portoAlegre).
terca(bernardo, santaMaria).
terca(maria, santaMaria).

quarta(pedro, portoAlegre).
quarta(caren, portoAlegre).
quarta(henrique, apartamento).
quarta(bia, portoAlegre).
quarta(adriano, santaMaria).
quarta(alice, portoAlegre).
quarta(bernardo, portoAlegre).
quarta(maria, santaMaria).

quinta(pedro, santaMaria).
quinta(caren, santaMaria).
quinta(henrique, apartamento).
quinta(bia, santaMaria).
quinta(adriano, apartamento).
quinta(alice, apartamento).
quinta(bernardo, santaMaria).
quinta(maria, santaMaria).

sexta(pedro, apartamento).
sexta(caren, apartamento).
sexta(henrique, apartamento).
sexta(bia, apartamento).
sexta(adriano, apartamento).
sexta(alice, apartamento).
sexta(bernardo, apartamento).
sexta(maria, apartamento).

acesso(X, Y) :- (
        bastao(X),
        Y = bastao ; 
        martelo(X) ,
        Y = martelo
    ),
    chave(X),
    presenteCrime(X).

motivo(P, R) :-
    insano(P),
    R = insanidade.
motivo(P, R) :-
    dinheiro(P),
    R = dinheiro.
motivo(P, R) :-
    ciumes(P),
    R = ciumes.

presenteCrime(P) :-
    sexta(P, apartamento) ;
    quinta(P, apartamento) .

% o motivo foi dinheiro
dinheiro(P) :- pobre(P).

% o motivo foi ciumes
ciumes(P) :-
    relacionamento(anita, P2),
    relacionamento(P2, P).

chave(bia).
% A chave foi roubada na segunda-feira em Santa Maria ou na terça-feira em Porto Alegre.
chave(P) :-
    segunda(P, santaMaria);
    terca(P, portoAlegre) .

% O bastão de baseball que foi roubado do amigo pobre de Anita, Bernardo, na quinta-feira em Porto Alegre ou na quarta-feira em Santa Maria
bastao(P) :-
    quinta(P, portoAlegre);
    quarta(P, santaMaria) .

% O martelo que foi roubado da caixa de ferramentas do apartamento na quarta ou na quinta-feira.
martelo(P) :-
    quarta(P, apartamento) ;
    quinta(P, apartamento).

assassino(Pessoa, Motivo, Arma) :- motivo(Pessoa, Motivo), acesso(Pessoa, Arma).
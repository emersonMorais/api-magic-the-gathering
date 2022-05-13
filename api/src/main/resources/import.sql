INSERT INTO players(name)values('Emerson');
INSERT INTO players(name)values('Jhon');
INSERT INTO players(name)values('Jess');
INSERT INTO players(name)values('Gustavo');
INSERT INTO players(name)values('Anderson');
INSERT INTO players(name)values('Teresa');

INSERT INTO decks(name, player_id)values('Floresta', 1);
INSERT INTO decks(name, player_id)values('Ilha', 2);
INSERT INTO decks(name, player_id)values('Planicies', 1);
INSERT INTO decks(name, player_id)values('' , 2);
INSERT INTO decks(name, player_id)values('Pantanos', 3);
INSERT INTO decks(name, player_id)values('Meu deck', 1);

INSERT INTO cards(edition, foil, language, name, price, quantity) values ('SLD', true, 'Eng', 'Tudo que reluz', 0.22, 2);
INSERT INTO cards(edition, foil, language, name, price, quantity) values ('CLB', false, 'PT', 'Arcone da Absolvição', 0.28, 1);
INSERT INTO cards(edition, foil, language, name, price, quantity) values ('AS', true, 'Eng', 'Tática do Vale Arden', 0.22, 2);
INSERT INTO cards(edition, foil, language, name, price, quantity) values ('AS', false, 'Eng', 'Arcone da Salvação', 0.43, 1);
INSERT INTO cards(edition, foil, language, name, price, quantity) values ('CLB', true, 'Eng', 'Competidora Aclamada', 0.40, 2);
INSERT INTO cards(edition, foil, language, name, price, quantity) values ('CLB', true, 'Eng', 'Competidora Aclamada', 0.40, 2);

INSERT INTO tb_card_deck(card_id, deck_id)values(1, 2);
INSERT INTO tb_card_deck(card_id, deck_id)values(2, 2);
INSERT INTO tb_card_deck(card_id, deck_id)values(3, 1);
INSERT INTO tb_card_deck(card_id, deck_id)values(4, 1);
INSERT INTO tb_card_deck(card_id, deck_id)values(2, 3);
INSERT INTO tb_card_deck(card_id, deck_id)values(3, 4);
INSERT INTO tb_card_deck(card_id, deck_id)values(4, 5);
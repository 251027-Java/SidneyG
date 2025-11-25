-- Active: 1763419559364@@127.0.0.1@5432@postgres
CREATE DATABASE postgres;

CREATE SCHEMA postgres;

SELECT * FROM sets;

CREATE TABLE sets(
    id varchar NOT NULL,
    name varchar NOT NULL,
    release_year integer,
    PRIMARY KEY(id)
);

SELECT column_name, data_type
FROM information_schema.columns
WHERE table_name = 'sets'
ORDER BY ordinal_position;


SELECT COUNT(*) FROM sets;

SELECT id, name, release_year
FROM sets
ORDER BY id
LIMIT 10;

SELECT current_database() AS db,
       inet_server_addr() AS host,
       inet_server_port() AS port;


SELECT COUNT(*) FROM sets;
SELECT COUNT(*) FROM cards;

SElECT * FROM cards;

SELECT * FROM decks;
SELECT * FROM deck_cards;







SELECT * FROM decks WHERE id = 7;




-- Join sets and cards. Can see set name + card name together
SELECT s.id   AS set_id,
       s.name AS set_name,
       c.id   AS card_id,
       c.name AS card_name
FROM sets s
JOIN cards c ON c.set_id = s.id
WHERE s.id = 'base1'
ORDER BY c.name
LIMIT 20;



-- Count number of cards in each set
SELECT s.id, s.name, COUNT(c.id) AS num_cards
FROM sets s
LEFT JOIN cards c ON c.set_id = s.id
GROUP BY s.id, s.name
ORDER BY num_cards DESC
LIMIT 10;


-- Count distinct card types each deck includes
SELECT d.id, d.name, COUNT(dc.card_id) AS unique_cards
FROM decks d
LEFT JOIN deck_cards dc ON dc.deck_id = d.id
GROUP BY d.id, d.name
ORDER BY unique_cards DESC;


-- Deck size
SELECT d.id, d.name, COALESCE(SUM(dc.quantity), 0) AS total_cards
FROM decks d
LEFT JOIN deck_cards dc ON dc.deck_id = d.id
GROUP BY d.id, d.name
ORDER BY total_cards DESC;


-- Shows each deck and a list of cards + quantities
SELECT d.name AS deck,
       STRING_AGG(c.name || ' x' || dc.quantity, ', ' ORDER BY c.name) AS cards
FROM decks d
JOIN deck_cards dc ON dc.deck_id = d.id
JOIN cards c ON c.id = dc.card_id
GROUP BY d.name
ORDER BY d.name;





















-- Finds cards that appear in more than one deck
SELECT c.id,
       c.name,
       COUNT(DISTINCT dc.deck_id) AS decks_used_in
FROM cards c
JOIN deck_cards dc ON dc.card_id = c.id
GROUP BY c.id, c.name
HAVING COUNT(DISTINCT dc.deck_id) > 1
ORDER BY decks_used_in DESC, c.name;
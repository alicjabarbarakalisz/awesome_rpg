CREATE TABLE rpg_character (
    name varchar(25),
    health int,
    alive boolean,
    level int
);

INSERT INTO rpg_character (name, health, alive, level)
VALUES ('alicja', 1000, true, 1),
       ('ioana', 1000, true, 1),
       ('vampire', 1200, true, 7);
-- DROP TABLE IF EXISTS fight;
-- DROP TABLE IF EXISTS fighter;
-- DROP TABLE IF EXISTS finishing_off;
-- DROP TABLE IF EXISTS fight_location;
-- DROP TABLE IF EXISTS tournament;

-- DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;

CREATE TABLE fight_location
(
    id      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name    VARCHAR NOT NULL,
    kingdom VARCHAR NOT NULL
);

CREATE TABLE fighter
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        VARCHAR NOT NULL,
    kingdom     VARCHAR NOT NULL,
    health      INTEGER NOT NULL,
    punch_power INTEGER NOT NULL
);

CREATE TABLE finishing_off
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    fighter_id  INTEGER NOT NULL,
    name        VARCHAR NOT NULL,
    finish_type VARCHAR NOT NULL,
    showy       INTEGER NOT NULL,
    complexity  INTEGER NOT NULL,
    FOREIGN KEY (fighter_id) REFERENCES fighter (id) ON DELETE CASCADE
);

CREATE TABLE tournament
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR NOT NULL
);

CREATE TABLE fight
(
    id                     INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name                   VARCHAR                           NOT NULL,
    earthrealm_fighter_id  INTEGER                           NOT NULL,
    outworld_fighter_id    INTEGER                           NOT NULL,
    tournament_id          INTEGER                           NOT NULL,
    fight_location_id      INTEGER                           NOT NULL,
    earthrealm_fighter_won BOOL                DEFAULT FALSE NOT NULL,
    outworld_fighter_won   BOOL                DEFAULT FALSE NOT NULL,
    someone_died           BOOL                DEFAULT FALSE NOT NULL
,
    FOREIGN KEY (earthrealm_fighter_id) REFERENCES fighter (id) ON DELETE CASCADE,
    FOREIGN KEY (outworld_fighter_id) REFERENCES fighter (id) ON DELETE CASCADE,
    FOREIGN KEY (tournament_id) REFERENCES tournament (id) ON DELETE CASCADE,
    FOREIGN KEY (fight_location_id) REFERENCES fight_location (id) ON DELETE CASCADE
);

CREATE TABLE fc_tournament_location
(
    tournament_id     INTEGER NOT NULL,
    fight_location_id INTEGER NOT NULL,
    PRIMARY KEY (tournament_id, fight_location_id)
);

CREATE TABLE fc_tournament_earthrealm_fighters
(
    tournament_id          INTEGER NOT NULL,
    earthrealm_fighters_id INTEGER NOT NULL,
    PRIMARY KEY (tournament_id, earthrealm_fighters_id)
);

CREATE TABLE fc_tournament_outworld_fighters
(
    tournament_id          INTEGER NOT NULL,
    outworld_fighters_id INTEGER NOT NULL,
    PRIMARY KEY (tournament_id, outworld_fighters_id)
);


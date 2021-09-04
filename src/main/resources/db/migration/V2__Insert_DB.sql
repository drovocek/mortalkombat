-- DELETE FROM fight;
-- DELETE FROM fighter;
-- DELETE FROM finishing_off;
-- DELETE
-- FROM fight_location;
-- DELETE FROM tournament;

ALTER SEQUENCE global_seq RESTART WITH 1000;

INSERT INTO fight_location (name, kingdom)
VALUES ('Kahn''s Arena', 'OUTWORLD'),         -- 1000
       ('Bridge of Immortality', 'OUTWORLD'), -- 1001
       ('Shang Tsung''s Island', 'OUTWORLD'), -- 1002
       ('Shaolin Temple', 'EARTHREALM'),      -- 1003
       ('Balcony', 'EARTHREALM'),             -- 1004
       ('Destroyed City', 'EARTHREALM'); -- 1005

INSERT INTO fighter (name, kingdom, health, punch_power)
VALUES ('Erron Black', 'OUTWORLD', 1000, 1000), -- 1006
       ('Shang Tsung', 'OUTWORLD', 500, 100),   -- 1007
       ('Kano', 'OUTWORLD', 100, 10),           -- 1008
       ('Johnny Cage', 'EARTHREALM', 200, 25),  -- 1009
       ('Liu Kang', 'EARTHREALM', 300, 20),     -- 1010
       ('Sonya Blade', 'EARTHREALM', 100, 5); -- 1011

INSERT INTO finishing_off (fighter_id, finish_type, name, showy, complexity)
VALUES (1006, 'FATALITY', 'Death Trap', 500, 100),
       (1006, 'BRUTALITY', 'Heavy Winds', 400, 80),
       (1006, 'FRIENDSHIP', 'What The Duck', 100, 50),

       (1007, 'FATALITY', 'Kondemmed To The Damned', 500, 100),
       (1007, 'BRUTALITY', 'Visceral Punt', 400, 80),
       (1007, 'FRIENDSHIP', 'Rainbow Konnection', 100, 50),

       (1008, 'FATALITY', 'Last Dance', 500, 100),
       (1008, 'BRUTALITY', 'Deadly Lips', 400, 80),
       (1008, 'FRIENDSHIP', '', 100, 50),

       (1009, 'FATALITY', 'Who Hired This Guy', 500, 100),
       (1009, 'BRUTALITY', 'The Award Goes To', 400, 80),
       (1009, 'FRIENDSHIP', 'Dub Dub WB', 100, 50),

       (1010, 'FATALITY', 'Belly of the Beast', 500, 100),
       (1010, 'BRUTALITY', 'One Inch Death Strike', 400, 80),
       (1010, 'FRIENDSHIP', 'Shaolin Hustle', 100, 50),

       (1011, 'FATALITY', 'Supply Drop', 500, 100),
       (1011, 'BRUTALITY', 'Popping Heads', 400, 80),
       (1011, 'FRIENDSHIP', 'Fetch, Good Drone', 100, 50);

INSERT INTO tournament (name)
VALUES ('Annihilation'), -- 1030
       ('Battle of the Realms'); -- 1031

INSERT INTO fc_tournament_location (tournament_id, fight_location_id)
VALUES (1030, 1000),
       (1030, 1001),
       (1031, 1002),
       (1030, 1003),
       (1031, 1004),
       (1031, 1005);

INSERT INTO fc_tournament_earthrealm_fighters (tournament_id, earthrealm_fighters_id)
VALUES (1030, 1011), -- Sonya Blade
       (1031, 1011),

       (1030, 1009), -- Johnny Cage

       (1030, 1010), -- Liu Kang
       (1031, 1010);

INSERT INTO fc_tournament_outworld_fighters (tournament_id, outworld_fighters_id)
VALUES (1030, 1007), -- Shang Tsung
       (1031, 1007),

       (1031, 1008), -- Kano

       (1030, 1006); -- Erron Black

INSERT INTO fight (name, earthrealm_fighter_id, outworld_fighter_id, tournament_id, fight_location_id,
                   earthrealm_fighter_won, outworld_fighter_won, someone_died)
VALUES ('Sonya Blade vs Erron Black', 1011, 1006, 1030, 1000, false, true, false),
       ('Johnny Cage vs Erron Black', 1009, 1006, 1030, 1001, true, false, true),
       ('Sonya Blade vs Shang Tsung', 1011, 1007, 1031, 1002, false, true, false),
       ('Liu Kang vs Shang Tsung', 1010, 1007, 1030, 1003, true, false, true),
       ('Liu Kang vs Kano', 1010, 1008, 1031, 1004, true, false, false),
       ('Sonya Blade vs Kano', 1011, 1008, 1031, 1005, true, false, true);

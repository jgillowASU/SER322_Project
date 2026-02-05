INSERT INTO PLANET (PlanetID, Name) VALUES (1, 'Tatooine');
INSERT INTO PLANET (PlanetID, Name) VALUES (2, 'Hoth');
INSERT INTO PLANET (PlanetID, Name) VALUES (3, 'Endor');
INSERT INTO PLANET (PlanetID, Name) VALUES (4, 'Naboo');
INSERT INTO PLANET (PlanetID, Name) VALUES (5, 'Coruscant');

INSERT INTO SYNDICATE (SyndicateID, Name) VALUES (1, 'Hutt Cartel');
INSERT INTO SYNDICATE (SyndicateID, Name) VALUES (2, 'Crimson Dawn');
INSERT INTO SYNDICATE (SyndicateID, Name) VALUES (3, 'Black Sun');
INSERT INTO SYNDICATE (SyndicateID, Name) VALUES (4, 'Pykes syndicate');

INSERT INTO `CHARACTER` (CharacterID, Name) VALUES (1, 'Han Solo');
INSERT INTO `CHARACTER` (CharacterID, Name) VALUES (2, 'Chewbacca');
INSERT INTO `CHARACTER` (CharacterID, Name) VALUES (3, 'Luke Skywalker');
INSERT INTO `CHARACTER` (CharacterID, Name) VALUES (4, 'Leia');
INSERT INTO `CHARACTER` (CharacterID, Name) VALUES (5, 'Boba Fett');
INSERT INTO `CHARACTER` (CharacterID, Name) VALUES (6, 'Din Djarin');
INSERT INTO `CHARACTER` (CharacterID, Name) VALUES (7, 'Greedo');
INSERT INTO `CHARACTER` (CharacterID, Name) VALUES (8, 'Lando Calrissian');
INSERT INTO `CHARACTER` (CharacterID, Name) VALUES (9, 'Bossk');
INSERT INTO `CHARACTER` (CharacterID, Name) VALUES (10, 'IG-88');

INSERT INTO TARGET (TargetID, Value, LastLocationPlanetID) VALUES (1, 50000, 1);
INSERT INTO TARGET (TargetID, Value, LastLocationPlanetID) VALUES (2, 120000, 2);
INSERT INTO TARGET (TargetID, Value, LastLocationPlanetID) VALUES (3, 200000, 5);
INSERT INTO TARGET (TargetID, Value, LastLocationPlanetID) VALUES (6, 15000, 1);
INSERT INTO TARGET (TargetID, Value, LastLocationPlanetID) VALUES (8, 40000, 3);

INSERT INTO BOUNTY_HUNTER (BountyHunterID, Credits) VALUES (5, 250000);
INSERT INTO BOUNTY_HUNTER (BountyHunterID, Credits) VALUES (6, 180000);
INSERT INTO BOUNTY_HUNTER (BountyHunterID, Credits) VALUES (7, 140000);
INSERT INTO BOUNTY_HUNTER (BountyHunterID, Credits) VALUES (9, 220000);
INSERT INTO BOUNTY_HUNTER (BountyHunterID, Credits) VALUES (10, 90000);

INSERT INTO CONTRACT (SyndicateID, TargetID, BountyHunterID, CompletionStatus) VALUES (1, 1, 4, 'Pending');
INSERT INTO CONTRACT (SyndicateID, TargetID, BountyHunterID, CompletionStatus) VALUES (4, 2, NULL, 'Pending');
INSERT INTO CONTRACT (SyndicateID, TargetID, BountyHunterID, CompletionStatus) VALUES (2, 3, 9, 'Pending');
INSERT INTO CONTRACT (SyndicateID, TargetID, BountyHunterID, CompletionStatus) VALUES (3, 6, 10, 'Completed');
INSERT INTO CONTRACT (SyndicateID, TargetID, BountyHunterID, CompletionStatus) VALUES (1, 7, 5, 'Failed');

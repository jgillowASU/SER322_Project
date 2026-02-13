SELECT Name
FROM `CHARACTER`;

SELECT Name
FROM PLANET;

SELECT Name
FROM SYNDICATE;

-- Targets
SELECT c.Name AS TargetName, t.Value, p.Name AS LastSeenPlanet
FROM TARGET t
JOIN `CHARACTER` c ON c.CharacterID = t.TargetID
LEFT JOIN PLANET p ON p.PlanetID = t.LastLocationPlanetID;

-- Bounty hunters
SELECT c.Name AS HunterName, b.Credits
FROM BOUNTY_HUNTER b
JOIN `CHARACTER` c ON c.CharacterID = b.BountyHunterID
ORDER BY b.Credits DESC;

-- All bounties
SELECT s.Name AS Syndicate, t.Name AS TargetName, h.Name AS HunterName, c.CompletionStatus
FROM CONTRACT c
JOIN SYNDICATE s ON s.SyndicateID = c.SyndicateID
JOIN `CHARACTER` t ON t.CharacterID = c.TargetID
LEFT JOIN `CHARACTER` h ON h.CharacterID = c.BountyHunterID;

-- Open Bounties
SELECT s.Name AS Syndicate, tc.Name AS TargetName, co.CompletionStatus
FROM CONTRACT co
JOIN SYNDICATE s ON s.SyndicateID = co.SyndicateID
JOIN `CHARACTER` tc ON tc.CharacterID = co.TargetID
WHERE co.BountyHunterID IS NULL
ORDER BY tc.Name;

-- Show only pending contracts
SELECT s.Name AS Syndicate, t.Name AS TargetName, h.Name AS HunterName
FROM CONTRACT c
JOIN SYNDICATE s ON s.SyndicateID = c.SyndicateID
JOIN `CHARACTER` t ON t.CharacterID = c.TargetID
LEFT JOIN `CHARACTER` h ON h.CharacterID = c.BountyHunterID
WHERE c.CompletionStatus = 'Pending';

-- Completed Contracts
SELECT s.Name AS Syndicate, t.Name AS TargetName, h.Name AS HunterName
FROM CONTRACT c
JOIN SYNDICATE s ON s.SyndicateID = c.SyndicateID
JOIN `CHARACTER` t ON t.CharacterID = c.TargetID
LEFT JOIN `CHARACTER` h ON h.CharacterID = c.BountyHunterID
WHERE c.CompletionStatus = 'Completed';

-- Contract count per syndicate
SELECT s.Name AS Syndicate, COUNT(*) AS TotalContracts
FROM CONTRACT c
JOIN SYNDICATE s ON s.SyndicateID = c.SyndicateID
GROUP BY s.Name;

-- Bounty hunter progress rankings by credits
SELECT c.Name AS HunterName, SUM(t.Value) AS TotalBountyValue
FROM CONTRACT ct
JOIN TARGET t ON t.TargetID = ct.TargetID
JOIN `CHARACTER` c ON c.CharacterID = ct.BountyHunterID
WHERE ct.CompletionStatus = 'Completed'
GROUP BY c.Name
ORDER BY TotalBountyValue DESC;

-- Open bounties on a specific planet
SELECT tc.Name AS TargetName, t.Value, p.Name AS LastSeenPlanet
FROM CONTRACT co
JOIN TARGET t ON t.TargetID = co.TargetID
JOIN `CHARACTER` tc ON tc.CharacterID = co.TargetID
LEFT JOIN PLANET p ON p.PlanetID = t.LastLocationPlanetID
WHERE co.BountyHunterID IS NULL
AND p.Name = 'Hoth';

-- List characters that are both a target and a bounty hunter
SELECT c.Name
FROM `CHARACTER` c
JOIN TARGET t ON t.TargetID = c.CharacterID
JOIN BOUNTY_HUNTER bh ON bh.BountyHunterID = c.CharacterID;

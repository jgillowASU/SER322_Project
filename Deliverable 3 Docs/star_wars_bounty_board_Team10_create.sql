CREATE DATABASE BountyHunterBoard;
USE BoutyHunterBoard;

CREATE TABLE `CHARACTER` (
    CharacterID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL
);

CREATE TABLE PLANET (
    PlanetID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL
);

CREATE TABLE TARGET (
    TargetID INT PRIMARY KEY,
    Value INT NOT NULL,
    LastLocationPlanetID INT,
    
    CONSTRAINT fk_target_character
        FOREIGN KEY (TargetID)
        REFERENCES `CHARACTER`(CharacterID)
        ON DELETE CASCADE,
        
    CONSTRAINT fk_target_planet
        FOREIGN KEY (LastLocationPlanetID)
        REFERENCES PLANET(PlanetID)
        ON DELETE SET NULL
);

CREATE TABLE BOUNTY_HUNTER (
    BountyHunterID INT PRIMARY KEY,
    Credits INT DEFAULT 0,
    
    CONSTRAINT fk_bountyhunter_character
        FOREIGN KEY (BountyHunterID)
        REFERENCES `CHARACTER`(CharacterID)
        ON DELETE CASCADE
);

CREATE TABLE SYNDICATE (
    SyndicateID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL
);

CREATE TABLE CONTRACT (
    ContractID INT PRIMARY KEY AUTO_INCREMENT,
    SyndicateID INT NOT NULL,
    TargetID INT NOT NULL,
    BountyHunterID INT,
    CompletionStatus ENUM('Pending','Completed','Failed') DEFAULT 'Pending',
    
    CONSTRAINT fk_contract_syndicate
        FOREIGN KEY (SyndicateID)
        REFERENCES SYNDICATE(SyndicateID)
        ON DELETE CASCADE,
        
    CONSTRAINT fk_contract_target
        FOREIGN KEY (TargetID)
        REFERENCES TARGET(TargetID)
        ON DELETE CASCADE,
        
    CONSTRAINT fk_contract_bountyhunter
        FOREIGN KEY (BountyHunterID)
        REFERENCES BOUNTY_HUNTER(BountyHunterID)
        ON DELETE SET NULL
);

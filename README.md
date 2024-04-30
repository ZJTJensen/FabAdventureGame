# FabOdyssey
Flesh and blood based mmo game mode


CREATE DATABASE fabOdyssey;

 USE fabOdyssey



CREATE TABLE Users (slug VARCHAR(20), phoneNumber VARCHAR(10), userName VARCHAR(20), userLevel VARCHAR(20));

CREATE TABLE Decks (slug VARCHAR(255),
    name VARCHAR(255),
    format VARCHAR(255),
    notes TEXT,
    visibility VARCHAR(255),
    cardBack INT,
    createdAt timestamp,
    totalVotes INT,
    myVote INT
);

CREATE TABLE Cards (
    slug VARCHAR(255),
    identifier VARCHAR(255),
    name VARCHAR(255),
    rarity VARCHAR(255),
    text TEXT,
    flavour TEXT,
    comments TEXT,
    image VARCHAR(255),
    total INT,
    isSideboard boolean
);

CREATE TABLE Stats (
    name VARCHAR(255),
    cost VARCHAR(255),
    defense VARCHAR(255),
    resource VARCHAR(255)
);

CREATE TABLE Keyword (
    name VARCHAR(255),
    keyword VARCHAR(255)
);

INSERT INTO Users VALUES ('YkRVDvJl','3019969901', 'St_Havock', '1');
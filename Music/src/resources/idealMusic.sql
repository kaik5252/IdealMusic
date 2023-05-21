/**
 * @author Rodrigo Rodrigues
 * @author Kaik D' Andrade
**/

DROP DATABASE IF EXISTS idealmusic;
CREATE DATABASE idealmusic CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
use idealmusic;

CREATE TABLE users (
    uid INT AUTO_INCREMENT PRIMARY KEY,
    ulogin VARCHAR(30) NOT NULL,
    upassword VARCHAR(128) NOT NULL,
    utype ENUM('employee', 'artist') NOT NULL
);

CREATE TABLE album (
    alid INT AUTO_INCREMENT PRIMARY KEY,
    alname VARCHAR(255) NOT NULL,
    alusers INT,
    FOREIGN KEY (alusers) REFERENCES users(uid)
);

CREATE TABLE category (
    cid INT AUTO_INCREMENT PRIMARY KEY,
    cname VARCHAR(255) NOT NULL
);

CREATE TABLE music (
    mid INT AUTO_INCREMENT PRIMARY KEY,
    mname VARCHAR(255) NOT NULL,
    msound VARCHAR(255) NOT NULL,
    mduration VARCHAR(255) NOT NULL,
    mrelease INT NOT NULL,
    mcategory INT NOT NULL,
    musers INT,
    FOREIGN KEY (musers) REFERENCES users(uid),
    FOREIGN KEY (mcategory) REFERENCES category(cid)
);

CREATE TABLE enclose (
    enid INT AUTO_INCREMENT PRIMARY KEY,
    enalbum INT,
    enmusic INT,
    FOREIGN KEY (enalbum) REFERENCES album(alid),
    FOREIGN KEY (enmusic) REFERENCES music(mid)
);

INSERT INTO category(cname) VALUES ("Pop");

INSERT INTO users(ulogin, upassword, utype) VALUES 
("gloria", sha2("gg2023", 512), "artist"), 
("pitty", sha2("pitty2023", 512), "artist"),
("gabriel souza", sha2("rootgabriel", 512), "employee"), 
("kaik francisco", sha2("rootkaik", 512), "employee");

INSERT INTO album(alname, alusers) VALUES ("Teste Albúm", 1);

INSERT INTO music(mname, msound, mduration, mrelease, mcategory, musers) VALUES 
("SOS A TODOS", "sound.wav", "03:15", 2023, 1, 1),
("SOS DEUS", "sound.wav", "03:15", 2023, 1, 1);

INSERT INTO enclose(enalbum, enmusic) VALUES 
(1, 1), 
(1, 2);
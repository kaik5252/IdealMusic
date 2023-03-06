/* @author Rodrigo Rocha */

DROP DATABASE IF EXISTS idealmusic;
CREATE DATABASE idealmusic CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
use idealmusic;

CREATE TABLE avatar (
    avid INT AUTO_INCREMENT PRIMARY KEY,
    avimg VARCHAR(255)
);

CREATE TABLE users (
    uid INT AUTO_INCREMENT PRIMARY KEY,
    uname VARCHAR(255) NOT NULL,
    ulogin VARCHAR(30) NOT NULL,
    upassword VARCHAR(128) NOT NULL,
    utype ENUM('employee', 'artist') NOT NULL,
    ustatus ENUM('on', 'del') DEFAULT 'on',
    uavatar INT DEFAULT 1,
    FOREIGN KEY (uavatar) REFERENCES avatar(avid)
);

CREATE TABLE album (
    alid INT AUTO_INCREMENT PRIMARY KEY,
    alname VARCHAR(255) NOT NULL,
    alstatus ENUM('on', 'del') DEFAULT 'on',
    aluser INT,
    FOREIGN KEY (aluser) REFERENCES users(uid)
);

CREATE TABLE category (
    cid INT AUTO_INCREMENT PRIMARY KEY,
    cname VARCHAR(255) NOT NULL
);

CREATE TABLE music (
    mid INT AUTO_INCREMENT PRIMARY KEY,
    mname VARCHAR(255) NOT NULL,
    msound VARCHAR(255) NOT NULL
);

CREATE TABLE own (
    oid INT AUTO_INCREMENT PRIMARY KEY,
    ocategory INT,
    omusic INT,
    FOREIGN KEY (ocategory) REFERENCES category(cid),
    FOREIGN KEY (omusic) REFERENCES music(mid)
);

CREATE TABLE enclose (
    enid INT AUTO_INCREMENT PRIMARY KEY,
    enalbum INT,
    enmusic INT,
    FOREIGN KEY (enalbum) REFERENCES album(alid),
    FOREIGN KEY (enmusic) REFERENCES music(mid)
);

INSERT INTO avatar(avimg) VALUES ('default.png');

INSERT INTO users(ulogin, uname, upassword, utype) VALUES 
('gabriel.souza', 'Gabriel', 'GaGa1234', 'employee'), 
('kaik.francis', 'Kaik', 'KaKa1234', 'employee');

INSERT INTO users(ulogin, uname, upassword, utype) VALUES 
('gloria', 'Gloria', 'SenhA1234', 'artist'), 
('pitty', 'Pitty', 'ConfiaveL1234', 'artist');
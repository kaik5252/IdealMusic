/* @author Rodrigo Rocha */

DROP DATABASE IF EXISTS idealmusic;
CREATE DATABASE idealmusic CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
use idealmusic;

CREATE TABLE users (
    uid INT AUTO_INCREMENT PRIMARY KEY,
    uname VARCHAR(255) NOT NULL,
    utel VARCHAR(15) NOT NULL,
    ulogin VARCHAR(30) NOT NULL,
    upassword VARCHAR(128) NOT NULL,
    utype ENUM('employee', 'artist') NOT NULL
);

CREATE TABLE employee (
    emid INT AUTO_INCREMENT PRIMARY KEY,
    emstatus ENUM('employee', 'adm') DEFAULT 'employee',
    emuser INT,
    FOREIGN KEY (emuser) REFERENCES users(uid)
);

CREATE TABLE artist (
    artid INT AUTO_INCREMENT PRIMARY KEY,
    artuser INT,
    FOREIGN KEY (artuser) REFERENCES users(uid)
);

CREATE TABLE album (
    alid INT AUTO_INCREMENT PRIMARY KEY,
    alname VARCHAR(255) NOT NULL,
    alartist INT,
    FOREIGN KEY (alartist) REFERENCES users(uid)
);

CREATE TABLE category (
    cid INT AUTO_INCREMENT PRIMARY KEY,
    cname VARCHAR(255) NOT NULL
);

CREATE TABLE music (
    mid INT AUTO_INCREMENT PRIMARY KEY,
    mname VARCHAR(255) NOT NULL,
    msound VARCHAR(255) NOT NULL,
    mcategory INT NOT NULL,
    FOREIGN KEY (mcategory) REFERENCES category(cid)
);

CREATE TABLE enclose (
    enid INT AUTO_INCREMENT PRIMARY KEY,
    enalbum INT,
    enmusic INT,
    FOREIGN KEY (enalbum) REFERENCES album(alid),
    FOREIGN KEY (enmusic) REFERENCES music(mid)
);

INSERT INTO category(cname) VALUES ('Pop');

/*
INSERT INTO users(ulogin, uname, upassword, utype) VALUES 
('gabriel.souza', 'Gabriel', 'GaGa1234', 'employee'), 
('kaik.francis', 'Kaik', 'KaKa1234', 'employee');

INSERT INTO users(ulogin, uname, upassword, utype) VALUES 
('gloria', 'Gloria', 'SenhA1234', 'artist'), 
('pitty', 'Pitty', 'ConfiaveL1234', 'artist');
*/
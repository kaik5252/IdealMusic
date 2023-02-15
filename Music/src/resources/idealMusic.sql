/* @author Rodrigo Rocha */

DROP DATABASE IF EXISTS idealmusic;
CREATE DATABASE idealmusic CHARACTER SET utf8 COLLATE utf8_general_ci;
use idealmusic;

CREATE TABLE avatar (
    avid INT AUTO_INCREMENT PRIMARY KEY,
    avimg VARCHAR(255) NOT NULL,
    avtype ENUM ('user', 'adm', 'both') DEFAULT 'user'
);

CREATE TABLE users (
    uid INT AUTO_INCREMENT PRIMARY KEY,
    uname VARCHAR(255) NOT NULL,
    uemail VARCHAR(255) UNIQUE NOT NULL,
    upassword VARCHAR(255) NOT NULL,
    uaid INT,
    utype ENUM ('user', 'adm') NOT NULL,
    ustatus ENUM ('on', 'del') DEFAULT 'on',
    FOREIGN KEY (uaid) REFERENCES avatar(avid)
);

CREATE TABLE category (
    cid INT AUTO_INCREMENT PRIMARY KEY,
    cname VARCHAR(255) NOT NULL
);

CREATE TABLE artist (
    aid INT AUTO_INCREMENT PRIMARY KEY,
    aname VARCHAR(255) NOT NULL,
    astatus ENUM('on', 'del') DEFAULT 'on'
);
 
CREATE TABLE music (
    mid INT AUTO_INCREMENT PRIMARY KEY,
    mname VARCHAR(255) NOT NULL,
    mbanner VARCHAR(255) NOT NULL,
    msound VARCHAR(255) NOT NULL,
    mctg INT,
    FOREIGN KEY (mctg) REFERENCES category(cid)
);

CREATE TABLE favorite (
    fid INT AUTO_INCREMENT PRIMARY KEY,
    fuser INT,
    fmusic INT,
    FOREIGN KEY (fuser) REFERENCES users(uid),
    FOREIGN KEY (fmusic) REFERENCES music(mid)
);

CREATE TABLE allocated (
    allo_artist INT,
    allo_music INT,
    FOREIGN KEY (allo_artist) REFERENCES artist(aid),
    FOREIGN KEY (allo_music) REFERENCES music(mid)
);
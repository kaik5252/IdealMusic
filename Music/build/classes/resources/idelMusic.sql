/* @author Rodrigo Rocha */

DROP DATABASE IF EXISTS idealmusic;
CREATE DATABASE idealmusic CHARACTER SET utf8 COLLATE utf8_general_ci;
USE idealmusic;

CREATE TABLE avatar (
    avatar_id INT AUTO_INCREMENT PRIMARY KEY,
    avatar_img VARCHAR(255) NOT NULL,
    avatar_type ENUM('user', 'adm') DEFAULT 'user'
);

CREATE TABLE favorite (
    fav_id INT AUTO_INCREMENT PRIMARY KEY,
    fav_mid INT,
    fav_playid INT,
    FOREIGN KEY fav_mid REFERENCES playlist(fav_id),
    FOREIGN KEY fav_playid REFERENCES music(m_id)
);

CREATE TABLE own (
    own_id INT AUTO_INCREMENT PRIMARY KEY,
    own_userid INT NOT NULL,
    own_favid INT NOT NULL,
    FOREIGN KEY (own_userid) REFERENCES user(u_id),
    FOREIGN KEY (own_favid) REFERENCES favorite(fav_id)
);

CREATE TABLE user (
    u_id INT AUTO_INCREMENT PRIMARY KEY,
    u_name VARCHAR(255) NOT NULL,
    u_email VARCHAR(255) UNIQUE NOT NULL,
    u_password VARCHAR(255) NOT NULL,
    u_type ENUM('user', 'adm') NOT NULL,
    u_status ENUM('on', 'del') DEFAULT 'on',
    u_avatarid INT NOT NULL,
    u_ownid INT,
    FOREIGN KEY u_avatarid REFERENCES avatar(avatar_id),
    FOREIGN KEY u_ownid REFERENCES own(own_id)
);

CREATE TABLE category (
    ctg_id INT AUTO_INCREMENT PRIMARY KEY,
    ctg_name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE music (
    m_id INT AUTO_INCREMENT PRIMARY KEY,
    m_name VARCHAR(255) NOT NULL,
    m_duration TIME NOT NULL,
    m_banner VARCHAR(255) NOT NULL,
    m_sound VARCHAR(255) NOT NULL,
    m_ctgid INT NOT NULL,
    FOREIGN KEY m_ctgid REFERENCES category(ctg_id)
);

CREATE TABLE artist (
    art_id INT AUTO_INCREMENT PRIMARY KEY,
    art_name VARCHAR(255) NOT NULL,
    art_status ENUM('on', 'del') DEFAULT 'on'
);

CREATE TABLE allocated (
    allo_id INT AUTO_INCREMENT PRIMARY KEY,
    allo_artid INT NOT NULL,
    allo_mid INT NOT NULL,
    FOREIGN KEY allo_artid REFERENCES artist(art_id),
    FOREIGN KEY allo_mid REFERENCES music(m_id)
);

CREATE TABLE playlist (
    play_id INT AUTO_INCREMENT PRIMARY KEY,
    play_name VARCHAR(255) NOT NULL
);

CREATE TABLE acquire (
    acq_id INT AUTO_INCREMENT PRIMARY KEY,
    acq_mid INT NOT NULL,
    acq_playid INT NOT NULL,
    FOREIGN KEY acq_mid REFERENCES music(m_id),
    FOREIGN KEY acq_playid REFERENCES playlist(play_id)
);





/* Os avatares */
INSERT INTO avatar(avatar_img, avatar_type) VALUES 
('src/resources/avatar/adm.jpg', 'adm');

/* Conta ADM */
INSERT INTO user(u_name, u_email, u_password, u_type, u_avatarid) VALUES 
("Kaik D' Andrade", 'kaikdossantossilva2@gmail.com', 'root0000', 'adm', 1), 
('Gabriel Souza', 'gabriel.s.av707@gmail.com', 'root0000', 'adm', 1);

/* As categorias das músicas */
INSERT INTO category(ctg_name) VALUES 
('Nacional'), 
('Internacional');

/* Dados para realizar os testes da funcionalidade do app (Temporário)*/
INSERT INTO artist(art_name) VALUES 
('Pitty'), 
('Ariana Grande'), 
('Dua Lipa'), 
('Billie Eilish'), 
('Gloria Groove');

INSERT INTO music() VALUES ();
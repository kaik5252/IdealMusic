DROP DATABASE IF EXISTS teste;
CREATE DATABASE teste CHARACTER SET utf8 COLLATE utf8_general_ci;
USE teste;

CREATE TABLE usuario (
  u_id INT PRIMARY KEY AUTO_INCREMENT,
  u_passwd varchar(255) NOT NULL,
  u_status ENUM('on', 'del') DEFAULT 'on'
);

INSERT INTO usuario (u_passwd) VALUES
(sha2('01234567', 512)),
(sha2('12345678', 512));
DROP DATABASE IF EXISTS teste;
CREATE DATABASE teste CHARACTER SET utf8 COLLATE utf8_general_ci;
USE teste;

CREATE TABLE usuario (
<<<<<<< Updated upstream
  u_id INT PRIMARY KEY AUTO_INCREMENT,
  u_passwd varchar(255) NOT NULL,
  u_status ENUM('on', 'del') DEFAULT 'on'
);

INSERT INTO usuario (u_passwd) VALUES
=======
  u_id int(11) AUTO_INCREMENT PRIMARY KEY,
  u_password varchar(255) UNIQUE NOT NULL
);

INSERT INTO usuario(u_password) VALUES
>>>>>>> Stashed changes
(sha2('01234567', 512)),
(sha2('12345678', 512));
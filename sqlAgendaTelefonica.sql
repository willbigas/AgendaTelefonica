CREATE SCHEMA IF NOT EXISTS `agendaTelefonicaProva`;

USE `agendaTelefonicaProva`;

CREATE TABLE tipoContato(
id INT(11) NOT NULL AUTO_INCREMENT,
nome varchar(50) NOT NULL,
PRIMARY KEY (id));


CREATE TABLE contato(
id INT(11) NOT NULL AUTO_INCREMENT,
nome varchar(50) NOT NULL,
nascimento date,
email varchar(50) NOT NULL,
id_tipoContato int,
PRIMARY KEY (id),
foreign key (id_tipoContato) references tipoContato(id)
);

CREATE TABLE telefone(
id INT(11) NOT NULL AUTO_INCREMENT,
ddd integer(3) NOT NULL,
numero integer(9) NOT NULL,
id_contato int,
PRIMARY KEY (id),
foreign key (id_contato) references contato(id)
);




select * from tipoContato;

select * from telefone;

select * from contato;


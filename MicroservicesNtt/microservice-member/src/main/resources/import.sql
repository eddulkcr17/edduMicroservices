--INSERT INTO persons (id_cliente, identificacion, nombre, genero, edad, direccion, telefono)
--VALUES
--(1,'1723721484','Jose Lema', 'M',22,'Otavalo sn y principal', '098254785'),
--(2,'1719453498','Marianela Montalvo','F',32, 'Amazonas y NNUU', '097548965'),
--(3,'1711181857','Juan Osorio', 'M',45,'13 junio y Equinoccial', '098874587');


--INSERT INTO clients (id_cliente, contrasena, estado, id_persona)
--VALUES (1,'1234', TRUE, 1),
--(2,'5678', TRUE, 2),
--(3,'1245', TRUE,3);

INSERT INTO memberDb.person (edad, estado, id_cliente, id_persona, dtype, contrasena, direccion, genero, identificacion, nombre, telefono)
VALUES(22, 1, 1, 1, 'A', '1234', 'Otavalo sn y principal', 'M', '1723721484', 'Jose Lema', '098254785');
INSERT INTO memberDb.person (edad, estado, id_cliente, id_persona, dtype, contrasena, direccion, genero, identificacion, nombre, telefono)
VALUES(32, 1, 2, 2, 'A', '5678', 'Amazonas y NNUU', 'F', '1719453498', 'Marianela Montalvo', '097548965');
INSERT INTO memberDb.person (edad, estado, id_cliente, id_persona, dtype, contrasena, direccion, genero, identificacion, nombre, telefono)
VALUES(45, 1, 3, 3, 'A', '1245', '13 junio y Equinoccial', 'M', '1711181857', 'Juan Osorio', '098874587');
SHOW DATABASES;

CREATE DATABASE `municipios`;
USE municipios;

CREATE TABLE `departamentos` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(150) NOT NULL,
	`codigo` INT NOT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_general_ci'
;


CREATE TABLE `municipios` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`departamento_id` INT NOT NULL,
	`nombre` VARCHAR(150) NOT NULL,
	`codigo` INT NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `FK__departamentos` FOREIGN KEY (`departamento_id`) REFERENCES `departamentos` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
)
COLLATE='utf8mb4_general_ci'
;

-- inserts de departamentos (crear)
INSERT INTO `municipios`.`departamentos` (`nombre`, `codigo`) VALUES ('Antioquia', '1');
INSERT INTO `municipios`.`departamentos` (`nombre`, `codigo`) VALUES ('Boyaca', '2');
INSERT INTO `municipios`.`departamentos` (`nombre`, `codigo`) VALUES ('La Guajira', '3');
INSERT INTO `municipios`.`departamentos` (`nombre`, `codigo`) VALUES ('Santander', '4');
INSERT INTO `municipios`.`departamentos` (`nombre`, `codigo`) VALUES ('Nariño', '5');

-- insets de municipios (crear)
INSERT INTO `municipios`.`municipios` (`departamento_id`, `nombre`, `codigo`) VALUES ('1', 'Medellin', '1');
INSERT INTO `municipios`.`municipios` (`departamento_id`, `nombre`, `codigo`) VALUES ('1', 'Envigado', '2');
INSERT INTO `municipios`.`municipios` (`departamento_id`, `nombre`, `codigo`) VALUES ('1', 'Caldas', '3');


-- update de un error (editar)
UPDATE `municipios`.`municipios` SET `nombre`='Caldas' WHERE  `id`=3;

-- eliminar el registro 2 (editar)
DELETE FROM `municipios`.`municipios` WHERE  `id`=2;

-- traer los id mayores a 3
SELECT * FROM departamentos WHERE id > 3;

-- CRUD
-- C -> Create
-- R -> Read
-- U -> Update 
-- D -> Delete





-- sesión de 22 de julio

-- todos los datos de una tabla
SELECT * FROM municipio;

--solo una columna
SELECT nombre FROM municipio;

-- alias
SELECT nombre AS name, codigo AS code FROM municipio;

-- alias de tablas
SELECT nombre AS name, codigo AS CODE 
FROM municipio AS mu;

SELECT mu.nombre, mu.codigo AS code
FROM municipio AS mu;

-- Join
SELECT dep.nombre, dep.codigo, mun.nombre, mun.codigo, ca.id
FROM municipio AS mun
LEFT JOIN departamento dep ON dep.id = mun.departamento_id;


-- limit
SELECT dep.nombre, dep.codigo, mun.nombre, mun.codigo, ca.id
FROM municipio AS mun
LEFT JOIN departamento dep ON dep.id = mun.departamento_id
LEFT JOIN casos ca ON ca.municipio_id = mun.id
LIMIT 5;


-- count
SELECT COUNT(*) FROM casos ca;


-- where 
SELECT COUNT(*)
FROM casos ca
WHERE edad = 30 
LIMIT 100;

SELECT COUNT(*)
FROM casos ca
WHERE sexo = 'F' 
LIMIT 100;

SELECT COUNT(*)
FROM casos ca
WHERE edad = 30 AND edad = 35
LIMIT 100;

SELECT COUNT(*)
FROM casos ca
WHERE edad = 30 OR edad = 35
LIMIT 100;

SELECT COUNT(*)
FROM casos ca
WHERE edad >= 30 and edad <= 35
LIMIT 100;


-- LIKE 
SELECT *
FROM casos ca
WHERE ca.pais_importado LIKE '%SPA%'
LIMIT 1000;


-- IS NULL y IS NOT NULL
SELECT *
FROM casos ca
WHERE ca.fecha_recuperacion IS NOT NULL
LIMIT 1000;

SELECT COUNT(*)
FROM casos ca
WHERE edad <> 20
LIMIT 100;


-- group by 
SELECT edad
FROM casos ca
GROUP BY edad

SELECT edad, COUNT( edad ) 
FROM casos ca
GROUP BY edad

-- order by 
SELECT edad, COUNT( edad ) 
FROM casos ca
GROUP BY edad
ORDER BY edad asc

SELECT edad, COUNT( edad ) 
FROM casos ca
GROUP BY edad
ORDER BY edad desc

-- top 10
SELECT edad, COUNT( edad ) 
FROM casos ca
GROUP BY edad
ORDER BY COUNT( edad ) DESC
LIMIT 10;
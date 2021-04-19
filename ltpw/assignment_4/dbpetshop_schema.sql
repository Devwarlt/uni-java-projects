CREATE DATABASE IF NOT EXISTS `employee_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dbpetshop`;
CREATE TABLE IF NOT EXISTS `animal` (
    `idAnimal` INT NOT NULL,
    `nomeAnimal` VARCHAR(45) NOT NULL,
    `nomeDono` VARCHAR(45) NOT NULL,
    `especie` VARCHAR(45) NOT NULL,
    `raca` VARCHAR(45) NOT NULL,
    `sexo` VARCHAR(45) NOT NULL,
    PRIMARY KEY(`idAnimal`)
) ENGINE = INNODB;
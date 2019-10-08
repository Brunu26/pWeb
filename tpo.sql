-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tpo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tpo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tpo` DEFAULT CHARACTER SET utf8 ;
USE `tpo` ;

-- -----------------------------------------------------
-- Table `tpo`.`encomenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpo`.`encomenda` (
  `idEncomenda` VARCHAR(45) NOT NULL,
  `endereco` TEXT NOT NULL,
  `idfranquia_remetente` INT NOT NULL,
  `idfranquia_destinatario` INT NOT NULL,
  PRIMARY KEY (`idEncomenda`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpo`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpo`.`endereco` (
  `regiao` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `numero` INT(11) NOT NULL,
  `idfranquia` INT(11) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tpo`.`franquia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tpo`.`franquia` (
  `idfranquia` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `matriz` TINYINT(4) NOT NULL,
  fr1 VARCHAR(45),
  KM1 VARCHAR(45),
  fr2 VARCHAR(45),
  KM2 VARCHAR(45),
  fr3 VARCHAR(45),
  KM3 VARCHAR(45),
  PRIMARY KEY (`idfranquia`))
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------
-- Table `tpo`.`users`
-- -----------------------------------------------------
CREATE TABLE `tpo`.`users` (
  `idusers` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `idfranquia` INT NOT NULL,
  `adm` TINYINT NOT NULL,
  PRIMARY KEY (`idusers`));

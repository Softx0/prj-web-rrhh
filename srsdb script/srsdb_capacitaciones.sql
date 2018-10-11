CREATE DATABASE  IF NOT EXISTS `srsdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `srsdb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: srsdb
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `capacitaciones`
--

DROP TABLE IF EXISTS `capacitaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `capacitaciones` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Titulo` varchar(100) NOT NULL,
  `Nivel` bigint(20) DEFAULT NULL,
  `Fecha_Desde` date DEFAULT NULL,
  `Fecha_Hasta` date DEFAULT NULL,
  `Institucion` varchar(100) DEFAULT NULL,
  `Estado` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Estado` (`Estado`),
  KEY `Nivel` (`Nivel`),
  CONSTRAINT `capacitaciones_ibfk_1` FOREIGN KEY (`Estado`) REFERENCES `estado` (`Id`),
  CONSTRAINT `capacitaciones_ibfk_2` FOREIGN KEY (`Nivel`) REFERENCES `nivel_academico` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capacitaciones`
--

LOCK TABLES `capacitaciones` WRITE;
/*!40000 ALTER TABLE `capacitaciones` DISABLE KEYS */;
INSERT INTO `capacitaciones` VALUES (5,'mmmmmmmmmmmmmm',6,'1985-12-30','2015-05-25','pppppppppppp',NULL),(6,'Desarrollo en Java Advanced',2,'2018-02-05','2018-11-09','UNAPEC',NULL),(7,'Tecnico en Csharp',5,'2002-01-01','2018-05-02','ITLA',NULL),(8,'hvbuyvbuyvb',4,'1990-09-09','1990-05-05','iuniuniuni',NULL),(9,'Dev Java Jr',5,'2001-05-09','2012-04-07','ITLA',NULL),(10,'IngEnSistemas',3,'2018-10-09','2018-10-25','PUCMM',NULL),(11,'IngSoftware',4,'2018-10-01','2018-10-26','UNAPEC',NULL),(12,'wsdmikdnm',6,'2018-10-14','2018-10-27','UNAPECCCC',NULL),(13,'dmcijdmcidj',4,'2018-10-14','2018-10-28','dfndcn',NULL),(14,'Ing en Ciberseguridad',5,'2018-10-14','2018-10-31','INTEC',NULL),(15,'Ingenieria en Software',2,'2018-10-02','2018-10-31','UNAPEC',NULL);
/*!40000 ALTER TABLE `capacitaciones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-10  9:35:48

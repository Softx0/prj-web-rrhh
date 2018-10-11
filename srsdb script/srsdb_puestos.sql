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
-- Table structure for table `puestos`
--

DROP TABLE IF EXISTS `puestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puestos` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Puesto` varchar(100) NOT NULL,
  `Nivel_de_Riesgo` bigint(20) DEFAULT NULL,
  `Departamento` bigint(20) DEFAULT NULL,
  `Salario_Minimo` double NOT NULL,
  `Salario_Maximo` double NOT NULL,
  `Estado` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Departamento` (`Departamento`),
  KEY `Nivel_de_Riesgo` (`Nivel_de_Riesgo`),
  KEY `Estado` (`Estado`),
  CONSTRAINT `puestos_ibfk_1` FOREIGN KEY (`Departamento`) REFERENCES `departamento` (`Id`),
  CONSTRAINT `puestos_ibfk_2` FOREIGN KEY (`Nivel_de_Riesgo`) REFERENCES `nivel_de_riesgo` (`Id`),
  CONSTRAINT `puestos_ibfk_3` FOREIGN KEY (`Estado`) REFERENCES `estado` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puestos`
--

LOCK TABLES `puestos` WRITE;
/*!40000 ALTER TABLE `puestos` DISABLE KEYS */;
INSERT INTO `puestos` VALUES (1,'Programador Java Sr.',2,1,50000,75000,1),(2,'Analista de Calidad',2,1,45000,700,1),(3,'Especialista en Branch',1,4,57750,65250,1),(4,'CEO',3,6,125350,175000,1),(5,'Reclutador Sr.',1,5,49275,56655,1),(6,'Bibliotecario',3,4,20000,30000,1),(7,'HelpDesk',3,3,50000,60000,2),(8,'Consultor',3,3,60000,1000000,2),(9,'Arquitecto de Software',3,3,80000,90000,2),(10,'Analista de Requisitos',3,3,65000,75000,1),(11,'Limpiabotas',3,3,5000,9000,1),(12,'Maquinista',2,9,75520,65820,1),(14,'Ejemplo',3,9,35000,45000,1);
/*!40000 ALTER TABLE `puestos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-10  9:35:45

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
-- Table structure for table `experiencia_laboral`
--

DROP TABLE IF EXISTS `experiencia_laboral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experiencia_laboral` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Empresa` varchar(100) NOT NULL,
  `Puesto_Ocupado` varchar(100) DEFAULT NULL,
  `Fecha_Desde` date NOT NULL,
  `Fecha_Hasta` date NOT NULL,
  `Salario` double NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiencia_laboral`
--

LOCK TABLES `experiencia_laboral` WRITE;
/*!40000 ALTER TABLE `experiencia_laboral` DISABLE KEYS */;
INSERT INTO `experiencia_laboral` VALUES (1,'Jajajajja','ajajjajajajaj','1928-11-05','2001-05-30',45852),(2,'oooooooooooooooooooooooo','oooooooooooooooooooooooo','2002-04-04','2003-05-06',545852),(3,'vavavavavavavava','cvvavavvavava','1999-12-31','2050-01-09',45000),(4,'jhk bjhvbjg','njhvjhgvhg','2010-09-08','2005-06-11',789789),(5,'UNIPAGO','Dev Java Sr','2011-02-09','2017-05-08',90000),(6,'APAP','Gerente RRRRRHHHHH','2002-01-05','2025-09-12',77777),(7,'UNAPEC','Limpiabotas','2003-12-30','2009-12-29',58245),(8,'Titanmarindedonpingue','cucaramacara','2018-10-21','2019-01-31',85000),(9,'BancoPopular','DesarrolladorCSharp','2018-10-14','2019-03-15',90000),(10,'hhhhhhh','','2018-10-14','2018-09-04',0),(11,'UNAPEC','Dev','2018-10-02','2018-10-01',4774747),(12,'Probando','Modal d','2018-10-07','2018-10-25',8888),(13,'jjhgcvhyrf','JHVBJGVHG','2018-10-30','2018-10-31',9864684),(14,'dfunudfn','dfnudnfd','2018-10-09','2018-10-31',6891684),(15,'UNIPAGO','Analista Programador','2018-10-28','2019-07-19',74200),(16,'APAP','QAPM','2011-07-05','2018-10-18',85000);
/*!40000 ALTER TABLE `experiencia_laboral` ENABLE KEYS */;
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

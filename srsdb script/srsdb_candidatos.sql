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
-- Table structure for table `candidatos`
--

DROP TABLE IF EXISTS `candidatos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidatos` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Cedula` varchar(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Salario_Aspira` double NOT NULL,
  `Recomendado_Por` varchar(80) DEFAULT NULL,
  `Puesto_Aspira` bigint(20) DEFAULT NULL,
  `Competencias` bigint(20) DEFAULT NULL,
  `Capacitaciones` bigint(20) DEFAULT NULL,
  `Estado_Candidato` bigint(20) DEFAULT '1',
  `Idiomas` bigint(20) DEFAULT NULL,
  `Experiencia_Laboral` bigint(20) DEFAULT '1',
  PRIMARY KEY (`Id`),
  KEY `Puesto_Aspira` (`Puesto_Aspira`),
  KEY `Capacitaciones` (`Capacitaciones`),
  KEY `Competencias` (`Competencias`),
  KEY `Idiomas` (`Idiomas`),
  KEY `Experiencia_Laboral` (`Experiencia_Laboral`),
  KEY `Estado_Candidato` (`Estado_Candidato`),
  CONSTRAINT `candidatos_ibfk_1` FOREIGN KEY (`Puesto_Aspira`) REFERENCES `puestos` (`Id`),
  CONSTRAINT `candidatos_ibfk_2` FOREIGN KEY (`Competencias`) REFERENCES `competencias` (`Id`),
  CONSTRAINT `candidatos_ibfk_3` FOREIGN KEY (`Capacitaciones`) REFERENCES `capacitaciones` (`Id`),
  CONSTRAINT `candidatos_ibfk_4` FOREIGN KEY (`Competencias`) REFERENCES `competencias` (`Id`),
  CONSTRAINT `candidatos_ibfk_5` FOREIGN KEY (`Idiomas`) REFERENCES `idiomas` (`Id`),
  CONSTRAINT `candidatos_ibfk_6` FOREIGN KEY (`Experiencia_Laboral`) REFERENCES `experiencia_laboral` (`Id`),
  CONSTRAINT `candidatos_ibfk_7` FOREIGN KEY (`Estado_Candidato`) REFERENCES `estado_candidato` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidatos`
--

LOCK TABLES `candidatos` WRITE;
/*!40000 ALTER TABLE `candidatos` DISABLE KEYS */;
INSERT INTO `candidatos` VALUES (57,'40215563657','wld,lwdm',6998,'fdskdnjs',2,6,NULL,NULL,1,3),(58,'40215563657','widniwdin',6585,'elfmekfmk',2,8,NULL,NULL,4,3),(59,'40215563657','dsfmckdmf',6565,'edmflkemd',2,8,NULL,NULL,2,3),(60,'40215563657','jk nfjnfjenf',562989,'elkmceoe,',1,7,NULL,NULL,6,3),(61,'40215563657','kjndfejfnjj ne',57,'ekffmkem c',3,7,NULL,NULL,4,3),(62,'40215563657','jienfjiefcf',284894487,'lkcmikecnik',5,6,NULL,NULL,7,3),(63,'40215563657',' kfekckecn ik',848488,'fdmfekfmke',3,7,NULL,NULL,8,3),(64,'40215563657','welewlcf,memlf',959659,'klemfkemfc',3,7,NULL,NULL,2,3),(65,'40215563657','smlksmdksmd',484787,'ejcbjdvc',3,7,NULL,NULL,4,3),(66,'40215563657','papapap',454,'paspapap',2,7,NULL,NULL,3,3),(68,'40215563657','lslaslasalslaslaslaslalsals',8484,'laslalsalslaslalslas',4,8,NULL,NULL,4,3),(70,'40215563657','9i8uytyrfgv',446,'KJKHKH',3,7,5,NULL,3,4),(71,'40215563657','Luis Geraldo',45750,'Carlos Torres',4,8,5,NULL,5,4),(72,'40215563657','eduardo',69845,'wsjdnbsnuj',4,7,8,NULL,5,6),(74,'40215563657','EduardoEmmanuelValenzuelaRomero',45000,'JuanPablo',4,8,10,NULL,4,8),(75,'40235608623','IavnErnesto',60000,'CarlosTorres',3,8,12,NULL,10,13),(76,'40215563657','jhjuyvgfyu',51468468,'ljhutfuy',4,8,NULL,NULL,4,NULL),(77,'40215563657','hdsdhshsh',6264586361,'skfdsiud',3,6,13,NULL,3,14);
/*!40000 ALTER TABLE `candidatos` ENABLE KEYS */;
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

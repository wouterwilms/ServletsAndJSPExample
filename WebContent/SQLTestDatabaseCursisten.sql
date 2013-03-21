CREATE DATABASE  IF NOT EXISTS `jsp_en_servlets_testschema` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `jsp_en_servlets_testschema`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: jsp_en_servlets_testschema
-- ------------------------------------------------------
-- Server version	5.5.29

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
-- Table structure for table `cursis`
--

DROP TABLE IF EXISTS `cursis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursis` (
  `idCursis` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(45) NOT NULL,
  `jaar` year(4) NOT NULL,
  PRIMARY KEY (`idCursis`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursis`
--

LOCK TABLES `cursis` WRITE;
/*!40000 ALTER TABLE `cursis` DISABLE KEYS */;
INSERT INTO `cursis` VALUES (1,'Java',2013),(2,'.NET',2013),(3,'Netwerk Technicus',2013);
/*!40000 ALTER TABLE `cursis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursist`
--

DROP TABLE IF EXISTS `cursist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursist` (
  `idCursist` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(45) NOT NULL,
  `cursis` int(11) NOT NULL,
  PRIMARY KEY (`idCursist`),
  KEY `gevolgdeCursis_idx` (`cursis`),
  CONSTRAINT `gevolgdeCursis` FOREIGN KEY (`cursis`) REFERENCES `cursis` (`idCursis`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursist`
--

LOCK TABLES `cursist` WRITE;
/*!40000 ALTER TABLE `cursist` DISABLE KEYS */;
INSERT INTO `cursist` VALUES (1,'Georges',1),(2,'Lennert',1),(3,'Serguei',1),(4,'Shadi',1),(5,'Tom',1),(6,'Wouter',1);
/*!40000 ALTER TABLE `cursist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-03-19 14:14:05
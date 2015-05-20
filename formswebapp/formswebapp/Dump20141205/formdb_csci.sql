CREATE DATABASE  IF NOT EXISTS `formdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `formdb`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: formdb
-- ------------------------------------------------------
-- Server version	5.6.15

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
-- Table structure for table `csci`
--

DROP TABLE IF EXISTS `csci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `csci` (
  `courseNumber` varchar(10) DEFAULT NULL,
  `section` varchar(10) DEFAULT NULL,
  `instructor` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `csci`
--

LOCK TABLES `csci` WRITE;
/*!40000 ALTER TABLE `csci` DISABLE KEYS */;
INSERT INTO `csci` VALUES ('101','01','Burke\r'),('101','02','Burke\r'),('101','03','Burke\r'),('101','d1','Streicher\r'),('101','h1','Burke\r'),('101','h2','Burke\r'),('101','sd5','MAtthews\r'),('101','sd6','Matthews\r'),('101','sd7','Matthews\r'),('101','sd8','Matthews\r'),('101','sd9','Matthews\r'),('105','01','Barnes\r'),('105','02','Wright\r'),('105','03','Burke\r'),('105','04','Dorman\r'),('105','d1','Wright\r'),('105','d2','Burke\r'),('110','01','Wright\r'),('110','02','Wright\r'),('110','03','Linder\r'),('110','04','Burke\r'),('110','05','Dorman\r'),('110','06','Sheel\r'),('110','d1','Linder\r'),('110','d2','Wright\r'),('110','d3','French\r'),('110','e1','Streicher\r'),('110','sd5','Wagner\r'),('120','d1','Barnes\r'),('130','01','Linder\r'),('130','02','Linder\r'),('130','04','Fuchs\r'),('130','05','Fuchs\r'),('130','h4','Fuchs\r'),('131l','01','Nance\r'),('131l','02','Sheel\r'),('140','01','Collins\r'),('140','02','Nance\r'),('140','03','Kumar\r'),('150','01','Larkins\r'),('150','02','Cox\r'),('150l','01','Larkins\r'),('150l','02','Cox\r'),('170','d1','Barnes\r'),('170','d2','Barnes\r'),('203','01','French\r'),('220','01','Rickard\r'),('220','h1','Rickard\r'),('225','01','Fuchs\r'),('310','01','Jones\r'),('310','h1','Jones\r'),('330','01','Cox\r'),('330','h1','Cox\r'),('335','01','Kumar\r'),('343','01','Fuchs\r'),('365','01','tbh\r'),('390','01','Rickard\r'),('409','01','French\r'),('416','e1','Murphy\r'),('434','d1','Murphy\r'),('445','01','Rickard\r'),('450','01','Larkins\r'),('495','01','Murphy\r'),('495','e2','Cox\r'),('495','h1','Murphy\r'),('534','d1','Murphy');
/*!40000 ALTER TABLE `csci` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-05 11:06:22

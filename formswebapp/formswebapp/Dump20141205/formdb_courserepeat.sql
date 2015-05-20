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
-- Table structure for table `courserepeat`
--

DROP TABLE IF EXISTS `courserepeat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courserepeat` (
  `formId` int(11) NOT NULL AUTO_INCREMENT,
  `courseToRepeat` varchar(50) DEFAULT NULL,
  `termTaken` varchar(50) DEFAULT NULL,
  `gradeEarned` varchar(50) DEFAULT NULL,
  `termToRepeat` varchar(50) DEFAULT NULL,
  `studId` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `teacher` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`formId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courserepeat`
--

LOCK TABLES `courserepeat` WRITE;
/*!40000 ALTER TABLE `courserepeat` DISABLE KEYS */;
INSERT INTO `courserepeat` VALUES (1,'csci210','fa12','f','sp13','1','Approved','1'),(5,'CSCI 310','FALL 14','F','SPRING 15',NULL,NULL,'1'),(6,'CSCI 225','FALL 12','F','SPRING 13',NULL,'Approved','1'),(7,'CSCI 123','fall 13','F','spring 14',NULL,'Approved','1'),(8,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'1234','1234','1234','1324',NULL,NULL,NULL);
/*!40000 ALTER TABLE `courserepeat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-05 11:06:21

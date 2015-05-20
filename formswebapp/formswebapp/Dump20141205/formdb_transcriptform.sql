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
-- Table structure for table `transcriptform`
--

DROP TABLE IF EXISTS `transcriptform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transcriptform` (
  `formId` int(11) NOT NULL AUTO_INCREMENT,
  `firstTermAttended` varchar(50) DEFAULT NULL,
  `firstYearAttended` varchar(50) DEFAULT NULL,
  `lastYearAttended` varchar(50) DEFAULT NULL,
  `lastTermAttended` varchar(50) DEFAULT NULL,
  `toBeCompleted` varchar(50) DEFAULT NULL,
  `numTrans1` varchar(50) DEFAULT NULL,
  `name1` varchar(50) DEFAULT NULL,
  `address1` varchar(50) DEFAULT NULL,
  `numTrans2` varchar(50) DEFAULT NULL,
  `name2` varchar(50) DEFAULT NULL,
  `address2` varchar(50) DEFAULT NULL,
  `numTrans3` varchar(50) DEFAULT NULL,
  `name3` varchar(50) DEFAULT NULL,
  `address3` varchar(50) DEFAULT NULL,
  `studId` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `teacher` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`formId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transcriptform`
--

LOCK TABLES `transcriptform` WRITE;
/*!40000 ALTER TABLE `transcriptform` DISABLE KEYS */;
INSERT INTO `transcriptform` VALUES (1,'SPRING','12','14','FALL','FALL 14','1','Ryan','1020 Phyllis St NMB SC 29582',NULL,NULL,NULL,NULL,NULL,NULL,'1','Approved','1'),(2,'1','123','123','1','','1','rrr',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `transcriptform` ENABLE KEYS */;
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

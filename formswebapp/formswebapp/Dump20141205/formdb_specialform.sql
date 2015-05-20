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
-- Table structure for table `specialform`
--

DROP TABLE IF EXISTS `specialform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specialform` (
  `year` varchar(50) DEFAULT NULL,
  `term` varchar(50) DEFAULT NULL,
  `dept1` varchar(50) DEFAULT NULL,
  `dept2` varchar(50) DEFAULT NULL,
  `dept3` varchar(50) DEFAULT NULL,
  `dept4` varchar(50) DEFAULT NULL,
  `course1` varchar(50) DEFAULT NULL,
  `course2` varchar(50) DEFAULT NULL,
  `course3` varchar(50) DEFAULT NULL,
  `course4` varchar(50) DEFAULT NULL,
  `section1` varchar(50) DEFAULT NULL,
  `section2` varchar(50) DEFAULT NULL,
  `section3` varchar(50) DEFAULT NULL,
  `section4` varchar(50) DEFAULT NULL,
  `credit1` varchar(50) DEFAULT NULL,
  `credit2` varchar(50) DEFAULT NULL,
  `credit3` varchar(50) DEFAULT NULL,
  `credit4` varchar(50) DEFAULT NULL,
  `permission1` varchar(50) DEFAULT NULL,
  `permission2` varchar(50) DEFAULT NULL,
  `permission3` varchar(50) DEFAULT NULL,
  `permission4` varchar(50) DEFAULT NULL,
  `formId` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `studId` varchar(50) DEFAULT NULL,
  `teacher` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialform`
--

LOCK TABLES `specialform` WRITE;
/*!40000 ALTER TABLE `specialform` DISABLE KEYS */;
INSERT INTO `specialform` VALUES ('2014','fall',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','Approved',NULL,NULL),('sadf','2','asdf','asdf','asdf','adf','asdf','asdf','adsf','asdf','asdf','asdf','asdf','asdf','asdf','asdf','asdf','asdf','adsf','asdfa','sdfasdf','asdfasdf',NULL,'In Progress',NULL,'1'),('2104',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'In Progress','1',NULL),('123444','undefined','1234','','','','','','','','','','','','','','','','','','','',NULL,'In Progress','undefined',NULL);
/*!40000 ALTER TABLE `specialform` ENABLE KEYS */;
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

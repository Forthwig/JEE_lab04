CREATE DATABASE  IF NOT EXISTS `junia_lab03` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `junia_lab03`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: junia_lab03
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `ingenieur`
--

DROP TABLE IF EXISTS `ingenieur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingenieur` (
                                `id` bigint(20) NOT NULL,
                                `login` varchar(255) DEFAULT NULL,
                                `password` varchar(255) DEFAULT NULL,
                                `enable` int(1) DEFAULT NULL,
                                `role` varchar(255) DEFAULT NULL,
                                `creationDate` datetime DEFAULT NULL,
                                `updateDate` datetime DEFAULT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingenieur`
--

LOCK TABLES `ingenieur` WRITE;
/*!40000 ALTER TABLE `ingenieur` DISABLE KEYS */;
INSERT INTO `ingenieur` VALUES (1,'junia','isen',1,'ROLE_USER','2019-09-16 10:00:38',NULL),(2,'hei','isa',1,'ROLE_USER','2019-09-16 10:00:38',NULL);
/*!40000 ALTER TABLE `ingenieur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `businesstype`
--

DROP TABLE IF EXISTS `businesstype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `businesstype` (
  `id` bigint(20) NOT NULL,
  `creationDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `businesstype`
--

LOCK TABLES `businesstype` WRITE;
/*!40000 ALTER TABLE `businesstype` DISABLE KEYS */;
INSERT INTO `businesstype` VALUES (6,'2019-09-16 10:00:38',NULL,'retail'),(7,'2019-09-16 10:00:38',NULL,'healthcare'),(8,'2019-09-16 10:00:38',NULL,'phone'),(9,'2019-09-16 10:00:38',NULL,'aeronautics'),(10,'2019-09-16 10:00:39',NULL,'food');
/*!40000 ALTER TABLE `businesstype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL,
  `creationDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'2019-09-16 10:00:38',NULL,'Worldline'),(2,'2019-09-16 10:00:38',NULL,'Sopra Steria'),(3,'2019-09-16 10:00:38',NULL,'Atos'),(4,'2019-09-16 10:00:38',NULL,'Cap Gemini'),(5,'2019-09-16 10:00:38',NULL,'CGI');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `creationDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `businessType_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3exe18sbal0uyd01iuhed23uf` (`businessType_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (11,'2019-09-16 10:00:39',NULL,'Auchan',6),(12,'2019-09-16 10:00:39',NULL,'Carrefour',6),(13,'2019-09-16 10:00:39',NULL,'Walmart',6),(14,'2019-09-16 10:00:39',NULL,'Philips',7),(15,'2019-09-16 10:00:39',NULL,'GE',7),(16,'2019-09-16 10:00:39',NULL,'Orange',8),(17,'2019-09-16 10:00:39',NULL,'Airbus',9),(18,'2019-09-16 10:00:39',NULL,'Boeing',9),(19,'2019-09-16 10:00:39',NULL,'Kraft',10),(20,'2019-09-16 10:00:39',NULL,'Nestle',10);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (35),(35),(35),(35);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` bigint(20) NOT NULL,
  `creationDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpub41wp2ytydeu4wkkp71xfq2` (`company_id`),
  KEY `FKsbm64qmwf17w5fdaueknmxbji` (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (21,'2019-09-16 10:00:39',NULL,'Webmail refactoring',1,16),(22,'2019-09-16 10:00:39',NULL,'Legacy project',3,18),(23,'2019-09-16 10:00:39',NULL,'Digital transformation',4,19),(24,'2019-09-16 10:00:39',NULL,'5G deployment',2,16),(25,'2019-09-16 10:00:39',NULL,'Cloud storage',2,16),(26,'2019-09-16 10:00:39',NULL,'RFID update',2,16),(27,'2019-09-16 10:00:39',NULL,'Mobile App',5,20),(28,'2019-09-16 10:00:39',NULL,'Mobile App',4,20),(29,'2019-09-16 10:00:39',NULL,'5G deployment',1,16),(30,'2019-09-16 10:00:39',NULL,'Project Management',3,17),(31,'2019-09-16 10:00:39',NULL,'Payment system',1,11),(32,'2019-09-16 10:00:39',NULL,'Webstore',1,13);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'junia_lab03'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-21 23:38:14

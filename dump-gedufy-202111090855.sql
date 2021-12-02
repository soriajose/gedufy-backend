-- MySQL dump 10.13  Distrib 5.5.39, for Win32 (x86)
--
-- Host: localhost    Database: gedufy
-- ------------------------------------------------------
-- Server version	5.5.39

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
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `imagen` varchar(500) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `cant_horas` int(11) DEFAULT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  `url` varchar(250) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `deleted_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Social Media Marketing','Este curso de Social Media Marketing...','https://img-c.udemycdn.com/course/240x135/1163506_89ed.jpg',15500,160,'Redes Sociales','https://www.udemy.com/course/curso-social-media-marketing/','2021-08-17 06:00:00','2021-08-17 06:00:00',NULL,'etorrielli','etorrielli',NULL),(2,'Data Science','Este curso de Data Science...','https://img-c.udemycdn.com/course/240x135/1606018_069c.jpg',25600,320,'Ciencia Datos','https://www.udemy.com/course/machinelearningpython/','2021-08-17 06:00:00','2021-08-17 06:00:00',NULL,'etorrielli','etorrielli',NULL),(3,'Ciencia de Datos','Este curso de Python para Ciencia de Datos...','https://img-c.udemycdn.com/course/240x135/2909820_5b11_5.jpg',28600,400,'Ciencia Datos','https://www.udemy.com/course/ciencia-de-datos-python/','2021-08-17 06:00:00','2021-08-17 06:00:00',NULL,'etorrielli','etorrielli',NULL),(4,'Máster en Java','Este curso de Máster Completo en Java...','https://img-c.udemycdn.com/course/240x135/3078492_1a27_2.jpg',28600,400,'Desarrollo','https://www.udemy.com/course/master-completo-java-de-cero-a-experto/','2021-08-17 06:00:00','2021-08-17 06:00:00',NULL,'etorrielli','etorrielli',NULL),(5,'Python','Este curso de Python...','https://img-c.udemycdn.com/course/480x270/882422_0549_11.jpg',28600,400,'Desarrollo','https://www.udemy.com/course/python-3-al-completo-desde-cero/','2021-08-17 06:00:00','2021-08-17 06:00:00',NULL,'etorrielli','etorrielli',NULL),(6,'MongoDB','Este curso de MongoDB...','https://img-c.udemycdn.com/course/480x270/4314704_3c63.jpg',28600,400,'Base de Datos','https://www.udemy.com/course/curso-completo-de-bases-de-datos-mongodb-y-nosql/','2021-10-28 07:48:56','2021-10-28 07:48:56',NULL,'etorrielli','etorrielli',NULL);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `dni` varchar(10) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `tipo_persona_id` int(11) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `deleted_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ix_email` (`email`),
  UNIQUE KEY `ix_dni` (`dni`),
  KEY `fk_tipo_persona` (`tipo_persona_id`),
  CONSTRAINT `fk_tipo_persona` FOREIGN KEY (`tipo_persona_id`) REFERENCES `tipo_persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Emanuel Ginobili','20111222','2020-01-01',NULL,'manu@mail.com',NULL,1,NULL,NULL,'2021-09-01 07:45:05',NULL,NULL,'anonimo'),(2,'Luis Scola','20222555',NULL,NULL,'luis@mail.com',NULL,1,NULL,NULL,'2021-09-02 11:14:33',NULL,NULL,'anonimo'),(3,'Facundo Campazo','20222666',NULL,NULL,'facu@mail.com',NULL,1,'2021-09-10 16:09:47','2021-09-10 16:09:47',NULL,'anonimo','anonimo',NULL),(4,'Leandro Bolmaro','88777666','2020-05-16','3512333222','leandro@mail.com','Barcelona',1,'2021-09-01 07:10:59',NULL,NULL,'anonimo',NULL,NULL),(5,'Andrés Chapu Nocioni','22777666','1980-05-23',NULL,'andres@mail.com','Argentina',1,'2021-09-01 07:13:36','2021-09-01 07:44:11',NULL,'anonimo','anonimo',NULL),(6,'Carlos Delfino','44555888',NULL,NULL,'carlos@mail.com',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL),(8,'Lebron Juan James','44555999',NULL,NULL,'lebron@mail.com','EEUU',1,'2021-09-02 11:01:34','2021-09-02 11:10:38',NULL,'anonimo','anonimo',NULL);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona_curso`
--

DROP TABLE IF EXISTS `persona_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona_curso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `persona_id` int(11) NOT NULL,
  `curso_id` int(11) NOT NULL,
  `observacion` varchar(100) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `deleted_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_persona_id` (`persona_id`),
  KEY `fk_curso_id` (`curso_id`),
  CONSTRAINT `fk_curso_id` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id`),
  CONSTRAINT `fk_persona_id` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona_curso`
--

LOCK TABLES `persona_curso` WRITE;
/*!40000 ALTER TABLE `persona_curso` DISABLE KEYS */;
INSERT INTO `persona_curso` VALUES (1,1,1,NULL,'2021-08-17 06:00:00','2021-08-17 06:00:00',NULL,'etorrielli','etorrielli',NULL),(2,2,1,NULL,'2021-08-17 06:00:00','2021-08-17 06:00:00',NULL,'etorrielli','etorrielli',NULL),(3,3,1,'Asignacion de prueba',NULL,NULL,NULL,NULL,NULL,NULL),(8,6,2,NULL,'2021-11-04 12:03:08','2021-11-04 12:03:08',NULL,'carlos@mail.com','carlos@mail.com',NULL),(15,2,3,NULL,'2021-11-04 13:39:28','2021-11-04 13:39:28',NULL,'luis@mail.com','luis@mail.com',NULL),(32,4,6,NULL,'2021-11-04 17:29:11','2021-11-04 17:29:11',NULL,'leandro@mail.com','leandro@mail.com',NULL),(33,8,1,NULL,'2021-11-04 17:33:11','2021-11-04 17:33:11',NULL,'lebron@mail.com','lebron@mail.com',NULL),(34,8,2,NULL,'2021-11-04 17:33:33','2021-11-04 17:33:33',NULL,'lebron@mail.com','lebron@mail.com',NULL);
/*!40000 ALTER TABLE `persona_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_persona`
--

DROP TABLE IF EXISTS `tipo_persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `created_by` varchar(30) DEFAULT NULL,
  `updated_by` varchar(30) DEFAULT NULL,
  `deleted_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_persona`
--

LOCK TABLES `tipo_persona` WRITE;
/*!40000 ALTER TABLE `tipo_persona` DISABLE KEYS */;
INSERT INTO `tipo_persona` VALUES (1,'ALUMNO',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'PROFESOR',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tipo_persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'gedufy'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-09  8:55:36

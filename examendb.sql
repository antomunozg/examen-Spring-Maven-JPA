-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: examendb
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `edad` int NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `zona_horaria` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (27,1,'Pasto','Antonio munoz','America/Bogota');
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante_examen`
--

DROP TABLE IF EXISTS `estudiante_examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante_examen` (
  `fecha_presentacion` datetime(6) DEFAULT NULL,
  `id_estudiante` bigint DEFAULT NULL,
  `id_estudiante_examen` bigint NOT NULL AUTO_INCREMENT,
  `id_examen` bigint DEFAULT NULL,
  PRIMARY KEY (`id_estudiante_examen`),
  KEY `FKil8qvpvk2tr7y23ta5gxu32ky` (`id_estudiante`),
  KEY `FKcrooycp62t641t64dij8kcewg` (`id_examen`),
  CONSTRAINT `FKcrooycp62t641t64dij8kcewg` FOREIGN KEY (`id_examen`) REFERENCES `examen` (`id`),
  CONSTRAINT `FKil8qvpvk2tr7y23ta5gxu32ky` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiante` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante_examen`
--

LOCK TABLES `estudiante_examen` WRITE;
/*!40000 ALTER TABLE `estudiante_examen` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudiante_examen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examen`
--

DROP TABLE IF EXISTS `examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examen` (
  `puntaje_total` int NOT NULL,
  `fecha_presentacion` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examen`
--

LOCK TABLES `examen` WRITE;
/*!40000 ALTER TABLE `examen` DISABLE KEYS */;
/*!40000 ALTER TABLE `examen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opcion`
--

DROP TABLE IF EXISTS `opcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opcion` (
  `es_correcta` bit(1) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `pregunta_id` bigint DEFAULT NULL,
  `texto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmbls7mhuqgs6v9ejkyehe93k8` (`pregunta_id`),
  CONSTRAINT `FKmbls7mhuqgs6v9ejkyehe93k8` FOREIGN KEY (`pregunta_id`) REFERENCES `pregunta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opcion`
--

LOCK TABLES `opcion` WRITE;
/*!40000 ALTER TABLE `opcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `opcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pregunta` (
  `puntaje` int NOT NULL,
  `examen_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `enunciado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoh775l3nb726t80q153sq3vp4` (`examen_id`),
  CONSTRAINT `FKoh775l3nb726t80q153sq3vp4` FOREIGN KEY (`examen_id`) REFERENCES `examen` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta`
--

LOCK TABLES `pregunta` WRITE;
/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respuesta` (
  `estudiante_id` bigint DEFAULT NULL,
  `examen_id` bigint DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `opcion_id` bigint DEFAULT NULL,
  `pregunta_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq9dhnfgf2cxj3s2s0uyf9xjn2` (`estudiante_id`),
  KEY `FKc1x3yuggq6c2680eqi6ew8c2h` (`examen_id`),
  KEY `FK74432jjxb0xi8pqbr4mt82v98` (`opcion_id`),
  KEY `FKd9oyrwyjw1otr38btjeevanif` (`pregunta_id`),
  CONSTRAINT `FK74432jjxb0xi8pqbr4mt82v98` FOREIGN KEY (`opcion_id`) REFERENCES `opcion` (`id`),
  CONSTRAINT `FKc1x3yuggq6c2680eqi6ew8c2h` FOREIGN KEY (`examen_id`) REFERENCES `examen` (`id`),
  CONSTRAINT `FKd9oyrwyjw1otr38btjeevanif` FOREIGN KEY (`pregunta_id`) REFERENCES `pregunta` (`id`),
  CONSTRAINT `FKq9dhnfgf2cxj3s2s0uyf9xjn2` FOREIGN KEY (`estudiante_id`) REFERENCES `estudiante` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta`
--

LOCK TABLES `respuesta` WRITE;
/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'examendb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-22 16:35:39

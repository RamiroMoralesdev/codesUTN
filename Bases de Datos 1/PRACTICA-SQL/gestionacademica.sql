-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: gestionacademica
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `id` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `id_carrera` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_alumnos_id_carrera` (`id_carrera`),
  CONSTRAINT `fk_alumnos_id_carrera` FOREIGN KEY (`id_carrera`) REFERENCES `carreras` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'Ana','Gomez',20,111),(2,'Juan','Perez',21,222),(3,'Sol','Martinez',22,NULL);
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignaturas`
--

DROP TABLE IF EXISTS `asignaturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignaturas` (
  `id` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `creditos` int DEFAULT NULL,
  `id_carrera` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_asignaturas_id_carrera` (`id_carrera`),
  CONSTRAINT `fk_asignaturas_id_carrera` FOREIGN KEY (`id_carrera`) REFERENCES `carreras` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignaturas`
--

LOCK TABLES `asignaturas` WRITE;
/*!40000 ALTER TABLE `asignaturas` DISABLE KEYS */;
INSERT INTO `asignaturas` VALUES (1,'MATEMATICA I ',8,1),(2,'PROGRMACION I',12,1),(3,'BASE DE DATOS I',12,222),(4,'ESTRUCTURAS DE DATOS',8,111),(5,'INTELIGENCIA ARTIFICIAL I',6,111),(6,'ELECTRONICA BASICA',8,111),(7,'REDES',12,222);
/*!40000 ALTER TABLE `asignaturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carreras`
--

DROP TABLE IF EXISTS `carreras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carreras` (
  `id` int NOT NULL,
  `nombre_carrera` varchar(45) DEFAULT NULL,
  `duracion` tinyint(1) DEFAULT NULL,
  `departamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carreras`
--

LOCK TABLES `carreras` WRITE;
/*!40000 ALTER TABLE `carreras` DISABLE KEYS */;
INSERT INTO `carreras` VALUES (1,'CIENCIA DE DATOS',5,'SISTEMAS'),(2,'ANALISIS DE DATOS',3,'SISTEMAS'),(3,'DISEÑO WEB',3,'ARTES Y DISEÑO'),(111,'Informatica',NULL,NULL),(222,'Electronica',NULL,NULL),(333,'Quimica',NULL,NULL);
/*!40000 ALTER TABLE `carreras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matriculas`
--

DROP TABLE IF EXISTS `matriculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matriculas` (
  `id_alumno` int NOT NULL,
  `id_asignatura` int NOT NULL,
  `calificacion` decimal(3,1) DEFAULT NULL,
  PRIMARY KEY (`id_alumno`,`id_asignatura`),
  KEY `id_asignatura` (`id_asignatura`),
  CONSTRAINT `matriculas_ibfk_1` FOREIGN KEY (`id_alumno`) REFERENCES `alumnos` (`id`),
  CONSTRAINT `matriculas_ibfk_2` FOREIGN KEY (`id_asignatura`) REFERENCES `asignaturas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matriculas`
--

LOCK TABLES `matriculas` WRITE;
/*!40000 ALTER TABLE `matriculas` DISABLE KEYS */;
INSERT INTO `matriculas` VALUES (1,1,9.0),(1,2,8.0),(2,3,7.5),(3,1,6.5);
/*!40000 ALTER TABLE `matriculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vista_alumnos_basica`
--

DROP TABLE IF EXISTS `vista_alumnos_basica`;
/*!50001 DROP VIEW IF EXISTS `vista_alumnos_basica`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_alumnos_basica` AS SELECT 
 1 AS `id`,
 1 AS `nombre`,
 1 AS `apellido`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_alumnos_carreras`
--

DROP TABLE IF EXISTS `vista_alumnos_carreras`;
/*!50001 DROP VIEW IF EXISTS `vista_alumnos_carreras`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_alumnos_carreras` AS SELECT 
 1 AS `id`,
 1 AS `nombre_carrera`,
 1 AS `duracion`,
 1 AS `departamento`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_alumnos_carreras_1`
--

DROP TABLE IF EXISTS `vista_alumnos_carreras_1`;
/*!50001 DROP VIEW IF EXISTS `vista_alumnos_carreras_1`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_alumnos_carreras_1` AS SELECT 
 1 AS `id`,
 1 AS `nombre_carrera`,
 1 AS `duracion`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_alumnos_carreras_2`
--

DROP TABLE IF EXISTS `vista_alumnos_carreras_2`;
/*!50001 DROP VIEW IF EXISTS `vista_alumnos_carreras_2`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_alumnos_carreras_2` AS SELECT 
 1 AS `id`,
 1 AS `nombre_carrera`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_alumnos_mayores`
--

DROP TABLE IF EXISTS `vista_alumnos_mayores`;
/*!50001 DROP VIEW IF EXISTS `vista_alumnos_mayores`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_alumnos_mayores` AS SELECT 
 1 AS `nombre`,
 1 AS `apellido`,
 1 AS `edad`,
 1 AS `nombre_carrera`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_asignaturas_carrera`
--

DROP TABLE IF EXISTS `vista_asignaturas_carrera`;
/*!50001 DROP VIEW IF EXISTS `vista_asignaturas_carrera`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_asignaturas_carrera` AS SELECT 
 1 AS `nombre_asignatura`,
 1 AS `creditos`,
 1 AS `nombre_carrera`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_asignaturas_credito_5`
--

DROP TABLE IF EXISTS `vista_asignaturas_credito_5`;
/*!50001 DROP VIEW IF EXISTS `vista_asignaturas_credito_5`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_asignaturas_credito_5` AS SELECT 
 1 AS `nombre`,
 1 AS `creditos`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_asignaturas_credito_alto`
--

DROP TABLE IF EXISTS `vista_asignaturas_credito_alto`;
/*!50001 DROP VIEW IF EXISTS `vista_asignaturas_credito_alto`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_asignaturas_credito_alto` AS SELECT 
 1 AS `nombre`,
 1 AS `creditos`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_asignaturas_creditos`
--

DROP TABLE IF EXISTS `vista_asignaturas_creditos`;
/*!50001 DROP VIEW IF EXISTS `vista_asignaturas_creditos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_asignaturas_creditos` AS SELECT 
 1 AS `id`,
 1 AS `nombre`,
 1 AS `creditos`,
 1 AS `id_carrera`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_creditos_por_alumno`
--

DROP TABLE IF EXISTS `vista_creditos_por_alumno`;
/*!50001 DROP VIEW IF EXISTS `vista_creditos_por_alumno`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_creditos_por_alumno` AS SELECT 
 1 AS `id`,
 1 AS `nombre`,
 1 AS `apellido`,
 1 AS `nombre_carrera`,
 1 AS `total_creditos`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vista_alumnos_basica`
--

/*!50001 DROP VIEW IF EXISTS `vista_alumnos_basica`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_alumnos_basica` AS select `alumnos`.`id` AS `id`,`alumnos`.`nombre` AS `nombre`,`alumnos`.`apellido` AS `apellido` from `alumnos` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_alumnos_carreras`
--

/*!50001 DROP VIEW IF EXISTS `vista_alumnos_carreras`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_alumnos_carreras` AS select `carreras`.`id` AS `id`,`carreras`.`nombre_carrera` AS `nombre_carrera`,`carreras`.`duracion` AS `duracion`,`carreras`.`departamento` AS `departamento` from `carreras` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_alumnos_carreras_1`
--

/*!50001 DROP VIEW IF EXISTS `vista_alumnos_carreras_1`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_alumnos_carreras_1` AS select `carreras`.`id` AS `id`,`carreras`.`nombre_carrera` AS `nombre_carrera`,`carreras`.`duracion` AS `duracion` from `carreras` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_alumnos_carreras_2`
--

/*!50001 DROP VIEW IF EXISTS `vista_alumnos_carreras_2`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_alumnos_carreras_2` AS select `carreras`.`id` AS `id`,`carreras`.`nombre_carrera` AS `nombre_carrera` from `carreras` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_alumnos_mayores`
--

/*!50001 DROP VIEW IF EXISTS `vista_alumnos_mayores`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_alumnos_mayores` AS select `al`.`nombre` AS `nombre`,`al`.`apellido` AS `apellido`,`al`.`edad` AS `edad`,`c`.`nombre_carrera` AS `nombre_carrera` from (`alumnos` `al` join `carreras` `c` on((`al`.`id_carrera` = `c`.`id`))) where (`al`.`edad` > 20) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_asignaturas_carrera`
--

/*!50001 DROP VIEW IF EXISTS `vista_asignaturas_carrera`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_asignaturas_carrera` AS select `a`.`nombre` AS `nombre_asignatura`,`a`.`creditos` AS `creditos`,`c`.`nombre_carrera` AS `nombre_carrera` from (`asignaturas` `a` join `carreras` `c` on((`a`.`id_carrera` = `c`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_asignaturas_credito_5`
--

/*!50001 DROP VIEW IF EXISTS `vista_asignaturas_credito_5`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_asignaturas_credito_5` AS select `asignaturas`.`nombre` AS `nombre`,`asignaturas`.`creditos` AS `creditos` from `asignaturas` where (`asignaturas`.`creditos` > 5) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_asignaturas_credito_alto`
--

/*!50001 DROP VIEW IF EXISTS `vista_asignaturas_credito_alto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_asignaturas_credito_alto` AS select `asignaturas`.`nombre` AS `nombre`,`asignaturas`.`creditos` AS `creditos` from `asignaturas` where (`asignaturas`.`creditos` > 5) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_asignaturas_creditos`
--

/*!50001 DROP VIEW IF EXISTS `vista_asignaturas_creditos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_asignaturas_creditos` AS select `asignaturas`.`id` AS `id`,`asignaturas`.`nombre` AS `nombre`,`asignaturas`.`creditos` AS `creditos`,`asignaturas`.`id_carrera` AS `id_carrera` from `asignaturas` where (`asignaturas`.`creditos` > 3) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_creditos_por_alumno`
--

/*!50001 DROP VIEW IF EXISTS `vista_creditos_por_alumno`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_creditos_por_alumno` AS select `al`.`id` AS `id`,`al`.`nombre` AS `nombre`,`al`.`apellido` AS `apellido`,`c`.`nombre_carrera` AS `nombre_carrera`,sum(`asig`.`creditos`) AS `total_creditos` from ((`alumnos` `al` join `carreras` `c` on((`al`.`id_carrera` = `c`.`id`))) join `asignaturas` `asig` on((`al`.`id_carrera` = `asig`.`id_carrera`))) group by `al`.`id`,`al`.`nombre`,`al`.`apellido`,`c`.`nombre_carrera` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-02 18:06:25

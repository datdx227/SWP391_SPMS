CREATE DATABASE  IF NOT EXISTS `spm` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `spm`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: spm
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `class_id` int NOT NULL AUTO_INCREMENT,
  `subject_id` int DEFAULT NULL,
  `class_code` varchar(50) DEFAULT NULL,
  `term_name` varchar(50) DEFAULT NULL,
  `is_block5` tinyint(1) DEFAULT NULL,
  `trainer_id` int DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `creator_id` int DEFAULT NULL,
  `updater_id` int DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `subject_id` (`subject_id`),
  KEY `trainer_id` (`trainer_id`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `class_ibfk_2` FOREIGN KEY (`trainer_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,1,'SE1619_SYB301','Summer',0,4,0,NULL,32,NULL,'2022-08-28 20:39:32'),(2,2,'SE1620_SYB301','Fall',0,9,1,NULL,32,NULL,'2022-08-28 20:40:31'),(3,1,'SE1621_SYB301','Spring',0,4,1,NULL,NULL,NULL,NULL),(4,1,'SE1622_SYB301','Fall',1,12,1,NULL,NULL,NULL,NULL),(5,1,'SE1623_SYB301','Summer',0,2,0,NULL,NULL,NULL,NULL),(6,1,'SE1624_SYB301','Fall',0,10,1,NULL,NULL,NULL,NULL),(7,1,'SE1625_SYB301','Spring',1,5,0,NULL,NULL,NULL,NULL),(8,1,'SE1626_SYB301','Spring',0,11,0,NULL,NULL,NULL,NULL),(9,1,'SE1627_SYB301','Summer',1,3,0,NULL,NULL,NULL,NULL),(10,1,'SE1628_SYB301','Fall',1,11,0,NULL,NULL,NULL,NULL),(11,1,'SE1629_SYB301','Spring',0,6,0,NULL,NULL,NULL,NULL),(12,1,'SE1630_SYB301','Fall',1,13,1,NULL,NULL,NULL,NULL),(13,1,'SE1631_SYB301','Summer',1,4,1,NULL,NULL,NULL,NULL),(14,1,'SE1632_SYB301','Fall',1,12,1,NULL,NULL,NULL,NULL),(15,1,'SE1633_SYB301','Spring',1,7,0,NULL,NULL,NULL,NULL),(16,2,'SE1619_SWD391','Summer',0,1,1,NULL,NULL,NULL,NULL),(17,2,'SE1620_SWD391','Summer',0,5,1,NULL,NULL,NULL,NULL),(18,2,'SE1621_SWD391','Fall',0,13,1,NULL,NULL,NULL,NULL),(19,2,'SE1622_SWD391','Spring',0,8,1,NULL,NULL,NULL,NULL),(20,2,'SE1623_SWD391','Summer',0,2,1,NULL,NULL,NULL,NULL),(21,2,'SE1624_SWD391','Summer',1,6,0,NULL,NULL,NULL,NULL),(22,2,'SE1625_SWD391','Fall',1,1,1,NULL,NULL,NULL,NULL),(23,2,'SE1626_SWD391','Spring',0,9,0,NULL,NULL,NULL,NULL),(24,2,'SE1627_SWD391','Fall',1,3,1,NULL,NULL,NULL,NULL),(25,2,'SE1628_SWD391','Summer',0,7,1,NULL,NULL,NULL,NULL),(26,2,'SE1629_SWD391','Fall',1,2,0,NULL,NULL,NULL,NULL),(27,2,'SE1630_SWD391','Spring',1,10,1,NULL,NULL,NULL,NULL),(28,2,'SE1631_SWD391','Spring',0,4,0,NULL,NULL,NULL,NULL),(29,2,'SE1632_SWD391','Summer',1,8,1,NULL,NULL,NULL,NULL),(30,2,'SE1633_SWD391','Fall',0,3,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_setting`
--

DROP TABLE IF EXISTS `class_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_setting` (
  `setting_id` int NOT NULL AUTO_INCREMENT,
  `setting_title` varchar(60) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `setting_value` varchar(45) DEFAULT NULL,
  `display_order` int DEFAULT NULL,
  `class_id` int DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  PRIMARY KEY (`setting_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_setting`
--

LOCK TABLES `class_setting` WRITE;
/*!40000 ALTER TABLE `class_setting` DISABLE KEYS */;
INSERT INTO `class_setting` VALUES (1,'Math','123',3,1,'Toán hoc 1',_binary '',1),(2,'Literature','321',5,NULL,'van hoc',_binary '',1),(3,'Physics','34',2,NULL,'vat ly',_binary '',2),(4,'Chemistry','34',4,NULL,'hoa hoc',_binary '',2),(6,'ClassSetting','1',1,1,'Active',_binary '\0',3),(7,'ClassSetting','2',2,1,'Close',NULL,3),(8,'ClassSetting','3',3,1,'Cancelled',NULL,2);
/*!40000 ALTER TABLE `class_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluation_criteria`
--

DROP TABLE IF EXISTS `evaluation_criteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluation_criteria` (
  `criteria_id` int NOT NULL AUTO_INCREMENT,
  `iteration_id` int DEFAULT NULL,
  `criteria_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `is_team_eval` tinyint(1) DEFAULT NULL,
  `eval_weight` int DEFAULT NULL,
  `max_loc` int DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `description` longtext,
  `creator_id` int DEFAULT NULL,
  `updater_id` int DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`criteria_id`),
  KEY `iteration_id` (`iteration_id`),
  KEY `creator_id` (`creator_id`),
  KEY `updater_id` (`updater_id`),
  CONSTRAINT `evaluation_criteria_ibfk_1` FOREIGN KEY (`iteration_id`) REFERENCES `iteration` (`iteration_id`),
  CONSTRAINT `evaluation_criteria_ibfk_2` FOREIGN KEY (`creator_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `evaluation_criteria_ibfk_3` FOREIGN KEY (`updater_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluation_criteria`
--

LOCK TABLES `evaluation_criteria` WRITE;
/*!40000 ALTER TABLE `evaluation_criteria` DISABLE KEYS */;
INSERT INTO `evaluation_criteria` VALUES (1,1,'criteria 1',1,70,240,1,'iteration 1 criteria 1 description',NULL,NULL,NULL,NULL),(2,1,'criteria 2',1,20,120,1,'iteration 1 criteria 2 description',NULL,NULL,NULL,NULL),(3,1,'criteria 3',1,10,60,1,'iteration 1 criteria 3 description',NULL,NULL,NULL,NULL),(4,2,'criteria 1',1,60,180,1,'iteration 2 criteria 1 description',NULL,NULL,NULL,NULL),(5,2,'criteria 2',1,20,120,1,'iteration 2 criteria 2 description',NULL,NULL,NULL,NULL),(6,2,'criteria 3',1,20,120,1,'iteration 2 criteria 3 description',NULL,NULL,NULL,NULL),(7,1,'asdasd',1,80,180,0,'',32,32,'2022-08-28 20:38:22','2022-08-28 20:38:47');
/*!40000 ALTER TABLE `evaluation_criteria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `function`
--

DROP TABLE IF EXISTS `function`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `function` (
  `function_id` int NOT NULL AUTO_INCREMENT,
  `team_id` int DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `feature` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `priority` int DEFAULT NULL,
  `is_closed` tinyint(1) DEFAULT NULL,
  `submit_status` tinyint(1) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`function_id`),
  KEY `team_id` (`team_id`),
  CONSTRAINT `function_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `function`
--

LOCK TABLES `function` WRITE;
/*!40000 ALTER TABLE `function` DISABLE KEYS */;
INSERT INTO `function` VALUES (1,1,'User profile','User',1,1,1,'Detail user information.'),(2,1,'Class Setting','Class',2,0,0,'setting for class function.'),(3,2,'Build Structure','Package',1,0,1,''),(4,3,'Add to cart','Cart',3,0,0,'Add product to cart.');
/*!40000 ALTER TABLE `function` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue`
--

DROP TABLE IF EXISTS `issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `issue` (
  `issue_id` int NOT NULL AUTO_INCREMENT,
  `issue_title` varchar(50) DEFAULT NULL,
  `issue_type` varchar(50) DEFAULT NULL,
  `function_id` int DEFAULT NULL,
  `milestone_id` int DEFAULT NULL,
  `assigner_id` int DEFAULT NULL,
  `assignee_id` int DEFAULT NULL,
  `team_id` int DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `creator_id` int DEFAULT NULL,
  `updater_id` int DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `function_id` (`function_id`),
  KEY `milestone_id` (`milestone_id`),
  KEY `team_id` (`team_id`),
  KEY `assigner_id` (`assigner_id`),
  KEY `assignee_id` (`assignee_id`),
  CONSTRAINT `issue_ibfk_1` FOREIGN KEY (`function_id`) REFERENCES `function` (`function_id`),
  CONSTRAINT `issue_ibfk_2` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`milestone_id`),
  CONSTRAINT `issue_ibfk_3` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  CONSTRAINT `issue_ibfk_4` FOREIGN KEY (`assigner_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `issue_ibfk_5` FOREIGN KEY (`assignee_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue`
--

LOCK TABLES `issue` WRITE;
/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
INSERT INTO `issue` VALUES (1,'Issue 1','Performance Problems',1,1,4,15,1,1,NULL,NULL,NULL,NULL),(2,'Issue 2','Client Crashes',2,2,5,16,2,0,NULL,NULL,NULL,NULL),(3,'Issue 3','Behavior Problems',3,3,6,17,3,0,NULL,NULL,NULL,NULL),(4,'Issue 4','Source Error',4,3,7,18,4,0,NULL,NULL,NULL,NULL),(5,'Issue 5','Client Crashes',4,4,8,19,1,1,NULL,NULL,NULL,NULL),(6,'Issue 6','Source Error',3,5,9,20,2,1,NULL,NULL,NULL,NULL),(7,'Issue 7','Performance Problems',2,8,10,21,4,1,NULL,NULL,NULL,NULL),(8,'Issue 8','Behavior Problems',1,6,11,15,3,0,NULL,NULL,NULL,NULL),(9,'Issue 9','Behavior Problems',2,3,12,16,1,1,NULL,NULL,NULL,NULL),(10,'Issue 10','Behavior Problems',2,1,13,17,2,0,NULL,NULL,NULL,NULL),(11,'Issue 11','Performance Problems',2,1,11,18,3,1,NULL,NULL,NULL,NULL),(12,'Issue 12','Source Error',2,1,12,19,4,1,NULL,NULL,NULL,NULL),(13,'Issue 10','Client Crashes',2,1,11,21,1,1,NULL,NULL,NULL,NULL),(14,'Issue 14','Source Error',2,1,4,20,2,1,NULL,NULL,NULL,NULL),(15,'Issue 15','Client Crashes',2,1,5,15,3,0,NULL,NULL,NULL,NULL),(16,'Issue 16','Performance Problems',2,1,6,16,4,1,NULL,NULL,NULL,NULL),(17,'Issue 17','Behavior Problems',2,1,7,17,1,0,NULL,NULL,NULL,NULL),(18,'Issue 18','Performance Problems',2,1,8,18,2,1,NULL,NULL,NULL,NULL),(19,'Issue 19','Source Error',2,1,9,19,3,0,NULL,NULL,NULL,NULL),(20,'Issue 20','Client Crashes',2,1,10,20,4,1,NULL,NULL,NULL,NULL),(21,'Issue 21','Source Error',2,1,11,21,1,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iteration`
--

DROP TABLE IF EXISTS `iteration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `iteration` (
  `iteration_id` int NOT NULL AUTO_INCREMENT,
  `subject_id` int DEFAULT NULL,
  `iteration_name` varchar(50) DEFAULT NULL,
  `eval_weight` int DEFAULT NULL,
  `is_ongoing` tinyint(1) DEFAULT NULL,
  `description` longtext,
  `status` tinyint(1) DEFAULT NULL,
  `creator_id` int DEFAULT NULL,
  `updater_id` int DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`iteration_id`),
  KEY `subject_id` (`subject_id`),
  KEY `creator_id` (`creator_id`),
  KEY `updater_id` (`updater_id`),
  CONSTRAINT `iteration_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `iteration_ibfk_2` FOREIGN KEY (`creator_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `iteration_ibfk_3` FOREIGN KEY (`updater_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iteration`
--

LOCK TABLES `iteration` WRITE;
/*!40000 ALTER TABLE `iteration` DISABLE KEYS */;
INSERT INTO `iteration` VALUES (1,2,'Iteration 1',1,NULL,NULL,1,NULL,NULL,NULL,NULL),(2,2,'Iteration 2',1,NULL,NULL,1,NULL,NULL,NULL,NULL),(3,2,'Iteration 3',1,NULL,NULL,1,NULL,NULL,NULL,NULL),(4,2,'Iteration 4',1,NULL,NULL,1,NULL,NULL,NULL,NULL),(5,2,'Iteration 5',1,NULL,NULL,1,NULL,NULL,NULL,NULL),(6,4,'Iteration 1',1,NULL,NULL,0,NULL,NULL,NULL,NULL),(7,4,'Iteration 2',1,NULL,NULL,0,NULL,NULL,NULL,NULL),(8,4,'Iteration 3',1,NULL,NULL,0,NULL,NULL,NULL,NULL),(9,4,'Iteration 4',1,NULL,NULL,0,NULL,NULL,NULL,NULL),(10,4,'Iteration 5',1,NULL,NULL,0,NULL,NULL,NULL,NULL),(11,2,'iter 1',90,0,'',1,32,32,'2022-08-28 20:36:55','2022-08-28 20:37:19');
/*!40000 ALTER TABLE `iteration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iteration_evaluation`
--

DROP TABLE IF EXISTS `iteration_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `iteration_evaluation` (
  `evaluation_id` int NOT NULL AUTO_INCREMENT,
  `milestone_id` int DEFAULT NULL,
  `team_id` int DEFAULT NULL,
  `class_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `loc` int DEFAULT NULL,
  `bonus` int DEFAULT NULL,
  `total_grade` int DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `indi_comment` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `creator_id` int DEFAULT NULL,
  `updater_id` int DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`evaluation_id`),
  KEY `milestone_id` (`milestone_id`),
  KEY `team_id` (`team_id`),
  KEY `class_id` (`class_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `iteration_evaluation_ibfk_1` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`milestone_id`),
  CONSTRAINT `iteration_evaluation_ibfk_2` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  CONSTRAINT `iteration_evaluation_ibfk_3` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`),
  CONSTRAINT `iteration_evaluation_ibfk_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iteration_evaluation`
--

LOCK TABLES `iteration_evaluation` WRITE;
/*!40000 ALTER TABLE `iteration_evaluation` DISABLE KEYS */;
INSERT INTO `iteration_evaluation` VALUES (1,1,1,5,14,140,1,7,'Good','Good',NULL,NULL,NULL,NULL),(2,2,2,8,18,120,2,6,'Not bad','Not bad',NULL,NULL,NULL,NULL),(3,3,3,24,15,80,1,4,'Not good','Bad',NULL,NULL,NULL,NULL),(4,4,4,16,21,120,2,6,'Not bad','Not bad',NULL,NULL,NULL,NULL),(5,8,1,5,15,160,2,8,'Good','Good',NULL,NULL,NULL,NULL),(6,7,2,8,19,140,1,7,'Not bad','Not bad',NULL,NULL,NULL,NULL),(7,6,3,24,16,80,2,4,'Not good','Bad',NULL,NULL,NULL,NULL),(8,5,4,16,20,100,1,5,'Not bad','Not bad',NULL,NULL,NULL,NULL),(9,8,1,5,16,180,1,9,'Good','Good',NULL,NULL,NULL,NULL),(10,7,2,8,20,100,2,5,'Not bad','Not bad',NULL,NULL,NULL,NULL),(11,6,3,24,17,60,1,3,'Not good','Bad',NULL,NULL,NULL,NULL),(12,5,4,16,15,120,2,6,'Not bad','Not bad',NULL,NULL,NULL,NULL),(13,4,1,5,17,120,2,6,'Good','Good',NULL,NULL,NULL,NULL),(14,3,2,8,21,100,1,5,'Not bad','Not bad',NULL,NULL,NULL,NULL),(15,2,3,24,18,80,2,4,'Not good','Bad',NULL,NULL,NULL,NULL),(16,1,4,16,17,160,1,8,'Not bad','Good',NULL,NULL,NULL,NULL),(17,5,1,5,18,140,1,7,'Good','Good',NULL,NULL,NULL,NULL),(18,2,2,8,14,120,2,6,'Not bad','Not bad',NULL,NULL,NULL,NULL),(19,7,3,24,19,120,1,6,'Not good','Not bad',NULL,NULL,NULL,NULL),(20,6,4,16,16,120,2,6,'Not bad','Not bad',NULL,NULL,NULL,NULL),(21,1,1,NULL,1,NULL,2,7,'Khá ổn áp',NULL,NULL,NULL,NULL,NULL),(22,2,2,NULL,2,NULL,2,7,'Team làm được',NULL,NULL,NULL,NULL,NULL),(23,3,2,NULL,2,NULL,3,6,'red sun in the sky',NULL,NULL,NULL,NULL,NULL),(24,3,3,NULL,3,NULL,3,8,'Bing chilling',NULL,NULL,NULL,NULL,NULL),(25,4,4,NULL,4,NULL,3,10,'Hail Hitler',NULL,NULL,NULL,NULL,NULL),(26,4,4,NULL,4,NULL,3,6,'Hailll',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `iteration_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loc_evaluation`
--

DROP TABLE IF EXISTS `loc_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loc_evaluation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `function_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `milestone_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `Quality_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `complexity_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `converted_loc` varchar(45) DEFAULT NULL,
  `comment` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `student_id` int DEFAULT NULL,
  `function_id` int DEFAULT NULL,
  `milestone_id` int DEFAULT NULL,
  `complexity_id` int DEFAULT NULL,
  `quality_id` int DEFAULT NULL,
  `is_late_submit` bit(1) DEFAULT NULL,
  `new_milestone_id` int DEFAULT NULL,
  `new_complexity_id` int DEFAULT NULL,
  `new_quality_id` int DEFAULT NULL,
  `new_converted_loc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loc_evaluation`
--

LOCK TABLES `loc_evaluation` WRITE;
/*!40000 ALTER TABLE `loc_evaluation` DISABLE KEYS */;
INSERT INTO `loc_evaluation` VALUES (1,'Login','Mike 1','Good','Hard','40','OK',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'Logout','Mike 3','OK','Normal','50','OK',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'Search','Mike 2','Not Bad','Easy','30','OK',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'Looking','For','Some one','Old Timer','35','OK',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'Logout','Mike 5','Tuyet','Great','50','OK',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'Search','Search Student','Good','great','60','OK',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'Filter','Filter by price','Good','great','55','OK',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'Booking','Booking orders ','Good','Normal','70','OK',3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'Update','Update Orders','Not Bad','Hard','65','OK',4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `loc_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_evaluation`
--

DROP TABLE IF EXISTS `member_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_evaluation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `evaluation_id` int DEFAULT NULL,
  `criteria_id` int DEFAULT NULL,
  `total_loc` int DEFAULT NULL,
  `grade` double DEFAULT NULL,
  `comment` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `student_id` int DEFAULT NULL,
  `team_id` int DEFAULT NULL,
  `criteria_name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_evaluation`
--

LOCK TABLES `member_evaluation` WRITE;
/*!40000 ALTER TABLE `member_evaluation` DISABLE KEYS */;
INSERT INTO `member_evaluation` VALUES (1,1,1,130,7,'Essemble togerther',1,1,'High'),(2,2,3,150,7.5,'Drifting far away',1,1,'Low'),(3,2,2,175,6,'Her sins has taken everthing away',2,2,'Normal'),(4,2,2,130,10,'Never gonna give you up',2,2,'Normal'),(5,1,3,200,7,'Never say goodbye',2,2,'Low'),(6,2,3,210,5,'Never gonna hurt you',3,3,'Low'),(7,2,1,140,5.6,'Erikaaaa',3,3,'High'),(8,2,1,200,6.5,'Winter is Coming',4,4,'High');
/*!40000 ALTER TABLE `member_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `milestone`
--

DROP TABLE IF EXISTS `milestone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `milestone` (
  `milestone_id` int NOT NULL AUTO_INCREMENT,
  `milestone_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `iteration_id` int DEFAULT NULL,
  `class_id` int DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`milestone_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `milestone`
--

LOCK TABLES `milestone` WRITE;
/*!40000 ALTER TABLE `milestone` DISABLE KEYS */;
INSERT INTO `milestone` VALUES (1,'Milestone 1',1,1,'2022-08-16','2022-08-20','OK',1),(2,'Milestone 1',2,1,'2022-07-29','2022-08-10','OK',1),(3,'Milestone 2',1,2,'2022-07-16','2022-07-29','OK nha',0),(4,'Milestone 2',2,2,'2022-08-24','2022-08-21','OK',1),(5,'Milestone 5',1,1,'2022-08-16','2022-08-19','Open',1),(6,'Milestone 3',2,1,'2022-08-10','2022-09-10','Closed',1),(7,'Milestone 4',2,2,'2022-08-16','2022-09-10','Cancelled',1),(8,'Milestone 4',1,2,'2022-08-10','2022-09-10','Open',0);
/*!40000 ALTER TABLE `milestone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setting`
--

DROP TABLE IF EXISTS `setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `setting` (
  `setting_id` int NOT NULL AUTO_INCREMENT,
  `setting_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `setting_value` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  `setting_order` int DEFAULT NULL,
  `note` longtext,
  `status` tinyint(1) DEFAULT NULL,
  `creator_id` int DEFAULT NULL,
  `updater_id` int DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`setting_id`),
  KEY `type_id` (`type_id`),
  KEY `creator_id` (`creator_id`),
  KEY `updater_id` (`updater_id`),
  CONSTRAINT `setting_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `setting` (`setting_id`),
  CONSTRAINT `setting_ibfk_2` FOREIGN KEY (`creator_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `setting_ibfk_3` FOREIGN KEY (`updater_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setting`
--

LOCK TABLES `setting` WRITE;
/*!40000 ALTER TABLE `setting` DISABLE KEYS */;
INSERT INTO `setting` VALUES (1,'Role','',NULL,12,NULL,0,NULL,NULL,NULL,NULL),(2,'Admin','1',1,2,NULL,1,NULL,NULL,NULL,NULL),(3,'Manager','2',1,3,NULL,NULL,NULL,NULL,NULL,NULL),(4,'Trainer','3',1,4,NULL,NULL,NULL,NULL,NULL,NULL),(5,'Student','4',1,5,NULL,1,NULL,NULL,NULL,NULL),(6,'Contact Types',NULL,NULL,2,NULL,1,NULL,NULL,NULL,NULL),(7,'Bug Report',NULL,6,3,NULL,NULL,NULL,NULL,NULL,NULL),(8,'User Support',NULL,6,4,NULL,NULL,NULL,NULL,NULL,NULL),(9,'Affiliate Program',NULL,6,5,NULL,NULL,NULL,NULL,NULL,NULL),(10,'Milestone status',NULL,5,6,NULL,NULL,NULL,NULL,NULL,NULL),(11,'Function status',NULL,4,4,NULL,NULL,NULL,NULL,NULL,NULL),(12,'Issue status',NULL,3,3,NULL,NULL,NULL,NULL,NULL,NULL),(13,'Class Status',NULL,2,3,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `subject_id` int NOT NULL AUTO_INCREMENT,
  `subject_code` varchar(50) DEFAULT NULL,
  `subject_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `manager_id` int DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `description` longtext,
  `creator_id` int DEFAULT NULL,
  `updater_id` int DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `manager_id` (`manager_id`),
  KEY `creator_id` (`creator_id`),
  KEY `updater_id` (`updater_id`),
  CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `subject_ibfk_2` FOREIGN KEY (`creator_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `subject_ibfk_3` FOREIGN KEY (`updater_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'SYB301','Start Your Business',NULL,0,NULL,NULL,1,NULL,'2022-08-29 19:15:12'),(2,'SWD391','Software Architecture and Design',32,0,NULL,NULL,NULL,NULL,NULL),(3,'HCI201','Human-Computer Interaction',NULL,1,NULL,NULL,NULL,NULL,NULL),(4,'PRM391','Mobile Programming',32,0,NULL,NULL,NULL,NULL,NULL),(5,'ISC301','e-Commerce',NULL,1,NULL,NULL,NULL,NULL,NULL),(6,'ACC101','Principles of Accounting',NULL,1,NULL,NULL,NULL,NULL,NULL),(7,'MAS291','Statistics and Probability',NULL,0,NULL,NULL,NULL,NULL,NULL),(8,'DBW301','Data warehouse',NULL,1,NULL,NULL,NULL,NULL,NULL),(9,'PRX301','Web Development(XML)',NULL,1,NULL,NULL,NULL,NULL,NULL),(10,'MLN101','Principles of Marxism - Leninism',NULL,0,NULL,NULL,NULL,NULL,NULL),(11,'Software','SW',22,1,'demo',1,NULL,'2022-08-29 19:16:50',NULL);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_setting`
--

DROP TABLE IF EXISTS `subject_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject_setting` (
  `setting_id` int NOT NULL AUTO_INCREMENT,
  `subject_id` int DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  `setting_title` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `setting_value` varchar(50) DEFAULT NULL,
  `display_order` int DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `description` longtext,
  `creator_id` int DEFAULT NULL,
  `updater_id` int DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`setting_id`),
  KEY `subject_id` (`subject_id`),
  KEY `type_id` (`type_id`),
  KEY `creator_id` (`creator_id`),
  KEY `updater_id` (`updater_id`),
  CONSTRAINT `subject_setting_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `subject_setting_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `setting` (`type_id`),
  CONSTRAINT `subject_setting_ibfk_3` FOREIGN KEY (`creator_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `subject_setting_ibfk_4` FOREIGN KEY (`updater_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_setting`
--

LOCK TABLES `subject_setting` WRITE;
/*!40000 ALTER TABLE `subject_setting` DISABLE KEYS */;
INSERT INTO `subject_setting` VALUES (1,1,NULL,'Business','1',5,1,NULL,NULL,NULL,NULL,NULL),(2,2,NULL,'Computer Science','1',8,1,NULL,NULL,NULL,NULL,NULL),(3,3,NULL,'Arts and Humanities','1',3,1,NULL,NULL,NULL,NULL,NULL),(4,4,NULL,'Computer Science','1',3,0,NULL,NULL,NULL,NULL,NULL),(5,5,NULL,'Computer Science','1',6,1,NULL,NULL,NULL,NULL,NULL),(6,6,NULL,'Business','1',3,0,NULL,NULL,NULL,NULL,NULL),(7,7,NULL,'Mathematics','1',8,1,NULL,NULL,NULL,NULL,NULL),(8,8,NULL,'Data Science','1',6,1,NULL,NULL,NULL,NULL,NULL),(9,9,NULL,'Computer Science','1',3,0,NULL,NULL,NULL,NULL,NULL),(10,10,NULL,'Arts and Humanities','1',3,1,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `subject_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submit`
--

DROP TABLE IF EXISTS `submit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `submit` (
  `milestone_id` int NOT NULL,
  `team_id` int NOT NULL,
  `package_file_link` longtext,
  `submit_date` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `creator_id` int DEFAULT NULL,
  `updater_id` int DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`milestone_id`,`team_id`),
  KEY `team_id` (`team_id`),
  KEY `creator_id` (`creator_id`),
  KEY `updater_id` (`updater_id`),
  CONSTRAINT `submit_ibfk_1` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`milestone_id`),
  CONSTRAINT `submit_ibfk_2` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  CONSTRAINT `submit_ibfk_3` FOREIGN KEY (`creator_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `submit_ibfk_4` FOREIGN KEY (`updater_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submit`
--

LOCK TABLES `submit` WRITE;
/*!40000 ALTER TABLE `submit` DISABLE KEYS */;
/*!40000 ALTER TABLE `submit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team` (
  `team_id` int NOT NULL AUTO_INCREMENT,
  `team_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `project_code` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `topic_code` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `topic_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status1` varchar(45) DEFAULT NULL,
  `submit` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'SGB','SWP391','SM01','Student Management',1,'123','pending','commit'),(2,'GAM','SWE123','SW02','Software Project',0,'asd','commited','submit'),(3,'TS','LAB321','SO11','Shopping Online',1,'fsd','evaluated','7/10'),(4,'SE','SWT301','TP03','Tracking Project',0,'dq','submitted','Fix Evaluating');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_evaluation`
--

DROP TABLE IF EXISTS `team_evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_evaluation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `criteria_id` int DEFAULT NULL,
  `grade` double DEFAULT NULL,
  `comment` varchar(145) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `milestone_id` int DEFAULT NULL,
  `team_id` int DEFAULT NULL,
  `criteria_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_evaluation`
--

LOCK TABLES `team_evaluation` WRITE;
/*!40000 ALTER TABLE `team_evaluation` DISABLE KEYS */;
INSERT INTO `team_evaluation` VALUES (1,1,7.77,'Thiếu vài chức năng, nhưng nhìn chung vẫn ổn ',1,1,'Hard'),(2,6,8.9,'Ổn áp 1',6,1,'Easy'),(3,2,7.2,'Khá ổn, nhưng còn nhiều cần cải thiện',2,2,'Standard'),(4,3,6.5,'Ok',3,3,'Standard'),(5,4,6.8,'oK weqeqw',4,4,'Low Standard'),(6,5,7.4,'OK',5,5,'Easy'),(7,6,8.7,'Có sáng tạo',5,6,'Hard');
/*!40000 ALTER TABLE `team_evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tracking`
--

DROP TABLE IF EXISTS `tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tracking` (
  `function_id` int NOT NULL,
  `milestone_id` int NOT NULL,
  `assigner_id` int NOT NULL,
  `assignee_id` int NOT NULL,
  `submit_status` tinyint(1) DEFAULT NULL,
  `history` longtext,
  `creator_id` int DEFAULT NULL,
  `updater_id` int DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`function_id`,`milestone_id`),
  KEY `milestone_id` (`milestone_id`),
  KEY `assigner_id` (`assigner_id`),
  KEY `assignee_id` (`assignee_id`),
  KEY `creator_id` (`creator_id`),
  KEY `updater_id` (`updater_id`),
  CONSTRAINT `tracking_ibfk_1` FOREIGN KEY (`function_id`) REFERENCES `function` (`function_id`),
  CONSTRAINT `tracking_ibfk_2` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`milestone_id`),
  CONSTRAINT `tracking_ibfk_3` FOREIGN KEY (`assigner_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `tracking_ibfk_4` FOREIGN KEY (`assignee_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `tracking_ibfk_5` FOREIGN KEY (`creator_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `tracking_ibfk_6` FOREIGN KEY (`updater_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tracking`
--

LOCK TABLES `tracking` WRITE;
/*!40000 ALTER TABLE `tracking` DISABLE KEYS */;
INSERT INTO `tracking` VALUES (1,1,3,3,1,'',NULL,NULL,NULL,NULL),(2,1,3,3,0,'',NULL,NULL,NULL,NULL),(3,1,3,3,1,'',NULL,NULL,NULL,NULL),(4,1,3,3,0,'',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `update`
--

DROP TABLE IF EXISTS `update`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `update` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `description` longtext,
  `update_date` datetime DEFAULT NULL,
  `function_id` int DEFAULT NULL,
  `milestone_id` int DEFAULT NULL,
  `creator_id` int DEFAULT NULL,
  `updater_id` int DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `function_id` (`function_id`),
  KEY `milestone_id` (`milestone_id`),
  KEY `creator_id` (`creator_id`),
  KEY `updater_id` (`updater_id`),
  CONSTRAINT `update_ibfk_1` FOREIGN KEY (`function_id`) REFERENCES `function` (`function_id`),
  CONSTRAINT `update_ibfk_2` FOREIGN KEY (`milestone_id`) REFERENCES `milestone` (`milestone_id`),
  CONSTRAINT `update_ibfk_3` FOREIGN KEY (`creator_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `update_ibfk_4` FOREIGN KEY (`updater_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `update`
--

LOCK TABLES `update` WRITE;
/*!40000 ALTER TABLE `update` DISABLE KEYS */;
/*!40000 ALTER TABLE `update` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` longtext,
  `role_id` int DEFAULT NULL,
  `avatar_link` longtext,
  `gender` tinyint(1) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `status` int NOT NULL,
  `creator_id` int DEFAULT NULL,
  `updater_id` int DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `role_id` (`role_id`),
  KEY `creator_id` (`creator_id`),
  KEY `updater_id` (`updater_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `setting` (`setting_id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`creator_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `user_ibfk_3` FOREIGN KEY (`updater_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Đỗ Sơn Tùng','stunghy@gmail.com','123123',2,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',1,'12345678',1,NULL,NULL,NULL,NULL),(2,'Nguyễn Mạnh Cường','cuongnmhe140995@fpt.edu.vn','123123',2,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(3,'Nguyễn Quang Tuấn','tuannqhe141475@fpt.edu.vn','123123',2,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(4,'Thầy Phan Trường Lâm','abcd@ggmail.com','123123',4,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(5,'Thầy Trần Đình Trí','av3ebe@ggmail.com','123123',4,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',1,'',1,NULL,NULL,NULL,NULL),(6,'Thầy Ngô Tùng Sơn','absrh2scd@ggmail.com','123123',4,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,0,NULL,NULL,NULL,NULL),(7,'Cô Lê Phương Chi','abgeb2cd@ggmail.com','123123',4,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(8,'Thầy Phạm Ngọc Hà','abvfdsb3cd@ggmail.com','123123',4,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(9,'Thầy Trần Quý Ban','abh45hcd@ggmail.com','123123',4,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(10,'Thầy Trần Bình Dương','abt4d4cd@ggmail.com','123123',4,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(11,'Thầy Lê Minh Tuấn','ab234cd@ggmail.com','123123',4,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(12,'Cô Trần Thu Thủy','abc123@ggmail.com','123123',4,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(13,'Thầy Lê Minh Tuấn','abc456@ggmail.com','123123',4,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(14,'Nguyễn Văn A','abc1234@ggmail.com','123123',5,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',1,'',1,NULL,NULL,NULL,NULL),(15,'Nguyễn Thị B','abcwqfr12@ggmail.com','123123',5,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(16,'Trần Văn C','abcw321312@ggmail.com','123123',5,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(17,'Tạ Đình D','abc323132@ggmail.com','123123',5,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(18,'Ngô Quang E','ab32323@ggmail.com','123123',5,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(19,'Vũ Thị F','abc2412@ggmail.com','123123',5,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(20,'Trần Ngọc G','ab2323f@ggmail.com','123123',5,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,0,NULL,NULL,NULL,NULL),(21,'Nguyễn Trần Phương H','a132312f@ggmail.com','123123',5,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(22,'Thầy Phạm Đức Thắng','a132af312f@ggmail.com','123123',3,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(23,'Thầy Lương Xuân Diệu','a1323afas12f@ggmail.com','123123',3,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,0,NULL,NULL,NULL,NULL),(24,'Thầy Phạm Ngọc Dương','a132afwev312f@ggmail.com','123123',3,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(25,'Cô Nguyễn Thị Hải Năng','a132vsvd312f@ggmail.com','123123',3,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(26,'Thầy Lã Ngọc Quang','a13we32312f@ggmail.com','123123',3,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(27,'Thầy Phan Đình Phát','a132cew312f@ggmail.com','123123',3,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(28,'Cô Nguyễn Thị Thùy Dương','a1we32dw312f@ggmail.com','123123',3,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(29,'Thầy Nguyễn Quốc Đông','avwv132312f@ggmail.com','123123',3,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(30,'Thầy Lê Thành Nhân','vwa132312f@ggmail.com','123123',3,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(31,'Cô Nghiêm Thị Lan Phương','a1323vwev12f@ggmail.com','123123',3,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,NULL,1,NULL,NULL,NULL,NULL),(32,'Manager','manager@mail.com','1234',3,'https://upload.wikimedia.org/wikipedia/commons/1/10/Ojiya_Nishikigoi_no_Sato_ac_(3).jpg',NULL,'12345678',1,NULL,NULL,NULL,NULL),(33,'Student 1','student1@mail.com','123123',5,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),(34,'Student 2','student2@mail.com','123123',5,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL),(35,'Tung Do','tungdo@mail.com','123123',5,NULL,NULL,NULL,1,NULL,NULL,'2022-08-28 19:02:53',NULL),(36,'Do Tung','sethetherald@duck.com','1234',5,NULL,NULL,'0904285035',1,NULL,NULL,'2022-08-28 20:34:25',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `web_contact`
--

DROP TABLE IF EXISTS `web_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `web_contact` (
  `contact_id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile` text,
  `category_id` int DEFAULT NULL,
  `message` longtext,
  `response` longtext,
  `status` int NOT NULL,
  `creator_id` int DEFAULT NULL,
  `updater_id` int DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`contact_id`),
  KEY `category_id` (`category_id`),
  KEY `creator_id` (`creator_id`),
  KEY `updater_id` (`updater_id`),
  CONSTRAINT `web_contact_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `setting` (`setting_id`),
  CONSTRAINT `web_contact_ibfk_2` FOREIGN KEY (`creator_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `web_contact_ibfk_3` FOREIGN KEY (`updater_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `web_contact`
--

LOCK TABLES `web_contact` WRITE;
/*!40000 ALTER TABLE `web_contact` DISABLE KEYS */;
INSERT INTO `web_contact` VALUES (1,'Tung Do','stunghy@gmail.com','0904285035',7,'there\'s a bug in the front page',NULL,0,NULL,NULL,'2022-08-28 20:29:06',NULL),(2,'Tung Do','sethetherald@duck.com','0904285035',9,'message 1',NULL,0,NULL,NULL,'2022-08-28 20:33:50',NULL);
/*!40000 ALTER TABLE `web_contact` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-01 19:38:03

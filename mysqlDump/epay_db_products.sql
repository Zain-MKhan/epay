-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: epay_db
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `sku` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `vendor` varchar(45) NOT NULL,
  `slug` varchar(45) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `image` varchar(600) DEFAULT NULL,
  PRIMARY KEY (`sku`),
  UNIQUE KEY `sku_UNIQUE` (`sku`),
  UNIQUE KEY `slug_UNIQUE` (`slug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'camera','This excellent camera is very high quality; in fact, it\'s 50mx capabilities allow to capture you crying in SOEN387 from a kilometer away!','Nikon','xps-0001',589.99,'https://dfstudio-d420.kxcdn.com/wordpress/wp-content/uploads/2019/06/digital_camera_photo-1080x675.jpg'),(2,'AsusRogPC','This is a asus rog PC very good','Asus','Rog-0002',1000.99,'https://www.asus.com/media/Odin/Websites/global/Series/52.png'),(3,'Airpods Max','Very expensive','Apple','Apple-003',599.66,'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/airpods-max-select-spacegray-202011_FV1_FMT_WHH?wid=940&hei=800&fmt=jpeg&qlt=90&.v=1604776025000'),(4,'Sony Headphones','wf-1000xm5','Sony','Sony-004',688.90,'https://sony.scene7.com/is/image/sonyglobalsolutions/Primary_image_black?$S7Product$&fmt=png-alpha'),(12,'jytd','uygo87tgy','kjuyfluytf','new-product-slug',99.99,'');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-10 21:59:48

CREATE DATABASE  IF NOT EXISTS `registros` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `registros`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: registros
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `tb_empresa`
--

DROP TABLE IF EXISTS `tb_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_empresa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(14) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cep` varchar(8) NOT NULL,
  `tb_usuarios` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_empresa_usuario` (`tb_usuarios`),
  CONSTRAINT `FK_empresa_usuario` FOREIGN KEY (`tb_usuarios`) REFERENCES `tb_usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_empresa`
--

LOCK TABLES `tb_empresa` WRITE;
/*!40000 ALTER TABLE `tb_empresa` DISABLE KEYS */;
INSERT INTO `tb_empresa` VALUES (1,'12345678000199','Minha Empresa','86000000',1);
/*!40000 ALTER TABLE `tb_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_motoristas`
--

DROP TABLE IF EXISTS `tb_motoristas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_motoristas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `tb_usuarios` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_motorista_usuario` (`tb_usuarios`),
  CONSTRAINT `FK_motorista_usuario` FOREIGN KEY (`tb_usuarios`) REFERENCES `tb_usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_motoristas`
--

LOCK TABLES `tb_motoristas` WRITE;
/*!40000 ALTER TABLE `tb_motoristas` DISABLE KEYS */;
INSERT INTO `tb_motoristas` VALUES (1,'joao paulo','12345678900','00123456789',1),(2,'antunes','32132132132','34234234234',2);
/*!40000 ALTER TABLE `tb_motoristas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rotas`
--

DROP TABLE IF EXISTS `tb_rotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rotas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cep_saida` varchar(10) NOT NULL,
  `cep_destino` varchar(10) NOT NULL,
  `distancia` varchar(10) NOT NULL,
  `tempo_estimado` varchar(10) DEFAULT NULL,
  `hora_saida` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `hora_chegada` timestamp NULL DEFAULT NULL,
  `observacao` varchar(200) DEFAULT NULL,
  `tb_veiculo` bigint(20) NOT NULL,
  `tb_motoristas` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rota_veiculo` (`tb_veiculo`),
  KEY `FK_rota_motorista` (`tb_motoristas`),
  CONSTRAINT `FK_rota_motorista` FOREIGN KEY (`tb_motoristas`) REFERENCES `tb_motoristas` (`id`),
  CONSTRAINT `FK_rota_veiculo` FOREIGN KEY (`tb_veiculo`) REFERENCES `tb_veiculo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rotas`
--

LOCK TABLES `tb_rotas` WRITE;
/*!40000 ALTER TABLE `tb_rotas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_rotas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuarios` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(150) NOT NULL,
  `senha` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuarios`
--

LOCK TABLES `tb_usuarios` WRITE;
/*!40000 ALTER TABLE `tb_usuarios` DISABLE KEYS */;
INSERT INTO `tb_usuarios` VALUES (1,'joao paulo','joao@paulo.com','123456'),(2,'antunes','antunes@joao.com','123456');
/*!40000 ALTER TABLE `tb_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_veiculo`
--

DROP TABLE IF EXISTS `tb_veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_veiculo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `placa` varchar(10) NOT NULL,
  `ano` varchar(10) NOT NULL,
  `modelo` varchar(100) NOT NULL,
  `disponibilidade` varchar(50) NOT NULL,
  `quilometragem` varchar(50) NOT NULL,
  `chassi` varchar(50) NOT NULL,
  `tb_empresa` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_veiculo_empresa` (`tb_empresa`),
  CONSTRAINT `FK_veiculo_empresa` FOREIGN KEY (`tb_empresa`) REFERENCES `tb_empresa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_veiculo`
--

LOCK TABLES `tb_veiculo` WRITE;
/*!40000 ALTER TABLE `tb_veiculo` DISABLE KEYS */;
INSERT INTO `tb_veiculo` VALUES (1,'cuzinhopre','2999','versa','Disponível','157000','cupreto',1);
/*!40000 ALTER TABLE `tb_veiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-08-13 15:04:40

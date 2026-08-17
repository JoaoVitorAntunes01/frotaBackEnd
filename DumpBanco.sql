CREATE DATABASE  IF NOT EXISTS `registros` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `registros`;
-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: registros
-- ------------------------------------------------------
-- Server version	8.0.45

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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(14) COLLATE utf8mb4_general_ci NOT NULL,
  `nome` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `cep` varchar(8) COLLATE utf8mb4_general_ci NOT NULL,
  `tb_usuarios` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_empresa_usuario` (`tb_usuarios`),
  CONSTRAINT `FK_empresa_usuario` FOREIGN KEY (`tb_usuarios`) REFERENCES `tb_usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_empresa`
--

LOCK TABLES `tb_empresa` WRITE;
/*!40000 ALTER TABLE `tb_empresa` DISABLE KEYS */;
INSERT INTO `tb_empresa` VALUES (1,'12345678000190','FrotaMax Transportes Ltda','86010000',1),(2,'23456789000101','TransNorte Logistica S/A','86020000',3),(3,'34567890000112','LogMais Transportes e Cargas','86030000',5),(4,'45678901000123','ViaCargo Distribuicao Ltda','86040000',7);
/*!40000 ALTER TABLE `tb_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_motoristas`
--

DROP TABLE IF EXISTS `tb_motoristas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_motoristas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `cpf` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  `telefone` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `tb_usuarios` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_motorista_usuario` (`tb_usuarios`),
  CONSTRAINT `FK_motorista_usuario` FOREIGN KEY (`tb_usuarios`) REFERENCES `tb_usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_motoristas`
--

LOCK TABLES `tb_motoristas` WRITE;
/*!40000 ALTER TABLE `tb_motoristas` DISABLE KEYS */;
INSERT INTO `tb_motoristas` VALUES (1,'Antonio Carlos Ferreira','12345678901','43991234567',2),(2,'Jose Roberto Nascimento','23456789012','43992345678',4),(3,'Paulo Sergio Ramos','34567890123','43993456789',6),(4,'Eduardo Luiz Gomes','45678901234','43994567890',8),(5,'Rafael dos Santos Melo','56789012345','43995678901',9),(6,'Tiago Henrique Correia','67890123456','43996789012',10),(7,'Vinicius Augusto Pinto','78901234567','43997890123',1),(8,'Gustavo Andre Moraes','89012345678','43998901234',3);
/*!40000 ALTER TABLE `tb_motoristas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rotas`
--

DROP TABLE IF EXISTS `tb_rotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rotas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cep_saida` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `cep_destino` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `distancia` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `tempo_estimado` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `hora_saida` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `hora_chegada` timestamp NULL DEFAULT NULL,
  `observacao` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tb_veiculo` bigint NOT NULL,
  `tb_motoristas` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rota_veiculo` (`tb_veiculo`),
  KEY `FK_rota_motorista` (`tb_motoristas`),
  CONSTRAINT `FK_rota_motorista` FOREIGN KEY (`tb_motoristas`) REFERENCES `tb_motoristas` (`id`),
  CONSTRAINT `FK_rota_veiculo` FOREIGN KEY (`tb_veiculo`) REFERENCES `tb_veiculo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rotas`
--

LOCK TABLES `tb_rotas` WRITE;
/*!40000 ALTER TABLE `tb_rotas` DISABLE KEYS */;
INSERT INTO `tb_rotas` VALUES (1,'86010000','87020000','120km','2h30','2026-08-01 09:00:00','2026-08-01 11:30:00','Carga fragil, atencao redobrada',1,1),(2,'86020000','80010000','450km','6h00','2026-08-02 08:00:00','2026-08-02 14:00:00',NULL,3,2),(3,'86030000','85010000','210km','3h15','2026-08-03 10:00:00','2026-08-03 13:15:00','Entrega parcial na filial',5,3),(4,'86040000','86400000','75km','1h20','2026-08-04 11:00:00','2026-08-04 12:20:00',NULL,7,4),(5,'86010000','84010000','190km','2h45','2026-08-05 09:30:00',NULL,'Rota em andamento',2,5),(6,'86020000','87400000','330km','4h50','2026-08-06 08:30:00','2026-08-06 13:20:00',NULL,4,6),(7,'86030000','86500000','60km','1h05','2026-08-07 12:00:00','2026-08-07 13:05:00','Cliente preferencial',6,7),(8,'86040000','80020000','270km','3h40','2026-08-08 09:00:00','2026-08-08 12:40:00',NULL,8,8),(9,'86010000','87300000','145km','2h10','2026-08-09 10:15:00','2026-08-09 12:25:00',NULL,1,2),(10,'86020000','86010000','30km','0h40','2026-08-10 16:00:00','2026-08-10 16:40:00','Entrega expressa',3,1),(11,'86030000','84500000','380km','5h20','2026-08-11 07:30:00','2026-08-11 12:50:00',NULL,5,4),(12,'86040000','86020000','25km','0h35','2026-08-12 18:00:00',NULL,'Rota em andamento',7,6),(13,'86010000','86030000','18km','0h25','2026-08-13 13:00:00','2026-08-13 13:25:00',NULL,2,8),(14,'86020000','87020000','160km','2h20','2026-08-14 09:45:00','2026-08-14 12:05:00','Carga refrigerada',4,3),(15,'86030000','86040000','40km','0h55','2026-08-15 11:30:00','2026-08-15 12:25:00',NULL,6,5);
/*!40000 ALTER TABLE `tb_rotas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `senha` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuarios`
--

LOCK TABLES `tb_usuarios` WRITE;
/*!40000 ALTER TABLE `tb_usuarios` DISABLE KEYS */;
INSERT INTO `tb_usuarios` VALUES (1,'Carlos Eduardo Silva','carlos.silva@frotamax.com','senha123'),(2,'Fernanda Souza Lima','fernanda.lima@frotamax.com','senha123'),(3,'Ricardo Almeida Santos','ricardo.santos@transnorte.com','senha123'),(4,'Juliana Pereira Costa','juliana.costa@transnorte.com','senha123'),(5,'Marcos Vinicius Oliveira','marcos.oliveira@logmais.com','senha123'),(6,'Patricia Rodrigues Alves','patricia.alves@logmais.com','senha123'),(7,'Bruno Henrique Martins','bruno.martins@viacargo.com','senha123'),(8,'Camila Ferreira Nunes','camila.nunes@viacargo.com','senha123'),(9,'Diego Rocha Barbosa','diego.barbosa@frotamax.com','senha123'),(10,'Larissa Cardoso Teixeira','larissa.teixeira@transnorte.com','senha123');
/*!40000 ALTER TABLE `tb_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_veiculo`
--

DROP TABLE IF EXISTS `tb_veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_veiculo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `placa` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `ano` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `modelo` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `disponibilidade` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `quilometragem` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `chassi` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `tb_empresa` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_veiculo_empresa` (`tb_empresa`),
  CONSTRAINT `FK_veiculo_empresa` FOREIGN KEY (`tb_empresa`) REFERENCES `tb_empresa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_veiculo`
--

LOCK TABLES `tb_veiculo` WRITE;
/*!40000 ALTER TABLE `tb_veiculo` DISABLE KEYS */;
INSERT INTO `tb_veiculo` VALUES (1,'ABC1D23','2019','Mercedes-Benz Atego 1719','Disponivel','158200','9BM384056KB123456',1),(2,'BRA2E19','2021','Volkswagen Delivery 9.170','Em rota','82340','9BWZZZ377VP123457',1),(3,'DEF4G56','2020','Iveco Daily 70C16','Disponivel','95400','93ZC1D5S0LJ123458',2),(4,'GHI7H89','2018','Ford Cargo 1719','Manutencao','210500','9BFXX55A1JB123459',2),(5,'JKL0I12','2022','Scania P250','Disponivel','43100','9BSP4X20003123460',3),(6,'MNO3J45','2017','Volvo VM 270','Disponivel','265700','9BVDS42T09E123461',3),(7,'PQR6K78','2023','Mercedes-Benz Accelo 815','Em rota','18900','9BM384056PB123462',4),(8,'STU9L01','2020','Hyundai HR HD Longo','Disponivel','112300','9BHHR27E0LB123463',4);
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

-- Dump completed on 2026-08-16 23:51:02

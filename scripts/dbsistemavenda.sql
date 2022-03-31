-- MySQL dump 10.13  Distrib 5.1.73, for Win32 (ia32)
--
-- Host: localhost    Database: dbsistemavenda
-- ------------------------------------------------------
-- Server version	5.1.73-community

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
-- Table structure for table `tbcidades`
--

DROP TABLE IF EXISTS `tbcidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbcidades` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL,
  `UF` varchar(2) NOT NULL,
  `Pais` varchar(50) NOT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbcidades`
--

LOCK TABLES `tbcidades` WRITE;
/*!40000 ALTER TABLE `tbcidades` DISABLE KEYS */;
INSERT INTO `tbcidades` VALUES (1,'ITUMBIARA','GO','BRASIL');
/*!40000 ALTER TABLE `tbcidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbcliente`
--

DROP TABLE IF EXISTS `tbcliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbcliente` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) NOT NULL,
  `CPF` varchar(14) NOT NULL,
  `DataNascimento` date NOT NULL,
  `Fone` varchar(14) DEFAULT NULL,
  `Tipo` varchar(6) DEFAULT NULL,
  `Endereco` varchar(100) DEFAULT NULL,
  `Numero` varchar(5) DEFAULT NULL,
  `Bairro` varchar(20) DEFAULT NULL,
  `Cidade` varchar(30) DEFAULT NULL,
  `Cep` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbcliente`
--

LOCK TABLES `tbcliente` WRITE;
/*!40000 ALTER TABLE `tbcliente` DISABLE KEYS */;
INSERT INTO `tbcliente` VALUES (1,'THALES OLIVERA DE ALMEIDA','028.614.851-08','1989-03-18','(64)99244-8995','RUA','ARGUARI','2947','BURITTYS III','','75513-844');
/*!40000 ALTER TABLE `tbcliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbcompra`
--

DROP TABLE IF EXISTS `tbcompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbcompra` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `CodigoFornecedor` int(11) NOT NULL,
  `DataCompra` date NOT NULL,
  `ValorTotal` decimal(10,2) NOT NULL,
  `Situacao` int(11) NOT NULL,
  PRIMARY KEY (`Codigo`),
  KEY `FK_CodigoFornecedor_idx` (`CodigoFornecedor`),
  CONSTRAINT `FK_CodigoFornecedor` FOREIGN KEY (`CodigoFornecedor`) REFERENCES `tbfornecedor` (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbcompra`
--

LOCK TABLES `tbcompra` WRITE;
/*!40000 ALTER TABLE `tbcompra` DISABLE KEYS */;
INSERT INTO `tbcompra` VALUES (1,1,'2020-03-13','520.25',2),(2,1,'2020-03-13','21.00',2);
/*!40000 ALTER TABLE `tbcompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbfornecedor`
--

DROP TABLE IF EXISTS `tbfornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbfornecedor` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) NOT NULL,
  `CNPJ` varchar(18) NOT NULL,
  `Fone` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbfornecedor`
--

LOCK TABLES `tbfornecedor` WRITE;
/*!40000 ALTER TABLE `tbfornecedor` DISABLE KEYS */;
INSERT INTO `tbfornecedor` VALUES (1,'CASTRILLON AUTOPEÇAS','12.145.475/0007-40','(64)34321-600');
/*!40000 ALTER TABLE `tbfornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbitemcompra`
--

DROP TABLE IF EXISTS `tbitemcompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbitemcompra` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `CodigoProduto` int(11) NOT NULL,
  `CodigoCompra` int(11) NOT NULL,
  `Quantidade` int(11) NOT NULL,
  `ValorUnitario` decimal(10,2) NOT NULL,
  PRIMARY KEY (`Codigo`),
  KEY `FK_CodigoCompra_idx2` (`CodigoCompra`),
  KEY `FK_CodigoProduto_idx2` (`CodigoProduto`),
  CONSTRAINT `FK_CodigoCompra2` FOREIGN KEY (`CodigoCompra`) REFERENCES `tbcompra` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_CodigoProduto2` FOREIGN KEY (`CodigoProduto`) REFERENCES `tbproduto` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbitemcompra`
--

LOCK TABLES `tbitemcompra` WRITE;
/*!40000 ALTER TABLE `tbitemcompra` DISABLE KEYS */;
INSERT INTO `tbitemcompra` VALUES (2,3,1,10,'21.00'),(3,2,1,5,'19.00'),(4,1,1,3,'71.75'),(5,3,2,1,'21.00');
/*!40000 ALTER TABLE `tbitemcompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbitemvenda`
--

DROP TABLE IF EXISTS `tbitemvenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbitemvenda` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `CodigoProduto` int(11) NOT NULL,
  `CodigoVenda` int(11) NOT NULL,
  `Quantidade` int(11) NOT NULL,
  `ValorUnitario` decimal(10,2) NOT NULL,
  PRIMARY KEY (`Codigo`),
  KEY `FK_CodigoVenda_idx` (`CodigoVenda`),
  KEY `FK_CodigoProduto_idx` (`CodigoProduto`),
  CONSTRAINT `FK_CodigoProduto` FOREIGN KEY (`CodigoProduto`) REFERENCES `tbproduto` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_CodigoVenda` FOREIGN KEY (`CodigoVenda`) REFERENCES `tbvenda` (`Codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbitemvenda`
--

LOCK TABLES `tbitemvenda` WRITE;
/*!40000 ALTER TABLE `tbitemvenda` DISABLE KEYS */;
INSERT INTO `tbitemvenda` VALUES (2,2,1,1,'20.52'),(3,3,1,1,'22.00'),(4,1,1,2,'80.00');
/*!40000 ALTER TABLE `tbitemvenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbproduto`
--

DROP TABLE IF EXISTS `tbproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbproduto` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(100) NOT NULL,
  `PrecoCompra` decimal(10,2) NOT NULL,
  `PrecoVenda` decimal(10,2) NOT NULL,
  `QuantidadeEstoque` int(11) NOT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbproduto`
--

LOCK TABLES `tbproduto` WRITE;
/*!40000 ALTER TABLE `tbproduto` DISABLE KEYS */;
INSERT INTO `tbproduto` VALUES (1,'ROL. RODA DIANT. GOL/FOX','71.75','80.00',1),(2,'OLEO LUBRAX ATF TA','19.00','20.52',4),(3,'KIT COIFA RODA GOL G5 08/FOX TDS','21.00','22.00',10);
/*!40000 ALTER TABLE `tbproduto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbvenda`
--

DROP TABLE IF EXISTS `tbvenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbvenda` (
  `Codigo` int(11) NOT NULL AUTO_INCREMENT,
  `CodigoCliente` int(11) NOT NULL,
  `DataVenda` date NOT NULL,
  `ValorTotal` decimal(10,2) NOT NULL,
  `Situacao` int(11) NOT NULL,
  PRIMARY KEY (`Codigo`),
  KEY `FK_CodigoCliente_idx` (`CodigoCliente`),
  CONSTRAINT `FK_CodigoCliente` FOREIGN KEY (`CodigoCliente`) REFERENCES `tbcliente` (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbvenda`
--

LOCK TABLES `tbvenda` WRITE;
/*!40000 ALTER TABLE `tbvenda` DISABLE KEYS */;
INSERT INTO `tbvenda` VALUES (1,1,'2020-03-13','202.52',2);
/*!40000 ALTER TABLE `tbvenda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-17 16:06:27

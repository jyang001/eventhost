CREATE DATABASE  IF NOT EXISTS `event_host`;
USE `event_host`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;

UNLOCK TABLES;


-- Dump completed on 2016-09-24 21:50:59

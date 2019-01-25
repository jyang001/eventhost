CREATE DATABASE  IF NOT EXISTS `event_host`;
USE `event_host`;

DROP TABLE IF EXISTS `account_role`;

CREATE TABLE `account_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `role_name` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETAIL_idx` (`account_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY(`account_id`) REFERENCES `account`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

LOCK TABLES `account_role` WRITE;

UNLOCK TABLES;
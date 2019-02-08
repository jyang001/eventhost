CREATE DATABASE  IF NOT EXISTS `event_host`;
USE `event_host`;

DROP TABLE IF EXISTS `event`;

CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `date` DATE NOT NULL,
  `invitation_code` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

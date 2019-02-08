CREATE DATABASE  IF NOT EXISTS `event_host`;
USE `event_host`;

DROP TABLE IF EXISTS `account_event`;

CREATE TABLE `account_event` (
  `account_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,

  PRIMARY KEY (`account_id`,`event_id`),

  FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  FOREIGN KEY (`event_id`) REFERENCES `event` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
)
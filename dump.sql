-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               8.0.13 - MySQL Community Server - GPL
-- Операционная система:         Win64
-- HeidiSQL Версия:              10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных user-management
CREATE DATABASE IF NOT EXISTS `user-management` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `user-management`;

-- Дамп структуры для таблица user-management.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `password` varchar(255) NOT NULL,
  `first_name` varchar(16) NOT NULL,
  `last_name` varchar(16) NOT NULL,
  `role` enum('ADMIN','USER') NOT NULL,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` enum('ACTIVE','INACTIVE') NOT NULL DEFAULT 'ACTIVE',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы user-management.users: 1 rows
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `username`, `password`, `first_name`, `last_name`, `role`, `created`, `status`) VALUES
	(1, 'admin123qq11', '$2a$08$cHuo.9SUEfghtv2S/80GGutTacVhvtVXWKoFpGUd6eIhxfQjMDTfq', 'admin1', 'admin1', 'USER', '2019-08-19 01:32:58', 'INACTIVE'),
	(2, 'asd4', '$2a$08$ZzphMBrzBKmXukBsoNeqb.A1pJX7XLDNBUWY4vcVi1eZJHH7nzz/C', 'asddasdasd12', '4442sdf', 'ADMIN', '2019-08-19 01:33:01', 'ACTIVE'),
	(3, 'vova2', '$2a$08$ZF86gmFLD05HHBX8YOjW2.SrFKotVEpLLMhx2ppi170IBpx7TvCJe', 'vladimir4444', 'medvedev', 'USER', '2019-08-19 01:33:02', 'ACTIVE'),
	(4, 'vvvv', '$2a$08$DFHEqG6aOvUOM9mdWM2Dger1FyLCwDyZiUReL4jHZq7Wtj1Pu3MJy', 'vova777', 'vova', 'ADMIN', '2019-08-19 01:33:03', 'ACTIVE'),
	(5, 'qwe', '$2a$08$C9ratUJM1z5qqxjfKlQNVurpFH7tn2u9lSt4ErEFQrMSVzWm1faq.', 'qwe', 'qwe', 'ADMIN', '2019-08-19 02:02:48', 'ACTIVE'),
	(6, 'zxc', '$2a$08$iWf5QDZSL4OhFrNlA3zzIeuYwKWJQEWZyOlW997FtTg7UPAoTK/0W', 'zxc', 'zxc', 'ADMIN', '2019-08-19 01:33:05', 'ACTIVE'),
	(7, 'qqqqq', '$2a$08$7LnWMQdhywjsEu0oxzPLc.nNd11yYXiETPy0ipCbfIlOx8EBxC1Ry', 'qqq', 'qqq', 'ADMIN', '2019-08-18 22:32:36', 'ACTIVE');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

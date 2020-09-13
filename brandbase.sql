-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               10.5.5-MariaDB - mariadb.org binary distribution
-- Операционная система:         Win64
-- HeidiSQL Версия:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных brandbase
CREATE DATABASE IF NOT EXISTS `brandbase` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `brandbase`;

-- Дамп структуры для таблица brandbase.brand
CREATE TABLE IF NOT EXISTS `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `body_type` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `transmission` varchar(255) DEFAULT NULL,
  `year` int(11) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1utqli2qjxuwtgpypddlctdkn` (`category_id`),
  CONSTRAINT `FK1utqli2qjxuwtgpypddlctdkn` FOREIGN KEY (`category_id`) REFERENCES `brand_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы brandbase.brand: ~14 rows (приблизительно)
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` (`id`, `body_type`, `brand`, `image`, `model`, `price`, `transmission`, `year`, `category_id`) VALUES
	(2, 'Pickup', 'Dodge', 'dodge_ram.png', 'Ram', 32000, 'Automatic', 2010, 3),
	(5, 'Crossover', 'BMW', 'bmw_x5.png', 'X5', 38000, 'Automatic', 2014, 2),
	(6, 'SUV', 'Cadilac', 'cadillac_escalade.png', 'Escalade', 48000, 'Automatic', 2016, 6),
	(7, 'Coupe', 'BMW', 'bmw_1.png', '1', 28000, 'Automatic', 2010, 2),
	(8, 'SUV', 'Kia', 'kia_sorento.png', 'Sorento', 34000, 'Automatic', 2012, 7),
	(10, 'SUV', 'Lada', 'lada_niva_urban.png', 'Niva Urban', 28000, 'Manual', 2018, 9),
	(11, 'SUV', 'Chevrolet', 'lada_niva.png', 'Niva', 20000, 'Manual', 2004, 9),
	(12, 'Hatchback', 'Mazda', 'mazda_2.png', '2', 23000, 'Manual', 2008, 8),
	(13, 'Wagon', 'Mazda', 'mazda_6.png', '6', 29000, 'Automatic', 2014, 8),
	(14, 'Van', 'Mazda', 'mazda_MPV.png', 'MPV', 32000, 'Manual', 2010, 8),
	(15, 'Coupe', 'Mercedes-Benz', 'mercedes_sls.png', 'SLS AMG', 56000, 'Robot', 2016, 5),
	(16, 'Sedan', 'Mitsubishi', 'mitsubishi_lancer.png', 'Lancer', 30000, 'Manual', 2015, 1),
	(18, 'Hatchback', 'Seat', 'seat_leon.png', 'Leon', 29000, 'Automatic', 2014, 4),
	(19, 'SUV', 'Infiniti', 'infiniti_fx.png', 'FX', 52000, 'Automatic', 2014, 10);
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.brand_category
CREATE TABLE IF NOT EXISTS `brand_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы brandbase.brand_category: ~10 rows (приблизительно)
/*!40000 ALTER TABLE `brand_category` DISABLE KEYS */;
INSERT INTO `brand_category` (`id`, `country`, `image`, `name`) VALUES
	(1, 'Japan', 'mitsubishi.png', 'Mitsubishi'),
	(2, 'Germany', 'bmw.png', 'BMW'),
	(3, 'USA', 'dodge.png', 'Dodge'),
	(4, 'Spain', 'seat.png', 'Seat'),
	(5, 'Germany', 'mercedes.png', 'Mercedes-Benz'),
	(6, 'USA', 'cadillac.png', 'Cadillac'),
	(7, 'South Korea', 'kia.png', 'Kia'),
	(8, 'Japan', 'mazda.png', 'Mazda'),
	(9, 'Russia', 'lada.png', 'Lada'),
	(10, 'Japan', 'infiniti.png', 'Infiniti');
/*!40000 ALTER TABLE `brand_category` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы brandbase.role: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`) VALUES
	(1, 'ROLE_USER'),
	(2, 'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы brandbase.user: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
	(2, 'admin@mail.com', 'admin', 'admin', '$2a$10$IqTJTjn39IU5.7sSCDQxzu3xug6z/LPU6IF0azE/8CkHCwYEnwBX.');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.users_roles
CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`),
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Дамп данных таблицы brandbase.users_roles: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
	(1, 1),
	(2, 2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

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
  `description` text DEFAULT NULL,
  `image2` varchar(255) DEFAULT NULL,
  `image3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1utqli2qjxuwtgpypddlctdkn` (`category_id`),
  CONSTRAINT `FK1utqli2qjxuwtgpypddlctdkn` FOREIGN KEY (`category_id`) REFERENCES `brand_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы brandbase.brand: ~15 rows (приблизительно)
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` (`id`, `body_type`, `brand`, `image`, `model`, `price`, `transmission`, `year`, `category_id`, `description`, `image2`, `image3`) VALUES
	(2, 'Pickup', 'Dodge', 'dodge_ram.png', 'Ram', 32000, 'Automatic', 2010, 3, 'The Ram pickup (Dodge Ram until 2010) is a full-size pickup truck manufactured by FCA US LLC (formerly Chrysler Group LLC) and marketed from 2010 onwards under the Ram Trucks brand. The current fifth-generation Ram debuted at the 2018 North American International Auto Show in Detroit, Michigan, in January of that year.  Previously, Ram was part of the Dodge line of light trucks. The name Ram was first used in 1981 model year Dodge Trucks in October 1980, following the retiring and rebadging of the Dodge D Series pickup trucks as well as B-series vans, though the company had used a ram\'s-head hood ornament on some trucks as early as 1933. Ram trucks have been named Motor Trend magazine\'s Truck of the Year seven times; the second-generation Ram won the award in 1994, the third-generation Ram heavy duty won the award in 2003, the fourth-generation Ram Heavy Duty won in 2010 and the fourth-generation Ram 1500 won in 2013 and 2014, and the current fifth-generation Ram 1500 won in 2019 and 2020.', 'dodge_ram2.png', 'dodge-ram-i.jpg'),
	(5, 'Crossover', 'BMW', 'bmw_x5.png', 'X5', 38000, 'Automatic', 2014, 2, 'The BMW X5 is a mid-size luxury, rear-wheel drive SUV produced by BMW. The X5 made its debut in 1999. It was BMW\'s first SUV and it also featured all-wheel drive and was available with either manual or automatic transmission.', 'bmw_x5_2.png', 'bmw-x5-i.jpg'),
	(6, 'SUV', 'Cadilac', 'cadillac_escalade.png', 'Escalade', 48000, 'Automatic', 2016, 6, 'The 2020 Cadillac Escalade is a good luxury large SUV, but it\'s not a great one. This truck-based SUV is held back by its ponderous handling and a finnicky infotainment system. Many of its rivals have sportier handling, smoother rides, and richer cabins.', 'cadillac_escalade_2.png', 'cadillac-escalade-i.jpg'),
	(7, 'Coupe', 'BMW', 'bmw_1.png', '1', 28000, 'Automatic', 2010, 2, 'he BMW 1 Series is a range of subcompact executive cars (C-segment) manufactured by BMW since 2004. It is the successor to the BMW 3 Series Compact and is currently in its third generation.  The first generation was produced in hatchback, coupe and convertible body styles. Since the second generation (introduced in 2013), the coupé and convertible models have been marketed as the 2 Series, therefore the 1 Series range no longer includes these body styles. A sedan model became available for the Chinese market in 2017.  The 1 Series is BMW\'s entry level of model range. Unusually for a small car, the 1 Series range is mostly rear-wheel drive, (except for the F52 sedan, which is front-wheel drive) with optional all-wheel drive being available on some models.', 'bmw_1_2.png', 'bmw-1-i.jpg'),
	(8, 'SUV', 'Kia', 'kia_sorento.png', 'Sorento', 34000, 'Automatic', 2012, 7, 'The Kia Sorento is a mid-size crossover SUV (previously compact SUV until 2009) produced since 2002 by South Korean manufacturer Kia Motors.', 'kia_sorento_2.png', 'kia-sorento-i.jpg'),
	(10, 'SUV', 'Lada', 'lada_niva_urban.png', 'Niva Urban', 28000, 'Manual', 2018, 9, 'Its compact size and a 4 wheel drive are the qualities of Lada  that are important in any city, both in old curving streets and on crowded avenues. Other traits that cannot leave a city person indifferent are comfort and original style. We took into account these wishes and created Lada  Urban.', 'lada_niva_urban_2.png', 'ladsa-Urban-I.jpg'),
	(11, 'SUV', 'Chevrolet', 'lada_niva.png', 'Niva', 20000, 'Manual', 2004, 9, 'The Lada Niva is a mini sport utility vehicle  produced by the AvtoVaz Group. Originally known as the vaz-2123 in the car\'s design stage, the SUV was branded as the Chevrolet Niva between 1998 and 2020 when Avtovaz (the parent company of the Lada brand) was in a joint venture with General Motors called gm-Avtovaz. The car was rebranded as the Lada Niva in 2020 after General Motors sold its 50-percent stake in the firm, which means that the car now has the same name that the Vaz-2121 has in certain European markets (with the Vaz-2123 being a development of the earlier Vaz-2121).', 'chevrolet_niva_2.jpg', 'chevrolet-niva-i.jpg'),
	(12, 'Hatchback', 'Mazda', 'mazda_2.png', '2', 23000, 'Manual', 2008, 8, 'The Mazda 2 is a supermini manufactured and marketed globally by Mazda since 1996, currently in its fourth generation. The 2 is marketed sometimes as the Demio and under previous nameplates including Mazda 121, Mazda Metro and Ford Festiva Mini Wagon.', 'mazda_2_2.png', 'mazda-2-i.jpg'),
	(13, 'Wagon', 'Mazda', 'mazda_6.png', '6', 29000, 'Automatic', 2014, 8, 'The Mazda 6 is a very good midsize car. It\'s one of the most enjoyable sedans in its class to drive, thanks to its nimble handling, smooth braking, and responsive steering. The base engine has enough power for most driving situations, but the available turbocharged engine adds a little extra punch', 'mazda_6_2.png', 'mazda-6-i.jpg'),
	(14, 'Van', 'Mazda', 'mazda_MPV.png', 'MPV', 32000, 'Manual', 2010, 8, 'The Mazda MPV (Multi-Purpose Vehicle) is a minivan manufactured by Mazda. Introduced in 1988 as a rear-wheel-drive model with optional selectable four-wheel drive, this was replaced in 1999 with a front-wheel-drive version with optional all-wheel-drive in some markets.', 'Mazda_mpv_2.png', 'mazda-mpv-i.jpg'),
	(15, 'Coupe', 'Mercedes-Benz', 'mercedes_sls.png', 'SLS AMG', 56000, 'Robot', 2016, 5, 'The SLS was the first Mercedes-Benz automobile designed and built from scratch entirely by amg. Upon its introduction at the 2009 Frankfurt Motor Show, the sls amg\'s 571 ps (420 kw; 563 hp) m159 engine was according to amg "the world\'s most powerful naturally aspirated production series engine" ever produced.', 'mercedes_sls_2.png', 'mercedes-sls-i.jpg'),
	(16, 'Sedan', 'Mitsubishi', 'mitsubishi_lancer.png', 'Lancer', 30000, 'Manual', 2015, 1, 'The Mitsubishi Lancer is a compact car produced by the Japanese manufacturer Mitsubishi since 1973.   The Lancer has been marketed as the Colt Lancer, Dodge Colt, Plymouth Colt, Chrysler Valiant Lancer, Chrysler Lancer, Eagle Summit, Hindustan Lancer, Soueast Lioncel, and Mitsubishi Mirage in various countries at different times, and has been sold as the Mitsubishi Galant Fortis in Japan since 2007. It has also been sold as Mitsubishi Lancer Fortis in Taiwan with a different facelift than the Galant Fortis. In Japan, it was sold at a specific retail chain called Car Plaza.   Between its introduction in 1973 and 2008, over six million units were sold. According to Mitsubishi, there were nine generations of development before the current model.   Mitsubishi ended production of the Lancer in August 2017 worldwide, with the exception of Taiwan and Mainland China. An extensive facelift was given to the car by Pininfarina\'s Chinese offices.', 'mitsubishi-lancer-2.png', 'mitsubishi-lancer-i.jpg'),
	(18, 'Hatchback', 'Seat', 'seat_leon.png', 'Leon', 29000, 'Automatic', 2014, 4, 'The SEAT Leon spelled Leon outside of Spain, (means "Lion", or also Leon, an old Kingdom of Spain) is a hatchback compact car built by the Spanish car manufacturer SEAT since October 1998.', 'seat_leon_2.png', 'seat-leon-i.jpg'),
	(19, 'SUV', 'Infiniti', 'infiniti_fx.png', 'FX', 52000, 'Automatic', 2014, 10, 'As Infiniti\'s midsize luxury sport-utility, the 2008 Infiniti FX35 adds new audio features and combines sports car like handling with the convenience of an SUV. A five-passenger crossover SUV, the 2007 Infiniti FX35 is a boldly-styled entry-level luxury vehicle that is available with RWD or AWD', 'infiniti_fx_2.png', 'infiniti-fx-i.jpg'),
	(34, 'Sedan', 'Chrysler', 'chrysler_300C.png', '300C', 42000, 'Automatic', 2012, 11, 'When it debuted as a 2005 model, the Chrysler 300 revived the long-dormant tradition of the full-size, high-style American performance car. While a 2.7-liter V6 was standard, and a 3.5-liter V6 optional, the engine that grabbed the headlines was the top-tier 5.7-liter Hemi V8 developing 340 horsepower.', 'chrysler_300C2.png', 'Chrysler-300C-I.jpg');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.brand_category
CREATE TABLE IF NOT EXISTS `brand_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Дамп данных таблицы brandbase.brand_category: ~11 rows (приблизительно)
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
	(10, 'Japan', 'infiniti.png', 'Infiniti'),
	(11, 'USA', 'chrysler_logo.png', 'Chrysler');
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

-- Дамп данных таблицы brandbase.user: ~1 rows (приблизительно)
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

-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               10.5.9-MariaDB - mariadb.org binary distribution
-- Операционная система:         Win64
-- HeidiSQL Версия:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных brandbase
CREATE DATABASE IF NOT EXISTS `brandbase` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `brandbase`;

-- Дамп структуры для таблица brandbase.car
CREATE TABLE IF NOT EXISTS `car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `body_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `brand` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` longtext COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image3` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `model` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int(11) NOT NULL,
  `transmission` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year` int(11) NOT NULL,
  `car_category_id` bigint(20) DEFAULT NULL,
  `segment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKprvkkwdoo99gw6gf0t5jnmhko` (`car_category_id`),
  KEY `FKjqesahapdts5cr3daitkdphi4` (`segment_id`),
  CONSTRAINT `FKjqesahapdts5cr3daitkdphi4` FOREIGN KEY (`segment_id`) REFERENCES `segment` (`id`),
  CONSTRAINT `FKprvkkwdoo99gw6gf0t5jnmhko` FOREIGN KEY (`car_category_id`) REFERENCES `car_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы brandbase.car: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` (`id`, `body_type`, `brand`, `country`, `description`, `image`, `image2`, `image3`, `model`, `price`, `transmission`, `year`, `car_category_id`, `segment_id`) VALUES
	(1, 'Седан', 'BMW', 'Германия', 'По уровню оснащенности и прогрессивности технологий баварский седан BMW 5-series нового поколения (индекс G30) ожидаемо превзошел своего предшественника. Новая "пятерка", разделяющая платформу с флагманской BMW 7-series, получила ряд усовершенствованных электронных ассистентов и помощников, стала незначительно крупнее в габаритах, при этом колесная база седана удлинилась на 7 мм и на 10 л "подрос" объем багажника. В силовой структуре кузова BMW 5-series облегченные композитные материалы не применялись как на старшей "семерке", тем не менее, инженерам удалось снизить вес автомобиля в среднем на целых 100 кг. Даже стоя неподвижно "баварец" создает сильное впечатление сильной внешностью. Визуально новый BMW 5-series можно опознать по "перерисованной" светотехнике, плавно перетекающей в увеличенные ноздри радиаторной решетки - такое стилистическое решение баварская "пятерка" получила впервые. Из других дизайнерских особенностей - декоративные боковые "клюшки" на передних крыльях (как у 7 серии), новые задние фонари, меняющиеся в зависимости от двигателя патрубки выхлопа. К слову, заметно улучшен коэффициент аэродинамического сопротивления - 0.22 (против 0.25 у прошлого поколения). Улучшить этот показатель помогли не только особенности кузова, но и управляемые заслонки в радиаторных решетках.  Модульная платформа CLAR внесла свои изменения в архитектуру подвески седана 5 серии. Спереди теперь здесь установлена 2-рычажная конструкция, сзади массивный нижний рычаг уступил место двум облегченным тягам. Пневматическая подвеска новому BMW 5-series не положена (у ближайшего конкурента Mercedes E-class, например, эта опция имеется). Здесь применяется традиционная пружинная компоновка с адаптивными амортизаторами и прогрессивной системой подавления кренов. Кроме того, седан может похвастаться подруливающей системой задних колес и активным рулевым механизмом с переменным шагом зубьев. Интерьер новой "пятерки" получил много новшеств. В этом списке большой информационный дисплей с увеличенной диагональю, обновленная система Connected Drive с широкими коммуникационными возможностями, знакомая по флагманской 7-серии система управления жестами, опция автоматической парковки (доступно даже для механических коробок). Силовая гамма BMW 5-series представлена усовершенствованными турбонаддувными моторами 190 - 340 сил, сочетающимися с 8-скоростной автоматической или 6-диапазонной ручной коробками.  Немецкий бизнес-седан имеет три пакета внешней отделки: Sport line, Luxury linе и M Sport. Линия Sport отличается сочетанием темных компонентов внешнего оформления и эксклюзивных колесных дисков Double spoke 634. В салоне BMW 5-series спортивную атмосферу создают подсвечиваемая надпись "Sport Line" и кресла с выраженной боковой поддержкой. Люксовая линия привносит в облик седана благородные элегантные черты в виде хромированных отделочных компонентов, блестящей окантовки боковых стекол, эксклюзивных колес с многоспицевым дизайном. Салон этого исполнения отличается улучшенным пакетом отделки кожаными материалами и натуральным деревом. Спортивная линия M Sport создает эффектный динамичный стиль и великолепно отражает темпераментный характер автомобиля. Особенностью пакета являются аэродинамичные бамперы, эксклюзивная отделка салона кoжаными материалами и алюминием, адаптивная подвеска. Для особо взыскательных водителей предусмотрена комплектация BMW Individual, предлагающая широкий спeктр отделки для уникальной персонализации автомобиля. За отдельную плату BMW 5-series можно доукомплектовать спутниковой системой сигнализации, камерой заднего вида, ассистентом парковки, функцией ночного видения, аудиосистемой Harman&Kardon.', 'bmw_5.png', 'bmw_5_2.png', 'bmw_5_3.png', '5-Series', 3180000, 'Автоматическая', 2017, 1, 2005),
	(2, 'Купе', 'BMW', 'Германия', 'BMW 2-series / БМВ 2-серии  Официальная премьера BMW 2-series состоялась 25 октября 2013 года. За день до дебюта новинки в сети интернет были обнародованы ее фотоснимки. Заднеприводное баварское купе эффектно продолжает линейку первой серии БМВ. Несмотря на улучшенный индекс класса, модель все же является преемником первой серии. Аналогичная ситуация произошла и с купе 3-серии, которое в новом поколении после кузова E92 возвысилось на следующую ступеньку в иерархии - 4-series. На российском рынке продажи нового BMW 2-series стартовали в 2014 году. Для покупателей купе доступно в трех линиях исполнения (Sport, Modern и M), а возможности индивидуализации 2 серии очень широкие, что характерно для BMW.  Что касается моторов, то их для BMW 2-series предложено пока всего 3: 2.0i и 184 л.с., 2.0d и 184 л.с., 3.0i и 326 л.с. Для всех модификаций доступна классическая 6-ступенчатая "механика" и 8-диапазонный автомат ZF. BMW 2-series получил конструкцию шасси, как у предыдущего поколения (1-series Coupe): спереди стойки МакФерсон, сзади - "многорычажка". Для БМВ 2-серии теперь стала доступной современная система iDrive с сенсорной панелью, как на автомобилях BMW классом выше.  На нашем рынке купе 2-й серии представлено в базовом варианте Advantage и линиях Sport, Luxury и M Sport. Версия Advantage сочетает в себе классический дизайн с базовым набором необходимого оборудования (светодиодные фары головного света и "противотуманки", динамический круиз-контроль, радио BMW Professional, мультируль, подогрев передних сидений, функция Hands Free). Исполнение Sport имеет 17-дюймовые колеса, спортсиденья с возможностью индивидуальной регулировки и особую тканевую отделку интерьера. В линии Luxury купе BMW 2-series отличается внешними компонентами отделки "Хром" и снабжается спортивным кожаным рулевым колесом, декоративными деревянными вставками в салоне, изысканной кожаной отделкой. Версия M Sport укомплектована спортивной подвеской, аэродинамическим обвесом и пакетом глянцевой внешней отделки.', 'bmw_2.png', 'bmw_2_2.jpg', 'bmw_2_3.jpg', '2-series', 1990000, 'Автоматическая', 2017, 1, 2003),
	(3, 'Седан', 'Mercedes', 'Германия', 'Mercedes C-class / Мерседес C-класс  Официальная презентация четвёртого поколения Mercedes C-class (W205) состоялась 16 декабря 2013 года. Новый C-class заметно прибавил в габаритах: длина кузова равна 4686 мм (против 4591 у предыдущей генерации). Также увеличилась колесная база, которая теперь составляет 2840 мм (против 2760 мм). При всем этом масса седана сократилась за счет применения алюминия и композитных материалов в конструкции кузова. Mercedes C-class использует заднеприводную платформу MRA, на базе которой уже реализован высокотехнологичный S-Class W222. Изменений претерпела также конструкция подвески: спереди используется 4-рычажка с алюминиевыми рычагами, сзади - прежняя 5-рычажная, которую немного доработали. Кроме того, впервые для Mercedes C-class компания предлагает пневмоподвеску, которая может самостоятельно регулировать клиренс в зависимости от загрузки автомобиля и его скорости.  На Mercedes C-class представлено множество систем активной и пассивной безопасности, среди которых можно выделить круиз-контроль, систему предотвращения фронтальных столкновений, круговой обзор, автоматический паркинг и многое другое. Автомобиль получил достаточно разнообразную линейку, мощностью от 156 до 510 л.с. В России Mercedes C-class можно приобрести в одной из нескольких модификаций, включая 2 заряженные версии от AMG. Среди доступного оборудования для Mercedes C-class предлагаются аудио Burmester, климатическая система, ионизатор воздуха, панорамная крыша и множество других полезных опций. Весной 2018 года на российский рынок приехала рестайлинговая версия компактного немецкого седана.  В базовой для нашегo рынка комплектации Premium немецкий седан Mercedes C-class получил легкосплавные диски колес R17 с дизайном 10 спиц, обивку салона черной тканью Aberden, декоративные вставки "рояльный лак", кресла с 4-точечной поясничной поддержкой и электроприводом, диодные фары головного светa High Performance, обогреваемые форсунки стеклоомывателя, сенсор дождя, мультимедийную систему (Bluetooth, интеграция со смартфонами, телефония), мультифункциональный спортивный руль, климатическую систему, подушки безопасности (включая коленные и боковые), парковочный ассистент. Линия оснащения Sport отличается отделкой экстерьера и салoна в стиле AMG, эксклюзивной решеткой радиатора Diamond и комплектуется колесами R18, более комфортабельными креслами с широким количеством регулировок, специальным противоугонным пакетом, сенсорной панелью с контроллером. В состав пакета спорт-версии AMG C43 вошли особые компоненты внешней и внутренней отделки, спортивная выхлопная система, рулевое колесо AMG Performance, салонная подсветка Ambient Lighting, подсвечиваемые пороги, климат-контроль Thermomatic. За доплату немецкому седану полагаются панорамная сдвижная крыша, крышка багажника с автозакрыванием, зеркала с автоматическим затемнением, звукоизоляционное остекление, вентиляций сидений, саунд-система Burmester.', 'mercedes_c.png', 'mercedes-c_2.jpg', 'mercedes-c_3.jpg', 'C-class', 2380000, 'Автоматическая', 2018, 2, 2003),
	(4, 'Седан', 'Toyota', 'Япония', 'Toyota Corolla / Тойота Королла  Двенадцатое по счету поколение Toyota Corolla развивает концепцию дизайна в стиле Hi-Tech и вплотную приближается к Toyota Camry по уровню комфорта и оснащения. В своей основе модель использует высокотехнологичную модульную платформу GA-C (модифицированный вариант архитектуры TNGA), для которой характерны увеличенная жесткость конструкции, низкий центр тяжести и энергоемкая многорычажная подвеска. Выразительная внешность Toyota Corolla ассоциируется с седанами бизнес-класса - низкий классический силуэт, а также массивные крылья и большой угол наклона стоек создают в этом автомобиле сильный и самодостаточный образ. Интерьер новинки по части эргономики и функциональности шагнул далеко вперед. Современный и просторный салон Toyota Corolla отличается высоким качеством исполнения, а пересмотренное в лучшую сторону оснащение создает атмосферу премиума.  В России для седана Toyota Corolla 2019 модельного года предусмотрен знакомый по прошлой генерации двигатель 1.6 л Dual VVT-I, который может сочетаться с 6-скоростной механикой либо вариатором Multidrive. Бесступенчатая трансмиссия получила более широкий диапазон передаточных чисел, что позволяет автомобилю более эффективно передвигаться на низких оборотах. Обновленная многорычажная подвеска, во многом схожая с более премиальной Camry, призвана улучшить плавность хода и оптимизировать управляемость. Также вслед за Camry новый седан Toyota Corolla получил медиаплатформу Toyota Touch с мультифункциональным 8-дюймовым дисплеем. Впервые на модели устанавливается цифровая приборная панель с 7-дюймовым экраном, а в топовых версиях предусмотрена проекция приборов на лобовое стекло.  Самая доступная версия Toyota Corolla Стандарт оснащена стальными дисками R15 с колпаками, фарами с галогеновыми лампами (вся остальная светотехника LED), датчиком света, аудиоподготовкой (4 динамика), передними креслами с подогревом, системой кондиционирования, монохромным 3.5-дюймовым дисплеем на панели приборов, фронтальными и боковыми "эйрбегами". В следующей комплектации Классик имеются легкосплавные диски R16, базовая аудиосистема с 6-ю динамиками (USB, AUX, Bluetooth), мультируль в кожаной отделке (+ электрообогрев), цветной инфодисплей 4.2 дюйма. Королла в линии оснащения Комфорт может похвастаться улучшенной отделкой, медиакомплексом с 8-дюймовым экраном, амбиентной подсветкой салона, 2-зонной климат-системой, цветным 7-дюймовым дисплеем на панели приборов, автозатемняемым зеркалом. В версии Престиж бонусом идут литые диски R17, хром-пакет внешней отделки, тонировка стекол, полностью диодная светотехника, функция бесключевого доступа. Максимальная комплектация Престиж Safety дополняется проекционным дисплеем 10-дюймов, автоуправлением дальним светом, распознаванием дорожных знаков, круиз-контролем с поддержкой дистанции', 'toyota_corolla.png', 'toyota_corolla_2.jpg', 'toyota-corolla_3.jpg', 'Corolla', 1367000, 'Автоматическая', 2019, 3, 2003);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.car_category
CREATE TABLE IF NOT EXISTS `car_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы brandbase.car_category: ~6 rows (приблизительно)
/*!40000 ALTER TABLE `car_category` DISABLE KEYS */;
INSERT INTO `car_category` (`id`, `country`, `image`, `name`) VALUES
	(1, 'Германия', 'bmw_logo.png', 'BMW'),
	(2, 'Германия', 'mercedes_logo.png', 'Mercedes-Benz'),
	(3, 'Япония', 'toyota_logo.png', 'Toyota'),
	(4, 'Япония', 'mazda_logo.png', 'Mazda'),
	(5, 'Швеция', 'volvo_logo.png', 'Volvo'),
	(6, 'Испания', 'seat_logo.png', 'Seat');
/*!40000 ALTER TABLE `car_category` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;

-- Дамп данных таблицы brandbase.hibernate_sequence: ~1 rows (приблизительно)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
	(4001, 1, 9223372036854775806, 1, 1, 1000, 0, 0);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.modification_auto
CREATE TABLE IF NOT EXISTS `modification_auto` (
  `id` bigint(20) NOT NULL,
  `acceleration_time` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `body_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `brand` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `build_country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `carrying_capacity` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `climate_control` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `curb_weight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `disk_size` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `drive_unit` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `electronic_control_systems` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_displacement` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_power` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `front_brakes` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `front_suspension` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fuel_higway_cycle` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fuel_mixed_cycle` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fuel_tank_volume` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fuel_urban_cycle` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `full_mass` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `guarantee` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `height` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `length` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `max_speed` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `model` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modification` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `number_of_cyclinders_and_arrangement` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `number_of_doors` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `number_of_seats` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `power_reserve` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `power_steering` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int(11) NOT NULL,
  `rear_brakes` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rear_suspension` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tire_size` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `torque` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `transmission_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `trunk_volume` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type_of_fuel` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `width` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year` int(11) NOT NULL,
  `car_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe7b7y3wy9kbek2s2dqpgaufqo` (`car_id`),
  CONSTRAINT `FKe7b7y3wy9kbek2s2dqpgaufqo` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы brandbase.modification_auto: ~5 rows (приблизительно)
/*!40000 ALTER TABLE `modification_auto` DISABLE KEYS */;
INSERT INTO `modification_auto` (`id`, `acceleration_time`, `body_type`, `brand`, `build_country`, `carrying_capacity`, `climate_control`, `curb_weight`, `disk_size`, `drive_unit`, `electronic_control_systems`, `engine_displacement`, `engine_power`, `engine_type`, `front_brakes`, `front_suspension`, `fuel_higway_cycle`, `fuel_mixed_cycle`, `fuel_tank_volume`, `fuel_urban_cycle`, `full_mass`, `guarantee`, `height`, `length`, `max_speed`, `model`, `modification`, `number_of_cyclinders_and_arrangement`, `number_of_doors`, `number_of_seats`, `power_reserve`, `power_steering`, `price`, `rear_brakes`, `rear_suspension`, `tire_size`, `torque`, `transmission_type`, `trunk_volume`, `type_of_fuel`, `width`, `year`, `car_id`) VALUES
	(2007, '7.8 сек', 'Седан', 'BMW', 'Россия', '670 кг', 'Климат-контроль', '1530 кг', '17x7,5J', '	Задний', 'ABS, ASR, EBA, EBD, ESP', '1998 см³', '184/5000-6500', 'Бензиновый с турбонаддувом', 'Дисковые вентилируемые', 'Независимая, многорычажная', '4.6 л на 100 км', '5.4 л на 100 км', '68 л', '6.9 л на 100 км', '2200 кг', '2 года без ограничения пробега', '1479 мм', '4936 мм', '235 км/ч', 'BMW 5-series', 'BMW 520i AT', '4/Рядный', '	4', '	5', '986 - 1 478 км', 'Электроусилитель', 3180000, 'Дисковые вентилируемые', 'Независимая, многорычажная', '	225/55 R17', '290/1350-4250', 'Автоматическая, 8 передач', '530 л', '	АИ-95', '1868 мм', 2017, 1),
	(2008, '7.5 сек', 'Седан', 'BMW', '	Россия', '685 кг', 'Климат-контроль', '1560 кг', '17x7,5J', 'Задний', 'ABS, ASR, EBA, EBD, ESP', '1995 см³', '190/4000', '	Дизельный с турбонаддувом', 'Дисковые вентилируемые', '	Независимая, многорычажная', '4.1 л на 100 км', '4.5 л на 100 км', '	66 л', '5.0 л на 100 км', '	2245 кг', '	2 года без ограничения пробега', '1479 мм', '4936 мм', '235 км/ч', '	BMW 5-series', 'BMW 520d AT', '4/Рядный', '4', '	5', '1 320 - 1 610 км', 'Электроусилитель', 3250000, 'Дисковые вентилируемые', '	Независимая, многорычажная', '225/55 R17', '400/1750-2500', 'Автоматическая, 8 передач', '	530 л', '	ДТ', '1868 мм', 2017, 1),
	(3001, '8.8 сек', '	Купе', '	BMW', 'Германия', '430 кг', 'Климат-контроль', '1420 кг', '16x7J', 'Задний', 'ABS, ASR, EBA, EBD, ESP, HHC', '1499 см³', '136/4400', 'Бензиновый с турбонаддувом', 'Дисковые вентилируемые', 'Независимая, многорычажная', '4.8 л на 100 км', '5.6 л на 100 км', '52 л', '6.9 л на 100 км', '1850 кг', '2 года без ограничения пробега', '1438 мм', '4432 мм', '210 км/ч', ' 2-series', 'BMW 218i MT', '3/Рядный', '	2', '4', '754 - 1 083 км', 'Электроусилитель', 1990000, 'Дисковые вентилируемые', 'Независимая, многорычажная', '205/55 R16', '220/1250-4300', 'Механическая, 6 передач', '	390 л', 'АИ-95', '1774 мм', 2017, 2),
	(3002, '8.3 сек', '	Седан', 'Mercedes', 'Германия', '565', '	Климат-контроль', '1425', '225/50 R17', 'Задний', 'ABS, ASR, EBA, EBD, ESP, HHC', '1595 см³', '150/5300', 'Бензиновый c турбонаддувом', '	Дисковые вентилируемые', 'Независимая, многорычажная', '	5.0 л на 100 км', '6.2 л на 100 км', '41', '8.1 л на 100 км', '1990', '2 года без ограничения пробега', '1442', '4686', '225 км/ч', '	Mercedes C-class', '	Mercedes C 180 AT', '	4/Рядный', '	4', '	5', '506 - 820 км', 'Электроусилитель', 2380000, 'Дисковые', 'Независимая, многорычажная', '225/55 R17', '250/1200-4000', 'Автоматическая, 9 передач', '480', '	АИ-95', '1810 ', 2018, 3),
	(3003, '11.0 сек', 'Седан', 'Toyota', 'Турция', '	415', 'Кондиционер', '1370', '5x6.5J', 'Передний', '	ABS, ASR, EBA, EBD, ESP, HHC', '1598 см³', '122/6000', '	Бензиновый', 'Дисковые вентилируемые', '	Независимая, McPherson', '5.4 л на 100 км', '6.6 л на 100 км', '50 л', '8.7 л на 100 км', '1785', '3 года или 100 000 км', '1435', '4630', '195 км/ч', '	Toyota Corolla', 'Toyota Corolla 1.6 MT', '4/Рядный', '	4', '	5', '575 - 926 км', 'Электроусилитель', 1367000, 'Дисковые', 'Полузависимая, торсионная балка', '195/65 R15', '153/5200', 'Механическая, 6 передач', '470 л', 'АИ-95', '1780', 2019, 4);
/*!40000 ALTER TABLE `modification_auto` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.modification_moto
CREATE TABLE IF NOT EXISTS `modification_moto` (
  `id` bigint(20) NOT NULL,
  `body_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `brand` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `build_country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cooling_system` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `curb_weight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `disk_size` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `electronic_control_systems` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_displacement` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_power` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `front_brakes` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `front_suspension` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fuel_cycle` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `height` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `launch_system` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `length` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `max_speed` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `model` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modification` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `number_of_cyclinders_and_arrangement` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `number_of_measures` int(11) NOT NULL,
  `number_of_valves_cyclinder` int(11) NOT NULL,
  `power_reserve` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int(11) NOT NULL,
  `rear_brakes` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rear_suspension` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tire_size` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `torque` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `transmission_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type_of_fuel` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `width` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year` int(11) NOT NULL,
  `moto_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK31tr0pe71x4xrigf3qy4xt613` (`moto_id`),
  CONSTRAINT `FK31tr0pe71x4xrigf3qy4xt613` FOREIGN KEY (`moto_id`) REFERENCES `motorcycle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы brandbase.modification_moto: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `modification_moto` DISABLE KEYS */;
/*!40000 ALTER TABLE `modification_moto` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.modification_truck
CREATE TABLE IF NOT EXISTS `modification_truck` (
  `id` bigint(20) NOT NULL,
  `acceleration_time` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `body_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `brand` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `build_country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `carrying_capacity` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `climate_control` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `curb_weight` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `disk_size` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `drive_unit` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `electronic_control_systems` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_displacement` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_power` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `front_brakes` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `front_suspension` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fuel_higway_cycle` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fuel_mixed_cycle` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fuel_tank_volume` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fuel_urban_cycle` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `full_mass` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `guarantee` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `height` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `length` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `max_speed` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `model` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modification` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `number_of_cyclinders_and_arrangement` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `number_of_doors` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `number_of_seats` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `power_reserve` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `power_steering` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int(11) NOT NULL,
  `rear_brakes` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rear_suspension` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tire_size` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `torque` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `transmission_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type_of_fuel` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `width` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year` int(11) NOT NULL,
  `truck_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK45701nkanahmqvwlwpo3l3ww7` (`truck_id`),
  CONSTRAINT `FK45701nkanahmqvwlwpo3l3ww7` FOREIGN KEY (`truck_id`) REFERENCES `truck` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы brandbase.modification_truck: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `modification_truck` DISABLE KEYS */;
/*!40000 ALTER TABLE `modification_truck` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.motorcycle
CREATE TABLE IF NOT EXISTS `motorcycle` (
  `id` bigint(20) NOT NULL,
  `brand` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image2` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image3` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `model` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `price` int(11) NOT NULL,
  `transmission` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `year` int(11) NOT NULL,
  `moto_category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq49qkd6g0kcadmppol9necwjr` (`moto_category_id`),
  CONSTRAINT `FKq49qkd6g0kcadmppol9necwjr` FOREIGN KEY (`moto_category_id`) REFERENCES `motorcycle_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы brandbase.motorcycle: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `motorcycle` DISABLE KEYS */;
/*!40000 ALTER TABLE `motorcycle` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.motorcycle_category
CREATE TABLE IF NOT EXISTS `motorcycle_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы brandbase.motorcycle_category: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `motorcycle_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `motorcycle_category` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы brandbase.role: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`) VALUES
	(1, 'ROLE_USER'),
	(2, 'ROLE_ADMIN'),
	(3, 'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.segment
CREATE TABLE IF NOT EXISTS `segment` (
  `id` bigint(20) NOT NULL,
  `description` longtext COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы brandbase.segment: ~6 rows (приблизительно)
/*!40000 ALTER TABLE `segment` DISABLE KEYS */;
INSERT INTO `segment` (`id`, `description`, `image`, `name`) VALUES
	(2001, 'А-класс или Mini cars. Автомобили “особо малого класса” — Daewoo Matiz, Toyota Yaris 1.0, Ford Ka, Renault Twingo, Peugeot 106, Daewoo Tico DLX, Hyundai Atos 1000GLS, Renault Twingo — по габаритам не превышают 3,6 м в длинe и 1,6 м в ширинe. По типу кузова машины сегмента A, как правило, представляют собой трёхдверные или пятидверные хэтчбеки. Представители этого класса экономичны, компактны и манёвренны, однако не отличаются мощностью и хороши лишь для передвижения по городу и на короткие дистанции.', 'fiat_A.png', 'А-класс'),
	(2002, 'B-класс или Small cars. “Малый класс” включает в себя автомобили не длиннее 3,6—3,9 м и не шире 1,5—1,7 м. Семейство автомобилей этого класса представляют Opel Corsa, Chevrolet Aveo, Kia Rio, Hyundai Accent, Hyundai Solaris, Skoda Felicia 1.3 LX, Suzuki, Swift 1.0, Volkswagen Polo 1.0, Volkswagen Polo Classic 1.4, Volkswagen Polo Variant, Ford Fiesta, Seat Ibiza, Peugeot 206, Toyota Yaris Verso, Seat Cordoba. По типу кузовов класс B весьма пёстр: трёхдверные хэтчбеки лидируют, но есть также седаны и универсалы. Например, Polo Variant и Toyota Yaris Verso. Последний отличается повышенной вместимостью (минивэн). Авто класса B чрезвычайно востребованы в Европе: на их долю приходится около четверти всех покупок. “Малый класс” вполне подходит для пригородных путешествий, но преимущественно в паре, для четырёх человек автомобили сегмента B несколько тесноваты.', 'ford_fiesta.png', 'В-класс'),
	(2003, 'C-класс или Medium cars. Самый популярный в Европе C-класс известен также под названиями “первый средний класс”, “гольф-класс” и “низший средний класс”. Каждый год выбор около 30% клиентов автомобильных концернов падает на машины со следующими характеристиками: 3,9—4,3 м длина и 1,6—1,7 ширина, тип кузова — хэтчбек, седан, универсал или минивэн. Автомобили C-класса, которые отличаются сдержанными ценами — выбирают обычно небольшие семьи, хотя некоторые автомобили “гольф-класса” вмещают до 5 человек. Наиболее видные представители  класса C: Volkswagen Golf/Bora, Opel Astra Audi A3, Daewoo Nexia, Chevrolet Cruze, Citroen Xsara, FIAT Brava, Ford Escort и Ford Focus, Peugeot 306, Toyota Corolla Honda Civic, Subaru Impreza, Hyundai Elantra, Kia Sephia/Shuma, Kia Ceed, Kia Cerrato, Mazda 323, Mitsubishi Colt/Lancer, Nissan Almera, Renault 19.', 'mitsubishi_lancer.png', 'С-класс'),
	(2004, 'D-класс или Larger cars. Класс комфортных автомобилей 4,3 – 4,6 м в длину и 1,69-1,73 в ширину характеризуют такие качества как вместительность, комфорт и надёжность. “Cредний класс» или ”второй средний класс”, как ещё называют этот сегмент рынка легковых автомобилей, представлен следующими моделями: Opel Vectra, Daewoo Espero/ Nubira, Ford Mondeo, , Mazda 626, Mitsubishi Carisma, Nissan Primera, Peugeot 406, Renault Laguna, Subaru Legacy, Toyota Avensis, Volkswagen Passat, Seat Toledo, Kia Clarus, Honda Accord, Skoda Octavia и др. В сегменте D, “разношёрстном” по типам кузовов (хэтчбек, седан, универсал, в том числе повышенной вместимости), есть автомобили и среднего ценового диапазона, и высшего.  Если модели, которыми представлены на современном рынке классы автомобилей B, С, D, наиболее удобны и приемлемы с экономической точки зрения и составляют подавляющее большинство автопарков европейских стран, то автомобили, входящие в классы E и F гораздо более редки.', 'volkswagen_passat_cc.png', 'D-класс'),
	(2005, 'E-класс или Executive cars. Автомобили “высшего среднего класса” помимо серьёзных размеров (от 4,6 до 4,9 м в длину и от 1,73 до 1,82 м в ширину) и внушающего доверие уровня комфорта, обладают выдающимися характеристиками: мощным двигателем, сложной подвеской и большой колёсной базой. Автомобили “бизнес-класса”, как ещё называют машины сегмента E, находят поклонников в среде успешных и состоятельных людей. Представители семейства: Jaguar S-type, Mercedes-Benz E-класса, Volvo S80/V70, BMW (серия 5), Audi А6, Hyundai Sonata, Opel Omega, Toyota Camry, Mitsubishi Galant, SAAB 9-5, Nissan Maxima — автомобили с кузовом седан и универсал, а также выпускавшаяся с 1992 по 2001 год Renault Safrane с 5-тидверным хэтчбеком. На авто класса E приходится всего около 5% рынка.', 'mercedes_e.png', 'E-класс'),
	(2006, 'F-класс или Luxury cars. “Высший класс” легковых авто представляют внушительных размеров мощные автомобили с кузовом типа “седан”. Предназначены автомобили класса F (более 4,9 м в длину и более 1,82 м в ширину), прежде всего, для людей публичных. Во-первых, для тех, кому положение не позволяет предпочесть роскоши что-то иное, а во-вторых, для тех, кого не повергнет в шок цена сего металлического благолепия: Jaguar XJ8, Bentley, Lexus LS, Volkswagen Phaeton, Rolls-Royce, Hyundai Equus, Toyota Crown, Audi A8, Mersedes Benz (S-класса).', 'mercedes_s.png', 'F-класс');
/*!40000 ALTER TABLE `segment` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.truck
CREATE TABLE IF NOT EXISTS `truck` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `body_type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `brand` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` longtext COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image3` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `model` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` int(11) NOT NULL,
  `transmission` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year` int(11) NOT NULL,
  `truck_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdubqxj3xbfyac27d3efs2dhml` (`truck_id`),
  CONSTRAINT `FKdubqxj3xbfyac27d3efs2dhml` FOREIGN KEY (`truck_id`) REFERENCES `truck_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы brandbase.truck: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `truck` DISABLE KEYS */;
/*!40000 ALTER TABLE `truck` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.truck_category
CREATE TABLE IF NOT EXISTS `truck_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы brandbase.truck_category: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `truck_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `truck_category` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы brandbase.user: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `email`, `first_name`, `last_name`, `password`) VALUES
	(1, 'gs@gmail.com', 'Timur', 'Swe', '$2a$10$oNP.z9dJShRZGbt2bqGzKeiLuWLvNisMVbS4Mp1gOLeyPqBcyJBKO'),
	(2, 'ram@gmail.com', 'Ram', 'St', '$2a$10$0wmSUZFt1szTXsQMVqUYM.MRo7B4u94SeOzmwyKpxkFCYzk54VF/W'),
	(3, 'kern@gmail.com', 'Артем', 'Керн', '$2a$10$Bzs5NNewggzwKiUMgvHH3uP60ea4NhFVYymeRO9Y.Dp1QAireEDIS');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Дамп структуры для таблица brandbase.users_roles
CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`),
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Дамп данных таблицы brandbase.users_roles: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
	(1, 1),
	(2, 2),
	(3, 3);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.60 : Database - carpark
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`carpark` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `carpark`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `adm_id` int(20) NOT NULL AUTO_INCREMENT,
  `adm_name` varchar(20) DEFAULT NULL,
  `adm_pwd` varchar(50) DEFAULT NULL,
  `adm_phone` varchar(11) DEFAULT NULL,
  `adm_email` varchar(50) NOT NULL,
  `adm_gender` int(10) NOT NULL,
  `adm_age` int(10) NOT NULL,
  `adm_delete_mark` char(1) DEFAULT '0',
  PRIMARY KEY (`adm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`adm_id`,`adm_name`,`adm_pwd`,`adm_phone`,`adm_email`,`adm_gender`,`adm_age`,`adm_delete_mark`) values (1,'admin','123123','15592069447','2314572802@qq.com',1,24,'0'),(25,'abc','123','11111111111','11111@baidu.com',1,22,'0'),(26,'aaa','111','22222222222','1111112223@qq.com',0,23,'0');

/*Table structure for table `car_msg` */

DROP TABLE IF EXISTS `car_msg`;

CREATE TABLE `car_msg` (
  `car_id` int(20) NOT NULL AUTO_INCREMENT,
  `park_id` int(20) NOT NULL,
  `user_id` int(20) DEFAULT NULL,
  `gmt_start` datetime DEFAULT NULL,
  `gmt_end` datetime DEFAULT NULL,
  `car_delete_mark` char(1) DEFAULT '0',
  PRIMARY KEY (`car_id`),
  KEY `fk_park_information` (`park_id`),
  KEY `fk_user` (`user_id`),
  CONSTRAINT `fk_park_information` FOREIGN KEY (`park_id`) REFERENCES `park_information` (`park_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `fix_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `car_msg` */

insert  into `car_msg`(`car_id`,`park_id`,`user_id`,`gmt_start`,`gmt_end`,`car_delete_mark`) values (1,1,1,'2022-04-06 20:53:00','2022-04-07 07:02:00','0'),(2,2,NULL,'2022-04-06 20:53:00','2022-04-07 01:53:00','0'),(3,10,5,'2022-04-23 20:08:30','2022-04-24 16:52:59','0'),(4,4,NULL,'2022-04-25 18:50:09','2022-04-27 18:50:14','0'),(5,6,NULL,'2022-04-19 18:50:21','2022-04-20 18:50:25','0'),(6,3,2,'2022-04-18 18:52:23','2022-04-28 18:52:27','0'),(7,12,3,'2022-04-19 19:06:08','2022-04-21 19:06:13','0'),(8,13,4,'2022-04-11 19:07:08','2022-04-20 19:07:11','0'),(9,14,6,'2022-04-25 19:08:00','2022-04-27 19:08:03','0'),(10,15,7,'2022-04-25 19:08:18','2022-04-29 19:08:20','0'),(11,16,8,'2022-04-11 19:08:41','2022-04-14 19:08:43','0'),(12,17,9,'2022-04-04 19:09:00','2022-04-27 19:09:04','0'),(13,18,NULL,'2022-04-19 19:10:12','2022-04-22 19:10:14','0'),(14,19,NULL,'2022-04-04 19:10:24','2022-04-05 14:10:26','0'),(15,20,NULL,'2022-04-25 19:10:40','2022-04-26 07:10:43','0'),(16,9,7,'2022-04-24 14:48:04','2022-04-25 19:14:42','0'),(17,11,NULL,'2022-04-24 16:27:37','2022-04-28 16:53:43','0'),(18,21,NULL,'2022-04-26 19:10:55','2022-04-28 19:10:58','0'),(19,22,NULL,'2022-04-12 06:11:06','2022-04-12 16:11:08','0'),(20,23,NULL,'2022-04-25 19:11:22','2022-04-26 07:11:24','0');

/*Table structure for table `fix_user` */

DROP TABLE IF EXISTS `fix_user`;

CREATE TABLE `fix_user` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `user_phone` varchar(50) DEFAULT NULL,
  `user_age` int(10) DEFAULT NULL,
  `user_gender` int(1) DEFAULT NULL,
  `user_car_num` varchar(20) NOT NULL,
  `user_delete_mark` int(1) DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `fix_user` */

insert  into `fix_user`(`user_id`,`user_name`,`user_phone`,`user_age`,`user_gender`,`user_car_num`,`user_delete_mark`) values (1,'小李','11111111111',22,0,'陕V 00000',0),(2,'小王','13572756214',44,1,'陕V 32532',0),(3,'张张','12345678987',25,0,'豫C 23456',0),(4,'大美','98765432123',33,1,'豫C 55566',0),(5,'小小','15592069447',22,1,'陕A 22233',0),(6,'晓晓','13526785423',19,1,'京J AB222',0),(7,'小丽','13572756214',30,0,'陕A 22222',0),(8,'大漂亮','15566234876',22,1,'川Y VVV88',0),(9,'张伟','15567823502',32,0,'陕A AAAA0',0);

/*Table structure for table `park_information` */

DROP TABLE IF EXISTS `park_information`;

CREATE TABLE `park_information` (
  `park_id` int(11) NOT NULL AUTO_INCREMENT,
  `park_type` varchar(10) DEFAULT NULL COMMENT 'free or fix',
  `park_status` char(1) DEFAULT '0',
  `park_delete_mark` char(1) DEFAULT '0',
  PRIMARY KEY (`park_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `park_information` */

insert  into `park_information`(`park_id`,`park_type`,`park_status`,`park_delete_mark`) values (1,'fix','1','0'),(2,'free','1','0'),(3,'fix','1','0'),(4,'free','1','0'),(5,'fix','0','1'),(6,'free','1','0'),(7,'free','1','1'),(8,'free','0','1'),(9,'fix','1','0'),(10,'fix','1','0'),(11,'free','1','0'),(12,'fix','1','0'),(13,'fix','1','0'),(14,'fix','1','0'),(15,'fix','1','0'),(16,'fix','1','0'),(17,'fix','1','0'),(18,'free','1','0'),(19,'free','1','0'),(20,'free','1','0'),(21,'free','1','0'),(22,'free','1','0'),(23,'free','1','0'),(24,'fix','1','0'),(25,'fix','0','0'),(26,'fix','0','0'),(27,'fix','0','0'),(28,'fix','0','0'),(29,'free','0','0'),(30,'free','0','0'),(31,'free','0','0'),(32,'free','0','0');

/*Table structure for table `pay_msg` */

DROP TABLE IF EXISTS `pay_msg`;

CREATE TABLE `pay_msg` (
  `pm_id` int(11) NOT NULL AUTO_INCREMENT,
  `pm_type` varchar(10) DEFAULT NULL COMMENT 'free or fix',
  `car_msg_id` int(20) NOT NULL,
  `pm_rate` int(10) DEFAULT NULL,
  `pay_money` int(50) DEFAULT NULL,
  `pay_method` varchar(10) DEFAULT NULL COMMENT 'month or year',
  `pm_delete_mark` char(1) DEFAULT '0',
  PRIMARY KEY (`pm_id`),
  KEY `fx_car_msg` (`car_msg_id`),
  CONSTRAINT `fx_car_msg` FOREIGN KEY (`car_msg_id`) REFERENCES `car_msg` (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `pay_msg` */

insert  into `pay_msg`(`pm_id`,`pm_type`,`car_msg_id`,`pm_rate`,`pay_money`,`pay_method`,`pm_delete_mark`) values (1,'fix',6,NULL,560,'year','0'),(2,'free',2,3,15,NULL,'0'),(3,'fix',7,NULL,560,'year','0'),(4,'fix',3,NULL,560,'year','0'),(5,'fix',8,NULL,120,'month','0'),(6,'fix',9,NULL,120,'month','0'),(7,'fix',10,NULL,560,'year','0'),(8,'fix',11,NULL,560,'year','0'),(9,'fix',12,NULL,120,'year','0'),(16,'fix',16,NULL,120,'month','0'),(19,'free',17,10,960,NULL,'0'),(20,'free',4,3,144,NULL,'0'),(21,'free',5,3,72,NULL,'0'),(22,'free',13,5,360,NULL,'0'),(23,'free',14,5,95,NULL,'0'),(24,'free',15,5,60,NULL,'0'),(25,'free',18,3,144,NULL,'0'),(26,'free',19,3,30,NULL,'0'),(27,'free',20,3,36,NULL,'0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

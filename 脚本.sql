/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.29 : Database - pss216
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pss216` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pss216`;

/*Table structure for table `t_employee` */

DROP TABLE IF EXISTS `t_employee`;

CREATE TABLE `t_employee` (
  `eid` int(11) NOT NULL AUTO_INCREMENT COMMENT '销售员编号',
  `name` varchar(30) DEFAULT NULL COMMENT '销售员姓名',
  `sex` varchar(4) DEFAULT NULL COMMENT '销售员性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系方式',
  `state` int(4) DEFAULT NULL COMMENT '销售员的状态',
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `t_employee` */

insert  into `t_employee`(`eid`,`name`,`sex`,`birthday`,`phone`,`state`) values (1,'王明','男','1990-02-15','15069878541',1),(2,'李小燕','女','1995-11-09','17845612546',1),(3,'刘红','女','1989-10-11','17845622546',1),(4,'张颜','女','1988-09-09','15769278658',1),(5,'周蕾','女','1995-12-09','15269878534',1),(6,'王刚','男','1999-01-09','18769828525',1);

/*Table structure for table `t_product` */

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `name` varchar(30) DEFAULT NULL COMMENT '商品名称',
  `price` float DEFAULT NULL COMMENT '商品价格',
  `store` int(11) DEFAULT NULL COMMENT '商品库存',
  `state` int(4) DEFAULT NULL COMMENT '商品状态',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `t_product` */

insert  into `t_product`(`pid`,`name`,`price`,`store`,`state`) values (1,'小米_MIX2s',2999,80,1),(2,'华为_P20',3499,30,1),(3,'OPPO_R11s',2399,100,1);

/*Table structure for table `t_sell` */

DROP TABLE IF EXISTS `t_sell`;

CREATE TABLE `t_sell` (
  `sid` varchar(20) NOT NULL COMMENT '销售编号',
  `pid` int(11) DEFAULT NULL COMMENT '商品编号',
  `eid` int(11) DEFAULT NULL COMMENT '销售员编号',
  `amount` int(11) DEFAULT NULL COMMENT '销售数量',
  `selldate` date DEFAULT NULL COMMENT '销售时间',
  `state` int(4) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`sid`),
  KEY `fk_pid` (`pid`),
  KEY `fk_eid` (`eid`),
  CONSTRAINT `FK_t_sell_eid` FOREIGN KEY (`eid`) REFERENCES `t_employee` (`eid`),
  CONSTRAINT `FK_t_sell_pid` FOREIGN KEY (`pid`) REFERENCES `t_product` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sell` */

insert  into `t_sell`(`sid`,`pid`,`eid`,`amount`,`selldate`,`state`) values ('20180502081145',1,3,2,'2018-05-02',1),('20180502081157',3,1,10,'2018-05-02',1),('20180615094501',1,2,5,'2018-06-15',1),('20180706112426',2,4,1,'2018-07-06',1),('20180706112522',3,2,12,'2018-07-06',1),('20180706112548',3,5,5,'2018-07-06',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

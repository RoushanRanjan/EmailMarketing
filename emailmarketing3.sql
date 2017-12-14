-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.12-log - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.1.0.4903
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for emailmarketing
CREATE DATABASE IF NOT EXISTS `emailmarketing` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `emailmarketing`;


-- Dumping structure for table emailmarketing.country
CREATE TABLE IF NOT EXISTS `country` (
  `countryId` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`countryId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table emailmarketing.country: ~4 rows (approximately)
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` (`countryId`, `country`) VALUES
	(1, 'India'),
	(2, 'pakistan'),
	(3, 'srilanka'),
	(4, 'austrailia');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;


-- Dumping structure for table emailmarketing.tbl_addrss
CREATE TABLE IF NOT EXISTS `tbl_addrss` (
  `addressid` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(45) NOT NULL,
  `tbl_city_cityid` int(11) NOT NULL,
  PRIMARY KEY (`addressid`),
  KEY `fk_tbl_addrss_tbl_city1_idx` (`tbl_city_cityid`),
  CONSTRAINT `fk_tbl_addrss_tbl_city1` FOREIGN KEY (`tbl_city_cityid`) REFERENCES `tbl_city` (`cityid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- Dumping data for table emailmarketing.tbl_addrss: ~25 rows (approximately)
/*!40000 ALTER TABLE `tbl_addrss` DISABLE KEYS */;
INSERT INTO `tbl_addrss` (`addressid`, `address`, `tbl_city_cityid`) VALUES
	(1, 'balepeer', 1),
	(2, 'chauseGalli', 2),
	(4, 'hyd', 5),
	(5, 'hyd', 5),
	(6, 'hyd', 5),
	(7, 'hyd', 5),
	(8, 'hyd', 5),
	(9, 'hyd', 5),
	(10, 'hyd', 5),
	(11, 'hyd', 5),
	(12, 'hyd', 5),
	(13, 'hyd', 5),
	(14, 'hyd', 5),
	(15, 'hyd', 5),
	(16, 'hyd', 5),
	(17, 'aaa', 1),
	(18, 'aaa', 1),
	(19, 'asdfsdf', 1),
	(20, 'adsdfsdf', 1),
	(21, 'asdfsdf', 1),
	(22, 'sdf', 1),
	(23, 'asdf', 1),
	(24, 'sdfd', 1),
	(25, 'qqqqqq', 1),
	(26, 'wwwww', 1);
/*!40000 ALTER TABLE `tbl_addrss` ENABLE KEYS */;


-- Dumping structure for table emailmarketing.tbl_city
CREATE TABLE IF NOT EXISTS `tbl_city` (
  `cityid` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(45) NOT NULL,
  `tbl_state_stateid` int(11) NOT NULL,
  PRIMARY KEY (`cityid`),
  KEY `fk_tbl_city_tbl_state1_idx` (`tbl_state_stateid`),
  CONSTRAINT `fk_tbl_city_tbl_state1` FOREIGN KEY (`tbl_state_stateid`) REFERENCES `tbl_state` (`stateid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table emailmarketing.tbl_city: ~5 rows (approximately)
/*!40000 ALTER TABLE `tbl_city` DISABLE KEYS */;
INSERT INTO `tbl_city` (`cityid`, `city`, `tbl_state_stateid`) VALUES
	(1, 'beed', 1),
	(2, 'kashi', 2),
	(3, 'patna', 3),
	(4, 'abotabad', 5),
	(5, 'turk', 6);
/*!40000 ALTER TABLE `tbl_city` ENABLE KEYS */;


-- Dumping structure for table emailmarketing.tbl_login
CREATE TABLE IF NOT EXISTS `tbl_login` (
  `loginid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `tbl_role_roleid` int(11) NOT NULL,
  PRIMARY KEY (`loginid`),
  KEY `fk_tbl_login_tbl_role_idx` (`tbl_role_roleid`),
  CONSTRAINT `fk_tbl_login_tbl_role` FOREIGN KEY (`tbl_role_roleid`) REFERENCES `tbl_role` (`roleid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- Dumping data for table emailmarketing.tbl_login: ~27 rows (approximately)
/*!40000 ALTER TABLE `tbl_login` DISABLE KEYS */;
INSERT INTO `tbl_login` (`loginid`, `username`, `password`, `tbl_role_roleid`) VALUES
	(1, 'wdeshmukh7@gmail.com', '123456', 4),
	(2, 'wdwd.1219@rediffmail.com', '345678', 3),
	(3, 'mailmechida@rediffmail.com', '456789', 1),
	(4, 'kahaho@gmail.com', '567890', 2),
	(6, 'raja@gmail.com', '123', 4),
	(7, 'raja@gmail.com', '123', 4),
	(8, 'raja@gmail.com', '123', 4),
	(9, 'raja@gmail.com', '123', 4),
	(10, 'raja@gmail.com', '123', 4),
	(11, 'raja@gmail.com', '123', 4),
	(12, 'raja@gmail.com', '123', 4),
	(13, 'raja@gmail.com', '123', 4),
	(14, 'raja@gmail.com', '123', 4),
	(15, 'raja@gmail.com', '123', 4),
	(16, 'raja@gmail.com', '123', 4),
	(17, 'raja@gmail.com', '123', 4),
	(18, 'raja@gmail.com', '123', 4),
	(19, 'rajkumarc@gmail.com', 'aaaaaaaa', 4),
	(20, 'zzzz@gmail.com', 'aaaaaaaa', 4),
	(21, 'yyyyy@gmil.com', 'yyyyyyyy', 4),
	(22, 'uuuuu@gmail.com', 'uuuuuuuu', 4),
	(23, 'iiiiii@gmil.com', 'aaaaaaaaaa', 4),
	(24, 'ooooo@gmail.com', 'oooooooo', 3),
	(25, 'pppppp@gmail.com', 'pppppppp', 2),
	(26, 'mmmmm@gmail.com', 'mmmmmmmm', 4),
	(27, 'qqqq@gmail.com', 'qqqqqqqq', 3),
	(28, 'wwww@gmail.com', 'wwwwwwwww', 2);
/*!40000 ALTER TABLE `tbl_login` ENABLE KEYS */;


-- Dumping structure for table emailmarketing.tbl_maillist
CREATE TABLE IF NOT EXISTS `tbl_maillist` (
  `mailid` int(11) NOT NULL AUTO_INCREMENT,
  `mails` varchar(45) DEFAULT NULL,
  `tbl_service_serviceid` int(11) NOT NULL,
  PRIMARY KEY (`mailid`),
  KEY `fk_tbl_maillist_tbl_service1_idx` (`tbl_service_serviceid`),
  CONSTRAINT `fk_tbl_maillist_tbl_service1` FOREIGN KEY (`tbl_service_serviceid`) REFERENCES `tbl_service` (`serviceid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table emailmarketing.tbl_maillist: ~7 rows (approximately)
/*!40000 ALTER TABLE `tbl_maillist` DISABLE KEYS */;
INSERT INTO `tbl_maillist` (`mailid`, `mails`, `tbl_service_serviceid`) VALUES
	(1, 'wdeshmukh7@gmail.com', 1),
	(2, 'wdeshmukh7@gmail.com', 2),
	(3, 'satya25051992@gmail.com', 3),
	(4, 'srout4848@gmail.com', 4),
	(5, 'anchldak12@rediffmail.com', 1),
	(6, 'ghjg@gfdh', 1),
	(7, 'nn@jkjk', 3);
/*!40000 ALTER TABLE `tbl_maillist` ENABLE KEYS */;


-- Dumping structure for table emailmarketing.tbl_operation
CREATE TABLE IF NOT EXISTS `tbl_operation` (
  `operationid` int(11) NOT NULL AUTO_INCREMENT,
  `operationDate` datetime NOT NULL,
  `tbl_operationtype_operationtypeId` int(11) NOT NULL,
  `tbl_product_productid` int(11) NOT NULL,
  `tbl_maillist_mailid` int(11) NOT NULL,
  `statusId` int(11) NOT NULL,
  PRIMARY KEY (`operationid`),
  KEY `fk_tbl_operation_tbl_operationtype1_idx` (`tbl_operationtype_operationtypeId`),
  KEY `fk_tbl_operation_tbl_product1_idx` (`tbl_product_productid`),
  KEY `fk_tbl_operation_tbl_maillist1_idx` (`tbl_maillist_mailid`),
  KEY `FK_tbl_operation_tbl_status` (`statusId`),
  CONSTRAINT `FK_tbl_operation_tbl_status` FOREIGN KEY (`statusId`) REFERENCES `tbl_status` (`statusId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_operation_tbl_maillist1` FOREIGN KEY (`tbl_maillist_mailid`) REFERENCES `tbl_maillist` (`mailid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_operation_tbl_operationtype1` FOREIGN KEY (`tbl_operationtype_operationtypeId`) REFERENCES `tbl_operationtype` (`operationtypeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_operation_tbl_product1` FOREIGN KEY (`tbl_product_productid`) REFERENCES `tbl_product` (`productid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table emailmarketing.tbl_operation: ~5 rows (approximately)
/*!40000 ALTER TABLE `tbl_operation` DISABLE KEYS */;
INSERT INTO `tbl_operation` (`operationid`, `operationDate`, `tbl_operationtype_operationtypeId`, `tbl_product_productid`, `tbl_maillist_mailid`, `statusId`) VALUES
	(1, '2017-03-26 01:09:35', 2, 1, 1, 2),
	(2, '2017-03-26 01:10:05', 1, 2, 1, 2),
	(3, '2017-03-26 01:10:41', 1, 2, 1, 1),
	(4, '2017-03-26 14:46:18', 1, 1, 1, 1),
	(5, '2017-04-07 18:01:03', 1, 2, 5, 1);
/*!40000 ALTER TABLE `tbl_operation` ENABLE KEYS */;


-- Dumping structure for table emailmarketing.tbl_operationtype
CREATE TABLE IF NOT EXISTS `tbl_operationtype` (
  `operationtypeId` int(11) NOT NULL AUTO_INCREMENT,
  `operation` varchar(45) NOT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`operationtypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table emailmarketing.tbl_operationtype: ~3 rows (approximately)
/*!40000 ALTER TABLE `tbl_operationtype` DISABLE KEYS */;
INSERT INTO `tbl_operationtype` (`operationtypeId`, `operation`, `price`) VALUES
	(1, 'click', 0.01),
	(2, 'buy', 0.05),
	(3, 'cart', 0);
/*!40000 ALTER TABLE `tbl_operationtype` ENABLE KEYS */;


-- Dumping structure for table emailmarketing.tbl_product
CREATE TABLE IF NOT EXISTS `tbl_product` (
  `productid` int(11) NOT NULL AUTO_INCREMENT,
  `productname` varchar(45) NOT NULL,
  `image` longtext NOT NULL,
  `productprice` int(11) NOT NULL,
  `producttype` varchar(45) NOT NULL,
  `owner_registerId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `statusId` int(11) NOT NULL,
  PRIMARY KEY (`productid`),
  KEY `fk_tbl_product_tbl_register1_idx` (`owner_registerId`),
  KEY `FK_tbl_product_tbl_status` (`statusId`),
  CONSTRAINT `FK_tbl_product_tbl_status` FOREIGN KEY (`statusId`) REFERENCES `tbl_status` (`statusId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_product_tbl_register1` FOREIGN KEY (`owner_registerId`) REFERENCES `tbl_register` (`registerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table emailmarketing.tbl_product: ~2 rows (approximately)
/*!40000 ALTER TABLE `tbl_product` DISABLE KEYS */;
INSERT INTO `tbl_product` (`productid`, `productname`, `image`, `productprice`, `producttype`, `owner_registerId`, `quantity`, `statusId`) VALUES
	(1, 'nada', 'ÿØÿáOýExif', 10, 'nada', 2, 2, 2),
	(2, 'gada', 'ÿØÿáOýExif', 20, 'gada', 2, 3, 1);
/*!40000 ALTER TABLE `tbl_product` ENABLE KEYS */;


-- Dumping structure for table emailmarketing.tbl_register
CREATE TABLE IF NOT EXISTS `tbl_register` (
  `registerId` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `companyName` varchar(45) NOT NULL,
  `loginid` int(11) NOT NULL,
  `addressid` int(11) NOT NULL,
  `contact_no` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`registerId`),
  KEY `fk_tbl_register_tbl_login1_idx` (`loginid`),
  KEY `fk_tbl_register_tbl_addrss1_idx` (`addressid`),
  CONSTRAINT `fk_tbl_register_tbl_addrss1` FOREIGN KEY (`addressid`) REFERENCES `tbl_addrss` (`addressid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_register_tbl_login1` FOREIGN KEY (`loginid`) REFERENCES `tbl_login` (`loginid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- Dumping data for table emailmarketing.tbl_register: ~26 rows (approximately)
/*!40000 ALTER TABLE `tbl_register` DISABLE KEYS */;
INSERT INTO `tbl_register` (`registerId`, `fname`, `lname`, `companyName`, `loginid`, `addressid`, `contact_no`) VALUES
	(1, 'wasim', 'desh', '', 1, 1, 1234569),
	(2, 'Nasim', 'desh', 'nacre', 2, 2, 2365897),
	(3, 'kaha', 'ho', 'vrae', 4, 2, 258796),
	(4, 'raja', 'rao', 'abc', 6, 4, 0),
	(5, 'raja', 'rao', 'abc', 7, 5, 0),
	(6, 'raja', 'rao', 'abc', 8, 6, 0),
	(7, 'raja', 'rao', 'abc', 9, 7, 0),
	(8, 'raja', 'rao', 'abc', 10, 8, 0),
	(9, 'raja', 'rao', 'abc', 11, 9, 0),
	(10, 'ra', 'rao', 'abc', 12, 10, 0),
	(11, 'ra', 'rao', 'abc', 13, 11, 0),
	(12, 'ra', 'rao', 'abc', 14, 12, 0),
	(13, 'ra', 'rao', 'abc', 15, 13, 0),
	(14, 'ra', 'rao', 'abc', 16, 14, 0),
	(15, 'ra', 'rao', 'abc', 17, 15, 0),
	(16, 'ra', 'rao', 'abc', 18, 16, 0),
	(17, 'rajkumar', 'kumar', 'aaaa', 19, 17, 0),
	(18, 'zzzzz', 'aaa', 'aaa', 20, 18, 0),
	(19, 'yyy', 'yyyy', 'asdfsdf', 21, 19, 0),
	(20, 'uuuu', 'uuuuu', 'aaa', 22, 20, 0),
	(21, 'iiiii', 'iiiiii', 'asdfsdf', 23, 21, 0),
	(22, 'oooooo', 'ooooo', 'aaa', 24, 22, 0),
	(23, 'pppp', 'pppp', 'pppp', 25, 23, 0),
	(24, 'mmmm', 'mmmmm', 'aaa', 26, 24, 0),
	(25, 'qqqqq', 'qqqqq', 'qqqqqq', 27, 25, 0),
	(26, 'wwwww', 'wwwww', 'wwwww', 28, 26, 0);
/*!40000 ALTER TABLE `tbl_register` ENABLE KEYS */;


-- Dumping structure for table emailmarketing.tbl_role
CREATE TABLE IF NOT EXISTS `tbl_role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `roletype` varchar(45) NOT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table emailmarketing.tbl_role: ~4 rows (approximately)
/*!40000 ALTER TABLE `tbl_role` DISABLE KEYS */;
INSERT INTO `tbl_role` (`roleid`, `roletype`) VALUES
	(1, 'Admin'),
	(2, 'ServiceOwner'),
	(3, 'ProductOwner'),
	(4, 'User');
/*!40000 ALTER TABLE `tbl_role` ENABLE KEYS */;


-- Dumping structure for table emailmarketing.tbl_service
CREATE TABLE IF NOT EXISTS `tbl_service` (
  `serviceid` int(11) NOT NULL AUTO_INCREMENT,
  `servicename` varchar(45) DEFAULT NULL,
  `tbl_register_registerId` int(11) NOT NULL,
  `servicedate` datetime DEFAULT NULL,
  `statusId` int(11) NOT NULL,
  PRIMARY KEY (`serviceid`),
  KEY `fk_tbl_service_tbl_register1_idx` (`tbl_register_registerId`),
  KEY `FK_tbl_service_tbl_status` (`statusId`),
  CONSTRAINT `FK_tbl_service_tbl_status` FOREIGN KEY (`statusId`) REFERENCES `tbl_status` (`statusId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_service_tbl_register1` FOREIGN KEY (`tbl_register_registerId`) REFERENCES `tbl_register` (`registerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table emailmarketing.tbl_service: ~4 rows (approximately)
/*!40000 ALTER TABLE `tbl_service` DISABLE KEYS */;
INSERT INTO `tbl_service` (`serviceid`, `servicename`, `tbl_register_registerId`, `servicedate`, `statusId`) VALUES
	(1, 'myservice', 3, '2017-03-26 01:05:52', 2),
	(2, 'yservice', 3, '2017-03-26 01:06:20', 2),
	(3, 'zservice', 3, '2017-03-31 11:21:26', 2),
	(4, 'yservice', 3, '2017-03-31 11:21:42', 2);
/*!40000 ALTER TABLE `tbl_service` ENABLE KEYS */;


-- Dumping structure for table emailmarketing.tbl_state
CREATE TABLE IF NOT EXISTS `tbl_state` (
  `stateid` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(45) NOT NULL,
  `country_countryId` int(11) NOT NULL,
  PRIMARY KEY (`stateid`),
  KEY `fk_tbl_state_country1_idx` (`country_countryId`),
  CONSTRAINT `fk_tbl_state_country1` FOREIGN KEY (`country_countryId`) REFERENCES `country` (`countryId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table emailmarketing.tbl_state: ~6 rows (approximately)
/*!40000 ALTER TABLE `tbl_state` DISABLE KEYS */;
INSERT INTO `tbl_state` (`stateid`, `state`, `country_countryId`) VALUES
	(1, 'Maharashtra', 1),
	(2, 'UP', 1),
	(3, 'bihar', 1),
	(4, 'oodisa', 1),
	(5, 'Islamabad', 2),
	(6, 'colambo', 3);
/*!40000 ALTER TABLE `tbl_state` ENABLE KEYS */;


-- Dumping structure for table emailmarketing.tbl_status
CREATE TABLE IF NOT EXISTS `tbl_status` (
  `statusId` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`statusId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table emailmarketing.tbl_status: ~2 rows (approximately)
/*!40000 ALTER TABLE `tbl_status` DISABLE KEYS */;
INSERT INTO `tbl_status` (`statusId`, `status`) VALUES
	(1, 'unread'),
	(2, 'read');
/*!40000 ALTER TABLE `tbl_status` ENABLE KEYS */;


-- Dumping structure for table emailmarketing.tbl_usermail
CREATE TABLE IF NOT EXISTS `tbl_usermail` (
  `usermailId` int(11) NOT NULL AUTO_INCREMENT,
  `tbl_login_loginid` int(11) NOT NULL,
  `tbl_maillist_mailid` int(11) NOT NULL,
  PRIMARY KEY (`usermailId`),
  KEY `fk_tbl_usermail_tbl_login1_idx` (`tbl_login_loginid`),
  KEY `fk_tbl_usermail_tbl_maillist1_idx` (`tbl_maillist_mailid`),
  CONSTRAINT `fk_tbl_usermail_tbl_login1` FOREIGN KEY (`tbl_login_loginid`) REFERENCES `tbl_login` (`loginid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_usermail_tbl_maillist1` FOREIGN KEY (`tbl_maillist_mailid`) REFERENCES `tbl_maillist` (`mailid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table emailmarketing.tbl_usermail: ~2 rows (approximately)
/*!40000 ALTER TABLE `tbl_usermail` DISABLE KEYS */;
INSERT INTO `tbl_usermail` (`usermailId`, `tbl_login_loginid`, `tbl_maillist_mailid`) VALUES
	(1, 1, 1),
	(2, 2, 2);
/*!40000 ALTER TABLE `tbl_usermail` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

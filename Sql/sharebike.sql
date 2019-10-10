/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : sharebike

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-10-10 19:46:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `appointment_record`
-- ----------------------------
DROP TABLE IF EXISTS `appointment_record`;
CREATE TABLE `appointment_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bikeId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `startTime` datetime NOT NULL,
  `endTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appointment_record
-- ----------------------------
INSERT INTO `appointment_record` VALUES ('2', '3', '6', '2019-05-22 01:59:33', '2019-05-22 02:02:17');
INSERT INTO `appointment_record` VALUES ('3', '3', '6', '2019-05-22 02:04:27', '2019-05-22 02:04:45');
INSERT INTO `appointment_record` VALUES ('4', '11', '6', '2019-05-24 03:36:05', '2019-05-26 16:06:32');
INSERT INTO `appointment_record` VALUES ('5', '9', '5', '2019-05-26 15:42:16', '2019-05-26 15:58:53');
INSERT INTO `appointment_record` VALUES ('6', '7', '5', '2019-05-26 16:02:33', '2019-05-26 16:05:27');
INSERT INTO `appointment_record` VALUES ('7', '3', '5', '2019-05-26 16:10:18', '2019-05-28 01:39:37');
INSERT INTO `appointment_record` VALUES ('8', '9', '5', '2019-05-28 01:44:52', '2019-05-28 01:46:33');
INSERT INTO `appointment_record` VALUES ('9', '15', '5', '2019-05-28 02:08:03', '2019-05-28 02:15:44');
INSERT INTO `appointment_record` VALUES ('10', '15', '5', '2019-05-28 02:35:03', '2019-05-28 02:35:45');
INSERT INTO `appointment_record` VALUES ('11', '15', '5', '2019-05-28 02:40:15', '2019-05-28 02:40:38');
INSERT INTO `appointment_record` VALUES ('12', '15', '5', '2019-05-28 06:31:36', '2019-05-28 06:33:10');
INSERT INTO `appointment_record` VALUES ('13', '16', '5', '2019-06-03 14:11:20', '2019-06-03 14:11:28');
INSERT INTO `appointment_record` VALUES ('14', '15', '5', '2019-06-03 14:14:33', '2019-06-03 14:14:50');
INSERT INTO `appointment_record` VALUES ('15', '15', '5', '2019-06-03 14:14:57', '2019-06-03 14:14:58');
INSERT INTO `appointment_record` VALUES ('16', '15', '5', '2019-06-03 14:15:33', '2019-06-03 14:15:36');
INSERT INTO `appointment_record` VALUES ('17', '15', '5', '2019-06-04 03:25:14', '2019-06-04 03:25:17');
INSERT INTO `appointment_record` VALUES ('18', '15', '5', '2019-06-04 03:30:34', '2019-06-04 03:30:52');
INSERT INTO `appointment_record` VALUES ('19', '15', '5', '2019-06-04 03:31:28', '2019-06-04 03:31:32');
INSERT INTO `appointment_record` VALUES ('20', '15', '5', '2019-06-04 06:27:35', '2019-06-04 06:27:41');
INSERT INTO `appointment_record` VALUES ('21', '15', '5', '2019-06-04 06:28:11', '2019-06-04 06:28:29');
INSERT INTO `appointment_record` VALUES ('22', '15', '5', '2019-06-04 12:13:36', '2019-06-04 12:14:07');
INSERT INTO `appointment_record` VALUES ('23', '15', '5', '2019-06-04 12:15:24', '2019-06-04 12:15:29');
INSERT INTO `appointment_record` VALUES ('24', '16', '5', '2019-06-05 06:22:32', '2019-06-05 06:22:51');
INSERT INTO `appointment_record` VALUES ('25', '16', '5', '2019-06-05 06:22:58', '2019-06-05 06:23:00');

-- ----------------------------
-- Table structure for `bike`
-- ----------------------------
DROP TABLE IF EXISTS `bike`;
CREATE TABLE `bike` (
  `bikeId` int(11) NOT NULL AUTO_INCREMENT,
  `state` int(3) NOT NULL,
  `startTime` datetime NOT NULL,
  `serviceTime` int(11) NOT NULL,
  `typeId` int(11) NOT NULL,
  PRIMARY KEY (`bikeId`),
  KEY `typeId` (`typeId`),
  CONSTRAINT `bike_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `bike_type` (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bike
-- ----------------------------
INSERT INTO `bike` VALUES ('3', '4', '2019-05-07 21:20:24', '0', '3');
INSERT INTO `bike` VALUES ('4', '4', '2019-05-08 21:20:37', '0', '4');
INSERT INTO `bike` VALUES ('5', '4', '2019-05-10 17:07:46', '0', '3');
INSERT INTO `bike` VALUES ('6', '4', '2019-05-12 17:08:14', '0', '3');
INSERT INTO `bike` VALUES ('7', '4', '2019-05-23 08:40:54', '0', '4');
INSERT INTO `bike` VALUES ('8', '4', '2019-05-23 08:41:39', '0', '4');
INSERT INTO `bike` VALUES ('9', '4', '2019-05-23 08:41:39', '0', '4');
INSERT INTO `bike` VALUES ('10', '4', '2019-05-23 08:41:39', '0', '4');
INSERT INTO `bike` VALUES ('11', '4', '2019-05-23 08:41:39', '0', '4');
INSERT INTO `bike` VALUES ('12', '4', '2019-05-23 08:45:40', '0', '3');
INSERT INTO `bike` VALUES ('13', '4', '2019-05-23 08:45:40', '0', '3');
INSERT INTO `bike` VALUES ('14', '4', '2019-05-23 08:45:40', '0', '3');
INSERT INTO `bike` VALUES ('15', '1', '2019-05-23 08:45:40', '0', '3');
INSERT INTO `bike` VALUES ('16', '4', '2019-05-23 08:45:40', '0', '3');
INSERT INTO `bike` VALUES ('17', '4', '2019-05-31 07:42:00', '0', '5');
INSERT INTO `bike` VALUES ('18', '4', '2019-05-31 07:42:00', '0', '5');
INSERT INTO `bike` VALUES ('19', '4', '2019-05-31 07:42:00', '0', '5');
INSERT INTO `bike` VALUES ('20', '4', '2019-05-31 07:42:00', '0', '5');
INSERT INTO `bike` VALUES ('21', '4', '2019-05-31 07:42:00', '0', '5');
INSERT INTO `bike` VALUES ('22', '4', '2019-05-31 07:42:01', '0', '5');
INSERT INTO `bike` VALUES ('23', '0', '2019-05-31 07:42:01', '0', '5');
INSERT INTO `bike` VALUES ('24', '4', '2019-05-31 07:42:01', '0', '5');
INSERT INTO `bike` VALUES ('25', '4', '2019-05-31 07:42:01', '0', '5');
INSERT INTO `bike` VALUES ('26', '4', '2019-05-31 07:42:01', '0', '5');
INSERT INTO `bike` VALUES ('27', '4', '2019-05-31 07:42:48', '0', '3');
INSERT INTO `bike` VALUES ('28', '4', '2019-05-31 07:42:48', '0', '3');
INSERT INTO `bike` VALUES ('29', '4', '2019-05-31 07:43:02', '0', '4');
INSERT INTO `bike` VALUES ('30', '4', '2019-05-31 07:43:02', '0', '4');
INSERT INTO `bike` VALUES ('31', '4', '2019-06-04 12:56:14', '0', '3');
INSERT INTO `bike` VALUES ('32', '4', '2019-06-04 12:56:14', '0', '3');
INSERT INTO `bike` VALUES ('33', '4', '2019-06-04 12:56:14', '0', '3');
INSERT INTO `bike` VALUES ('34', '4', '2019-06-04 12:56:14', '0', '3');
INSERT INTO `bike` VALUES ('35', '4', '2019-06-04 12:56:14', '0', '3');
INSERT INTO `bike` VALUES ('36', '4', '2019-06-04 12:56:15', '0', '3');
INSERT INTO `bike` VALUES ('37', '4', '2019-06-04 12:56:15', '0', '3');
INSERT INTO `bike` VALUES ('38', '4', '2019-06-04 12:56:15', '0', '3');
INSERT INTO `bike` VALUES ('39', '4', '2019-06-04 12:56:15', '0', '3');
INSERT INTO `bike` VALUES ('40', '4', '2019-06-04 12:56:15', '0', '3');
INSERT INTO `bike` VALUES ('41', '4', '2019-06-04 12:56:15', '0', '3');
INSERT INTO `bike` VALUES ('42', '4', '2019-06-04 12:56:15', '0', '3');
INSERT INTO `bike` VALUES ('43', '4', '2019-06-04 12:56:15', '0', '3');
INSERT INTO `bike` VALUES ('44', '4', '2019-06-04 12:56:15', '0', '3');
INSERT INTO `bike` VALUES ('45', '4', '2019-06-04 12:56:15', '0', '3');

-- ----------------------------
-- Table structure for `bike_type`
-- ----------------------------
DROP TABLE IF EXISTS `bike_type`;
CREATE TABLE `bike_type` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `supplier` varchar(255) NOT NULL,
  `kind` int(1) NOT NULL DEFAULT '0',
  `number` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bike_type
-- ----------------------------
INSERT INTO `bike_type` VALUES ('3', '江南皮革厂', '0', '30');
INSERT INTO `bike_type` VALUES ('4', '江南皮革厂', '1', '12');
INSERT INTO `bike_type` VALUES ('5', '天工大', '1', '10');
INSERT INTO `bike_type` VALUES ('6', '天工大', '0', '0');
INSERT INTO `bike_type` VALUES ('7', '捷安特', '0', '0');

-- ----------------------------
-- Table structure for `manager_record`
-- ----------------------------
DROP TABLE IF EXISTS `manager_record`;
CREATE TABLE `manager_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `bikeId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager_record
-- ----------------------------

-- ----------------------------
-- Table structure for `payment_record`
-- ----------------------------
DROP TABLE IF EXISTS `payment_record`;
CREATE TABLE `payment_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `money` int(255) NOT NULL,
  `payDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment_record
-- ----------------------------
INSERT INTO `payment_record` VALUES ('1', '7', '2', '2019-05-22 00:00:00');
INSERT INTO `payment_record` VALUES ('2', '7', '2', '2019-05-22 02:00:25');
INSERT INTO `payment_record` VALUES ('3', '6', '1', '2019-05-22 02:03:21');
INSERT INTO `payment_record` VALUES ('4', '7', '2', '2019-05-22 09:05:51');
INSERT INTO `payment_record` VALUES ('5', '7', '4', '2019-05-26 15:51:40');
INSERT INTO `payment_record` VALUES ('6', '5', '120', '2019-05-26 15:52:25');
INSERT INTO `payment_record` VALUES ('7', '5', '2', '2019-05-26 15:57:19');
INSERT INTO `payment_record` VALUES ('8', '6', '2', '2019-05-27 13:52:30');
INSERT INTO `payment_record` VALUES ('9', '6', '2', '2019-05-27 13:52:30');
INSERT INTO `payment_record` VALUES ('10', '5', '1', '2019-05-28 02:15:44');
INSERT INTO `payment_record` VALUES ('11', '5', '1', '2019-05-28 02:23:20');
INSERT INTO `payment_record` VALUES ('12', '5', '1', '2019-05-28 02:23:20');
INSERT INTO `payment_record` VALUES ('13', '5', '1', '2019-05-28 02:33:17');
INSERT INTO `payment_record` VALUES ('14', '5', '1', '2019-05-28 02:35:42');
INSERT INTO `payment_record` VALUES ('15', '5', '1', '2019-05-28 02:40:41');
INSERT INTO `payment_record` VALUES ('16', '5', '1', '2019-05-28 06:34:26');
INSERT INTO `payment_record` VALUES ('17', '6', '1', '2019-05-28 06:35:29');
INSERT INTO `payment_record` VALUES ('18', '12', '1', '2019-06-03 08:02:33');
INSERT INTO `payment_record` VALUES ('19', '5', '2', '2019-06-03 12:54:43');
INSERT INTO `payment_record` VALUES ('20', '5', '13', '2019-06-04 03:23:19');
INSERT INTO `payment_record` VALUES ('21', '5', '1', '2019-06-04 03:25:26');
INSERT INTO `payment_record` VALUES ('22', '5', '2', '2019-06-04 06:26:49');
INSERT INTO `payment_record` VALUES ('23', '5', '1', '2019-06-04 06:27:47');
INSERT INTO `payment_record` VALUES ('24', '5', '1', '2019-06-04 07:47:16');
INSERT INTO `payment_record` VALUES ('25', '5', '1', '2019-06-04 07:57:44');
INSERT INTO `payment_record` VALUES ('26', '5', '1', '2019-06-04 12:08:49');
INSERT INTO `payment_record` VALUES ('27', '5', '1', '2019-06-04 12:13:30');
INSERT INTO `payment_record` VALUES ('28', '5', '1', '2019-06-04 12:33:55');
INSERT INTO `payment_record` VALUES ('29', '5', '1', '2019-06-04 12:34:53');
INSERT INTO `payment_record` VALUES ('30', '5', '2', '2019-06-05 06:21:57');
INSERT INTO `payment_record` VALUES ('31', '5', '1', '2019-06-05 06:23:13');

-- ----------------------------
-- Table structure for `recharge_record`
-- ----------------------------
DROP TABLE IF EXISTS `recharge_record`;
CREATE TABLE `recharge_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `rechargeDate` datetime NOT NULL,
  `money` float(5,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recharge_record
-- ----------------------------
INSERT INTO `recharge_record` VALUES ('1', '6', '2019-05-22 07:00:28', '50');
INSERT INTO `recharge_record` VALUES ('2', '5', '2019-05-22 07:00:58', '15');
INSERT INTO `recharge_record` VALUES ('3', '6', '2019-05-22 07:49:09', '15');
INSERT INTO `recharge_record` VALUES ('4', '5', '2019-05-27 13:00:28', '10');
INSERT INTO `recharge_record` VALUES ('5', '5', '2019-05-27 13:03:50', '50');
INSERT INTO `recharge_record` VALUES ('6', '6', '2019-05-27 13:52:30', '10');
INSERT INTO `recharge_record` VALUES ('7', '12', '2019-06-03 08:02:03', '50');
INSERT INTO `recharge_record` VALUES ('8', '5', '2019-06-03 12:50:56', '10');
INSERT INTO `recharge_record` VALUES ('9', '5', '2019-06-03 12:50:59', '20');
INSERT INTO `recharge_record` VALUES ('10', '5', '2019-06-03 12:51:05', '19');
INSERT INTO `recharge_record` VALUES ('11', '5', '2019-06-04 12:19:20', '120');

-- ----------------------------
-- Table structure for `repair_record`
-- ----------------------------
DROP TABLE IF EXISTS `repair_record`;
CREATE TABLE `repair_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `bikeId` int(11) NOT NULL,
  `repairDate` datetime NOT NULL,
  `finshDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair_record
-- ----------------------------
INSERT INTO `repair_record` VALUES ('6', '9', '6', '2019-05-15 21:10:34', '2019-05-31 21:10:38');
INSERT INTO `repair_record` VALUES ('7', '9', '6', '2019-05-08 21:10:44', '2019-05-22 13:30:44');
INSERT INTO `repair_record` VALUES ('8', '9', '6', '2019-05-15 21:32:00', '2019-05-22 13:32:37');
INSERT INTO `repair_record` VALUES ('9', '9', '5', '2019-05-23 02:46:24', '2019-05-23 02:52:41');
INSERT INTO `repair_record` VALUES ('10', '9', '6', '2019-05-23 02:53:14', '2019-05-23 02:57:08');
INSERT INTO `repair_record` VALUES ('11', '9', '5', '2019-05-23 02:53:31', '2019-05-23 02:56:35');
INSERT INTO `repair_record` VALUES ('12', '10', '8', '2019-05-26 08:19:45', '2019-06-03 09:10:43');
INSERT INTO `repair_record` VALUES ('13', '9', '12', '2019-05-31 02:29:39', '2019-06-03 08:56:18');
INSERT INTO `repair_record` VALUES ('14', '9', '13', '2019-06-03 08:33:38', '2019-06-03 08:56:57');
INSERT INTO `repair_record` VALUES ('15', '9', '22', '2019-06-03 08:58:43', '2019-06-03 09:00:49');
INSERT INTO `repair_record` VALUES ('16', '9', '15', '2019-06-03 09:08:16', '2019-06-03 09:08:24');
INSERT INTO `repair_record` VALUES ('17', '9', '22', '2019-06-03 09:13:05', '2019-06-03 09:13:58');
INSERT INTO `repair_record` VALUES ('18', '9', '21', '2019-06-03 09:13:09', '2019-06-03 09:13:22');
INSERT INTO `repair_record` VALUES ('19', '9', '20', '2019-06-03 09:13:12', '2019-06-03 09:18:12');
INSERT INTO `repair_record` VALUES ('20', '10', '15', '2019-06-04 12:42:47', null);
INSERT INTO `repair_record` VALUES ('21', '10', '17', '2019-06-04 12:44:37', '2019-06-05 06:24:19');
INSERT INTO `repair_record` VALUES ('22', '10', '19', '2019-06-04 12:45:15', '2019-06-04 12:49:08');

-- ----------------------------
-- Table structure for `use_bike`
-- ----------------------------
DROP TABLE IF EXISTS `use_bike`;
CREATE TABLE `use_bike` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `bikeId` int(11) NOT NULL,
  `borrowDate` datetime NOT NULL,
  `backDate` datetime DEFAULT NULL,
  `money` float(5,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of use_bike
-- ----------------------------
INSERT INTO `use_bike` VALUES ('3', '7', '4', '2019-05-22 01:53:08', '2019-05-22 01:54:16', '2');
INSERT INTO `use_bike` VALUES ('4', '7', '4', '2019-05-22 01:55:53', '2019-05-22 02:00:25', '2');
INSERT INTO `use_bike` VALUES ('5', '6', '3', '2019-05-22 02:02:17', '2019-05-22 02:03:21', '1');
INSERT INTO `use_bike` VALUES ('6', '7', '4', '2019-05-22 08:42:38', '2019-05-22 09:05:51', '2');
INSERT INTO `use_bike` VALUES ('7', '5', '4', '2019-05-24 03:35:12', '2019-05-26 15:52:25', '120');
INSERT INTO `use_bike` VALUES ('8', '7', '6', '2019-05-26 11:04:06', '2019-05-26 15:51:40', '4');
INSERT INTO `use_bike` VALUES ('9', '5', '7', '2019-05-26 15:42:16', '2019-05-26 15:57:19', '2');
INSERT INTO `use_bike` VALUES ('10', '6', '9', '2019-05-27 13:52:30', '2019-05-27 13:52:30', '2');
INSERT INTO `use_bike` VALUES ('11', '6', '10', '2019-05-27 13:52:30', '2019-05-27 13:52:30', '2');
INSERT INTO `use_bike` VALUES ('16', '5', '15', '2019-05-28 02:32:57', '2019-05-28 02:33:16', '1');
INSERT INTO `use_bike` VALUES ('17', '5', '16', '2019-05-28 02:35:27', '2019-05-28 02:35:42', '1');
INSERT INTO `use_bike` VALUES ('18', '5', '16', '2019-05-28 02:40:34', '2019-05-28 02:40:41', '1');
INSERT INTO `use_bike` VALUES ('19', '6', '16', '2019-05-28 06:32:25', '2019-05-28 06:35:29', '1');
INSERT INTO `use_bike` VALUES ('20', '5', '15', '2019-05-28 06:33:11', '2019-05-28 06:34:26', '1');
INSERT INTO `use_bike` VALUES ('21', '12', '15', '2019-06-03 08:02:17', '2019-06-03 08:02:33', '1');
INSERT INTO `use_bike` VALUES ('22', '5', '20', '2019-06-03 12:41:36', '2019-06-03 12:54:43', '2');
INSERT INTO `use_bike` VALUES ('23', '5', '15', '2019-06-03 14:15:37', '2019-06-04 03:23:19', '13');
INSERT INTO `use_bike` VALUES ('24', '5', '15', '2019-06-04 03:25:17', '2019-06-04 03:25:26', '1');
INSERT INTO `use_bike` VALUES ('25', '5', '15', '2019-06-04 03:31:32', '2019-06-04 06:26:49', '2');
INSERT INTO `use_bike` VALUES ('26', '5', '15', '2019-06-04 06:27:41', '2019-06-04 06:27:47', '1');
INSERT INTO `use_bike` VALUES ('27', '5', '15', '2019-06-04 07:08:02', '2019-06-04 07:47:16', '1');
INSERT INTO `use_bike` VALUES ('28', '5', '15', '2019-06-04 07:56:36', '2019-06-04 07:57:44', '1');
INSERT INTO `use_bike` VALUES ('29', '5', '15', '2019-06-04 12:06:16', '2019-06-04 12:08:48', '1');
INSERT INTO `use_bike` VALUES ('30', '5', '15', '2019-06-04 12:10:50', '2019-06-04 12:13:30', '1');
INSERT INTO `use_bike` VALUES ('31', '5', '15', '2019-06-04 12:15:30', '2019-06-04 12:33:55', '1');
INSERT INTO `use_bike` VALUES ('32', '5', '15', '2019-06-04 12:34:21', '2019-06-04 12:34:52', '1');
INSERT INTO `use_bike` VALUES ('33', '5', '10', '2019-06-05 06:21:49', '2019-06-05 06:21:57', '2');
INSERT INTO `use_bike` VALUES ('34', '5', '16', '2019-06-05 06:23:00', '2019-06-05 06:23:13', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `phone` char(11) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '123456',
  `balance` float(11,0) DEFAULT '0',
  `state` int(2) DEFAULT '0',
  `grade` int(4) DEFAULT '0',
  `registerDate` datetime DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', 'test1', '15188888888', '123456', '292', '0', '0', '2019-05-20 08:28:32');
INSERT INTO `user` VALUES ('6', 'test2', '15288888888', '123456', '169', '0', '0', '2019-05-20 08:35:58');
INSERT INTO `user` VALUES ('7', 'test3', '15388888888', '123456', '40', '0', '0', '2019-05-20 12:25:09');
INSERT INTO `user` VALUES ('9', 'repMan1', '15488888888', '123456', '0', '0', '1', '2019-05-22 09:01:31');
INSERT INTO `user` VALUES ('10', 'repMan2', '15588888888', '123456', '0', '0', '1', '2019-05-24 07:03:20');
INSERT INTO `user` VALUES ('11', 'admin', '15832178529', '123456', '0', '0', '2', null);
INSERT INTO `user` VALUES ('12', 'test4', '15688888888', '123456', '49', '0', '0', '2019-06-03 08:01:34');

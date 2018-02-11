/*
Navicat MySQL Data Transfer

Source Server         : localhost-3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-02-12 00:18:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `o_id` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `price` double(11,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '111');
INSERT INTO `orders` VALUES ('4', '2', '444');
INSERT INTO `orders` VALUES ('3', '1', '333');
INSERT INTO `orders` VALUES ('2', '1', '222');
INSERT INTO `orders` VALUES ('5', '2', '555');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `p_id` int(11) DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'jack');
INSERT INTO `person` VALUES ('2', 'lucy');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '张三', 'zhangsan', 'nan', 'xiaosan');

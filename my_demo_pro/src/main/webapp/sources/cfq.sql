/*
Navicat MySQL Data Transfer

Source Server         : 本地库
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : cfq

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-11-17 16:06:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `pass_word` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `add_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_people` varchar(20) DEFAULT NULL,
  `add_people` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'cfq', '202cb962ac59075b964b07152d234b70', '2017-11-07 15:40:07', '2017-11-07 15:40:07', '褚夫强', '褚夫强');

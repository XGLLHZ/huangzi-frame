/*
 Navicat Premium Data Transfer

 Source Server         : centos
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 119.23.234.176:3306
 Source Schema         : huangzi-frame

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 26/08/2019 16:12:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户-角色：主键',
  `user_id` int(10) NULL DEFAULT NULL COMMENT '用户：主键',
  `role_id` int(10) NULL DEFAULT NULL COMMENT '角色：主键',
  `delete_flag` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '删除状态：0：未删除；1：已删除',
  `created_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1, 0, '2019-08-22 21:26:28', '2019-08-22 21:26:28');
INSERT INTO `sys_user_role` VALUES (2, 2, 2, 0, '2019-08-22 21:26:33', '2019-08-22 21:26:33');
INSERT INTO `sys_user_role` VALUES (3, 3, 3, 0, '2019-08-22 21:26:40', '2019-08-22 21:26:40');

SET FOREIGN_KEY_CHECKS = 1;

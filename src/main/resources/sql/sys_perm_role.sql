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

 Date: 26/08/2019 16:09:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_perm_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_perm_role`;
CREATE TABLE `sys_perm_role`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '权限-角色：主键',
  `perm_id` int(10) NULL DEFAULT NULL COMMENT '权限：主键',
  `role_id` int(10) NULL DEFAULT NULL COMMENT '角色：主键',
  `delete_flag` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '删除状态：0：未删除；1：已删除',
  `created_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_perm_role
-- ----------------------------
INSERT INTO `sys_perm_role` VALUES (2, 8, 1, 0, '2019-08-22 21:33:42', '2019-08-22 21:33:42');
INSERT INTO `sys_perm_role` VALUES (3, 9, 1, 0, '2019-08-22 21:33:44', '2019-08-22 21:33:44');
INSERT INTO `sys_perm_role` VALUES (4, 8, 2, 0, '2019-08-22 21:33:27', '2019-08-22 21:33:27');
INSERT INTO `sys_perm_role` VALUES (5, 9, 2, 0, '2019-08-22 21:33:50', '2019-08-22 21:33:50');
INSERT INTO `sys_perm_role` VALUES (6, 9, 3, 0, '2019-08-22 21:33:57', '2019-08-22 21:33:57');
INSERT INTO `sys_perm_role` VALUES (7, 10, 1, 0, '2019-08-23 14:29:21', '2019-08-23 14:29:21');

SET FOREIGN_KEY_CHECKS = 1;

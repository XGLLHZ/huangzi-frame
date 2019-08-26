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

 Date: 26/08/2019 16:12:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色主键',
  `role_namey` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '英文名',
  `role_namez` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '中文名',
  `delete_flag` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '删除状态：0：未删除；1：已删除',
  `created_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'SUPER_ADMIN', '超级管理员', 0, '2019-08-22 21:24:34', '2019-08-22 21:24:34');
INSERT INTO `sys_role` VALUES (2, 'ADMIN', '管理员', 0, '2019-08-22 21:24:50', '2019-08-22 21:24:50');
INSERT INTO `sys_role` VALUES (3, 'SYSTEM_USER', '用户', 0, '2019-08-22 21:25:13', '2019-08-22 21:25:13');

SET FOREIGN_KEY_CHECKS = 1;

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

 Date: 26/08/2019 16:12:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '权限表主键',
  `parent_id` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '父id：0：表示父菜单；1 2 3 ...：表示子菜单',
  `perm_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '权限名称',
  `perm_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '权限api',
  `delete_flag` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '删除状态：0：未删除；1：已删除',
  `created_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (8, 0, '资源管理', '/admin/permission/list', 0, '2019-08-22 21:23:15', '2019-08-22 21:23:15');
INSERT INTO `sys_permission` VALUES (9, 0, '角色管理', '/admin/role/list', 0, '2019-08-22 21:23:30', '2019-08-22 21:23:30');
INSERT INTO `sys_permission` VALUES (10, 0, '用户管理', '/admin/user/list', 0, '2019-08-23 14:29:07', '2019-08-23 14:29:07');

SET FOREIGN_KEY_CHECKS = 1;

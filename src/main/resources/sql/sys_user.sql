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

 Date: 26/08/2019 16:12:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '系统用户主键',
  `user_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '账号',
  `user_pass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `delete_flag` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '删除状态：0：未删除；1：已删除',
  `created_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'superadmin', '$2a$10$ESd7nlWZjDW2nUddI8A7M.I3MvE.UJxCiP5Dkc0SYbAF9FFzyySRm', 0, '2019-08-26 12:07:49', '2019-08-26 12:07:49');
INSERT INTO `sys_user` VALUES (2, 'admin', '$2a$10$dwYfJyG4uiOdQOFevMmnFeX7hg2Ts75HT/QJLozjGrFGVBvmzn5de', 0, '2019-08-26 12:09:48', '2019-08-26 12:09:48');
INSERT INTO `sys_user` VALUES (3, 'huangzi', '$2a$10$dwYfJyG4uiOdQOFevMmnFeX7hg2Ts75HT/QJLozjGrFGVBvmzn5de', 0, '2019-08-23 16:11:50', '2019-08-23 16:11:50');

SET FOREIGN_KEY_CHECKS = 1;

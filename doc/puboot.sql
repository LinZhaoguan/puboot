/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : puboot

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 17/09/2020 17:21:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pb_sys_authority
-- ----------------------------
DROP TABLE IF EXISTS `pb_sys_authority`;
CREATE TABLE `pb_sys_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auth_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限名称',
  `auth_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限编码',
  `auth_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限路径',
  `auth_type` int(11) NOT NULL DEFAULT '1' COMMENT '权限类型 1-菜单 2-按钮',
  `auth_icon` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限图标',
  `auth_order` int(11) NOT NULL DEFAULT '1' COMMENT '权限排序',
  `auth_description` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限描述',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` int(11) NOT NULL COMMENT '创建用户ID',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新用户ID',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '逻辑删除 0-未删除 1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='权限';

-- ----------------------------
-- Table structure for pb_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `pb_sys_role`;
CREATE TABLE `pb_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `role_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色编码',
  `auth_description` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色描述',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` int(11) NOT NULL COMMENT '创建用户ID',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新用户ID',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '逻辑删除 0-未删除 1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色';

-- ----------------------------
-- Table structure for pb_sys_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `pb_sys_role_authority`;
CREATE TABLE `pb_sys_role_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色ID',
  `auth_id` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` int(11) NOT NULL COMMENT '创建用户ID',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新用户ID',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '逻辑删除 0-未删除 1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色与权限关联关系';

-- ----------------------------
-- Table structure for pb_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `pb_sys_user`;
CREATE TABLE `pb_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `nick_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别 1-男 0-女',
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `id_number` varchar(18) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '身份证号',
  `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '住址',
  `enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效 0-无效 1-有效',
  `locked` tinyint(1) DEFAULT NULL COMMENT '是否被锁定 0-未锁定 1-已锁定',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建用户ID',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新用户ID',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '逻辑删除 0-未删除 1-已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `pb_user_username_uindex` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户';

-- ----------------------------
-- Table structure for pb_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `pb_sys_user_role`;
CREATE TABLE `pb_sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户ID',
  `role_id` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` int(11) NOT NULL COMMENT '创建用户ID',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新用户ID',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '逻辑删除 0-未删除 1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户与角色关联关系';

SET FOREIGN_KEY_CHECKS = 1;

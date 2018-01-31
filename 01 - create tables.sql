CREATE DATABASE IF NOT EXISTS `dms`;
USE `dms`;

-- security_user
DROP TABLE IF EXISTS `security_user`;
CREATE TABLE IF NOT EXISTS `security_user` (
  `id`             INTEGER     NOT NULL AUTO_INCREMENT KEY,
  `active`         VARCHAR(1)           DEFAULT '+',
  `user_id`        VARCHAR(20) NOT NULL,
  `user_name`      VARCHAR(50) NOT NULL,
  `password`       VARCHAR(50) NOT NULL,
  `enabled`        VARCHAR(1)           DEFAULT '+',
  `locked`         VARCHAR(1),
  `expired`        VARCHAR(1),
  `fail_times`     INT(11)              DEFAULT 0,
  `create_ts`      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user_id` INTEGER,
  `update_ts`      TIMESTAMP,
  `update_user_id` INTEGER,
  `remark`         VARCHAR(500)
);

-- security_role
DROP TABLE IF EXISTS `security_role`;
CREATE TABLE IF NOT EXISTS `security_role` (
  `id`      INTEGER     NOT NULL AUTO_INCREMENT KEY,
  `active`  VARCHAR(1)           DEFAULT '+',
  `intl_id` VARCHAR(30) NOT NULL,
  `name`    VARCHAR(50) NOT NULL,
  `remark`  VARCHAR(500)
);

-- security_user_role
DROP TABLE IF EXISTS `security_user_role`;
CREATE TABLE IF NOT EXISTS `security_user_role` (
  `active`           VARCHAR(1) DEFAULT '+',
  `security_user_id` INTEGER NOT NULL,
  `security_role_id` INTEGER NOT NULL,
  `remark`           VARCHAR(500)
);
ALTER TABLE security_user_role ADD PRIMARY KEY (security_user_id, security_role_id);

-- security_menu
DROP TABLE IF EXISTS `security_menu`;
CREATE TABLE IF NOT EXISTS `security_menu` (
  `id`         INTEGER      NOT NULL AUTO_INCREMENT KEY,
  `active`     VARCHAR(1)            DEFAULT '+',
  `intl_id`    VARCHAR(30)  NOT NULL,
  `name`       VARCHAR(50)  NOT NULL,
  `href`       VARCHAR(255) NOT NULL,
  `position_x` INT(11)      NOT NULL,
  `position_y` INT(11)      NOT NULL,
  `remark`     VARCHAR(500)
);

-- security_menu_role
DROP TABLE IF EXISTS `security_menu_role`;
CREATE TABLE IF NOT EXISTS `security_menu_role` (
  `active`           VARCHAR(1) DEFAULT '+',
  `security_menu_id` INTEGER NOT NULL,
  `security_role_id` INTEGER NOT NULL,
  `remark`           VARCHAR(500)
);
ALTER TABLE security_menu_role ADD PRIMARY KEY (security_menu_id, security_role_id);

-- system_property
DROP TABLE IF EXISTS `system_property`;
CREATE TABLE IF NOT EXISTS `system_property` (
  `active` VARCHAR(1) DEFAULT '+',
  `key`    VARCHAR(20) NOT NULL KEY,
  `value`  VARCHAR(200),
  `remark` VARCHAR(500)
);

-- code_user_type
DROP TABLE IF EXISTS `code_user_type`;
CREATE TABLE IF NOT EXISTS `code_user_type` (
  `id`      INTEGER     NOT NULL AUTO_INCREMENT KEY,
  `active`  VARCHAR(1)  DEFAULT '+',
  `intl_id` VARCHAR(30) NOT NULL,
  `name`    VARCHAR(50) NOT NULL,
  `remark`  VARCHAR(500)
);



-- app信息
CREATE TABLE IF NOT EXISTS `app_info`(
  `id` bigint(20) UNSIGNED NOT NULL  AUTO_INCREMENT,
  `appName` varchar(30) NOT NULL COMMENT 'app名称',
  `versionName` varchar(30) NOT NULL COMMENT '',
  `versionCode` varchar(30) NOT NULL COMMENT '',
  `packageName` varchar(30) NOT NULL COMMENT '',
  `usedPercentValue` varchar(30) NOT NULL COMMENT '',
  `deviceBrand` varchar(30) NOT NULL COMMENT '',
  `systemModel` varchar(30) NOT NULL COMMENT '',
  `systemLanguage` varchar(30) NOT NULL COMMENT '',
  `systemVersion` varchar(30) NOT NULL COMMENT '',
  `cpuType` varchar(30) NOT NULL COMMENT '',
  `devSpace` varchar(30) NOT NULL COMMENT '',
  `deviceId` varchar(30) NOT NULL COMMENT '',
  `netSpeed` varchar(30) NOT NULL COMMENT '',
  `createAt` varchar(60) DEFAULT NULL COMMENT '创建时间',
  `updateAt` varchar(60) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
)ENGINE =InnoDB DEFAULT charset =utf8 COMMENT='app信息'



-- 用户信息
CREATE TABLE IF NOT EXISTS  `user`(
    `id` bigint(20) UNSIGNED NOT NULL  AUTO_INCREMENT,
    `userName` varchar (20) NOT NULL COMMENT '用户名',
    `passWord` varchar (20) NOT NULL COMMENT '密码',
    `isBlack` int NOT NULL DEFAULT 0 COMMENT '是否黑名单',
    PRIMARY KEY (`id`)
)ENGINE =InnoDB DEFAULT charset =utf8 COMMENT='用户信息'


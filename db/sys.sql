-- 创建序列表
DROP TABLE IF EXISTS `sys_sequence`;
CREATE TABLE `sys_sequence` (
    `name` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_bin',
    `current_value` VARCHAR(10) NULL DEFAULT '100' COLLATE 'utf8mb4_bin',
    PRIMARY KEY (`name`)
)
COMMENT='序列表'
COLLATE='utf8mb4_bin'
ENGINE=InnoDB;


-- 获取当前序列
DROP FUNCTION IF EXISTS currval; 
DELIMITER $ 
CREATE FUNCTION currval (seq_name VARCHAR(50)) 
     RETURNS VARCHAR(10)
     LANGUAGE SQL 
     DETERMINISTIC 
     CONTAINS SQL 
     SQL SECURITY DEFINER 
     COMMENT ''
BEGIN
     DECLARE value VARCHAR(10); 
     SET VALUE = NULL; 
     SELECT current_value INTO value 
          FROM sys_sequence
          WHERE name = seq_name; 
     RETURN value; 
END
$ 
DELIMITER ; 


-- 获取下一序列
DROP FUNCTION IF EXISTS nextval; 
DELIMITER $ 
CREATE FUNCTION nextval (seq_name VARCHAR(50)) 
     RETURNS VARCHAR(10)
     LANGUAGE SQL 
     DETERMINISTIC 
     CONTAINS SQL 
     SQL SECURITY DEFINER 
     COMMENT ''
BEGIN
     UPDATE sys_sequence
          SET current_value = current_value + '1' 
          WHERE name = seq_name; 
     RETURN currval(seq_name); 
END
$ 
DELIMITER ;


-- 创建User表
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
    `id` VARCHAR(10) NOT NULL COMMENT '主键' COLLATE 'utf8mb4_bin',
    `name` VARCHAR(50) NULL DEFAULT NULL COMMENT '姓名' COLLATE 'utf8mb4_bin',
    `login_name` VARCHAR(50) NULL DEFAULT NULL COMMENT '登录名' COLLATE 'utf8mb4_bin',
    `password` VARCHAR(50) NULL DEFAULT NULL COMMENT '密码' COLLATE 'utf8mb4_bin',
    `gender` VARCHAR(10) NULL DEFAULT NULL COMMENT '性别' COLLATE 'utf8mb4_bin',
    `nation` VARCHAR(10) NULL DEFAULT NULL COMMENT '民族' COLLATE 'utf8mb4_bin',
    `birthdate` DATETIME NULL DEFAULT NULL COMMENT '出生日期',
    `address` VARCHAR(50) NULL DEFAULT NULL COMMENT '居住地址' COLLATE 'utf8mb4_bin',
    `email` VARCHAR(50) NULL DEFAULT NULL COMMENT '电子邮箱' COLLATE 'utf8mb4_bin',
    `mobile` VARCHAR(20) NULL DEFAULT NULL COMMENT '手机号码' COLLATE 'utf8mb4_bin',
    `per_sign` VARCHAR(200) NULL DEFAULT NULL COMMENT '个人签名' COLLATE 'utf8mb4_bin',
    `create_by` VARCHAR(10) NOT NULL COMMENT '创建者' COLLATE 'utf8mb4_bin',
    `create_date` TIMESTAMP NOT NULL COMMENT '创建日期',
    `update_by` VARCHAR(10) NOT NULL COMMENT '更新者' COLLATE 'utf8mb4_bin',
    `update_date` TIMESTAMP NOT NULL COMMENT '更新日期',
    `del_flag` VARCHAR(5) NOT NULL COMMENT '删除标记' COLLATE 'utf8mb4_bin'
)
COLLATE='utf8mb4_bin'
ENGINE=InnoDB;
-- 添加主键
ALTER TABLE `sys_user` ADD PRIMARY KEY (`id`, `login_name`);


-- 系统管理员
INSERT INTO `wss`.`sys_user` (`id`, `name`, `login_name`, `password`, `gender`, `nation`, `birthdate`, `address`, `email`, `mobile`, `per_sign`, `create_by`, `create_date`, `update_by`, `update_date`, `del_flag`) VALUES ('1', '系统管理员', 'admin', 'admin', '男', '汉族', '2020-05-10 00:00:00', '北京西城区', '2199887379@qq.com', '13263105091', '无', '1', '2020-05-14 08:45:35', '1', '2020-05-14 08:45:41', '0');



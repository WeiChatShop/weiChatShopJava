使用Intellij编写代码

数据库

CREATE TABLE `book_cart` (  
`id` INT(13) NOT NULL AUTO_INCREMENT,  
`uid` VARCHAR(50) NULL DEFAULT NULL COMMENT '用户唯一标识',  
`addr_id` INT(13) NULL DEFAULT NULL COMMENT '用户收货地址',  
`book_id` INT(13) NOT NULL COMMENT '购买的书籍id',  
`num` INT(13) NOT NULL COMMENT '购书数量',  
`payment` DOUBLE NOT NULL DEFAULT '0' COMMENT '用户付款',  
`send_status` SMALLINT(1) NOT NULL DEFAULT '0' COMMENT '发货状态0未发货,1已发货',  
`should_pay` DOUBLE NULL DEFAULT NULL COMMENT '应支付',  
`addip` VARCHAR(50) NULL DEFAULT NULL COMMENT 'ip地址',  
`addtime` DATETIME NULL DEFAULT NULL COMMENT '添加购物车时间',  
`payip` VARCHAR(50) NULL DEFAULT NULL COMMENT '支付ip',   
`paytime` DATETIME NULL DEFAULT NULL COMMENT '支付时间',  
PRIMARY KEY (`id`),  
INDEX `uid` (`uid`),  
INDEX `book_id` (`book_id`),  
INDEX `addr_id` (`addr_id`),  
INDEX `send_status` (`send_status`)  
)  
COMMENT='购书车'  
COLLATE='utf8_general_ci'  
ENGINE=MyISAM  
;  
  
 CREATE TABLE `book_class` (  
`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',  
`name` VARCHAR(100) NULL DEFAULT NULL COMMENT '种类名称',  
`describe` TEXT NULL COMMENT '种类说明',  
PRIMARY KEY (`id`),  
UNIQUE INDEX `class` (`name`)  
)  
COMMENT='书的种类名称'  
COLLATE='utf8_general_ci'  
ENGINE=MyISAM  
ROW_FORMAT=English (Great Britain) [!For All Users]  
;  
  
CREATE TABLE `book_info` (  
`id` INT(13) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',  
`name` VARCHAR(100) NOT NULL DEFAULT '0' COMMENT '书名',  
`describe` VARCHAR(500) NOT NULL COMMENT '简介描述',  
`list` TEXT NULL COMMENT '目录',  
`path` VARCHAR(300) NULL DEFAULT '0' COMMENT '图片路径',  
`stock` INT(5) UNSIGNED NULL DEFAULT '0' COMMENT '图书库存数量',  
`sell` INT(5) UNSIGNED NULL DEFAULT '0' COMMENT '图书售出数量',  
`hot` TINYINT(1) UNSIGNED NULL DEFAULT '0' COMMENT '热卖(推荐)0不推荐,1推荐,2过往推荐',  
`classify_id` SMALLINT(3) UNSIGNED NULL DEFAULT '0' COMMENT '分类',  
`status` TINYINT(1) UNSIGNED NULL DEFAULT '1' COMMENT '书的状况0下架,1上架',  
`price` DOUBLE UNSIGNED NULL DEFAULT '0' COMMENT '书的价格',  
`freight` DOUBLE UNSIGNED NULL DEFAULT '0' COMMENT '运费',  
PRIMARY KEY (`id`),  
INDEX `status` (`status`),  
INDEX `classify_id` (`classify_id`)  
)
COMMENT='书的信息表:包括书名,书的分类,书的描述,书的目录,书的照片位置,书的状态,是否为本周推荐的,书的库存      ,书的被购买量'  
COLLATE='utf8_general_ci'  
ENGINE=MyISAM  
;  
  
CREATE TABLE `user_info` (  
`id` INT(13) NOT NULL AUTO_INCREMENT COMMENT 'id',  
`uid` VARCHAR(100) NOT NULL COMMENT '用户唯一标识',  
`name` VARCHAR(100) NOT NULL COMMENT '用户名',  
`phone` VARCHAR(50) NOT NULL COMMENT '手机号码',  
`province` VARCHAR(50) NOT NULL COMMENT '省份',  
`city` VARCHAR(50) NOT NULL COMMENT '市区',  
`detail_addr` VARCHAR(50) NOT NULL COMMENT '详细地址',  
`postalcode` INT(8) NOT NULL COMMENT '邮编',  
`require` VARCHAR(300)  NULL DEFAULT NULL COMMENT '用户特殊要求',  
PRIMARY KEY (`id`),  
INDEX `uid` (`uid`)  
)  
COMMENT='收货人信息,一个uid可以有多个收货地址'  
COLLATE='utf8_general_ci'  
ENGINE=MyISAM  
ROW_FORMAT=English (Great Britain) [!For All Users]  
;  
CREATE TABLE `account_log` (  
`id` INT(13) NOT NULL AUTO_INCREMENT,  
`uid` VARCHAR(50) NULL DEFAULT NULL COMMENT '用户唯一标识',  
`pay` INT(13) NULL DEFAULT NULL COMMENT '用户付款',  
`cart_id` INT(13) NULL DEFAULT NULL COMMENT '用户为某一次购物付款',  
`paytime` DATETIME NULL DEFAULT NULL COMMENT '支付时间',  
`payip` VARCHAR(50) NULL DEFAULT NULL COMMENT '支付ip',  
PRIMARY KEY (`id`),  
UNIQUE INDEX `cart_id` (`cart_id`),  
INDEX `uid` (`uid`)  
)  
COMMENT='用户支付日志表,用于对账'  
COLLATE='utf8_general_ci'  
ENGINE=MyISAM  
;  
=======
  
数据库  
  
    CREATE TABLE `book_cart` (  
	`id` INT(13) NOT NULL AUTO_INCREMENT,  
	`uid` VARCHAR(50) NULL DEFAULT NULL COMMENT '用户唯一标识',  
	`addr_id` INT(13) NULL DEFAULT NULL COMMENT '用户收货地址',  
	`book_id` INT(13) NOT NULL COMMENT '购买的书籍id',  
	`num` INT(13) NOT NULL COMMENT '购书数量',  
	`payment` DOUBLE NOT NULL DEFAULT '0' COMMENT '用户付款',  
	`send_status` SMALLINT(1) NOT NULL DEFAULT '0' COMMENT '发货状态0未发货,1已发货',  
	`should_pay` DOUBLE NULL DEFAULT NULL COMMENT '应支付',  
	`addip` VARCHAR(50) NULL DEFAULT NULL COMMENT 'ip地址',  
	`addtime` DATETIME NULL DEFAULT NULL COMMENT '添加购物车时间',  
	`payip` VARCHAR(50) NULL DEFAULT NULL COMMENT '支付ip',  
	`paytime` DATETIME NULL DEFAULT NULL COMMENT '支付时间',  
	PRIMARY KEY (`id`),  
	INDEX `uid` (`uid`),  
	INDEX `book_id` (`book_id`),  
	INDEX `addr_id` (`addr_id`),  
	INDEX `send_status` (`send_status`)  
	)  
	COMMENT='购书车'  
	COLLATE='utf8_general_ci'  
	ENGINE=MyISAM  
	;  

      CREATE TABLE `book_class` (  
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',  
	`name` VARCHAR(100) NULL DEFAULT NULL COMMENT '种类名称',  
	`describe` TEXT NULL COMMENT '种类说明',  
	PRIMARY KEY (`id`),  
	UNIQUE INDEX `class` (`name`)  
	)  
	COMMENT='书的种类名称'   
	COLLATE='utf8_general_ci'  
	ENGINE=MyISAM  
	ROW_FORMAT=English (Great Britain) [!For All Users]  
	;  

    CREATE TABLE `book_info` (  
	`id` INT(13) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',  
	`name` VARCHAR(100) NOT NULL DEFAULT '0' COMMENT '书名',  
	`describe` VARCHAR(500) NOT NULL COMMENT '简介描述',
	`list` TEXT NULL COMMENT '目录',
	`path` VARCHAR(300) NULL DEFAULT '0' COMMENT '图片路径',
	`stock` INT(5) UNSIGNED NULL DEFAULT '0' COMMENT '图书库存数量',
	`sell` INT(5) UNSIGNED NULL DEFAULT '0' COMMENT '图书售出数量',
	`hot` TINYINT(1) UNSIGNED NULL DEFAULT '0' COMMENT '热卖(推荐)0不推荐,1推荐,2过往推荐',
	`classify_id` SMALLINT(3) UNSIGNED NULL DEFAULT '0' COMMENT '分类',
	`status` TINYINT(1) UNSIGNED NULL DEFAULT '1' COMMENT '书的状况0下架,1上架',
	`price` DOUBLE UNSIGNED NULL DEFAULT '0' COMMENT '书的价格',
	`freight` DOUBLE UNSIGNED NULL DEFAULT '0' COMMENT '运费',
	PRIMARY KEY (`id`),
	INDEX `status` (`status`),
	INDEX `classify_id` (`classify_id`)
	)
	COMMENT='书的信息表:包括书名,书的分类,书的描述,书的目录,书的照片位置,书的状态,是否为本周推荐的,书的库存 		,书的被购买量'
	COLLATE='utf8_general_ci'
	ENGINE=MyISAM
	;

	CREATE TABLE `user_info` (
	`id` INT(13) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`uid` VARCHAR(100) NOT NULL COMMENT '用户唯一标识',
	`name` VARCHAR(100) NOT NULL COMMENT '用户名',
	`phone` VARCHAR(50) NOT NULL COMMENT '手机号码',
	`province` VARCHAR(50) NOT NULL COMMENT '省份',
	`city` VARCHAR(50) NOT NULL COMMENT '市区',
	`detail_addr` VARCHAR(50) NOT NULL COMMENT '详细地址',
	`postalcode` INT(8) NOT NULL COMMENT '邮编',
	`require` VARCHAR(300)  NULL DEFAULT NULL COMMENT '用户特殊要求',
	PRIMARY KEY (`id`),
	INDEX `uid` (`uid`)
	)
	COMMENT='收货人信息,一个uid可以有多个收货地址'
	COLLATE='utf8_general_ci'
	ENGINE=MyISAM
	ROW_FORMAT=English (Great Britain) [!For All Users]
	;
	CREATE TABLE `account_log` (
	`id` INT(13) NOT NULL AUTO_INCREMENT,
	`uid` VARCHAR(50) NULL DEFAULT NULL COMMENT '用户唯一标识',
	`pay` INT(13) NULL DEFAULT NULL COMMENT '用户付款',
	`cart_id` INT(13) NULL DEFAULT NULL COMMENT '用户为某一次购物付款',
	`paytime` DATETIME NULL DEFAULT NULL COMMENT '支付时间',
	`payip` VARCHAR(50) NULL DEFAULT NULL COMMENT '支付ip',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `cart_id` (`cart_id`),
	INDEX `uid` (`uid`)
	)
	COMMENT='用户支付日志表,用于对账'
	COLLATE='utf8_general_ci'
	ENGINE=MyISAM
	;  

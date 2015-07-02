ʹ��Intellij��д����

���ݿ�
CREATE TABLE `account_log` (
	`id` INT(13) NOT NULL AUTO_INCREMENT,
	`uid` VARCHAR(50) NULL DEFAULT NULL COMMENT '�û�Ψһ��ʶ',
	`pay` INT(13) NULL DEFAULT NULL COMMENT '�û�����',
	`cart_id` INT(13) NULL DEFAULT NULL COMMENT '�û�Ϊĳһ�ι��︶��',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `cart_id` (`cart_id`),
	INDEX `uid` (`uid`)
)
COMMENT='�û�֧����־��,���ڶ���'
COLLATE='utf8_general_ci'
ENGINE=MyISAM
ROW_FORMAT=English (Great Britain) [!For All Users]
;

CREATE TABLE `book_class` (
	`id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`name` VARCHAR(100) NULL DEFAULT NULL COMMENT '��������',
	`describe` TEXT NULL COMMENT '����˵��',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `class` (`name`)
)
COMMENT='�����������'
COLLATE='utf8_general_ci'
ENGINE=MyISAM
ROW_FORMAT=English (Great Britain) [!For All Users]
;

CREATE TABLE `book_info` (
	`id` INT(13) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
	`name` VARCHAR(100) NOT NULL DEFAULT '0' COMMENT '����',
	`describe` TEXT NOT NULL COMMENT '�������',
	`list` TEXT NULL COMMENT 'Ŀ¼',
	`path` VARCHAR(300) NULL DEFAULT '0' COMMENT 'ͼƬ·��',
	`stock` INT(5) UNSIGNED NULL DEFAULT '0' COMMENT 'ͼ��������',
	`sell` INT(5) UNSIGNED NULL DEFAULT '0' COMMENT 'ͼ���۳�����',
	`hot` TINYINT(1) UNSIGNED NULL DEFAULT '0' COMMENT '����(�Ƽ�)0���Ƽ�,1�Ƽ�,2�����Ƽ�',
	`classify_id` SMALLINT(3) UNSIGNED NULL DEFAULT '0' COMMENT '����',
	`status` TINYINT(1) UNSIGNED NULL DEFAULT '0' COMMENT '���״��0�¼�,1�ϼ�',
	`price` SMALLINT(3) UNSIGNED NULL DEFAULT '0' COMMENT '��ļ۸�',
	`freight` SMALLINT(2) UNSIGNED NULL DEFAULT '0' COMMENT '�˷�',
	PRIMARY KEY (`id`),
	INDEX `status` (`status`),
	INDEX `classify_id` (`classify_id`)
)
COMMENT='�����Ϣ��:��������,��ķ���,�������,���Ŀ¼,�����Ƭλ��,���״̬,�Ƿ�Ϊ�����Ƽ���,��Ŀ�� ,��ı�������'
COLLATE='utf8_general_ci'
ENGINE=MyISAM
ROW_FORMAT=English (Great Britain) [!For All Users]
;
CREATE TABLE `user_info` (
	`id` INT(13) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`uid` VARCHAR(100) NOT NULL COMMENT '�û�Ψһ��ʶ',
	`name` VARCHAR(100) NOT NULL COMMENT '�û���',
	`phone` VARCHAR(50) NOT NULL COMMENT '�ֻ�����',
	`province` VARCHAR(50) NOT NULL COMMENT 'ʡ��',
	`city` VARCHAR(50) NOT NULL COMMENT '����',
	`detail_addr` VARCHAR(50) NOT NULL COMMENT '��ϸ��ַ',
	`postalcode` INT(8) NOT NULL COMMENT '�ʱ�',
	`require` VARCHAR(300) NOT NULL COMMENT '�û�����Ҫ��',
	PRIMARY KEY (`id`),
	INDEX `uid` (`uid`)
)
COMMENT='�ջ�����Ϣ,һ��uid�����ж���ջ���ַ'
COLLATE='utf8_general_ci'
ENGINE=MyISAM
ROW_FORMAT=English (Great Britain) [!For All Users]
;
CREATE TABLE `account_log` (
	`id` INT(13) NOT NULL AUTO_INCREMENT,
	`uid` VARCHAR(50) NULL DEFAULT NULL COMMENT '�û�Ψһ��ʶ',
	`pay` INT(13) NULL DEFAULT NULL COMMENT '�û�����',
	`cart_id` INT(13) NULL DEFAULT NULL COMMENT '�û�Ϊĳһ�ι��︶��',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `cart_id` (`cart_id`),
	INDEX `uid` (`uid`)
)
COMMENT='�û�֧����־��,���ڶ���'
COLLATE='utf8_general_ci'
ENGINE=MyISAM
ROW_FORMAT=English (Great Britain) [!For All Users]
;

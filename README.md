ʹ��Intellij��д����

���ݿ�
CREATE TABLE `book_cart` (
	`id` INT(13) NOT NULL AUTO_INCREMENT,
	`uid` VARCHAR(50) NULL DEFAULT NULL COMMENT '�û�Ψһ��ʶ',
	`addr_id` INT(13) NULL DEFAULT NULL COMMENT '�û��ջ���ַ',
	`book_id` INT(13) NOT NULL COMMENT '������鼮id',
	`num` INT(13) NOT NULL COMMENT '��������',
	`payment` DOUBLE NOT NULL DEFAULT '0' COMMENT '�û�����',
	`send_status` SMALLINT(1) NOT NULL DEFAULT '0' COMMENT '����״̬0δ����,1�ѷ���',
	`should_pay` DOUBLE NULL DEFAULT NULL COMMENT 'Ӧ֧��',
	`addip` VARCHAR(50) NULL DEFAULT NULL COMMENT 'ip��ַ',
	`addtime` DATETIME NULL DEFAULT NULL COMMENT '��ӹ��ﳵʱ��',
	`payip` VARCHAR(50) NULL DEFAULT NULL COMMENT '֧��ip',
	`paytime` DATETIME NULL DEFAULT NULL COMMENT '֧��ʱ��',
	PRIMARY KEY (`id`),
	INDEX `uid` (`uid`),
	INDEX `book_id` (`book_id`),
	INDEX `addr_id` (`addr_id`),
	INDEX `send_status` (`send_status`)
)
COMMENT='���鳵'
COLLATE='utf8_general_ci'
ENGINE=MyISAM
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
	`describe` VARCHAR(500) NOT NULL COMMENT '�������',
	`list` TEXT NULL COMMENT 'Ŀ¼',
	`path` VARCHAR(300) NULL DEFAULT '0' COMMENT 'ͼƬ·��',
	`stock` INT(5) UNSIGNED NULL DEFAULT '0' COMMENT 'ͼ��������',
	`sell` INT(5) UNSIGNED NULL DEFAULT '0' COMMENT 'ͼ���۳�����',
	`hot` TINYINT(1) UNSIGNED NULL DEFAULT '0' COMMENT '����(�Ƽ�)0���Ƽ�,1�Ƽ�,2�����Ƽ�',
	`classify_id` SMALLINT(3) UNSIGNED NULL DEFAULT '0' COMMENT '����',
	`status` TINYINT(1) UNSIGNED NULL DEFAULT '1' COMMENT '���״��0�¼�,1�ϼ�',
	`price` DOUBLE UNSIGNED NULL DEFAULT '0' COMMENT '��ļ۸�',
	`freight` DOUBLE UNSIGNED NULL DEFAULT '0' COMMENT '�˷�',
	PRIMARY KEY (`id`),
	INDEX `status` (`status`),
	INDEX `classify_id` (`classify_id`)
)
COMMENT='�����Ϣ��:��������,��ķ���,�������,���Ŀ¼,�����Ƭλ��,���״̬,�Ƿ�Ϊ�����Ƽ���,��Ŀ�� ,��ı�������'
COLLATE='utf8_general_ci'
ENGINE=MyISAM
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
	`require` VARCHAR(300)  NULL DEFAULT NULL COMMENT '�û�����Ҫ��',
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
	`paytime` DATETIME NULL DEFAULT NULL COMMENT '֧��ʱ��',
	`payip` VARCHAR(50) NULL DEFAULT NULL COMMENT '֧��ip',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `cart_id` (`cart_id`),
	INDEX `uid` (`uid`)
)
COMMENT='�û�֧����־��,���ڶ���'
COLLATE='utf8_general_ci'
ENGINE=MyISAM
;

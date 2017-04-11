create database `orderdata`;

use `orderdata`;


create table `users`(
		`account` varchar(12) not null primary key comment '帐号 ，表示手机号，必须独一无二',
		`username` varchar(32) not null comment '用户昵称',  
		`password` varchar(18) not null comment '用户密码',
		`status` int not null default 0 comment '0表示没有审核通过，其他表示通过',
		`picture` longblob  comment '省份证照片路径',
		`signintime`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
		`id` varchar(32) not null comment '身份证号'
		)ENGINE=InnoDB DEFAULT CHARSET=utf8;
		
create table `book`(
		`id` int(11) not null primary key AUTO_INCREMENT,
		`downtime`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '放号的时间',
		`usetime`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '使用的时间',
		`useraccount` varchar(12) not null default '' COMMENT '抢到用户的帐号',
		`used` int not null default 0 COMMENT '0表示没有使用，其他表示已经使用或者过期'
		)ENGINE=InnoDB DEFAULT CHARSET=utf8;
		
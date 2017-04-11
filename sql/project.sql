create database `orderdata`;

use `orderdata`;

# authority是普通用户表示的0，一是管理员
create table `users`(
		`id` int not null primary key auto_increment,
		`username` varchar(32) not null,  
		`password` varchar(18) not null,
		`phone` varchar(120) not null,
		`authority` int default 0  
		);
		
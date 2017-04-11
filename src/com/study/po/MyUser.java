package com.study.po;

import java.util.Arrays;
import java.util.Date;

/**
 * `account` varchar(12) not null primary key comment '帐号 ，表示手机号，必须独一无二',
		`username` varchar(32) not null comment '用户昵称',  
		`password` varchar(18) not null comment '用户密码',
		`status` int not null default 0 comment '0表示没有审核通过，其他表示通过',
		`picture` longblob  comment '省份证照片路径',
		`signintime`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
		`id` varchar(32) not null comment '身份证号'
 * @author Administrator
 *
 */
public class MyUser {

	private String id;
	private String username;
	private String password;
	private String account;
	private Date signintime;
	private byte[] picture;
	private int status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Date getSignintime() {
		return signintime;
	}
	public void setSignintime(Date signintime) {
		this.signintime = signintime;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "MyUser [id=" + id + ", username=" + username + ", password=" + password + ", account=" + account
				+ ", signintime=" + signintime + ", picture=" + Arrays.toString(picture) + ", status=" + status + "]";
	}
	
	
	
	
	
}

package com.study.po;

public class MyUser {

	private int id;
	private String username;
	private String password;
	private String phone;
	
	//表示用户权限 0 普通用户，1是管理员
	private int authority;

	@Override
	public String toString() {
		return "MyUser [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", authority=" + authority + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
	
}

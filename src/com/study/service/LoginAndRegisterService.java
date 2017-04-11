package com.study.service;

import com.study.po.User;

public interface LoginAndRegisterService {
	
	public boolean onLogin(String username,String password);
	
	public void register(User user);

}

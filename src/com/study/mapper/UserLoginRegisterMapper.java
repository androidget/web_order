package com.study.mapper;

import com.study.po.MyUser;

public interface UserLoginRegisterMapper {

	/**
	 * 通过用户名获取用户信息  用户登录时查询
	 * @param username
	 * @return
	 */
	public MyUser getUserByUsername(String accout) throws Exception;
	
	/**
	 * 注册用户将用户保存到数据库中  使用于注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public long saveUser(MyUser user) throws Exception;
	
	public void deleteUser(String accout) throws Exception;
	
	public void editUser(MyUser user,String accout) throws Exception;
	
}

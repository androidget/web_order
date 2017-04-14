package com.study.mapper;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.po.MyUser;

public class UserLoginRegisterMapperTest {

	// 这个是自动注入 使用注解
	@Autowired
	private UserLoginRegisterMapper userLoginRegisterMapper;
	

	@Before
	public void setUp() throws Exception {
      ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring/applicationContext.xml"  
        ,"classpath:mybatis/mybatis-sqlMapConfig.xml"});
	}

	@Test
	public void Inserttest() throws Exception {
		MyUser user = new MyUser();
		user.setId("4303211991245555");
		user.setAccount("yangxianglong");
		user.setPassword("helloworld");
		user.setSignintime(new Date());
		userLoginRegisterMapper.saveUser(user);
	}

}

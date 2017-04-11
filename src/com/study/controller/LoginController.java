package com.study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password){
		//各种逻辑操作，判断是否存在用户，密码是否正确。。。。
		session.setAttribute("username", username);
		//登录成功重定向
		return "redirect:/items/queryItems";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/items/queryItems";
	}

}

package com.study.exceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercepter  implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取对应的url
		String url = request.getRequestURI();
		//判断是否是公开的地址（实际需要放到配置文件当中）
		if(url.contains("login")){
			return true;
		}
		
		//不是登录则需要判断是否需要进行身份认证
		
		HttpSession session = request.getSession();
		String username=(String) session.getAttribute("username");
		
		if(username!=null){
			//表示存在用户不拦截
			return true;
		}
		
		//执行这里表示用户身份需要认证，跳转登陆页面   /  表示绝对路径
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}

}

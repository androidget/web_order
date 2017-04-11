package com.study.exceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.study.exception.CustomException;

/**
 * spring mvc 中 给出了一个统一的异常处理类让系统进行统一的处理
 * @author Administrator
 *
 */
public class MyExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		
		CustomException customException=null;
		//处理相关的异常逻辑
		if(ex instanceof CustomException){
			customException=(CustomException) ex;
		}else {
			customException=new CustomException("未知错误");
		}
		
		String errorMessage=customException.getMessage();
		
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("error", errorMessage);
		
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}

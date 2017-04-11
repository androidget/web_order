package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.po.ItemsCustom;

@Controller
public class JsonTestController {

	
	@RequestMapping(value="requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
		
		return itemsCustom;
	}
	
	@RequestMapping(value="responseJson")
	public @ResponseBody ItemsCustom responseJson( ItemsCustom itemsCustom){  //这个是正常的key/value进行提交
		
		return itemsCustom;
	}
}

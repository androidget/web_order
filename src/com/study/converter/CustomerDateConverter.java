package com.study.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义日期的绑定类型
 * @author Administrator
 *
 */
public class CustomerDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			return format.parse(arg0);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}

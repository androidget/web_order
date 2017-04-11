<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome 注册</title>
</head>

<!-- 如果使用post 则表示get 编码，在get默认是   IOS8859-1 的编码  -->
<body>
	<form action="${pageContext.request.contextPath }/login" method="post">
		用户名 ：<input type="text" name="username"> <br/>
		 手机号码 ：<input type="text" name="phone"> <br/> 
		 登录密码 ：<input type="password" name="password">  <br/> 
		  确认密码 ：<input type="password" name="repassword">  <br/> 
		  
		  <input type="submit" value="注册">
	</form>
</body>

</html>
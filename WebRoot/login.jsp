<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome 登录</title>

<script type="text/javascript">
	function jump() {
		//清空表单所有数据  
		document.getElementById("firstname").value = ""
		document.getElementById("lastname").value = ""
		document.getElementById("firstnameLabel").value = ""
		document.getElementById("lastnameLabel").value = ""
	}

	function check() {
		var txt_firstname = document.getElementById("firstname").value
		var txt_lastname = document.getElementById("lastname").value

		document.getElementById("firstnameLabel").value = ""
		document.getElementById("lastnameLabel").value = ""

		var isSuccess = 1;
		if (txt_firstname==null || txt_firstname.length == 0) {
			document.getElementById("firstnameLabel").value ="username不能为空！"
			/* $("#firstnameLabel").css({
				"color" : "red"
			}); */
			isSuccess = 0;
		}
		if (txt_lastname==null || txt_lastname.length == 0) {
			document.getElementById("lastnameLabel").value ="密码不能为空！"
			
			/* $("#lastnameLabel").text("密码不能为空！")
			$("#lastnameLabel").css({
				"color" : "red"
			}); */
			isSuccess = 0;
		}
		if (isSuccess == 0) {
			return false;
		}
		return true;
	}
</script>


</head>

<!-- 如果使用post 则表示get 编码，在get默认是   IOS8859-1 的编码  -->
<body>
	<form id="login" action="${pageContext.request.contextPath }/login"
		onsubmit="return check()" method="post">
		登录名 ：<input type="text" name="username" id="firstname"> <input
			type="text" id="firstnameLabel"><br /> 登录密码 ：<input
			type="password" name="password" id="lastname"> <input
			type="text" id="lastnameLabel"> <br /> <input type="submit"
			value="登录"> <input type="button" value="清空" onclick="jump()">
	</form>
</body>

</html>
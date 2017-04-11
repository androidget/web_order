<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSON 交互测试</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	function requestJson() {
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/requestJson',
			contentType:'application/json;charset=utf-8',//设置字符编码，默认是key/value 
			data:'{"name":"helloworld","price":"55.0"}',
			success:function(data){     //返回json
				alert(data);
			}
		});
		
		
	}
	
	function responseJson() {
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/responseJson',
			data:'name=你好&price=88.6',
			success:function(data){     //返回json
				alert(data);
			}
		});
	}

</script>
</head>





<body>
	<input type="button" onclick="requestJson()" value="请求json,输出json">
	<input type="button" onclick="responseJson()" value="请求key/value,输出json">
</body>

</html>
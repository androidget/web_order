<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>

</head>
<body>

	<c:if test="${allErrors!=null}">
		输入有误：<br/>
		<c:forEach items="${allErrors}" var="error">
			<span>${error}</span>
			<br />
			<br />
			<!-- 循环获取自己定义的list错误信息 -->
			<%-- <span>map:${error.defaultMessage }</span> 如果不出现乱码的情况下是用这个来接受错误提示信息的  <br/><br/>  --%>
		</c:forEach>
	</c:if>

	<form id="itemForm"
		action="${pageContext.request.contextPath }/items/updateItem"
		method="post">
		<input type="hidden" name="id" value="${itemsCustom.id }" /> 修改商品信息：
		<table width="100%" border=1>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name" value="${itemsCustom.name }" /></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price"
					value="${itemsCustom.price }" /></td>
			</tr>
			<tr>
				<td>商品生产日期</td>
				<td><input type="text" name="createtime"
					value="<fmt:formatDate value="${itemsCustom.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" /></td>
			</tr>
			<%-- <tr>
	<td>商品图片</td>
	<td>
		<c:if test="${item.pic !=null}">
			<img src="/pic/${item.pic}" width=100 height=100/>
			<br/>
		</c:if>
		<input type="file"  name="pictureFile"/> 
	</td>
</tr> --%>
			<tr>
				<td>商品简介</td>
				<td><textarea rows="3" cols="30" name="detail">${itemsCustom.detail }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>

	</form>
</body>

</html>
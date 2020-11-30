<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="cn.xzc.domain.Order"%>
	
	<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单展示列表页面</title>
</head>
<body style="text-align: center">
	<br />
	<br />
	<table border="1px" cellpadding="0" cellspacing="0" width="90%">
		<caption>
			<h2>订单信息</h2>
		</caption>
		<tr>
			<td>订单人</td>
			<td>下单时间</td>
			<td>订单总价</td>

		</tr>
		<c:forEach var="entry" items="${orderlist.items }">
				<tr>
					<td>${entry.user.username }</td>
					<td>${entry.ordertime }</td>
					<td>${entry.price }</td>
					
				</tr>
			</c:forEach>
	</table>
</body>
</html>

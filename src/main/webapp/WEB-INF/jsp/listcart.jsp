<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车列表</title>
<script type="text/javascript">
	function deleteitem(id) {
		var b = window.confirm("您确认删除吗？");
		if (b) {
			//window代表当前浏览器窗口，location代表当前浏览器窗口的地址栏
			window.location.href = "${pageContext.request.contextPath }/DeleteCartGoodServlet?id=" + id;
		}
	}
	
	function paycart() {
		var b = window.confirm("您确认结账吗？");
		if (b) {
			window.location.href = "${pageContext.request.contextPath }/OrderListServlet";
		}
	}
	
</script>
</head>
<body style="text-align: center;">
	<h1>购物车列表</h1>
	
	<c:if test="${empty(cart.items) }">	<!-- el表达式中的empty()函数：检测map是否为null或""，若是则返回true -->
		您没有购买任何商品！！！
	</c:if>
	
	<c:if test="${!empty(cart.items) }">
		<table width="70%" border="1px" align="center">
			<tr>
				<td>书名</td>
				<td>单价</td>
				<td>数量</td>
				<td>小计</td>
				<td>操作</td>
			</tr>
			
			<c:forEach var="entry" items="${cart.items }">
				<tr>
					<td>${entry.good.name }</td>
					<td>${entry.good.price }</td>
					<td>${entry.quantity }</td>
					<td>${entry.price }</td>
					<td>
		 				<!-- javascript:void(0)：去掉超链接默认的行为 -->
						<a href="javascript:void(0)" onclick="deleteitem(${entry.good.id})">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2">总价</td>
				<td colspan="2">${cart.price }元</td>
				<td colspan="1">
					<a href="javascript:void(0)" onclick="paycart()" >结账</a>
				</td>
			</tr>
		</table>
	</c:if>
</body>
</html>

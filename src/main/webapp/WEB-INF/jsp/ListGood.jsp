<%@page import="java.sql.SQLException"%> 
<%@page import="java.sql.DriverManager"%> 
<%@page import="java.sql.Connection"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.xzc.domain.Good"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上商城</title>
</head>
<h1>xzc的小商城</h1>
<br/>
<br/>
<div>
	<div style="float: left;">
		<form action="${pageContext.request.contextPath }/AddGoodUIServlet" method="post">
		<button>添加商品</button>
		</form>
	</div>
	<div style="clear: both"></div>
</div>
<div>
	<div style="float: right;">
		<form action="${pageContext.request.contextPath }/LogoutServlet" method="post">
		<c:if test="${user != null }">
			欢迎您，${user.nickname }
		</c:if>
		
		<button>注销</button>
		</form>
	</div>
	<div style="clear: both"></div>
</div>
<hr>
<body style="text-align: center;">
	<h1>商品列表</h1>
	<table width="70%" border="1px" align="center">
		<tr>
			<td>商品id</td>
			<td>商品名</td>
			<td>售价</td>
			<td>描述</td>
			<td>操作1</td>
			<td>操作2</td>
		</tr>
		 <% 
      		// 获取图书信息集合 
      		List<Good> list = (List<Good>) request.getAttribute("list"); 
      		// 判断集合是否有效 
      		if (list == null || list.size() < 1) { 
        		out.print("没有数据！"); 
      			} else { 
        		// 遍历图书集合中的数据 
        			for (Good good : list) { 
    	%> 
			<tr>
				<td><%=good.getId()%></td>
				<td><%=good.getName()%></td>
				<td><%=good.getPrice()%></td>
				<td><%=good.getDescription()%> </td>
				<td>
					<a href="${pageContext.request.contextPath}/BuyServlet?id=<%=good.getId() %>" target="_blank">添加到购物篮</a>
				</td>
				<td> 
      				<a href="${pageContext.request.contextPath}/DeleteGoodServlet?id=<%=good.getId()%>">删除</a> 
      			</td>
      			<td > 
        			<form style="align:center; background-color: gray" action="${pageContext.request.contextPath}/UpdateGoodServlet" method="post"
         				 onsubmit="return check(this);"> 
           				<input type="hidden" name="id" value="<%=good.getId()%>"> 
           				<input type="text" name="price" size="1"> 
           				<input type="submit" value="修改价格"> 
        			</form> 
      			</td> 
			</tr>
			
		<%
		}
		} %>		
	</table>
	<a href="${pageContext.request.contextPath}/ListCartUIServlet" target="_blank">查看购物车</a>
	<a href="${pageContext.request.contextPath}/ShowOrderUIServlet" target="_blank">显示订单</a>
</body>
</html>

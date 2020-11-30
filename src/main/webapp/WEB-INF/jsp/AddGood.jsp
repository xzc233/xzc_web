<%@page import="java.sql.SQLException"%> 
<%@page import="java.sql.DriverManager"%> 
<%@page import="java.sql.Connection"%> 
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<title>添加商品信息</title> 
</head> 
  
  
<body> 
  
<form action="${pageContext.request.contextPath }/AddGoodServlet" method="post" onsubmit="check(this)"> 
  <table align="center" width="450"> 
    <tr> 
      <td align="center" colspan="2"> 
        <h2>添加商品信息</h2> 
        <hr> 
      </td> 
    </tr> 
  
    <tr> 
      <td align="right">商品名称：</td> 
      <td><input type="text" name="name" value="${form.name }"><em>${form.errors.name }</em></td> 
    </tr> 
  
    <tr> 
      <td align="right">价 格：</td> 
      <td><input type="text" name="price"value="${form.price }"><em>${form.errors.price }</em></td> 
    </tr> 
  
    <tr> 
      <td align="right">id：</td> 
      <td><input type="text" name="id"value="${form.id }"><em>${form.errors.id }</em></td> 
    </tr> 
  
    <tr> 
      <td align="right">描述：</td> 
      <td><input type="text" name="description" /></td> 
    </tr> 
    <tr> 
      <td align="center" colspan="2"><input type="submit" value="添　加"> 
      </td> 
    </tr> 
  </table> 
</form> 
  
  
</body> 
</html> 
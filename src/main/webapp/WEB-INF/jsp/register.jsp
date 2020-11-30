<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
</head>
<body>
    <div class="wrapper">
       
            <div class="main">
                <form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
                <table width="350px" align="center">
                	<caption><h1>用户注册</h1>
                	</caption>
                    <tr>
                    <td class="username">
                        <input type="text" name="username" value="${form.username }" placeholder="账号"><em>${form.errors.username }</em>
                    </td>
                    </tr>
                    <tr>
                    <td class="password">
                        <input type="password" name="password" value="${form.password }" placeholder="密码"><em>${form.errors.password }</em>
                    </td>
                    </tr>
                    <tr>
                    <td class="password2">
                        <input type="password" name="password2" value="${form.password2 }" placeholder="再次输入密码"><em>${form.errors.password2 }</em>
                    </td>
                    </tr>
                    <tr>
                    <td class="email">
                        <input type="text" name="email" value="${form.email }" placeholder="邮箱"><em>${form.errors.email }</em>
                    </td>
                    </tr>
      				<tr>
                    <td class="nickname">
                        <input type="text" name="nickname" value="${form.nickname }" placeholder="昵称"><em>${form.errors.nickname }</em>
                    </td>
                    </tr>
                    <tr>
					
					<td><button>注册</button></td>
					</tr>
                </table>
                </form>
            </div>
        
    </div>
</body>
</html>

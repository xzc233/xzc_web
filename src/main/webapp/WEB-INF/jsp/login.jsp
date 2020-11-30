<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>
<body>
    
        <div class="wrapper">
        
            <h1>登录系统</h1>
            
                 
                         <form action="${pageContext.request.contextPath }/LoginServlet" method="post">
                            <p class="name"><i></i><input type="text" name="username" class="userName" placeholder="请输入用户名"></p>
                            <p class="password"><i></i><input type="password" name="password" class="pwd" placeholder="请输入密码"></p>
                            <button>登录</button>
                            <p class="remember"><input type="checkbox" name="remember">记住密码</p>
                            <p class="regist"><span>没有账号?</span><a href="${pageContext.request.contextPath}/RegisterUIServlet">立即注册</a></p>
                            <div class="clear"></div>
                        </form>
                    
                   
                
         
        </div>
 
</body>
</html>
package cn.xzc.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzc.domain.User;
import cn.xzc.impl.BusinessServiceImpl;

//处理登录请求
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		BusinessServiceImpl service = new BusinessServiceImpl();
		User user = service.login(username, password);
		if (user.getNickname() != null) {
			request.getSession().setAttribute("user", user);
			//让用户登录成功后跳转到首页
			response.sendRedirect(request.getContextPath() + "/ShowGoodServlet");
			return;
		}
		request.setAttribute("message", "对不起，用户名或密码错误！！请重新登录！2秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='2;url="+request.getContextPath()+"/LoginUIServlet'>");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}



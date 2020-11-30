package cn.xzc.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzc.domain.User;
import cn.xzc.exception.UserExistException;
import cn.xzc.impl.BusinessServiceImpl;
import cn.xzc.utils.WebUtils;
import cn.xzc.web.formbean.RegisterForm;

//处理注册请求
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//1.对提交的表单字段进行合法性校验（设计一个对象代表提交的表单，即formBean，formBean封装表单提交的数据）
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b = form.validate();
		
		//2.如果校验失败，跳回到表单页面，回显校验失败信息
		if (!b) {
			request.setAttribute("form", form);// form记住了上次提交过的数据
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		
		//3.如果校验成功，则调用Service层处理注册请求
		User user = new User();
		//从formbean将属性拷贝到user对象中去，bean的拷贝。需要用到BeanUtils的copyProperties()方法
		WebUtils.copyBean(form, user);
		
		BusinessServiceImpl service = new BusinessServiceImpl();
		try {
			service.register(user);
			//6.如果Service层处理成功，跳转到网站的全局消息显示页面，为用户显示注册成功的消息
//			request.setAttribute("message", "恭喜您，注册成功");
			request.setAttribute("message", "恭喜您，注册成功！！！1秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='1;url="+request.getContextPath()+"/LoginUIServlet'");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (UserExistException e) {
			//4.如果Service层处理不成功，并且不成功的原因是因为注册用户已存在的话，则跳回到注册页面，显示注册用户已存在
			form.getErrors().put("username", "注册的用户名已存在");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			//5.如果Service层处理不成功，并且不成功的原因是因为其他问题的话，则跳转到网站的全局消息显示页面，为用户显示友好错误消息
			e.printStackTrace();// 其他异常不要抛给用户，对用户不友好，所以应该try，并在后台记录异常
			request.setAttribute("message", "服务器出现未知错误");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}



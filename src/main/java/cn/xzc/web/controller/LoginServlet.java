package cn.xzc.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzc.domain.User;
import cn.xzc.impl.BusinessServiceImpl;

//�����¼����
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		BusinessServiceImpl service = new BusinessServiceImpl();
		User user = service.login(username, password);
		if (user.getNickname() != null) {
			request.getSession().setAttribute("user", user);
			//���û���¼�ɹ�����ת����ҳ
			response.sendRedirect(request.getContextPath() + "/ShowGoodServlet");
			return;
		}
		request.setAttribute("message", "�Բ����û�����������󣡣������µ�¼��2���Ϊ���Զ�������¼ҳ�棡��<meta http-equiv='refresh' content='2;url="+request.getContextPath()+"/LoginUIServlet'>");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}



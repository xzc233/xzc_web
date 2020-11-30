package cn.xzc.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//�����û�ע������
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("user");
			session.removeAttribute("cart");
		}
		
		//ע���ɹ�����ת��ȫ����Ϣ��ʾҳ�棬��ʾע���ɹ�����Ϣ����������Ϣ��ʾҳ���3�����ת����ҳ
		request.setAttribute("message", "ע���ɹ������������1�����ת�����û����ת����͵�......!!!<meta http-equiv='refresh' content='1;url="+request.getContextPath()+"/LoginUIServlet'");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
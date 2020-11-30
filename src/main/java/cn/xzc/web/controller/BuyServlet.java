package cn.xzc.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzc.domain.Good;
import cn.xzc.domain.Cart;
import cn.xzc.service.CustService;

//����鼮����
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		CustService service = new CustService();
		Good good = service.findGood(id);
		
		//�õ��û��Ĺ��ﳵ
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		// �û���һ�ι���Ϊ�û��������ﳵ
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		//����ӵ��û��Ĺ��ﳵ�У���ɹ���
		cart.add(good);
		
		/*
		 * ��������·��ʵ�ַ��/WEB-INF/jsp/listcart.jsp
		 * �������ַ�����������ˣ��������޷�ֱ�ӷ��ʵģ�
		 * Ҫʵ�ֵĻ�����Ƚ��鷳����Ҫ������Servlet��Ȼ����ת��listcart.jspҳ�档
		 */
//		response.sendRedirect("/WEB-INF/jsp/listcart.jsp");
		response.sendRedirect(request.getContextPath() + "/ListCartUIServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

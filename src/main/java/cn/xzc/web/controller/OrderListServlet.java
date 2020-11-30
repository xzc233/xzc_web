package cn.xzc.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzc.domain.OrderList;
import cn.xzc.domain.Cart;
import cn.xzc.domain.User;

@WebServlet("/OrderListServlet")
public class OrderListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderList orderlist = (OrderList) request.getSession().getAttribute("orderlist");
		
		//�õ��û��Ĺ��ﳵ
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		User user=(User)request.getSession().getAttribute("user");
		// �û���һ�ι���Ϊ�û��������ﳵ
		if (orderlist == null) {
			orderlist = new OrderList();
			request.getSession().setAttribute("orderlist", orderlist);
		}
		
		//����ӵ��û��Ĺ��ﳵ�У���ɹ���
		orderlist.add(cart,user);
		response.sendRedirect(request.getContextPath() + "/SendEmail");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

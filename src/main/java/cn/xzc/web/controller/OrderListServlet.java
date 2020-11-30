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
		
		//得到用户的购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		User user=(User)request.getSession().getAttribute("user");
		// 用户第一次购买，为用户创建购物车
		if (orderlist == null) {
			orderlist = new OrderList();
			request.getSession().setAttribute("orderlist", orderlist);
		}
		
		//把书加到用户的购物车中，完成购买
		orderlist.add(cart,user);
		response.sendRedirect(request.getContextPath() + "/SendEmail");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

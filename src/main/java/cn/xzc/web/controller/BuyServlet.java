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

//完成书籍购买
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		CustService service = new CustService();
		Good good = service.findGood(id);
		
		//得到用户的购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		// 用户第一次购买，为用户创建购物车
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		//把书加到用户的购物车中，完成购买
		cart.add(good);
		
		/*
		 * 浏览器重新访问地址：/WEB-INF/jsp/listcart.jsp
		 * 但这个地址被保护起来了，外面是无法直接访问的，
		 * 要实现的话，会比较麻烦，需要先跳到Servlet，然后再转到listcart.jsp页面。
		 */
//		response.sendRedirect("/WEB-INF/jsp/listcart.jsp");
		response.sendRedirect(request.getContextPath() + "/ListCartUIServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

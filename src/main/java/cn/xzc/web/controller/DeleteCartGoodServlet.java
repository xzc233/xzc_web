package cn.xzc.web.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzc.domain.Cart;	
import cn.xzc.service.CustService;
@WebServlet("/DeleteCartGoodServlet")
public class DeleteCartGoodServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		CustService service = new CustService();
		service.deleteCartItem(id, cart);
		
		//删除成功，还是跳转到listcart.jsp页面
		response.sendRedirect(request.getContextPath() + "/ListCartUIServlet");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

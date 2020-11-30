package cn.xzc.web.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement ;

import cn.xzc.domain.Good; 
@WebServlet("/DeleteGoodServlet")
public class DeleteGoodServlet extends HttpServlet{
	private static final long serialVersionUID = 1L; 
	  
	  /** 
	   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse 
	   *   response) 
	   */
	  protected void doGet(HttpServletRequest request, 
	      HttpServletResponse response) throws ServletException, IOException { 
	    int id = Integer.valueOf(request.getParameter("id")); 
	    try { 
	     // 加载数据库驱动，注册到驱动管理器 
	     Class.forName("com.mysql.jdbc.Driver"); 
	     // 数据库连接字符串 
	     String url = "jdbc:mysql://localhost:3306/good?useUnicode=true&characterEncoding=utf8&useSSL=false"; 
	      // 数据库用户名 
	     String username = "root"; 
	      // 数据库密码 
	     String password = "991213"; 
	     // 创建Connection连接 
	     Connection conn = DriverManager.getConnection(url, username, password); 
	     // 删除图书信息的SQL语句 
	     String sql = "delete from good where id="+id; 
	     // 获取PreparedStatement 
	     PreparedStatement ps = conn.prepareStatement(sql); 
	     // 对SQL语句中的第一个占位符赋值  
	     // 执行更新操作 
	     ps.executeUpdate(); 
	     // 关闭PreparedStatement 
	     ps.close(); 
	     // 关闭Connection 	
	     conn.close(); 
	     request.setAttribute("message", "删除成功！！！1秒后为您自动跳到购物页面！！<meta http-equiv='refresh' content='1;url="+request.getContextPath()+"/ShowGoodServlet'");
	     request.getRequestDispatcher("/message.jsp").forward(request, response);
	        
	    } catch (Exception e) { 
	      e.printStackTrace(); 
	    } 
	    // 重定向到FindServlet 
	   
	  } 
	  
	  /** 
	   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse 
	   *   response) 
	   */
	  protected void doPost(HttpServletRequest request, 
	      HttpServletResponse response) throws ServletException, IOException { 
	    doGet(request, response); 
	  } 
}

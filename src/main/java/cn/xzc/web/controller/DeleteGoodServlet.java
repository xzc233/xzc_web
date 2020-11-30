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
	     // �������ݿ�������ע�ᵽ���������� 
	     Class.forName("com.mysql.jdbc.Driver"); 
	     // ���ݿ������ַ��� 
	     String url = "jdbc:mysql://localhost:3306/good?useUnicode=true&characterEncoding=utf8&useSSL=false"; 
	      // ���ݿ��û��� 
	     String username = "root"; 
	      // ���ݿ����� 
	     String password = "991213"; 
	     // ����Connection���� 
	     Connection conn = DriverManager.getConnection(url, username, password); 
	     // ɾ��ͼ����Ϣ��SQL��� 
	     String sql = "delete from good where id="+id; 
	     // ��ȡPreparedStatement 
	     PreparedStatement ps = conn.prepareStatement(sql); 
	     // ��SQL����еĵ�һ��ռλ����ֵ  
	     // ִ�и��²��� 
	     ps.executeUpdate(); 
	     // �ر�PreparedStatement 
	     ps.close(); 
	     // �ر�Connection 	
	     conn.close(); 
	     request.setAttribute("message", "ɾ���ɹ�������1���Ϊ���Զ���������ҳ�棡��<meta http-equiv='refresh' content='1;url="+request.getContextPath()+"/ShowGoodServlet'");
	     request.getRequestDispatcher("/message.jsp").forward(request, response);
	        
	    } catch (Exception e) { 
	      e.printStackTrace(); 
	    } 
	    // �ض���FindServlet 
	   
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

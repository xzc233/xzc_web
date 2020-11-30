package cn.xzc.web.controller;
import java.io.IOException; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
  
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
@WebServlet("/UpdateGoodServlet")
public class UpdateGoodServlet extends HttpServlet{
	private static final long serialVersionUID = 1L; 
	  /** 
	   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse 
	   *   response) 
	   */
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	    int id = Integer.valueOf(request.getParameter("id")); 
	    double price = Double.parseDouble(request.getParameter("price")); 
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
	      Connection conn = DriverManager.getConnection(url, username, 
	          password); 
	      // ����SQL��� 
	      String sql = "update good set price=? where id=?"; 
	      // ��ȡPreparedStatement 
	      PreparedStatement ps = conn.prepareStatement(sql); 
	      // ��SQL����еĵ�һ��������ֵ 
	      ps.setDouble(1, price); 
	      // ��SQL����еĵڶ���������ֵ 
	      ps.setInt(2, id); 
	      // ִ�и��²��� 
	      ps.executeUpdate(); 
	      // �ر�PreparedStatement 
	      ps.close(); 
	      // �ر�Connection 
	      conn.close(); 
	    } catch (Exception e) { 
	      e.printStackTrace(); 
	    } 
	    // �ض���FindServlet 
	    response.sendRedirect(request.getContextPath()+"/ShowGoodServlet"); 
	  
	  } 
	  
	  /** 
	   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse 
	   *   response) 
	   */
	  protected void doPost(HttpServletRequest request, 
	      HttpServletResponse response) throws ServletException, IOException { 
	    // TODO Auto-generated method stub 
	    doGet(request, response); 
	  } 
}

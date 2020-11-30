package cn.xzc.web.controller;
import java.io.IOException; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List; 
  
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
  
import cn.xzc.domain.Good;
@WebServlet("/ShowGoodServlet")
public class ShowGoodServlet extends HttpServlet{
		private static final long serialVersionUID = 1L; 
	  
	  /** 
	   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse 
	   *   response) 
	   */
		protected void doGet(HttpServletRequest request, 
				HttpServletResponse response) throws ServletException, IOException { 
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
		      // 添加图书信息的SQL语句 
		      String sql = "select * from good"; 
		      // 获取Statement 
		      Statement statement = conn.createStatement(); 
	  
		      ResultSet resultSet = statement.executeQuery(sql); 
	  
		      List<Good>list = new ArrayList<Good>(); 
		      while (resultSet.next()) { 
	  
		    	  Good good = new Good(); 
		    	  	good.setId(resultSet.getInt("id")); 
		    	  	good.setName(resultSet.getString("goodname")); 
		    	  	good.setPrice(resultSet.getDouble("price")); 
		    	  	good.setDescription(resultSet.getString("description")); 
		    	  	list.add(good); 
	  
		      } 
		      request.setAttribute("list", list); 
		      resultSet.close(); 
		      statement.close(); 
		      conn.close(); 
	  
	    	} catch (Exception e) { 
	    		e.printStackTrace(); 
	    	} 
	  
	    		request.getRequestDispatcher("/WEB-INF/jsp/ListGood.jsp").forward(request, response); 
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

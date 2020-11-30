package cn.xzc.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzc.utils.WebUtils;
import cn.xzc.web.formbean.AddGoodForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement ;

//处理注册请求
@WebServlet("/AddGoodServlet")
public class AddGoodServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1.对提交的表单字段进行合法性校验（设计一个对象代表提交的表单，即formBean，formBean封装表单提交的数据）
				AddGoodForm form = WebUtils.request2Bean(request, AddGoodForm.class);
				boolean b = form.ConfirmId();
				
				//2.如果校验失败，跳回到表单页面，回显校验失败信息
				if (!b) {
					request.setAttribute("form", form);// form记住了上次提交过的数据
					request.getRequestDispatcher("/WEB-INF/jsp/AddGood.jsp").forward(request, response);
					return;
				}
				
				//3.如果校验成功，则调用Service层处理注册请求
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
		      Connection conn = DriverManager.getConnection(url, username, 
		          password); 
		      // 添加图书信息的SQL语句 
		      String sql = "insert into good(id,goodname,price,description) values(?,?,?,?)"; 
		      // 获取PreparedStatement 
		      String name = request.getParameter("name");
		      //获取的中文字符为正常
		      String id = request.getParameter("id");
		      String description = request.getParameter("description");
		      String price = request.getParameter("price");
		      PreparedStatement ps = conn.prepareStatement(sql); 
		      // 对SQL语句中的第1个参数赋值 
		      ps.setString(1, id); 
		      // 对SQL语句中的第2个参数赋值 
		      ps.setString(2, name); 
		      // 对SQL语句中的第3个参数赋值 	
		      ps.setDouble(3, Double.parseDouble(price)); 
		      // 对SQL语句中的第4个参数赋值 
		      ps.setString(4, description); 
		
		      // 执行更新操作，返回所影响的行数 
		      int row = ps.executeUpdate(); 
		      // 判断是否更新成功 
		      if (row > 0) { 
		        // 更新成输出信息 
		    	  request.setAttribute("message", "添加成功！！！1秒后为您自动跳到购物页面！！<meta http-equiv='refresh' content='1;url="+request.getContextPath()+"/ShowGoodServlet'");
		    	  request.getRequestDispatcher("/message.jsp").forward(request, response);
		    	  return;
		      } 
		      // 关闭PreparedStatement，释放资源 
		      ps.close(); 
		      // 关闭Connection，释放资源 
		      conn.close(); 
		    } catch (Exception e) { 
		    	request.setAttribute("message","图书信息添加失败！<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/ShowGoodServlet'"); 
		      e.printStackTrace(); 
		    } 
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
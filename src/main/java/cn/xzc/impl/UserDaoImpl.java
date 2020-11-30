package cn.xzc.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.xzc.dao.UserDao;
import cn.xzc.domain.User;
public class UserDaoImpl implements UserDao {
	
	@Override
	public void add(User user) {
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
		      String sql = "insert into user(username,password,email,nickname) values(?,?,?,?)"; 
		      PreparedStatement ps = conn.prepareStatement(sql); 
		      ps.setString(1, user.getUsername());
		      ps.setString(2, user.getPassword());
		      ps.setString(3, user.getEmail());
		      ps.setString(4, user.getNickname());
		      ps.executeUpdate();
		      ps.close();
		      conn.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public User find(String username, String password) {
		try {
				
			Class.forName("com.mysql.jdbc.Driver"); 
				// 数据库连接字符串 
		      String url = "jdbc:mysql://localhost:3306/good?useUnicode=true&characterEncoding=utf8&useSSL=false"; 
		      // 数据库用户名 
		      String userName = "root"; 
		      // 数据库密码 
		      String passWord = "991213"; 
		      // 创建Connection连接 
		      Connection conn = DriverManager.getConnection(url, userName, passWord); 
		      Statement sta = conn.createStatement();
		      String sql="select * from user where username='"+username+"' and password='"+password+"'";
		      ResultSet rs = sta.executeQuery(sql);
		      User user = new User();
		      while(rs.next())
		      {
		    	 
		      user.setEmail(rs.getString("email"));
		      user.setNickname(rs.getString("nickname"));
		      user.setPassword(rs.getString("password"));
		      user.setUsername(rs.getString("username"));
		      }
		      sta.close();
		      conn.close();
		      return user;
			} catch (Exception e) {
			// 最好应该转换为自定义异常，但不想把这个工程搞得太复杂了
			throw new RuntimeException(e);
		}
	}
	
	//查找注册的用户是否在数据库中存在
	@Override
	public boolean find(String username) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			// 数据库连接字符串 
			String url = "jdbc:mysql://localhost:3306/good?useUnicode=true&characterEncoding=utf8&useSSL=false"; 
			// 数据库用户名 
			String userName = "root"; 
			// 数据库密码 
			String passWord = "991213"; 
			// 创建Connection连接 
			Connection conn = DriverManager.getConnection(url, userName, passWord); 
			Statement sta = conn.createStatement();
			String sql="select count(*) from user where username='"+username+"'";
			ResultSet rs = sta.executeQuery(sql);
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			sta.close();
		     conn.close();
			if(count!=0){
				return false;
	    	  }
			
			return true;
		} catch (Exception e) {
			// 最好应该转换为自定义异常，但不想把这个工程搞得太复杂了
			throw new RuntimeException(e);
		}
	}
}
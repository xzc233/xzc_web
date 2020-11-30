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
		      // ���ͼ����Ϣ��SQL��� 
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
				// ���ݿ������ַ��� 
		      String url = "jdbc:mysql://localhost:3306/good?useUnicode=true&characterEncoding=utf8&useSSL=false"; 
		      // ���ݿ��û��� 
		      String userName = "root"; 
		      // ���ݿ����� 
		      String passWord = "991213"; 
		      // ����Connection���� 
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
			// ���Ӧ��ת��Ϊ�Զ����쳣���������������̸��̫������
			throw new RuntimeException(e);
		}
	}
	
	//����ע����û��Ƿ������ݿ��д���
	@Override
	public boolean find(String username) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			// ���ݿ������ַ��� 
			String url = "jdbc:mysql://localhost:3306/good?useUnicode=true&characterEncoding=utf8&useSSL=false"; 
			// ���ݿ��û��� 
			String userName = "root"; 
			// ���ݿ����� 
			String passWord = "991213"; 
			// ����Connection���� 
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
			// ���Ӧ��ת��Ϊ�Զ����쳣���������������̸��̫������
			throw new RuntimeException(e);
		}
	}
}
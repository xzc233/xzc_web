package cn.xzc.dao;
import java.util.Map;
import java.sql.*;

import javax.xml.stream.events.StartElement;
import cn.xzc.domain.Good;

public class GoodDao {
	
	public Good find(String id) {
		Good good=new Good();
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			// 数据库连接字符串 
			String url = "jdbc:mysql://localhost:3306/good?useUnicode=true&characterEncoding=utf8&useSSL=false"; 
			// 数据库用户名 
			String username = "root"; 
			// 数据库密码 
			String password = "991213"; 
			// 创建Connection连接 
			Connection conn = DriverManager.getConnection(url, username, password); 
	    
			Statement state=conn.createStatement();//容器
			String sql="select * from good where id="+id;           //sql语句
			
			ResultSet rs=state.executeQuery(sql);     //将sql语句传至数据库，返回的值为一个字符集用一个变量接收 
			while(rs.next()){
				good.setId(Integer.parseInt(rs.getString(1)));	 //getString（n）获取第n列的内容
				good.setName(rs.getString(2)); 						//数据库中的列数是从1开始的
				good.setPrice(Double.parseDouble(rs.getString(3)));
				good.setDescription(rs.getString(4));
			}
			rs.close();
			state.close();
	        conn.close();               
	        return good;               
			}catch (Exception e) { 
		      e.printStackTrace(); 
			 }
		  return good; 
		    
		}
	
}

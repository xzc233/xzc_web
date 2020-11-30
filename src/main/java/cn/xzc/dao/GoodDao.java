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
			String url = "jdbc:mysql://localhost:3306/good?useUnicode=true&characterEncoding=utf8&useSSL=false"; 
			String username = "root"; 
			String password = "991213"; 
			Connection conn = DriverManager.getConnection(url, username, password); 
			Statement state=conn.createStatement();
			String sql="select * from good where id="+id;           
			ResultSet rs=state.executeQuery(sql);    
			while(rs.next()){
				good.setId(Integer.parseInt(rs.getString(1)));	 
				good.setName(rs.getString(2)); 						
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

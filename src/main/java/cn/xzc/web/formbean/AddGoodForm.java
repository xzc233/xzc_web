package cn.xzc.web.formbean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

import java.sql.ResultSet;
import java.sql.Statement ;
public class AddGoodForm {
	private String id;
	private String name;
	private String price;
	private String description;
	
	private Map errors = new HashMap();
	public String getId() {
		return id;
	}
	public void setId(String i) {
		this.id = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	public boolean ConfirmId(){
		boolean isOK=true;
		if (this.name == null || this.name.trim().equals("")) {
			isOK = false;
			errors.put("name", "商品名不能为空");
		}
		
		if (this.price==null|| this.price.trim().equals("")) {
				isOK = false;
				errors.put("price", "价格不能为空");
		}
		if (this.id==null|| this.id.trim().equals("")) {
				isOK = false;
				errors.put("id", "id不能为空");
		}
		if(isOK==true){
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
	      Statement sta = conn.createStatement();
	      String sql="select count(*) from good where id="+this.getId();
	      ResultSet rs = sta.executeQuery(sql);
	      int count = 0;
	      while (rs.next()) {
	    	  count = rs.getInt(1);
	      }
	      if(count!=0){
	    	  isOK = false;
	    	  errors.put("id", "id重复，不能使用");
	    	  }
	      sta.close();
	      conn.close();
	      
	      }catch (Exception e) { 
			      e.printStackTrace(); 
			      
			    } 
		}
		return isOK;
	}
}

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
			errors.put("name", "��Ʒ������Ϊ��");
		}
		
		if (this.price==null|| this.price.trim().equals("")) {
				isOK = false;
				errors.put("price", "�۸���Ϊ��");
		}
		if (this.id==null|| this.id.trim().equals("")) {
				isOK = false;
				errors.put("id", "id����Ϊ��");
		}
		if(isOK==true){
		try{	
				Class.forName("com.mysql.jdbc.Driver"); 
				// ���ݿ������ַ��� 
	      String url = "jdbc:mysql://localhost:3306/good?useUnicode=true&characterEncoding=utf8&useSSL=false"; 
	      // ���ݿ��û��� 
	      String username = "root"; 
	      // ���ݿ����� 
	      String password = "991213"; 
	      // ����Connection���� 
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
	    	  errors.put("id", "id�ظ�������ʹ��");
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

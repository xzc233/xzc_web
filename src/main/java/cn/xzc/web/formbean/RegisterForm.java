package cn.xzc.web.formbean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {
	
	/*
	 * 表单提交过来的全部是字符串
	 */
	private String username;
	private String password;
	private String password2;
	private String email;
	private String nickname;
	
	private Map errors = new HashMap();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Map getErrors() {
		return errors;
	}
	public void setErrors(Map errors) {
		this.errors = errors;
	}
	
	/*
	 * 以下是我们规定的校验规则：
	 * 
	 * 用户名不能为空，并且要是3-8位字母
	 * 密码不能为空，并且要是3-8位数字
	 * 确认密码不能为空，并且要和一次密码一致
	 * 电子邮箱不能为空，并且要是一个格式合法的邮箱
	 * 生日可以为空，不为空时，必须要是一个日期
	 * 昵称不可以为空，并且要是汉字
	 */
	public boolean validate() {
		boolean isOK = true;
		
		if (this.username == null || this.username.trim().equals("")) {
			isOK = false;
			errors.put("username", "用户名不能为空");
		} else {
			if (!this.username.matches("[A-Za-z]{3,8}")) {
				isOK = false;
				errors.put("username", "用户名必须要是3-8位字母");
			}
		}
		
		if (this.password == null || this.password.trim().equals("")) {
			isOK = false;
			errors.put("password", "密码不能为空");
		} else {
			if (!this.password.matches("\\d{3,8}")) {
				isOK = false;
				errors.put("password", "密码必须要是3-8位数字");
			}
		}
		
		if (this.password2 == null || this.password2.trim().equals("")) {
			isOK = false;
			errors.put("password2", "确认密码不能为空");
		} else {
			if (!this.password2.equals(this.password)) {
				isOK = false;
				errors.put("password2", "两次密码要一致");
			}
		}
		
		//电子邮箱不能为空，并且要是一个格式合法的邮箱
		if (this.email == null || this.email.trim().equals("")) {
			isOK = false;
			errors.put("email", "邮箱不能为空");
		} else {
			//邮箱在现实中的几种格式：qqq@sina.com、aaa@sina.com.cn、aa_bb.cc@sina.com.cn
			// \\w+@\\w+(\\.\\w+)+
			if (!this.email.matches("\\w+@\\w+(\\.\\w+)+")) {
				isOK = false;
				errors.put("email", "邮箱格式不对");
			}
		}
		
		//昵称不可以为空，并且要是汉字
		if (this.nickname == null || this.nickname.trim().equals("")) {
			isOK = false;
			errors.put("nickname", "昵称不能为空");
		} else {
			if (!this.nickname.matches("^([\u4e00-\u9fa5]+)$")) {
				isOK = false;
				errors.put("nickname", "昵称必须是汉字");
			}
		}
			
		
		return isOK;
	}
	
}

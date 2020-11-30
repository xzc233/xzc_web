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
	 * ���ύ������ȫ�����ַ���
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
	 * ���������ǹ涨��У�����
	 * 
	 * �û�������Ϊ�գ�����Ҫ��3-8λ��ĸ
	 * ���벻��Ϊ�գ�����Ҫ��3-8λ����
	 * ȷ�����벻��Ϊ�գ�����Ҫ��һ������һ��
	 * �������䲻��Ϊ�գ�����Ҫ��һ����ʽ�Ϸ�������
	 * ���տ���Ϊ�գ���Ϊ��ʱ������Ҫ��һ������
	 * �ǳƲ�����Ϊ�գ�����Ҫ�Ǻ���
	 */
	public boolean validate() {
		boolean isOK = true;
		
		if (this.username == null || this.username.trim().equals("")) {
			isOK = false;
			errors.put("username", "�û�������Ϊ��");
		} else {
			if (!this.username.matches("[A-Za-z]{3,8}")) {
				isOK = false;
				errors.put("username", "�û�������Ҫ��3-8λ��ĸ");
			}
		}
		
		if (this.password == null || this.password.trim().equals("")) {
			isOK = false;
			errors.put("password", "���벻��Ϊ��");
		} else {
			if (!this.password.matches("\\d{3,8}")) {
				isOK = false;
				errors.put("password", "�������Ҫ��3-8λ����");
			}
		}
		
		if (this.password2 == null || this.password2.trim().equals("")) {
			isOK = false;
			errors.put("password2", "ȷ�����벻��Ϊ��");
		} else {
			if (!this.password2.equals(this.password)) {
				isOK = false;
				errors.put("password2", "��������Ҫһ��");
			}
		}
		
		//�������䲻��Ϊ�գ�����Ҫ��һ����ʽ�Ϸ�������
		if (this.email == null || this.email.trim().equals("")) {
			isOK = false;
			errors.put("email", "���䲻��Ϊ��");
		} else {
			//��������ʵ�еļ��ָ�ʽ��qqq@sina.com��aaa@sina.com.cn��aa_bb.cc@sina.com.cn
			// \\w+@\\w+(\\.\\w+)+
			if (!this.email.matches("\\w+@\\w+(\\.\\w+)+")) {
				isOK = false;
				errors.put("email", "�����ʽ����");
			}
		}
		
		//�ǳƲ�����Ϊ�գ�����Ҫ�Ǻ���
		if (this.nickname == null || this.nickname.trim().equals("")) {
			isOK = false;
			errors.put("nickname", "�ǳƲ���Ϊ��");
		} else {
			if (!this.nickname.matches("^([\u4e00-\u9fa5]+)$")) {
				isOK = false;
				errors.put("nickname", "�ǳƱ����Ǻ���");
			}
		}
			
		
		return isOK;
	}
	
}

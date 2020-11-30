package cn.xzc.web.controller;
import java.io.*;
import java.util.Properties;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import cn.xzc.domain.User;

@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet{
    
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	  
	  final Properties props = new Properties();
	  User user=(User)request.getSession().getAttribute("user");
	  if(user==null){
		  request.setAttribute("message", "���ȵ�¼��<meta http-equiv='refresh' content='2;url="+request.getContextPath()+"/LoginUIServlet'>");
		  request.getRequestDispatcher("/message.jsp").forward(request, response);
		  
	  }
      // ��ʾSMTP�����ʼ���������������֤
      props.put("mail.smtp.auth", "true");
      //�˴���дSMTP������
      props.put("mail.smtp.host", "smtp.qq.com");
      //�˿ںţ�QQ��������������˿ڣ�������һ����һֱʹ�ò��ˣ����Ծ͸�����һ��587
      props.put("mail.smtp.port", "587");
      // �˴���д����˺�
      props.put("mail.user","827689391@qq.com");
      // �˴����������ǰ��˵��16λSTMP����
      props.put("mail.password","oebtkrusgplvbahg");

      // ������Ȩ��Ϣ�����ڽ���SMTP���������֤
      Authenticator authenticator = new Authenticator() {

          protected PasswordAuthentication getPasswordAuthentication() {
              // �û���������
              String userName = props.getProperty("mail.user");
              String password = props.getProperty("mail.password");
              return new PasswordAuthentication(userName, password);
          }
      };
      // ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
      Session mailSession = Session.getInstance(props, authenticator);
      // �����ʼ���Ϣ
      MimeMessage message = new MimeMessage(mailSession);
      // ���÷�����
      InternetAddress form;
		try {
			form = new InternetAddress(
			        props.getProperty("mail.user"));
		
			message.setFrom(form);
		
      // �����ռ��˵�����
      InternetAddress to = new InternetAddress(user.getEmail());
      message.setRecipient(Message.RecipientType.TO, to);
      // �����ʼ�����
      message.setSubject("�����̳ǵ�һ���ʼ�");
      // �����ʼ���������
      message.setContent("����ɹ�", "text/html;charset=UTF-8");
      // ���Ȼ���Ƿ����ʼ���
      Transport.send(message);
      request.setAttribute("message", "�ʼ��ѳɹ����ͣ����� <meta http-equiv='refresh' content='2;url="+request.getContextPath()+"/ListCartUIServlet'>");
	  request.getRequestDispatcher("/message.jsp").forward(request, response);
	} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
} 
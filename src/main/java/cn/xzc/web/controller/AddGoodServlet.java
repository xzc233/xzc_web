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

//����ע������
@WebServlet("/AddGoodServlet")
public class AddGoodServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1.���ύ�ı��ֶν��кϷ���У�飨���һ����������ύ�ı�����formBean��formBean��װ���ύ�����ݣ�
				AddGoodForm form = WebUtils.request2Bean(request, AddGoodForm.class);
				boolean b = form.ConfirmId();
				
				//2.���У��ʧ�ܣ����ص���ҳ�棬����У��ʧ����Ϣ
				if (!b) {
					request.setAttribute("form", form);// form��ס���ϴ��ύ��������
					request.getRequestDispatcher("/WEB-INF/jsp/AddGood.jsp").forward(request, response);
					return;
				}
				
				//3.���У��ɹ��������Service�㴦��ע������
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
		      String sql = "insert into good(id,goodname,price,description) values(?,?,?,?)"; 
		      // ��ȡPreparedStatement 
		      String name = request.getParameter("name");
		      //��ȡ�������ַ�Ϊ����
		      String id = request.getParameter("id");
		      String description = request.getParameter("description");
		      String price = request.getParameter("price");
		      PreparedStatement ps = conn.prepareStatement(sql); 
		      // ��SQL����еĵ�1��������ֵ 
		      ps.setString(1, id); 
		      // ��SQL����еĵ�2��������ֵ 
		      ps.setString(2, name); 
		      // ��SQL����еĵ�3��������ֵ 	
		      ps.setDouble(3, Double.parseDouble(price)); 
		      // ��SQL����еĵ�4��������ֵ 
		      ps.setString(4, description); 
		
		      // ִ�и��²�����������Ӱ������� 
		      int row = ps.executeUpdate(); 
		      // �ж��Ƿ���³ɹ� 
		      if (row > 0) { 
		        // ���³������Ϣ 
		    	  request.setAttribute("message", "��ӳɹ�������1���Ϊ���Զ���������ҳ�棡��<meta http-equiv='refresh' content='1;url="+request.getContextPath()+"/ShowGoodServlet'");
		    	  request.getRequestDispatcher("/message.jsp").forward(request, response);
		    	  return;
		      } 
		      // �ر�PreparedStatement���ͷ���Դ 
		      ps.close(); 
		      // �ر�Connection���ͷ���Դ 
		      conn.close(); 
		    } catch (Exception e) { 
		    	request.setAttribute("message","ͼ����Ϣ���ʧ�ܣ�<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/ShowGoodServlet'"); 
		      e.printStackTrace(); 
		    } 
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
package cn.xzc.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xzc.domain.User;
import cn.xzc.exception.UserExistException;
import cn.xzc.impl.BusinessServiceImpl;
import cn.xzc.utils.WebUtils;
import cn.xzc.web.formbean.RegisterForm;

//����ע������
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//1.���ύ�ı��ֶν��кϷ���У�飨���һ����������ύ�ı�����formBean��formBean��װ���ύ�����ݣ�
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b = form.validate();
		
		//2.���У��ʧ�ܣ����ص���ҳ�棬����У��ʧ����Ϣ
		if (!b) {
			request.setAttribute("form", form);// form��ס���ϴ��ύ��������
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		
		//3.���У��ɹ��������Service�㴦��ע������
		User user = new User();
		//��formbean�����Կ�����user������ȥ��bean�Ŀ�������Ҫ�õ�BeanUtils��copyProperties()����
		WebUtils.copyBean(form, user);
		
		BusinessServiceImpl service = new BusinessServiceImpl();
		try {
			service.register(user);
			//6.���Service�㴦��ɹ�����ת����վ��ȫ����Ϣ��ʾҳ�棬Ϊ�û���ʾע��ɹ�����Ϣ
//			request.setAttribute("message", "��ϲ����ע��ɹ�");
			request.setAttribute("message", "��ϲ����ע��ɹ�������1���Ϊ���Զ�������¼ҳ�棡��<meta http-equiv='refresh' content='1;url="+request.getContextPath()+"/LoginUIServlet'");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (UserExistException e) {
			//4.���Service�㴦���ɹ������Ҳ��ɹ���ԭ������Ϊע���û��Ѵ��ڵĻ��������ص�ע��ҳ�棬��ʾע���û��Ѵ���
			form.getErrors().put("username", "ע����û����Ѵ���");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			//5.���Service�㴦���ɹ������Ҳ��ɹ���ԭ������Ϊ��������Ļ�������ת����վ��ȫ����Ϣ��ʾҳ�棬Ϊ�û���ʾ�Ѻô�����Ϣ
			e.printStackTrace();// �����쳣��Ҫ�׸��û������û����Ѻã�����Ӧ��try�����ں�̨��¼�쳣
			request.setAttribute("message", "����������δ֪����");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}



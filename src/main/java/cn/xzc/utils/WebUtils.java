package cn.xzc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtils {
	                                                             //RegisterForm.class
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass) {
		try {
			//1.����Ҫ��װ���ݵ�bean
			T bean = beanClass.newInstance();
			
			//2.��request�е���������bean��
			Enumeration<String> e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();   // username��password��email��birthday
				String value = request.getParameter(name);// aaa��123��aaa@sina.com.cn
				BeanUtils.setProperty(bean, name, value);
			}
			
			return bean;
		} catch (Exception e) {
			// ��һ������ʱ�쳣�͵��ˣ�û��Ҫ���������鷳
			throw new RuntimeException(e);
		}
	}
	
	/*
    private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private String nickname;
	
	private Map errors = new HashMap();
	--------------------------------------
	private String id;
	private String username;
	private String password;
	private String email;
	private Date birthday;
	private String nickname;
	*/
	public static void copyBean(Object src, Object dest) {
		//ע������ת����
		ConvertUtils.register(new Converter() {
			
			public <T> T convert(Class<T> type, Object value) {
				if (value == null) {
					return null;
				}
				
				String str = (String) value;
				if (str.trim().equals("")) {
					return null;
				}
				
				//1980-09-32
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return (T) df.parse(str);
				} catch (ParseException e) {
					/*
					 * �����쳣��һ��Ҫ֪ͨ��һ������׸��쳣����һ�㣬���ܴ�ӡ�ڿ���̨�ϡ�
					 * ���쳣�����ܶϣ������ԭ�����쳣��Ϣ��װ��ȥ���׳��쳣����һ�㣬��һ��ͻ�֪�����׳���ʲô���⡣
					 */
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
		
		try {
			/*
			 * �ڴ���Ŀ�У��Ǵ�formbean�����Կ�����user������ȥ����bean�Ŀ�����
			 * ����ʵ�ʿ����У��ǳ�ʵ�á�
			 */
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//����ȫ��Ψһ��ID
	public static String generateID() {
		// UUID�㷨������ϵͳ��������xx��ַ��CPU���������ͺŵȵ�����һ��128λ�����ַ���������ȷ����ȫ��Ψһ�ġ�
		return UUID.randomUUID().toString();
	}
	
}

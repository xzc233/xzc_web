package junit.test;

import java.util.Date;

import org.junit.Test;

import cn.xzc.domain.User;
import cn.xzc.exception.UserExistException;
import cn.xzc.impl.BusinessServiceImpl;

public class ServiceTest {

	@Test
	public void testRegister() {
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("yeer@qq.com");
		user.setId("102");
		user.setNickname("Ҷ��");
		user.setPassword("321");
		user.setUsername("yeer");
		
		BusinessServiceImpl service = new BusinessServiceImpl();
		try {
			service.register(user);
			System.out.println("ע��ɹ�������");
		} catch (UserExistException e) {
			System.out.println("�û��Ѵ���");
		}
	}
	
	@Test
	public void testLogin() {
		BusinessServiceImpl service = new BusinessServiceImpl();
		User user = service.login("yeer", "321");
		System.out.println(user);
	}
	
}
package junit.test;
import java.util.Date;

import org.junit.Test;

import cn.xzc.dao.UserDao;
import cn.xzc.impl.UserDaoImpl;
import cn.xzc.domain.User;

public class UserDaoTest {
	
	@Test
	public void testAdd() {
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("haha@qq.com");
		user.setId("101");
		user.setNickname("草拟");
		user.setPassword("321");
		user.setUsername("haha");
		
		UserDao dao = new UserDaoImpl();
		dao.add(user);
	}
	
	@Test
	public void testFind() {
		UserDao dao = new UserDaoImpl();
		dao.find("yeyi", "123");// 在断点模式Watch
	}
	
	@Test
	public void testFindByUsername() {
		UserDao dao = new UserDaoImpl();
		System.out.println(dao.find("hahadd"));
	}
}


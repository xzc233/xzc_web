package cn.xzc.impl;

import cn.xzc.dao.UserDao;
import cn.xzc.domain.User;
import cn.xzc.exception.UserExistException;
//对Web层提供所有的业务服务
public class BusinessServiceImpl {
	
	/*
	 * 业务逻辑层和数据访问层需要解耦。
	 * 要解耦，有两种方法：工厂设计模式   or Spring
	 */
	private UserDao dao = new UserDaoImpl();

	//对Web层提供注册服务
	public void register(User user) throws UserExistException {
		//先判断当前要注册的用户是否存在
		boolean b = dao.find(user.getUsername());
		if (!b) {
			/*
			 * Service层是由Web层来调用的，
			 * 发现当前要注册的用户已存在，要提醒给Web层，Web层给用户一个友好提示。
			 * 希望Web层一定要处理，处理之后给用户一个友好提示，所以抛一个编译时异常，
			 * 抛运行时异常是不行的，因为Web层可处理可不处理。
			 */
			throw new UserExistException();//发现要注册的用户已存在，则给Web层抛一个编译时异常，提醒Web层处理这个异常，给用户一个友好提示。
		} else {
			dao.add(user);
		}
	}
	
	//对Web层提供登录服务
	public User login(String username, String password) {
		return dao.find(username, password);
	}
	
}
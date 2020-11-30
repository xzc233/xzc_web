package cn.xzc.service;

import cn.xzc.domain.User;
import cn.xzc.exception.UserExistException;
public interface UserService {
	
	void registerUser(User user) throws UserExistException;
	
	User loginUser(String userName, String userPwd);
}

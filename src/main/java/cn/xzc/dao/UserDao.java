package cn.xzc.dao;

import cn.xzc.domain.User;

public interface UserDao {

	void add(User user);

	User find(String username, String password);

	//����ע����û��Ƿ������ݿ��д���
	boolean find(String username);

}
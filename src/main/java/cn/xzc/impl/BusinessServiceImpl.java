package cn.xzc.impl;

import cn.xzc.dao.UserDao;
import cn.xzc.domain.User;
import cn.xzc.exception.UserExistException;
//��Web���ṩ���е�ҵ�����
public class BusinessServiceImpl {
	
	/*
	 * ҵ���߼�������ݷ��ʲ���Ҫ���
	 * Ҫ��������ַ������������ģʽ   or Spring
	 */
	private UserDao dao = new UserDaoImpl();

	//��Web���ṩע�����
	public void register(User user) throws UserExistException {
		//���жϵ�ǰҪע����û��Ƿ����
		boolean b = dao.find(user.getUsername());
		if (!b) {
			/*
			 * Service������Web�������õģ�
			 * ���ֵ�ǰҪע����û��Ѵ��ڣ�Ҫ���Ѹ�Web�㣬Web����û�һ���Ѻ���ʾ��
			 * ϣ��Web��һ��Ҫ��������֮����û�һ���Ѻ���ʾ��������һ������ʱ�쳣��
			 * ������ʱ�쳣�ǲ��еģ���ΪWeb��ɴ���ɲ�����
			 */
			throw new UserExistException();//����Ҫע����û��Ѵ��ڣ����Web����һ������ʱ�쳣������Web�㴦������쳣�����û�һ���Ѻ���ʾ��
		} else {
			dao.add(user);
		}
	}
	
	//��Web���ṩ��¼����
	public User login(String username, String password) {
		return dao.find(username, password);
	}
	
}
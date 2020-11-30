package cn.xzc.dao;
import java.util.List;

import cn.xzc.domain.Order;

	public interface OrderDao {

		void add(Order o);

		/*
		 * ���鷳��һ������
		 * �������Ҫ��Order����Ļ�����Ϣ�һ�������Ҫ���û�����Ϣ�һ�������Ҫ�Ѷ�����������Ϣ�һ�����
		 * ��ô��Ҫ����4�ű�
		 * 
		 */
		Order find(String id);

		/*
		 * �鿴�Ѿ�������û�����Ķ�����Ϣ
		 * 
		 * statusΪtrue����ʾ�ѷ���
		 * statusΪfalse����ʾδ����
		 */
		List<Order> getAll(boolean status);
		
	}


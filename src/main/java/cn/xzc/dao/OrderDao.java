package cn.xzc.dao;
import java.util.List;

import cn.xzc.domain.Order;

	public interface OrderDao {

		void add(Order o);
		List<Order> getAll(boolean status);
		
	}


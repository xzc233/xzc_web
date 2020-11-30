package cn.xzc.service;
import java.util.Map;

import cn.xzc.dao.GoodDao;
import cn.xzc.domain.Good;
import cn.xzc.domain.Cart;
public class CustService {
	private GoodDao dao = new GoodDao();
	
	
	public Good findGood(String id) {
		return dao.find(id);
	}
	public void deleteCartItem(String id, Cart cart) {
		cart.remove(id);
	}
}

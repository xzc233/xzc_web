package cn.xzc.domain;
import java.util.*;
import java.util.Date;
import java.util.ArrayList;
public class OrderList {
	private List<Order>items=new ArrayList<Order>();
	public List<Order> getItems() {
		return items;
	}
 
	public void setItems(List<Order> items) {
		this.items = items;
	}
	public void add(Cart cart,User user) {
			Order order = new Order();
			order.setPrice(cart.getPrice());
			order.setOrdertime(new Date());
			order.setUser(user);
			items.add(order);
		
	}
}

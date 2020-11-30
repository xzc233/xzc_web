package cn.xzc.domain;

import java.util.Date;

public class Order {
	private Date ordertime;//下单时间
	private double price;//订单总价
	
	private User user;//记住下单人
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
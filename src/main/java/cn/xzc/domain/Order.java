package cn.xzc.domain;

import java.util.Date;

public class Order {
	private Date ordertime;//�µ�ʱ��
	private double price;//�����ܼ�
	
	private User user;//��ס�µ���
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
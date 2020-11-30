package cn.xzc.domain;
import java.util.*;

import java.util.ArrayList;

public class Cart {
	private List<ShopCar>items=new ArrayList<ShopCar>();
	private double price;//记住购物车中所有商品多少钱
	public List<ShopCar> getItems() {
		return items;
	}
 
	public void setItems(List<ShopCar> items) {
		this.items = items;
	}
	public void add(Good good) {
		//看购物车中有没有，要添加的书对应的购物项
		
		boolean isOk=false;
		int i=0;
		for(;i<items.size();i++){
			if(good.getId()==items.get(i).getGood().getId()){
				isOk=true;
				break;
			}
		}
		if (!isOk) {
			ShopCar good1 = new ShopCar();
			good1.setGood(good);
			good1.setQuantity(1);
			items.add(good1);
		} else {
			items.get(i).setQuantity(items.get(i).getQuantity() + 1);
		}
	}
	public void remove(String id){
		for(int i=0;i<items.size();i++){
			if(Integer.parseInt(id)==items.get(i).getGood().getId()){
				items.remove(i);
			}
		}
	}
	
	public double getPrice() {
		double totalPrice = 0;
		for(int i=0;i<items.size();i++) {
			ShopCar good=items.get(i);
			totalPrice += good.getPrice();
		}
		this.price = totalPrice;
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}


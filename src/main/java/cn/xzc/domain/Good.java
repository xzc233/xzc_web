package cn.xzc.domain;

	public class Good {
		private int id;
		private String name;
		private double price;
		private String description;
	
		public Good() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Good(int id, String name, double price, String description) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.description = description;
		}
		public int getId() {
			return id;
		}
		public void setId(int i) {
			this.id = i;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
}

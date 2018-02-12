package org.zerock.domain;


public class ProductVO {

	private String name;
	private double price;
	
	public ProductVO(String name, double price) {
		super();//java.lang.Object 클래스로 모든 클래스는 이것을 상속받아 구현한다. 부모생성자 호출
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "ProductVO [name="  + name + ", price=" + price + "]";
	}
	
}

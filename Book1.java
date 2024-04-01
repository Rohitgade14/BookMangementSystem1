package com.jsp.Entity1;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book1 {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	int id ;
	String name;
	int price;
	String auther;
	public Book1(int id, String name, int price, String auther) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.auther = auther;
	}
	public Book1() {
		super();
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	@Override
	public String toString() {
		return "Book1 [id=" + id + ", name=" + name + ", price=" + price + ", auther=" + auther + "]";
	}
	

}

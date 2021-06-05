package com.course.practicaljava.entity;

import java.time.LocalDate;

public class Car {
	private Boolean available;
	private String brand;
	private String color;
	private LocalDate firstReleaseData;
	private int price;
	private String type;
	
	public Car() {
		
	}
	public Car(String brand, String color, String type) {
		super();
		this.brand = brand;
		this.color = color;
		this.type = type;
	}
	public Boolean getAvailable() {
		return available;
	}
	public String getBrand() {
		return brand;
	}
	public String getColor() {
		return color;
	}
	public LocalDate getFirstReleaseData() {
		return firstReleaseData;
	}
	public int getPrice() {
		return price;
	}
	public String getType() {
		return type;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setFirstReleaseData(LocalDate firstReleaseData) {
		this.firstReleaseData = firstReleaseData;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", type=" + type + "]";
	}
	
	
}

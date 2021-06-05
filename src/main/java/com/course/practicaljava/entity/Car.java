package com.course.practicaljava.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Document(indexName = "practical-java")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Car {
	
	@JsonInclude(value = Include.NON_EMPTY)
	private List<String> additionalFeatures;
	private Boolean available;
	private String brand;
	private String color;
	@JsonUnwrapped
	private Engine engine;
	@Field(type = FieldType.Date, format = DateFormat.date)
	@JsonFormat(pattern = "yyyy-MM-dd") 
	private LocalDate firstReleaseData;
	@Id
	private String id;
	private int price;
	@JsonInclude(value = Include.NON_EMPTY)
	private String secretFeature;
	private String type;
	private List<Tyre> tyres;
	public Car() {
		
	}
	public Car(String brand, String color, String type) {
		super();
		this.brand = brand;
		this.color = color;
		this.type = type;
	}
	
	public List<String> getAdditionalFeatures() {
		return additionalFeatures;
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
	public Engine getEngine() {
		return engine;
	}
	public LocalDate getFirstReleaseData() {
		return firstReleaseData;
	}
	public String getId() {
		return id;
	}
	public int getPrice() {
		return price;
	}
	public String getSecretFeature() {
		return secretFeature;
	}
	public String getType() {
		return type;
	}
	public List<Tyre> getTyres() {
		return tyres;
	}
	public void setAdditionalFeatures(List<String> additionalFeatures) {
		this.additionalFeatures = additionalFeatures;
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
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public void setFirstReleaseData(LocalDate firstReleaseData) {
		this.firstReleaseData = firstReleaseData;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setSecretFeature(String secretFeature) {
		this.secretFeature = secretFeature;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setTyres(List<Tyre> tyres) {
		this.tyres = tyres;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", type=" + type + "]";
	}
	
	
}

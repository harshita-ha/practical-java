package com.course.practicaljava.service;

import java.util.Arrays;
import java.util.List;

import com.course.practicaljava.entity.Car;


public interface CarService {
	
	List<String> Brands = Arrays.asList("Toyota","Honda","Ford","BMW","Mitsubishi");
	List<String> Types = Arrays.asList("Sudan","SUV","HPV","Hatchback","Convertible");
	List<String> Colors = Arrays.asList("Red","Black","White","Silver","Blue");
	List<String> additionalFeatures = Arrays.asList("GPS","Alarm","Soundproof","Media","Leather Seats");
	List<String> Fuels = Arrays.asList("Petrol","Hybrid","Electric");
	List<String> tyreManufacturers = Arrays.asList("Goodyear","Bridgestone","Dunlop");
	Car generateCar();
}

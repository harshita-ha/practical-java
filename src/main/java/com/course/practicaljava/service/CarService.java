package com.course.practicaljava.service;

import java.util.Arrays;
import java.util.List;

import com.course.practicaljava.entity.Car;


public interface CarService {
	
	List<String> Brands = Arrays.asList("Toyota","Honda","Ford");
	List<String> Types = Arrays.asList("Sudan","SUV","HPV");
	List<String> Colors = Arrays.asList("Red","Black","White");

	Car generateCar();
}

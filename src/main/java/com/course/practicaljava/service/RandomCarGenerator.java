package com.course.practicaljava.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.course.practicaljava.entity.Car;

@Service
public class RandomCarGenerator implements CarService {

	@Override
	public Car generateCar() {
		
		String brand = Brands.get(ThreadLocalRandom.current().nextInt(0, Brands.size()));
		String type = Types.get(ThreadLocalRandom.current().nextInt(0, Types.size()));
		String color = Colors.get(ThreadLocalRandom.current().nextInt(0, Colors.size()));
		
		return new Car(brand, color, type);
	}

}

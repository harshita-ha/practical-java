package com.course.practicaljava.api.server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.practicaljava.entity.Car;
import com.course.practicaljava.service.CarService;

@RestController
@RequestMapping(value="/api/car/v1")
public class CarApiJava {
	
	@Autowired
	private CarService carService;
	
	@GetMapping(value="/random", produces = MediaType.APPLICATION_JSON_VALUE)
	public Car random() {
		return carService.generateCar();
	}
	
	@GetMapping(value = "/random-cars", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> getCars(){
		List<Car> carList = new ArrayList<>();
		for(int i=0;i<ThreadLocalRandom.current().nextInt(1, 10);i++) {
			carList.add(carService.generateCar());
		}
		return carList;
	}
	
	@PostMapping(value="/echo",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getCar(@RequestBody Car car) {
		return car.toString();
	}
}

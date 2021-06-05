package com.course.practicaljava.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.course.practicaljava.entity.Car;
import com.course.practicaljava.repository.CarElasticRepository;
import com.course.practicaljava.service.CarService;

@Component
public class CarElasticDatasource {
	
	@Autowired
	private CarElasticRepository carRepository;
	
	@Autowired
	@Qualifier("randomCarGenerator")
	private CarService carService;
	
	@Autowired
	@Qualifier("webClientElasticsearch")
	private WebClient webClient;
	
	@EventListener(ApplicationReadyEvent.class)
	public void populateData() {
		
		String response = webClient.delete().uri("/practical-java").retrieve().bodyToMono(String.class).block();
		
		List<Car>cars = new ArrayList<>();
		
		for(int i=0;i<10000;i++) {
			cars.add(carService.generateCar());
		}
		
		carRepository.saveAll(cars);
	}
}

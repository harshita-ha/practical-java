package com.course.practicaljava.api.server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.practicaljava.entity.Car;
import com.course.practicaljava.repository.CarElasticRepository;
import com.course.practicaljava.service.CarService;

@RestController
@RequestMapping(value="/api/car/v1")
public class CarApiJava {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private CarElasticRepository carRepository;
	
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
	
	@GetMapping(value = "/count")
	public String countCar() {
		return "There are  : "+carRepository.count()+" cars";
	}
	
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveCar(@RequestBody Car car)
	{
		String id=carRepository.save(car).getId();
		return "Saved with ID : " + id;
	}
	
	@GetMapping(value = "/{id}")
	public Car getCar(@PathVariable("id") String carId) {
		return carRepository.findById(carId).orElse(null);
	}
	
	@PutMapping(value = "/{id}")
	public String updateCar( @PathVariable("id") String carId, @RequestBody Car updatedCar) {
		updatedCar.setId(carId);
		Car newCar = carRepository.save(updatedCar);
		return "Updated car with ID : "+ newCar.getId();
	}
	
	@GetMapping(value = "/find-json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> findByBrandAndColor(@RequestBody  Car car, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue="10") int size){
		PageRequest pageable = PageRequest.of(page, size, Sort.by(Direction.DESC, "price"));
		return carRepository.findByBrandAndColor(car.getBrand(), car.getColor(), pageable);
	}
}

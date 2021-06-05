package com.course.practicaljava.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.course.practicaljava.entity.Car;
import com.course.practicaljava.entity.Engine;
import com.course.practicaljava.entity.Tyre;
import com.course.practicaljava.util.RandomDateUtil;

@Service
public class RandomCarGenerator implements CarService {
	
	@Override
	public Car generateCar() {
		
		String brand = Brands.get(ThreadLocalRandom.current().nextInt(0, Brands.size()));
		
		String type = Types.get(ThreadLocalRandom.current().nextInt(0, Types.size()));
		
		String color = Colors.get(ThreadLocalRandom.current().nextInt(0, Colors.size()));
		
		String fuels = Fuels.get(ThreadLocalRandom.current().nextInt(0,Fuels.size()));
		
		int price = ThreadLocalRandom.current().nextInt(5000, 12001);
		
		Boolean available = ThreadLocalRandom.current().nextBoolean();
		
		int horsePower = ThreadLocalRandom.current().nextInt(100, 221);
		
		Engine engine = new Engine(fuels, horsePower);
		
		List<Tyre> tyres = new ArrayList<>();
		
		String secretFeature = ThreadLocalRandom.current().nextBoolean() ? "Can Fly" : null; 
		
		for(int i=0;i<4;i++) {
			String tyreManufacturer = tyreManufacturers.get(ThreadLocalRandom.current().nextInt(0,tyreManufacturers.size()));
			int size= ThreadLocalRandom.current().nextInt(15, 18);
			int tyrePrice = ThreadLocalRandom.current().nextInt(200,401);
			Tyre tyre = new Tyre(tyreManufacturer, size, tyrePrice);
			tyres.add(tyre);
		}
		
		LocalDate randomDay = RandomDateUtil.generateRandom();
		
		List<String>additionalFeaturesTemp = new ArrayList<String>();
		
		int randomLastIdx = ThreadLocalRandom.current().nextInt(0,additionalFeatures.size());

		
		for(int i=0;i<randomLastIdx;i++) {
			additionalFeaturesTemp.add(additionalFeatures.get(i));
		}
		
		Car car=new Car(brand,type,color);
		
		car.setAvailable(available);
		
		car.setPrice(price);
		
		car.setFirstReleaseData(randomDay);
		
		car.setAdditionalFeatures(additionalFeaturesTemp);
		
		car.setEngine(engine);
		
		car.setTyres(tyres);
		
		car.setSecretFeature(secretFeature);
		
		return car;
	}

}

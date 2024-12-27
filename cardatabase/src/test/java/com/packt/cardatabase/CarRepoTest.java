package com.packt.cardatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CarRepoTest {
	
	@Autowired
	private CarRepository carRepository;
	
	public void saveTest() {
		carRepository.save(
			new Car("Ford","Mustang","Red","ADF-1121",2021,59000));
		carRepository.save(
			new Car("Nissan","Leaf","White","SSJ-3002",2019,29000));
		carRepository.save(
			new Car("Toyota","Prius","Silver","KKO-0212",2020,39000));
	}
	
	public void findAllTest() {
		for(Car car:carRepository.findAll()) {
			log.info(car.toString());
		}
	}
	
	@Test
	public void findByBrandTest() {
		for(Car car:carRepository.findByBrand("yota")) {
			log.info(car.toString());
		}
		
	}
	
}









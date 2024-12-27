package com.packt.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;

//스프링 부트로 RESTful웹 서비스 만들기
//Jackson라이브러리에 의해 JSON객체로 변환됩니다.

public class CarController {
	@Autowired
	private CarRepository carRepository;
	
	@RequestMapping("/cars")
	public Iterable<Car> getCars(){
		return carRepository.findAll();
	}
	
}

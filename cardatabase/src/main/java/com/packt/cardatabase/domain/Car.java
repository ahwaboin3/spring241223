package com.packt.cardatabase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String brand, model, color, registerNumber;
	private int year, price;
	
	//대일(ToOne)관계ㅒ에는 FetchType.LAZY를 정의해야 한다.
	//FetchType은 데이터베이스에서 데이터를 검색하는 전략을 정의한다.
	//지정 가능한 값은 즉시 검색을 의미하 EAGER또는 지연 검색을 의미하는
	//LAZY일 수 있다. 지연 검색은 데이터베이스에서 소유자를 검색하면
	//필요할 때에 해당 소유자와 연관된 모든 자동차를 검색한다는 뜻이다.
	//반면 즉시 검색은 해당 소유자의 모든 자동차를 즉시 검색한다.
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="owner")
	private Owner owner;
	
	public Car() {
	}
	
	public Car(String brand, String model, 
			String color, String registerNumber, 
			int year, int price, Owner owner) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registerNumber = registerNumber;
		this.year = year;
		this.price = price;
		this.owner=owner;
	}



	
	
	

}

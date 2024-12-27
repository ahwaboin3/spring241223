package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends
CrudRepository<Car, Long>{
	//@Query 어노테이션을 이용하면 sql문으로 쿼리를 만들 수도 있다.
	@Query("select c from Car c where c.brand like %?1")
	List<Car> findByBrand(String brand);
}

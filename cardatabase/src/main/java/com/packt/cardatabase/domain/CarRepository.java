package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// 쿼리 메소드를 포함하려면 리포지터리 클래스에 
//@RepositoryRestResource 어노테이션을 추가해야 한다.
// 쿼리 매개변수에는 @Param어노테이션을 지정한다.

@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface CarRepository extends
CrudRepository<Car, Long>{
	//브랜드로 자동차를 검색
	List<Car> findByBrand(@Param("brand")String brand);
	
	//색상으로 자동차를 검색
	List<Car> findByColor(@Param("color")String color);
	
	//@Query 어노테이션을 이용하면 sql문으로 쿼리를 만들 수도 있다.
	@Query("select c from Car c where c.brand like %?1")
	List<Car> findByBrandLike(String brand);
}

package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Item;

//Repository 설계하기
//Spring Data JPA에서는 엔티티 매니저를 직접 이용해 코드를 작성하지 않아도 됩니다.
//그 대신에 Data Access Object의 역활을 하는 Repository 인터페이스를 설계한 후
//사용하는 것만으로 충분합니다.
//JpaRepository를 상속합니다. JpaRepository는 2개의 제네릭 타입을 사용하는데
// 첫 번째에는 엔티티 타입 클래스를 넣어주고, 두 번째는 기본키 타입을 넣어줍니다.

// JpaRepository에서 지원하는 메소드
// 메소드 | 기능
// <S extends T> save(S entity) | 엔티티 저장 및 수정
// void delete(T entity) | 엔티티 삭제
// count() | 엔티티 총 개수 반환
// Iterable<T> findAll() | 모든 엔티티 조회
// Optional <T> findById (Long id)
public interface ItemRepository extends JpaRepository<Item, Long>{
	//쿼리 메소드
	//쿼리 메소드는 스프링 데이터 JPA에서 제공하는 핵심 기능 중 하나로 Repository
	//인터페이스에 간단한 네이밍 룰을 이용하여 메소드를 작성하면 원하는 쿼리를 실행할
	//있습니다.
	//네이밍 룰 중 find를 사용 한다.
	//find+(엔티티 이름)+By+변수이름
	//엔티티명은 생략이 가능합니다.
	//상품의 이름을 이용하여 데이터를 조회하는 메소드를 추가
	List<Item> findByItemNm(String itemNm);

}






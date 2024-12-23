package com.shop.entity;

import java.time.LocalDateTime;

import com.shop.constant.ItemSellStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//JPA란?
//JPA(Java Persistence API)는 자바 ORM 기술에 대한 API표준입니다.
//ORM이란 'Object Relational Mapping'의 약자로 객체와 관계형 데이터베이스를
//매핑해주는 것을 말합니다.

//엔티티
//엔티티(Entity)란 데니터베이스의 테이블에 대응하는 클래스라고 생각하시면 됩니다.
@Entity
@Getter
@Setter
@ToString
public class Item {
	
	@Id
	private Long id;
	private String itemNm;
	private int price;
	private int stockNumber;
	private String itemDetail;
	private ItemSellStatus itemSellStatus;
	private LocalDateTime regTime;
	private LocalDateTime updateTime;

}

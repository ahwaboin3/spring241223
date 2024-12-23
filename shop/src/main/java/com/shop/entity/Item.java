package com.shop.entity;

import java.time.LocalDateTime;

import com.shop.constant.ItemSellStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//JPA란?
//JPA(Java Persistence API)는 자바 ORM 기술에 대한 API표준입니다.
//ORM이란 'Object Relational Mapping'의 약자로 객체와 관계형 데이터베이스를
//매핑해주는 것을 말합니다.

//엔티티
//엔티티(Entity)란 데니터베이스의 테이블에 대응하는 클래스라고 생각하시면 됩니다.

// 엔티티 매핑 관련 어노테이션
// 어노테이션 | 설명
// @Entity | 클래스를 엔티티로 선언
// @Table | 엔티티와 매핑할 테이블을 지정
// @Id | 테이블의 기본 키에 사용할 속성을 지정
// @GeneratedValue | 키 값을 생성하는 전략 명시
// @Column | 필드와 컬럼 매핑
// @Lob | BLOB,CLOB 타입 매핑 
// CLOB과 BLOB의 의미
// CLOB이란 사이즈가 큰 데이터를 외부 파일로 저장하기 위한 데이터 타입입니다. 
// 문자형 대용량 파일을 저장하는데 사용하는 데이터 타입이라고 생각하면 됩니다.
// BLOB은 바이너리 데이터를 DB외부에 저장하기 위한 타입입니다. 이미지, 사운드, 비디오
// 같은 멀티미디어 데이터를 다룰 때 사용할 수 있습니다.
// @Enumerated | enum 타입 매핑

// @Column 어노테이션 추가 속성
// 속성 | 설명
// name | 필드와 매핑할 컬럼의 이름 설정
// unique | 유니크 제약 조건 설정
// insertable | insert 가능 여부
// updatable | update 가능 여부
// length | String 타입의 문자 길이 제약조건 설정
// nullable | null값의 허용 여부 설정, false설정 시 not null 제약조건 추가
// columnDefinition | 데이터베이스 컬럼 정보 직접 기술 예) @Column(
// columnDefinition="varchar(5) default '10' not null")

//@GeneratedValue어노테이션을 통한 기본키를 생성하는 전략 총 4가지
// 생성 전략 | 설명
// GenerationType.AUTO(default) | JPA 구현체가 자동으로 생성 전략 결정
// GenerationType.IDENTITY | 기본키 생성을 데이터베이스에 위임
// 예) MySql 데이터베이스의 경우 AUTO_INCREMENT를 사용하여 기본키 생성
// GenerationType.SEQUENCE | 데이터베이스 시퀀스 오브젝트를 이용한 기본키 생성
// @SequenceGenerator를 사용하여 시퀀스 등록 필요
// GenerationType.TABLE | 키 생성용 테이블 사용 @TableGeneratror 필용

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false, length=50)
	private String itemNm;
	@Column(nullable=false)
	private int price;
	@Column(nullable=false)
	private int stockNumber;
	@Lob
	@Column(nullable=false)
	private String itemDetail;
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus;
	private LocalDateTime regTime;
	private LocalDateTime updateTime;

}

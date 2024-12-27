package com.packt.cardatabase.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//테이블 간의 관계 추가
//일대다 관계를 만든다
//소유자 한 명이 자동차 여러 대를 가질 수 있지만, 한 자동차의 소유자는 한 명
//뜻이다.
@Entity
@Getter
@Setter
@ToString
//car테이블과 owner테이블 간의 일대다 관계 때문에 car테이블의 전체 가져오기가
//문제가 발생했습니다.
//자동차가 직렬화되면 연결된 소유자가 직렬화되고 이어서 그가 소유한 자동차가 다시
//직렬화되는식의 문제입니다.
//Owner클래스의 cars필드에 @JsonIgnore 어노테이션을 지정해서 직렬화 프로세스 중에
//cars필드를 무시하게 하는 것이다.
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ownerid;
	private String firstname, lastname;
	
	//cascade특성은 삭제 또는 업데이트 시 연속 효과가 적용되는 방법을
	//지정한다. 이 특성을 ALL로 설정하면 모든 작업이 연속 적용된다.
	//예를 들어, 소유자를 삭제하면 그 소유자와 연결된 모든 자동차도 함께
	//삭제된다. mappedBy="owner"특성 설정은 Car클래스에 있는 owner필드가
	//이 관계의 기본키임을 지정한다.
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
	private List<Car> cars;
	
	public Owner() {
		super();
	}

	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
	

}

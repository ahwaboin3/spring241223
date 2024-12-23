package com.example;

//스프링에서는 getter와 setter를 사용합니다.
public class UserDto {
	
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", age=" + age + "]";
	}

}

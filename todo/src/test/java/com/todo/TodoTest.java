package com.todo;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoTest {
	@Autowired
	TodoRepo todoRepo;
	
	@Test
	public void saveTodos() {
		Todo todo1=new Todo();
		todo1.setDone(false);
		todo1.setContent("React 공부하기");
		todo1.setCreatedDate(LocalDateTime.now());
		Todo todo2=new Todo();
		todo2.setDone(false);
		todo2.setContent("빨래 널기");
		todo2.setCreatedDate(LocalDateTime.now());
		Todo todo3=new Todo();
		todo3.setDone(false);
		todo3.setContent("노래 연습하기");
		todo3.setCreatedDate(LocalDateTime.now());
		todoRepo.save(todo1);
		todoRepo.save(todo2);
		todoRepo.save(todo3);
	}

}







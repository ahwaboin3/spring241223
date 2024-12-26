package com.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoSer {
	//자동 의존성 주입
	@Autowired
	private TodoRepo todoRepo;
	
	public void putTodo(Todo todo) {
		//데이터 처리
		todoRepo.save(todo);
	}

}





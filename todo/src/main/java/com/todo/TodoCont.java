package com.todo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TodoCont {
	
	@Autowired
	TodoSer todoSer;
	
	@GetMapping
	public String putTodo(Todo todo) {
		todo.setCreatedDate(LocalDateTime.now());
		todoSer.putTodo(todo);
		return "index";
	}
	
	@PostMapping
	public String putTodoPost(Todo todo) {
		todo.setCreatedDate(LocalDateTime.now());
		System.out.println(todo);
		return "index";
	}
}

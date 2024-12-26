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
	public String putToto(Todo todo) {
		todo.setCreatedDate(LocalDateTime.now());
		todoSer.putTodo(todo);
		return "index";
	}
	
	@PostMapping
	public String putTotoPost(Todo todo) {
		todo.setCreatedDate(LocalDateTime.now());
		System.out.println(todo);
		return "index";
	}
}

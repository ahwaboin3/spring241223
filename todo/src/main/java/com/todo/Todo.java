package com.todo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Todo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private boolean isDone;
	private String content;
	private LocalDateTime createdDate;
}

package com.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
// @Controller 처럼 @Entity라고 작성해야한다.
public class TodoEntity1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String date;

	@Column(length = 200)
	private String content;

	private Boolean completed;

	private Long customernum;

//	    @ManyToOne
//	    @JoinColumn(name= "num")
//	    private User user;

}
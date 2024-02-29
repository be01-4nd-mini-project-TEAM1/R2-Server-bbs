package com.todo.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TodoEntity2 { // 팀 테이블
	
	private Long personal_id; // 개인 식별
	
	private Long team_id;  // 팀 식별
	
	@Id
	@Column(name="content_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int content_id; // 글 번호
	
	@Column(length = 200)
	private String team_content;  // 내용
	
	private String date; // 지정 날짜
	
    private Boolean completed; // 완료 여부
	
//	private String nickname;

	
}


//{
//    "team_id" : 1,
//    "personal_id" : 1,
//    "completed" : false,
//    "date" : "2024-01-09",
//    "team_content" : "밥먹기"
//}



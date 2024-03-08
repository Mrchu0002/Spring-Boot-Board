package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import com.mysite.sbb.question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
	
	@Id //id 속성을 기본 키 값 지정
	@GeneratedValue(strategy = GenerationType.IDENTITY) //일일히 값을 입력하지 않아도 알아서 1씩 증가
	private Integer id;
	
	@Column(columnDefinition = "TEXT")
	private String content;	
	
	private LocalDateTime creatDate; // 카멜 케이스 형식 이름 실제컬럼명은 create_date 가 됨
	
	@ManyToOne //부모 자식관계를 갖는 구조에서 사용 ->  부모 : Question, 자식 : Answer
	private Question question;
	
}

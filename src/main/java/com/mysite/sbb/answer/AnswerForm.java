package com.mysite.sbb.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
	
	@NotEmpty(message = "내용입력은 필수 사항 입니다.")
	private String content;
}

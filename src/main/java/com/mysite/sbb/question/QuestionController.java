package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.answer.AnswerForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RequestMapping("/question")
@RequiredArgsConstructor //퀘스트레포지토리 생성자 사용을 위해 어노텐션을 적용
@Controller
public class QuestionController {
	
	//private final QuestionRepository questionRepository; 
	private final QuestionService questionService; //어노텐션에 의한 생성자 주입
	
	
	
	@GetMapping("/list")
	public String list(Model model) { 
		//List<Question> questionList = this.questionRepository.findAll();
		List<Question> questionList =this.questionService.getList();
		model.addAttribute("questionList",questionList); 
		/*
		  모델 객체에 값을담아두면 템플릿에서 사용이 가능
		  Model 객체는 따로 생성할 필요 없이 컨트롤러의 메서드에 매개변수로 지정하기만 하면 
		  스프링 부트가 자동으로 Model 객체를 생성한다.
		*/
		return "question_list";
	}
	
	@GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question",question);
        return "question_detail";
    }
	
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
	@GetMapping("/create")
	public String questionCreate(QuestionForm questionForm) {
		return "question_form";
	}
	
	@PostMapping("/create")
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "question_Form";
		}
		this.questionService.create(questionForm.getSubject(), questionForm.getContent());
		return "redirect:/question/list";
	}
	
}

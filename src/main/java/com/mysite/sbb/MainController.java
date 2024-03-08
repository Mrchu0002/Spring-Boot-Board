package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

	

@Controller
public class MainController {
	@GetMapping("/sbb")
	@ResponseBody
	public String index() {
		System.out.println("index");
		return "안녕하세요 sbb에 오신걸 환영 합니다!";
	}
	
	@GetMapping("/")
	public String root() { //기본 url인 http://localhost:8080 로 접속했을때 질문답변페이지가 메인으로 뜨게 하는 루트url방법
		return "redirect:/question/list";
	}
	
	
}

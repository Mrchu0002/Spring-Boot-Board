package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//@ <= 이것이붙은 것은 어노테인션
@Controller //헬로우컨트롤러클래스가 컨트롤러의 기능을 사용하겠다 이 어노텐션이 있어야 스프링부트프레임워크 활용가능
public class HellowController {
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello Spring Boot Board!";
	}

}

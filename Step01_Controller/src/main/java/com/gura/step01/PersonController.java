package com.gura.step01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. Controller 만들기
@Controller
public class PersonController {
	
	// 2. RequestMapping하기
	@RequestMapping("/person")
	public String person(HttpServletRequest request){
		
		// Model(data)
		String person = "지상몬";
		// Model을 request에 담고
		request.setAttribute("person", person);
		
		// 3. view 페이지로 forward이동
		return "person";
		
	}
}

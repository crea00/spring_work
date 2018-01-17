package com.gura.step01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. Controller만들기
@Controller
public class FortuneController {

	// 2. 요청 Mapping (.do를 뺀 나머지 요청명을 적는다.)
	@RequestMapping("/fortune")
	public String fortune(HttpServletRequest request){
		// Model(data)을 request에 담기
		String fortuneToday = "동쪽으로 가면 귀인을 만나여";
		request.setAttribute("fortuneToday", fortuneToday);
		
		// 3. view 페이지 정보 리턴하기
		// /WEB-INF/views/ + fortune + .jsp 형식으로 바뀐다.
		return "fortune";
	}
}

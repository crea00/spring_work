package com.gura.quiz01;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request){
		
		List<String> news = new ArrayList<String>();
		news.add("하나");
		news.add("하나");
		news.add("하나");
		
		request.setAttribute("news", news);
		
		return "home";
	}
	}
	

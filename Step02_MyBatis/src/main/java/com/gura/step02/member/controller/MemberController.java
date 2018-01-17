package com.gura.step02.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping
	public String list(){
		
		
		return "member/list";
	}
}

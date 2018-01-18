package com.gura.step02.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step02.member.dto.MemberDto;
import com.gura.step02.member.service.MemberService;

// Controller를 Bean으로 만들기, Controller에서는 직접 Dao를 access하지 않고 service를 이용한다.
@Controller
public class MemberController {

	// 의존객체 주입받기, Controller는 Service에 의존한다.(by Autowired annotation)
	@Autowired
	private MemberService service;
	
	/*
	 * 	Controller에서 폼 전송되는 파라미터를 추출하는 방법 3가지
	 * 	1. 
	 */
	public ModelAndView insert1(HttpServletRequest request){
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		return null;
	}
	
	// @RequestParam을 이용해서 파라미터 추출된 값 전달받기
	public ModelAndView insert2(@RequestParam String name, @RequestParam String addr){
		return null;
	}
	
	// @ModelAttribute를 이용해서 추출된 파라미터가 들어간 dto 전달받기
	@RequestMapping("/member/insert")
	public ModelAndView insert3(@ModelAttribute MemberDto dto){
		
		ModelAndView mView = service.insert(dto);
		/*
		 * 	Redirect 이동
		 * 	
		 * 	redirect : 요청경로
		 * 
		 */
		// 문자열을 리턴하거나 mView의 setViewName을 이용하여 리턴하면 된다.
		
		// mView.setViewName("redirect:/member/list.do);
		
		// forward 이동
		mView.setViewName("member/alert");
		return mView;
	}
	
	// 회원추가폼 요청 처리
	@RequestMapping("/member/insertform")
	public String insertForm(){
		/*
		 * 	String type을 리턴하면 view페이지의 정보를 의미한다.
		 *	/WEB-INF/views/member/insertform.jsp
		 */
		
		return "member/insertform";
	}

	@RequestMapping("/member/list") // http://localhost:8888/step02/ "member/list" .do (앞에 /이 꼭 붙어야함)
	public ModelAndView list(){
		
		// MemberService객체를 이용해서 ModelAndView객체를 리턴받는다
		ModelAndView mView = service.getList();
		
		// Service객체가 리턴해준 ModelAndView객체에 View page정보 담기
		mView.setViewName("member/list"); // forward이동, /WEB-INF/views/ "member/list" .jsp (앞에 /이 붙으면 안됨), servlet-context.xml에 설정되어있음
		// view페이지가 WEB-INF에 있는 이유는 사용자가 직접 요청을 못하게 하기 위해서임, Controller를 꼭 거쳐야함
		
		// Model과 View 페이지의 정보를 함께 담고 있는 ModelAndView객체를 리턴해준다.
		return mView;
	}
}

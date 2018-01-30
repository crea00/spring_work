package com.gura.step04.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.cafe.dto.CafeDto;
import com.gura.step04.cafe.service.CafeService;

@Controller
public class CafeController {

	@Autowired
	private CafeService cafeService;
	
	@RequestMapping("/cafe/list")
	public ModelAndView list(HttpServletRequest request){
		ModelAndView mView = cafeService.list(request);
		mView.setViewName("cafe/list");
		return mView;
	}
	
	@RequestMapping("/cafe/insertform")
	public ModelAndView authInsertForm(HttpServletRequest request){
		
		return new ModelAndView("cafe/insertform");
	}
	
	// Cafe 글 저장 요청 처리
	@RequestMapping("/cafe/insert")
	public ModelAndView authInsert(HttpServletRequest request, @ModelAttribute CafeDto dto){
		/*
		 * 	인자로 전달된 CafeDto 객체에는 title, content가 들어있다.
		 * 	writer는 session에서 읽어서 넣어준다.
		 */
		String writer = (String)request.getSession().getAttribute("id");
		dto.setWriter(writer);
		// 서비스를 이용해서 DB에 저장
		cafeService.insert(dto);
		
		// 글목록 보기로 redirect해준다.
		return new ModelAndView("redirect:/cafe/list.do");
	}
	
	// 글 자세히보기 요청 처리
	@RequestMapping("/cafe/detail")
	public ModelAndView detail(HttpServletRequest request){
		ModelAndView mView = cafeService.detail(request);
		
		mView.setViewName("cafe/detail");
		return mView;
	}
	
	// 글 삭제 요청 처리 
	@RequestMapping("/cafe/delete")
	public ModelAndView authDelete(HttpServletRequest request, @RequestParam int num){
		
		cafeService.delete(num);
		
		return new ModelAndView("redirect:/cafe/list.do");
	}
	
	// 카페 글 수정 폼 요청 처리
	@RequestMapping("/cafe/updateform")
	public ModelAndView authUpdateForm(HttpServletRequest request, @RequestParam int num){
		
		ModelAndView mView = cafeService.detail(num);
		mView.setViewName("cafe/updateform");
		
		return mView;
	}
	
	// 글 수정 요청처리
	@RequestMapping("/cafe/update")
	public ModelAndView authUpdate(HttpServletRequest request, @ModelAttribute CafeDto dto){
		
		cafeService.update(dto);
		
		// 수정 결과 페이지로 이동하면서 글번호를 가지고간다.
		ModelAndView mView = new ModelAndView();
		
		mView.addObject("num", dto.getNum());
		mView.setViewName("cafe/update_result");
		
		return mView;
	}
	
	// 댓글을 추가하는 요청 처리
	@RequestMapping("/cafe/comment_insert")
	public ModelAndView authCommentInsert(HttpServletRequest request){
		cafeService.commentInsert(request);
		
		// 글번호를 읽어와서 글 자세히 보기 페이지로 redirect 이동
		String num = request.getParameter("ref_group");
		
		return new ModelAndView("redirect:/cafe/detail.do?num=" + num);
	}
}

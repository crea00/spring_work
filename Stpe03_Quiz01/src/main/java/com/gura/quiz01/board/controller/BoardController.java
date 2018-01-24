package com.gura.quiz01.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.quiz01.board.dto.BoardDto;
import com.gura.quiz01.board.service.BoardService;

@Controller
public class BoardController {

	// 의존객체 주입받기
	@Autowired
	private BoardService service;
	
	
	
	@RequestMapping("/board/update")
	public ModelAndView update(@ModelAttribute BoardDto dto){
		ModelAndView mView = service.update(dto);
		mView.setViewName("redirect:/board/list.do");
		return mView;
	}
	

	@RequestMapping("/board/updateform")
	public ModelAndView updateForm(@RequestParam int num){
		ModelAndView mView = service.getData(num);
		mView.setViewName("board/updateform");
		return mView;
	}
	
	@RequestMapping("/board/delete")
	public String delete(@RequestParam int num){
		service.delete(num);
		return "redirect:/board/list.do";
	}
	
	@RequestMapping("/board/list")
	public ModelAndView list(){
		
		ModelAndView mView = service.getList();
		mView.setViewName("board/list");
		return mView;
	}
	
	@RequestMapping("/board/insert")
	public ModelAndView insert(@ModelAttribute BoardDto dto){
		ModelAndView mView = service.insert(dto);
		mView.setViewName("redirect:/board/list.do");
		return mView;
	}
	
	@RequestMapping("/board/insertform")
	public String insertform(){
		return "board/insertform";
	}
}

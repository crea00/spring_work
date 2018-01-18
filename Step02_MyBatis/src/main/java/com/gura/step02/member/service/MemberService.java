package com.gura.step02.member.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.step02.member.dto.MemberDto;

public interface MemberService {
	public ModelAndView insert(MemberDto dto);
	public ModelAndView update(MemberDto dto);
	public ModelAndView delete(int num);
	public ModelAndView getData(int num);
	public ModelAndView getList();

}

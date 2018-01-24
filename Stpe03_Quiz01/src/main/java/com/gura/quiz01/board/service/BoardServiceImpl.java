package com.gura.quiz01.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.quiz01.board.dao.BoardDao;
import com.gura.quiz01.board.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao dao;
	
	@Override
	public ModelAndView insert(BoardDto dto) {
		// 회원정보 저장
		dao.insert(dto);
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto", dto);
		return mView;
	}

	@Override
	public ModelAndView update(BoardDto dto) {
		dao.update(dto);
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto", dto);
		return mView;
	}

	@Override
	public void delete(int num) {
		dao.delete(num);
		
	}

	@Override
	public ModelAndView getList() {
		// Dao를 이용해서 글목록을 얻어온다.
		List<BoardDto> list = dao.getlist();
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("list", list);
		return mView;
	}

	@Override
	public ModelAndView getData(int num) {
		BoardDto dto = dao.getData(num);
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto", dto);
		return mView;
	}

}

package com.gura.quiz01.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.quiz01.board.dto.BoardDto;

// 1. BoardDaoImpl 객체가 Spring Bean Container에 등록되도록 @Repository를 써준다.
@Repository
public class BoardDaoImpl implements BoardDao{
	
	// 2. Spring Bean Container에서 핵심의존객체인 session객체를 주입받을 수 있도록
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(BoardDto dto) {
		session.insert("board.insert", dto);
		
	}

	@Override
	public void update(BoardDto dto) {
		session.update("board.update", dto);
		
	}

	@Override
	public void delete(int num) {
		session.delete("board.delete", num);
		
	}

	@Override
	public List<BoardDto> getlist() {
		List<BoardDto> list = session.selectList("board.getList");
		return list;
	}

	@Override
	public BoardDto getData(int num) {
		BoardDto dto = session.selectOne("board.getData", num);
		return dto;
	}

}

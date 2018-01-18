package com.gura.step02.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.step02.member.dto.MemberDto;

// Dao를 implements하는 메소드는 @Repository annotation을 붙인다.
// 1. MemberDaoImpl 객체가  Spring Bean Container에 등록되도록 
// @Repository annotation이 있고 servlet-context.xml문서에서 component scan이 일어나면 Bean이 된다.
@Repository
public class MemberDaoImpl implements MemberDao {
	
	// 2. Spring Bean Container에서 주입받을 수 있도록 
	@Autowired
	private SqlSession session;	// 핵심 의존객체
	
	
	@Override
	public void insert(MemberDto dto) {
		session.insert("member.insert", dto);
		
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update", dto);
		
	}

	@Override
	public void delete(int num) {
		session.delete("member.delete", num);
		
	}

	@Override
	public List<MemberDto> getlist() {
		List<MemberDto> list = session.selectList("member.getList");
		return list;
	}

	@Override
	public MemberDto getData(int num) {
		MemberDto dto = session.selectOne("member.getData", num);
		return dto;
	}

}

package com.gura.step02.member.dao;

import java.util.List;

import com.gura.step02.member.dto.MemberDto;

/*
 *	MemberDaoImpl 클래스가 구현할 인터페이스 정의하기
 */
public interface MemberDao {
	public void insert(MemberDto dto);
	public void update(MemberDto dto);
	public void delete(int num);
	public List<MemberDto> getlist();
	public MemberDto getData(int num);
}
package com.gura.step02.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step02.member.dao.MemberDao;
import com.gura.step02.member.dto.MemberDto;

// 1.  
@Service
public class MemberServiceImpl implements MemberService {
	
	// 2.
	// service는 dao에 의존하고 있으므로 dao를 주입받기 위해 @Autowired annotation을 쓴다
	@Autowired
	private MemberDao dao;
	
	@Override
	public ModelAndView insert(MemberDto dto) {
		// 회원정보 저장
		dao.insert(dto);
		
		// ModenAndView 객체를 생성해서
		ModelAndView mView = new ModelAndView();
		
		// msg라는 키값으로 String type을 담는다.
		mView.addObject("msg", "저장했습니다");

		// 리턴한다.
		return mView;
	}

	@Override
	public ModelAndView update(MemberDto dto) {
		dao.update(dto);
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("msg", "회원정보를 수정했습니다.");
		
		return mView;
	}

	@Override
	// return값을 void로 하려면 interface에서 return값을 수정해야 한다.
	public void delete(int num) {
		// Dao를 이용해서 삭제한다.
		dao.delete(num);
	
	}

	@Override
	public ModelAndView getData(int num) {
		
		// 수정할 회원의 정보를 얻어와서 
		MemberDto dto = dao.getData(num);
		// ModelAndView객체에 담고
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto", dto);
		// 리턴해준다.
		return mView;
	}

	@Override
	public ModelAndView getList() {
		// Dao를 이용해서 회원목록을 얻어온다.
		List<MemberDto> list = dao.getlist();
		
		ModelAndView mView = new ModelAndView();
		// Model을 list라는 키값으로 담는다.(JSP의 request.setAttribute와 같다)
		mView.addObject("list", list);
		// 여기서 View page의 정보를 설정하는 것 보다는 Controller에서 View page의 정보를 설정하는 것이 더 낫다
		//mView.setViewName("member/list");
		
		// Model이 담긴 ModelAndView객체를 리턴해준다
		return mView;
	}

}

package test.service;

import org.springframework.stereotype.Service;

// Annotation을 붙이고 component scan을 이용해서 bean이 된다.
@Service
public class MemberServiceImpl implements MemberService {

	@Override
	public void insert() {
		System.out.println("회원정보를 저장합니다.");
		
	}

	@Override
	public void select() {
		System.out.println("회원정보를 출력합니다.");
		
	}

}

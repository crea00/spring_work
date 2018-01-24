package test.main;
/*
 * 	Aspect Oriented Programming (AOP)
 * 
 * 	- 핵심 비즈니스 로직과 상관없는 작업을 처리할 때 주로 이용한다.
 * 	- cross-cutting concern(공통 관심 사항 <-> core concern(핵심 관심 사항))을 만들어서 원하는 곳에 적용시킴
 * 
 * 	1. 로그 출력
 * 	2. 인증 작업 (ex. 로그인 필터를 쓰지 않고 AOP를 이용해서 인증작업을 처리할 수 있다.) -> controller에 AOP를 적용
 * 	3. 트랜젝션 관리 등 -> service에 AOP적용
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.service.MemberService;

public class MainClass {
	public static void main(String[] args) {
		// init.xml 문서를 읽어들여서 bean으로 만들기
		ApplicationContext context = new ClassPathXmlApplicationContext("+test/main/init.xml");
		//만들어진 bean 중에서 MemberService Type 얻어오기
		MemberService mService = context.getBean(MemberService.class);
		// 메소드 호출하기
		mService.insert();
		System.out.println("-----------");
		mService.select();
	}
}

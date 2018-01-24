package test.main;
/*
 * 	Aspect Oriented Programming (AOP)
 * 
 * 	- 핵심 비즈니스 로직과 상관없는 작업을 처리할 때 주로 이용한다.
 * 	- cross concern(횡단 관심사)을 만들어서 원하는 곳에 적용시킴
 * 
 * 	1. 로그 출력
 * 	2. 인증 작업 (ex. 로그인 필터를 쓰지 않고 AOP를 이용해서 인증작업을 처리할 수 있다.)
 * 	3. 트랜젝션 관리 등
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.service.BoardService;
import test.service.MemberService;

public class MainClass2 {
	public static void main(String[] args) {
		// init.xml 문서를 읽어들여서 bean으로 만들기
		ApplicationContext context = new ClassPathXmlApplicationContext("test/main/init.xml");
		
		BoardService bService = context.getBean(BoardService.class);
		
		bService.insert();
		System.out.println("==============");
		bService.select();
		
	}
}

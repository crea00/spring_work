package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.service.BoardService;
import test.service.MemberService;

public class MainClass2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("test/main/init.xml");
		
		// org.springframework.beans.factory.NoSuchBeanDefinitionException => spring container에 bean이 없다는 뜻
		// class에 @Service annotation이 없으면 에러가 발생할 수 있다.
		BoardService bService = context.getBean(BoardService.class);
		
		bService.insert();
		System.out.println("==============");
		bService.select();
		
	}

}

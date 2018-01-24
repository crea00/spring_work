package test.aspect;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * 	-Aspectj Expression
 * 
 * 	1. execution(public * *(..)) => 접근 지정자가 public 인 메소드가 
 * 	   point cut
 * 	2. execution(* test.service.*.*(..))
 * 	3. execution(public void insert*(..))
 * 		=> 접근 지정자는 public 리턴 type 은 void 이고 메소드명이 
 * 		insert 로 시작하는 모든 메소드가 point cutol99
 * 	4. execution(* delete*(*))
 * 		=> 메소드 명이 delete 로 시작하고 인자로 1개 전달받는 메소드가 
 * 		point cut
 * 	5. execution(* delete*(*,*))
 * 		=> 메소드 명이 delete 로 시작하고 인자로 2개 전달받는 메소드가 
 *      point cut
 */

@Component
@Aspect
public class writingAspect {
	
	@Before("execution(public void write*(..))")
	// 특정 메소드가 실행되기 바로 이전
	public void preparePen(){
		System.out.println("펜을 준비해서 뚜껑을 열어요");
	}
	
	@After("execution(public void write*(..))")
	// 특정 메소드가 끝나고 리턴된 뒤 바로 이후
	public void endPen(){
		System.out.println("펜의 뚜껑을 닫고 정리를 해요");
	}
	/*
	 * 	ProceedingJoinPoint 객체는 @Around에서만 지원된다.
	 */
	
	@Around("execution(public void *ToTeacher(..))")
	public void aroundPen(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Pen 준비");	// Before
		
		// AOP가 적용된 메소드에 전달된 인자 배열 받아오기(인자가 여러개일 수도 있기 때문)
		Object[] args = joinPoint.getArgs();
		// 인자들이 담긴 배열에서 값을 하나씩 빼서 		
		for(Object tmp:args){
			// 만일 객체가 String type이라면
			if(tmp instanceof String){
				String name = (String)tmp; // casting
				System.out.println("메소드에 전달된 name : " + name);
			}
		}
		joinPoint.proceed();	// 핵심 로직 수행, 여기를 기준으로 before, after이 나뉜다
		
		System.out.println("Pen 마무리");		// After
	}
	
	@Around("execution(public java.util.Map *ToMother())")
	public Object aroundMother(ProceedingJoinPoint joinPoint) throws Throwable{
		
		Object obj = joinPoint.proceed();
		
		// 리턴된 객체가 Map type이라면
		if(obj instanceof Map){
			// 원래 type으로 casting해서
			Map<String, Object> map = (Map)obj;
			// Map에 저장된 데이터 읽어와 보기
			String msg = (String)map.get("msg");
			System.out.println("msg : " + msg);
			// Map에 저장된 데이터 수정하기
			map.put("msg", "안녕 엄마");
		}
		return obj;
	}
}

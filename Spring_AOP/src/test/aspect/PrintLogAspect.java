package test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class PrintLogAspect {

	public Object printLog (ProceedingJoinPoint joinPoint) throws Throwable{

		System.out.println("비즈니스 로직을 수행하기 직전입니다.");
		
		// 로직 수행
		Object obj = joinPoint.proceed();
		
		System.out.println("비즈니스 로직을 수행했습니다.");
		
		return obj;
	}
	
	// 메소드를 하나 더 만들어서 select 메소드에 적용해보세요.
	public Object printLog2(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Select 로직을 수행하기 직전입니다.");
		
		Object obj = joinPoint.proceed();
		
		System.out.println("Select 로직을 수행했습니다.");
		
		return obj;
	}
}

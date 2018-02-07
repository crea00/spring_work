package com.gura.step04.shop.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.gura.step04.exception.MyException;
import com.gura.step04.exception.NoDeliveryException;

/*
 *	Exception을 처리하는 Controller
 *	예외를 독립적인 객체에서 처리하기 위해서는 ControllerAdvice Annotation을 사용한다.
 */
@ControllerAdvice
public class ExceptionController {
	
	// MyException type의 예외가 발생했을 때 호출되는 메소드
	@ExceptionHandler(MyException.class)
	public ModelAndView handleMyException(MyException me){
		ModelAndView mView = new ModelAndView();
		mView.addObject("exception", me);
		mView.setViewName("error/my");
		return mView;
	}

	
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView handleDataAccessException(DataAccessException dae){
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("exception", dae);
		mView.setViewName("error/data_access");
		return mView;
	}
}


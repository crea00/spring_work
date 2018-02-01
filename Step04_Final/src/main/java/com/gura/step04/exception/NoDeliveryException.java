package com.gura.step04.exception;

import org.springframework.dao.DataAccessException;
/*
 * 	Dao 객체에서 특정 상황에서 발생시킬 Exception 클래스 정의하기
 * 	@Repository(Dao)에서 작업을 하다가 exception이 발생하면 DataAcessException이 발생
 */
public class NoDeliveryException extends DataAccessException {

	public NoDeliveryException(String msg) {
		super(msg);	// 부모생성자에 문자열(예외 메세지) 넘겨주기
	}

}

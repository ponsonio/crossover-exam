package com.crossover.exception;

/**
 * Bussiness Excetions
 * @author koki
 *
 */
public class BusinessException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2129824018615727624L;


	public BusinessException(String message){
		super(message);
	}
	
	
	public BusinessException(String message, Exception cause){
		super(message, cause);
	}

}

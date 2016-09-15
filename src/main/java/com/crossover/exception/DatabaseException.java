package com.crossover.exception;

/**
 * Any data exception catched
 * @author koki
 *
 */
public class DatabaseException extends Exception {

		/**
	 * 
	 */
	private static final long serialVersionUID = 8665708945629631224L;


		public DatabaseException(String message){
			super(message);
		}
		
		
		public DatabaseException(String message, Exception cause){
			super(message, cause);
		}
}

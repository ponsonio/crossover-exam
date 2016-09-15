package com.crossover.bo;

import org.springframework.stereotype.Component;


/**
 * Class to generate an validate tokens
 * @author koki
 *
 */
@Component
public class TokenBO {

	//TODO:Implement this with a token generator and database 

	String token = "QWERTY" ;
	
	/**
	 * Get a valid token
	 * @return
	 */
	public String getToken() {
		//TODO:Here you call the generator and save the token to the database 
		return token ;
	}
	
	/**
	 * Validates the token
	 * @param token
	 * @return
	 */
	public boolean validateToken(String token){
		//TODO:Here you find if the token is valid 
		return this.token.equalsIgnoreCase(token);
	}
	
}

package com.crossover.services.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.bo.TokenBO;
import com.crossover.log.Logger;
/**
 * Security resources services
 * @author koki
 *
 */
@Controller
@RequestMapping("security")
public class SecurityServices {

	@Autowired
	private TokenBO tokenBO;
	
	
	/**
	 * Login service, returning an authentication token
	 * @param user
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public String login(
			@RequestParam(value = "user") String user,
				@RequestParam(value = "password") String password) {
		try{
			//TODO Validate the user
			return  "{ \"token\":\"" + tokenBO.getToken() + "\"}";
		}catch(Exception e){
			Logger.logError("Error getting a token :", e);
			return null;
		}
	}
	
	/**
	 * Get a token
	 * @param user
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/token", method = RequestMethod.GET)
	@ResponseBody
	public String getToken(
			@RequestParam(value = "user") String user,
				@RequestParam(value = "password") String password) {
		try{
			//TODO Validate the user
			return "{ \"token\":\""+ tokenBO.getToken()+ "\"}";
		}catch(Exception e){
			Logger.logError("Error getting a token :", e);
			return null;
		}
	}
	
	/**
	 * Verify a token
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/verify", method = RequestMethod.GET)
	@ResponseBody
	public boolean validateToken(@RequestParam(value = "token") String token) {
		try{
			return tokenBO.validateToken(token);
		}catch(Exception e){
			Logger.logError("Error validating a token :", e);
			return false;
		}
	}

	
}

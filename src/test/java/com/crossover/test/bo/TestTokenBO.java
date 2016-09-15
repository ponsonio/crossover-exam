package com.crossover.test.bo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crossover.bo.TokenBO;
import com.crossover.dao.AirportDao;

import junit.framework.Assert;


/**
 * Test the business logic of tokenBO
 * @author koki
 *
 */
@ContextConfiguration(locations = "classpath:persistence-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTokenBO {

	  @Autowired
	  private TokenBO tokenBO;
	
	  /**
	   * Test the token generation and validation
	   */
	 @Test
	 public void TestTokenBO() {
		try{
			String token = tokenBO.getToken();
			boolean valid = tokenBO.validateToken(token);
			Assert.assertEquals(valid, true);
			
			token = "ABC";
			valid = tokenBO.validateToken(token);
			Assert.assertEquals(valid, false);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}

package com.crossover.test.bo;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.crossover.bo.AirportBO;
import com.crossover.dao.AirportDao;
import com.crossover.entity.Airport;
import com.crossover.exception.DatabaseException;
import com.crossover.log.Logger;

/**
 * Test the business operations of airport BO
 * @author koki
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TestAirportBO {

	
	/**
	 * The other methods are not tested as you will be testing hibernate and spring
	 */
	
	  @Mock
	  AirportDao airportDao;
	  
	  @InjectMocks
	  AirportBO airportBO;
	  
	/**
	 * Test the airport listing  
	 * @throws DatabaseException
	 */
	@Test
	public void testgetAirports() throws DatabaseException{
		 try{
			  	List<Airport> listAirportResul ;
			  	List<Airport> listAirportResulDao = new ArrayList<Airport>() ;
			  	
			  	Airport r1 = new Airport();
			  	Airport r2 = new Airport() ;
		 
			  	listAirportResulDao.add(r1) ;
			  	listAirportResulDao.add(r2);
			  	
			    when(airportDao.getAirports()).thenReturn(listAirportResulDao);
			  	
			  	
			    listAirportResul = airportBO.getAirports();
				
			    Assert.assertEquals(listAirportResul.size(),2); 
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
	 



}

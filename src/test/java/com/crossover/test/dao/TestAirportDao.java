package com.crossover.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.dao.AirportDao;
import com.crossover.entity.Airport;
import com.crossover.exception.DatabaseException;

/**
 * Test the data access related to Airport Data Access
 * @author koki
 *
 */
@ContextConfiguration(locations = "classpath:persistence-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAirportDao {

	 @Autowired
	  private AirportDao  airportDao;
	  
	 /**
	  * Test the list of airpots
	  */
	    @Test
	    @Transactional
	    //@Rollback(true)
	    public void testgetAirports()
	    {
	        List<Airport> list;
			try {
				list = airportDao.getAirports();
		        Assert.assertEquals(3,list.size());
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
	    
	    /**
	     * Test getting an specific airport
	     */
	    @Test
	    @Transactional
	    //@Rollback(true)
	    public void testgetAirport()
	    {
	        Airport airport;
			try {
				airport = airportDao.getAirport((long) 1);
		        Assert.assertEquals(airport.getId(),1);
		        airport = airportDao.getAirport((long) 1000);
		        Assert.assertEquals(airport,null);
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
	    
	    /**
	     * Test the creation of an Airport
	     */
	    @Test
	    @Transactional
	    //@Rollback(true)
	    public void testcreateAirport()
	    {
	        Airport airport = new Airport();
			try {
				airport.setCode("C-004");
				airport.setCity("Arequipa");
				airport.setCountry("Peru");
				airport.setAdress("Javier Prado 1233");
				airport.setName("Miguel Grau");
				
				airportDao.createAirport(airport);

				
				//second test
				//try to insert it again
				
				try {
					airportDao.createAirport(airport);
				}catch(DatabaseException e){
					System.out.println(e.getMessage());
					Assert.assertEquals(e.getMessage(),"An error creating an airport");
				}
				
				
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
	    
	    
	    /**
	     * Test the deletetion of an airport
	     */
	    @Test
	    @Transactional
	    //@Rollback(true)
	    public void testdeleteAirport()
	    {
	        Airport airport = new Airport();
			try {
				airport.setId(1);;
				
				airportDao.deletetAirport((long)1);

			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
}

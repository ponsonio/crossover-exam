package com.crossover.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crossover.dao.AirportDao;
import com.crossover.entity.Airport;
import com.crossover.exception.DatabaseException;
import com.crossover.log.Logger;

/**
 * Bussiness logic for the airport object
 * @author koki
 *
 */
@Component
public class AirportBO {
	


	  @Autowired
	  private AirportDao airportDao;

	public AirportBO() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	/**
	 * Get a list of all Registered Airports
	 * @return
	 * @throws DatabaseException
	 */
	public List<Airport> getAirports() throws DatabaseException{
		try{
			return airportDao.getAirports() ;
		}catch(DatabaseException e){
			Logger.logError("Error listing airports :", e);
			throw e;
		}
	}
	 
	/**
	 * Gets an airpot by id
	 * @param id
	 * @return
	 * @throws DatabaseException
	 */
	public Airport getAirport(Long id) throws DatabaseException{
		try{
			return airportDao.getAirport(id) ;
		}catch(DatabaseException e){
			Logger.logError("Error listing airports :", e);
			throw e;
		}
	}
	  
	/**
	 * Deletes an aipor by id
	 * @param id
	 * @throws DatabaseException
	 * @throws Exception
	 */
	public void deleteAirport(Long id) throws DatabaseException , Exception{
		try{
			airportDao.deletetAirport(id) ;
		}catch(DatabaseException e){
			Logger.logError("Database error deleting airport :", e);
			throw e;
		}catch (Exception ex) {
			Logger.logError("Unkwon error deleting airport :", ex);
			throw ex;
		}
	}

	/**
	 * Creates an airport
	 * @param airport
	 * @throws DatabaseException
	 */
	public void createAirport(Airport airport) throws DatabaseException{
		try{
			//TODO : Validate data ( there's an airport with the same code or data its consistence and complete  and)  throw an exception if necesary , write the test case for that exception
			airportDao.createAirport(airport) ;
		}catch(DatabaseException e){
			Logger.logError("Error creating airport :", e);
			throw e;
		}catch (Exception ex) {
			Logger.logError("Unkwon creating  airport :", ex);
			throw ex;
		}
	}

	
}

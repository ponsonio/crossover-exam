package com.crossover.services.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.bo.AirportBO;
import com.crossover.bo.TokenBO;
import com.crossover.entity.Airport;
import com.crossover.log.Logger;

/**
 * Airport Resource Services
 * @author koki
 *
 */
@Controller
@RequestMapping("airport")
public class AirportServices {

	@Autowired
	private AirportBO airportBO;
	
	@Autowired
	private TokenBO tokenBO;
	
	/**
	 * List all resources
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody Airport[] getAirports(@RequestParam(value = "token") String token) {
		Airport[] airports;
		try {
			
			if (tokenBO.validateToken(token) == false) {
				Logger.logWarning("Invalid token " + token);
				//TODO: Change the HTTP header to error!
				return null;			
			}
			
			Object[] objs = airportBO.getAirports().toArray();
			airports = new Airport[objs.length];
			for (int i = 0; i < objs.length; i++) {
				airports[i] = (Airport) objs[i];
			}
			return airports;
		} catch (Exception e) {
			Logger.logError("Error getting airports rates ", e);
			//TODO: Change the HTTP header to error!
			return null;
		}

	}
	
	/**
	 * Get a resource by id
	 * @param id
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Airport getAirport(@PathVariable String id ,
							@RequestParam(value = "token") String token) {
		Airport airport ;
		try {
			if (tokenBO.validateToken(token) == false) {
				Logger.logWarning("Invalid token " + token);
				//TODO: Change the HTTP header to error!
				return null;			
			}			
			long longid = Long.parseLong(id);
			airport = airportBO.getAirport(longid);
			return airport;
		}catch(NumberFormatException nfe){
			Logger.logError("invalid id ", nfe);
			//TODO: Change the HTTP header to error!
			return null;		
		} catch (Exception e) {
			Logger.logError("Error getting airport", e);
			//TODO: Change the HTTP header to error!
			return null;
		}

	}
	
	/**
	 * deletes a resource by id
	 * @param id
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteAirport(@PathVariable String id
				, @RequestParam(value = "token") String token) {
		try {
			if (tokenBO.validateToken(token) == false) {
				Logger.logWarning("Invalid token " + token);
				//TODO: Change the HTTP header to error!
				return null;			
			}		
			long longid = Long.parseLong(id);
			airportBO.deleteAirport(longid);
			return  "{ \"message\":\"" + "ok" + "\"}";
		}catch(NumberFormatException nfe){
			Logger.logError("invalid id :", nfe);
			return  "{ \"message\":\"" + "Invalid Id" + "\"}";
			//TODO: Change the HTTP header to error!
			//return null;		
		} catch (Exception e) {
			Logger.logError("Error deleting airport ", e);
			return  "{ \"message\":\"" + e.getMessage() + "\"}";
			//return null;
			//TODO: Change the HTTP header to error!
		}

	}
	
	/**
	 * Creates a resource
	 * @param code
	 * @param name
	 * @param city
	 * @param country
	 * @param adress
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public @ResponseBody String createAirport(
			@RequestParam(value = "code") String code,
				@RequestParam(value = "name") String name,
					@RequestParam(value = "city") String city,
					@RequestParam(value = "country") String country,
						@RequestParam(value = "adress") String adress,
							@RequestParam(value = "token") String token
				) {
		try {
			if (tokenBO.validateToken(token) == false) {
				Logger.logWarning("Invalid token " + token);
				//TODO: Change the HTTP header to error!
				return null;			
			}
			Airport airport = new Airport();
			airport.setCode(code);
			airport.setName(name);
			airport.setCity(city);
			airport.setCountry(country);
			airport.setAdress(adress);			
			airportBO.createAirport(airport);
			return  "{ \"message\":\"" + "ok" + "\"}";
		} catch (Exception e) {
			Logger.logError("Error creating airport", e);
			return  "{ \"message\":\"" + e.getMessage() + "\"}";
			//return null;
			//TODO: Change the HTTP header to error!
		}

	}
	
}

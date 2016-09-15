package com.crossover.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.entity.Airport;
import com.crossover.exception.DatabaseException;

/**
 * Data access logic for Airport entity
 * @author koki
 *
 */
@Repository
@Transactional
public class AirportDao {
	
	
	
	  @Autowired
	  private SessionFactory sessionFactory;

	public AirportDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	/**
	 * Return the airport or null if not found
	 * @param id the id of the airport
	 * @return Airport or null if not found
	 * @exception DatabaseException 
	 */
	 public Airport getAirport(Long id) throws DatabaseException{
		 Airport airport = null;
		 try{
			 airport = (Airport) sessionFactory.getCurrentSession().get(Airport.class, id) ;
			 return airport;
		 }catch(Exception e){
			 new DatabaseException("An error finding airport by id", e);
		 }
		return airport;
	 }
	 
	 /**
	  * Get all the airports
	  * @return
	  * @throws DatabaseException
	  */
		@SuppressWarnings("unchecked")
	 public List<Airport> getAirports() throws DatabaseException{
			  try{
				  Query q = sessionFactory.getCurrentSession().createQuery(" from Airport a ");
				  return  q.list();
			  }catch(Exception e) {
				  throw new DatabaseException("An error happend listing airports" ,e);
			  }
	 }
	 
	
	/**
	 * Deletes and Airport
	 * @param airport
	 * @throws DatabaseException
	 */
	 public void deletetAirport(Long id) throws DatabaseException{
			  try{
				  Airport airport = new Airport();
				  airport.setId(id);;
				  sessionFactory.getCurrentSession().delete(airport) ;
			  }catch(Exception e) {
				  throw new DatabaseException("An error deleting airport" ,e);
			  }
	 }
	 
	 
	 /***
	  * Creates an airport
	  * @param airport
	  * @exception : DatabaseException if code duplicated or database error 
	  */
	 public void createAirport(Airport airport) throws DatabaseException{
		  try{
			  Query q = sessionFactory.getCurrentSession().createQuery(" from Airport a where a.code = :code");
			  q.setParameter("code", airport.getCode());
			  if (q.list().isEmpty() == false){
				  throw new DatabaseException("An error creating an airport, duplicate code" );
			  }
			  sessionFactory.getCurrentSession().persist(airport) ;
			  
		  }catch(Exception e) {
			  throw new DatabaseException("An error creating an airport" ,e);
		  }
		 
	 }

}

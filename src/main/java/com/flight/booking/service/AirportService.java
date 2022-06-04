/**
 * 
 */
package com.flight.booking.service;

import java.util.List;

import com.flight.booking.entity.Airport;

/**
 * @author Navin
 *
 */
public interface AirportService {
	
	void save(Airport a);

	void update(Airport a);
	
	void delete(Long id);

	List<Airport> findAll();	
	
	void deleteById(Long id);
	
	Airport findById(Long id);

}

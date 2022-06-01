/**
 * 
 */
package com.flight.booking.service;

import java.util.Date;
import java.util.List;

import com.flight.booking.entity.Flights;

/**
 * @author Navin
 *
 */
public interface FlightService {

	void save(Flights a);
	
	void update(Flights a);

	List<Flights> findAll();
	
	List<Flights> findAllByOrigin(String origin);
	
	List<Flights> findAllByDestination(String destination);
	
	List<Flights> findAllByOriginAndDestination(String origin, String detsination);
	
	List<Flights> findAllByOriginAndDestinationAndDateOfFlight(String origin, String detsination, Date dof);
	
	void deleteById(Long id);
	
	Flights findById(Long id);	
}

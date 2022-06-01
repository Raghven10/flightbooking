/**
 * 
 */
package com.flight.booking.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.booking.entity.Flights;

/**
 * @author Navin
 *
 */
@Repository
public interface FlightsRepository extends JpaRepository<Flights, Long> {

	List<Flights> findAllByOrigin(String origin);
	
	List<Flights> findAllByDestination(String destination);
	
	List<Flights> findAllByOriginAndDestination(String origin, String detsination);
	
	List<Flights> findAllByOriginAndDestinationAndDateOfFlight(String origin, String detsination, Date dof);
}

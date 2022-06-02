/**
 * 
 */
package com.flight.booking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.booking.entity.Airport;

/**
 * @author Navin
 *
 */
@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
	
	List<Airport> findAll();
	
	List<Airport> findAllByState(String state);
	
	Airport findByCode(String code);
	
	Airport findByName(String name);	

}

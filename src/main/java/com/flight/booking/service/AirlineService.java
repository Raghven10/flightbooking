package com.flight.booking.service;

import java.util.List;

import com.flight.booking.entity.Airline;

public interface AirlineService {
	
	void save(Airline a);
	
	void delete(Long id);

	List<Airline> findAll();

}

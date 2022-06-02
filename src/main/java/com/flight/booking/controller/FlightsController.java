/**
 * 
 */
package com.flight.booking.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.booking.entity.Flights;
import com.flight.booking.service.FlightService;

/**
 * @author Navin
 *
 */
@RestController
@CrossOrigin
public class FlightsController {

	@Autowired FlightService service;
	
	
	//api/flights
	
	@GetMapping(path="/flights-all")
	public List<Flights> flightsAll() {
		
	    return service.findAll();
	}
	
	@GetMapping(path="/get-flight-detail/{id}")
	public Flights getFlightDetail(@PathVariable ("id") Long id) {
		
	    return service.findById(id);
	}
	
	@GetMapping(path="/flight-search")
	public List<Flights> flights(@RequestParam("origin") String origin, @RequestParam("destination") String destination, @RequestParam("dateOfFlight") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dof) {
		System.out.println("Parameters are there...");
		
		
		//return service.findAllByOriginAndDestination(origin, destination);
		return service.findAllByOriginDestinationAndDateOfFlight(origin, destination, dof);
	}
	
	public FlightsController() {
		// TODO Auto-generated constructor stub
	}

}

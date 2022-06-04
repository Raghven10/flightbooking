/**
 * 
 */
package com.flight.booking.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.booking.entity.Airline;
import com.flight.booking.entity.Flights;
import com.flight.booking.service.AirlineService;
import com.flight.booking.service.FlightService;

/**
 * @author Navin
 *
 */
@RestController
@CrossOrigin
public class FlightsController {

	@Autowired FlightService service;
	
	@Autowired AirlineService airlineService;
	
	// Proposed APIs 	
	// POST - /api/v1.0/flight/airline/register	
	@PostMapping(path="/api/v1.0/flight/airline/register")
	public ResponseEntity<ResponseMessage> registerAirline(@RequestBody Airline airline) {
		
		airlineService.save(airline);
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Registered Successfully."),HttpStatus.OK);		
	}
	
	@DeleteMapping(path="/api/v1.0/flight/airline/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteAirline(@PathVariable ("id") Long id) {
		
		System.out.println("Request to delete came for ID: "+id);
		
		airlineService.delete(id);
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Deleted Successfully."),HttpStatus.OK);		
	}
	
		
	// POST - /api/v1.0/flight/airline/inventory/add	
	@PostMapping(path="/api/v1.0/flight/airline/inventory/add")
	public ResponseEntity<ResponseMessage> saveFlightDetail(@RequestBody Flights flight) {
		
		service.save(flight);
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("saved Successfully."),HttpStatus.OK);
		
	}
	
	
	@GetMapping(path="/api/v1.0/flight/airline/all")
	public List<Airline> airlinesAll() {
		
	    return airlineService.findAll();
	}
	
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

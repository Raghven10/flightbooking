/**
 * 
 */
package com.flight.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.booking.entity.Airport;
import com.flight.booking.service.AirportService;

/**
 * @author Navin
 *
 */

@RestController
@CrossOrigin
public class AirportController {

	@Autowired AirportService service;
	
	
	// /api/v1.0/flight/airport/all
	
	@GetMapping(path="/api/v1.0/flight/airport/all")
	public List<Airport> airportsAll() {
		
	    return service.findAll();
	}
	
	@PostMapping(path="/api/v1.0/flight/airport/register")
	public ResponseEntity<ResponseMessage> registerAirport(@RequestBody Airport airport) {
		
		service.save(airport);
		
	    return new ResponseEntity<ResponseMessage>(new ResponseMessage("Registered Successfully."),HttpStatus.OK);	
	}
	
	@DeleteMapping(path="/api/v1.0/flight/airport/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteAirport(@PathVariable ("id") Long id) {
		
		System.out.println("Request to delete came for ID: "+id);		
		service.delete(id);
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Deleted Successfully."),HttpStatus.OK);		
	}
	
	@GetMapping(path="/airports")
	public List<Airport> airports() {
		
	    return service.findAll();
	}
	
	public AirportController() {
		// TODO Auto-generated constructor stub
	}

}

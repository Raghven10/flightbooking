/**
 * 
 */
package com.flight.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	//api/v1.0.1/airports
	
	
	@GetMapping(path="/airports")
	public List<Airport> airports() {
		
	    return service.findAll();
	}
	
	
	
	public AirportController() {
		// TODO Auto-generated constructor stub
	}

}

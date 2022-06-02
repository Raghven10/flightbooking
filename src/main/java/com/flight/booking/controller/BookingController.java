package com.flight.booking.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.booking.entity.AppUser;
import com.flight.booking.entity.Booking;
import com.flight.booking.entity.Payment;
import com.flight.booking.service.AppUserService;
import com.flight.booking.service.BookingService;
import com.flight.booking.service.PaymentService;

@RestController
@CrossOrigin
public class BookingController {

	@Autowired BookingService service;
	
	@Autowired AppUserService userService;
	
	@Autowired PaymentService payService;
	
	@GetMapping(path="/bookking-all")
	public List<Booking> bookingsAll() {
		
	    return service.findAll();
	}
	
	@GetMapping(path="/user-bookking-all")
	public List<Booking> bookingsAllUser(Principal principal) {
		
		AppUser user = userService.findByEmail(principal.getName());
		
	    return service.findAllByAppUser(user);
	}
	
	@PostMapping(path="/create-booking")
	public Booking saveBooking(@RequestBody Booking booking, Principal principal) {
		
		AppUser user = userService.findByEmail(principal.getName());		
		booking.setAppUser(user);
		service.save(booking);		
		return booking;	    
	}
	
	@PostMapping(path="/payment")
	public Payment payment(@RequestBody Payment payment) {		
		
		payService.save(payment);
		
		return payment;
		
	}
	
	
	@PostMapping(path="/cancel-booking/{id}")
	public Booking payment(@PathVariable("id") Long id) {		
		
		
		Booking booking = service.findById(id);
		service.cancel(booking);
		
		return booking;
		
	}
	
	
	

}

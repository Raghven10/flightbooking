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

import com.flight.booking.dao.BookingRepository;
import com.flight.booking.entity.AppUser;
import com.flight.booking.entity.Booking;
import com.flight.booking.entity.Payment;
import com.flight.booking.service.AppUserService;
import com.flight.booking.service.BookingService;
import com.flight.booking.service.PaymentService;

@RestController
@CrossOrigin(origins="*")
public class BookingController {

	@Autowired BookingService service;
	
	@Autowired BookingRepository repos;
	
	@Autowired AppUserService userService;
	
	@Autowired PaymentService payService;
	
	//search booking with Email ID
	@GetMapping(path="/api/v1.0/flight/booking/history/{emailId}")
	public List<Booking> findBookingsByEmailId(@PathVariable ("emailId") String emailId) {
			
		AppUser user = userService.findByEmail(emailId);
			
		return service.findAllByAppUser(user);
	}
	
	
	//search booking with pnr
	@GetMapping(path="/api/v1.0/flight/ticket/{pnr}")
	public Booking searchTicket(@PathVariable ("pnr") Long pnr) {
			
		return service.findById(pnr);
	}
	
	//Cancel a Booked ticket
	
	@GetMapping(path="/api/v1.0/flight/booking/cancel/{pnr}")
	public Booking cancelBooking(@PathVariable("pnr") Long id) {				
			
		Booking booking = service.findById(id);
		service.cancel(booking);
			
		return booking;
			
	}
	
	
	@GetMapping(path="/bookking-all")
	public List<Booking> bookingsAll() {
		
	    return service.findAll();
	}
	
	
	@GetMapping(path="/user-bookking-all")
	public List<Booking> bookingsAllUser(Principal principal) {
		
		AppUser user = userService.findByEmail(principal.getName());
		
	    return service.findAllByAppUser(user);
	}
	
	@GetMapping(path="/booking-details/{id}")
	public Booking bookingDetails(@PathVariable ("id") Long id) {
		
		return service.findById(id);
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
	
	
	
	
	

}

package com.flight.booking.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.booking.dao.PaymentRepository;
import com.flight.booking.entity.Booking;
import com.flight.booking.entity.Payment;
import com.flight.booking.service.BookingService;
import com.flight.booking.service.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{

	@Autowired PaymentRepository repos;
	
	@Autowired BookingService service;
	
	@Override
	public void save(Payment a) {
		
		System.out.println("Payment Body: "+a);
		Booking booking = a.getBooking();
		
		
		System.out.println("Booking Details:   "+booking);
		booking.setStatus("BOOKED");		
		repos.save(a);
		service.finalizeBooking(booking);
	}

	@Override
	public List<Payment> findAll() {
		
		return repos.findAll();
	}

	
	@Override
	public Payment findById(Long id) {
		
		return repos.findById(id).orElse(null);
	}

	
	
}

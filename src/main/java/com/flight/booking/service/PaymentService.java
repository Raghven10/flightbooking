package com.flight.booking.service;

import java.util.List;

import com.flight.booking.entity.Payment;


public interface PaymentService{

	void save(Payment a);	

	List<Payment> findAll();	
	
	Payment findById(Long id);
}

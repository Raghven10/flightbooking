package com.flight.booking.service;

import java.util.List;

import com.flight.booking.entity.AppUser;
import com.flight.booking.entity.Booking;

public interface BookingService {
	
	void save(Booking a);
	
	void finalizeBooking(Booking a);

	void cancel(Booking a);

	List<Booking> findAll();
	
	List<Booking> findAllByAppUser(AppUser user);
	
	Booking findById(Long id);

}

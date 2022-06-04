package com.flight.booking.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.booking.dao.BookingRepository;
import com.flight.booking.entity.AppUser;
import com.flight.booking.entity.Booking;
import com.flight.booking.service.BookingService;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{

	@Autowired BookingRepository repos;
	
	public BookingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Booking a) {
		
		
		a.setStatus("PENDING");
		repos.save(a);
		
	}

	@Override
	public void cancel(Booking a) {
	
		a.setStatus("CANCELLED");
		repos.save(a);
	}

	@Override
	public List<Booking> findAll() {
		
		return repos.findAll();
	}
	
	@Override
	public List<Booking> findAllByAppUser(AppUser user) {
		
		return repos.findAllByAppUser(user);
	}

	@Override
	public Booking findById(Long id) {
		
		return repos.findById(id).orElse(null);
	}

	@Override
	public void finalizeBooking(Booking a) {
	
		a.setStatus("BOOKED");
		repos.save(a);
	}

}

package com.flight.booking.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.booking.dao.AirlineRepository;
import com.flight.booking.entity.Airline;
import com.flight.booking.service.AirlineService;

@Service
@Transactional
public class AirlineServiceImpl implements AirlineService{

	@Autowired AirlineRepository repos;
	
	
	
	@Override
	public void save(Airline a) {

		repos.save(a);	
	}
	
	

	@Override
	public List<Airline> findAll() {
		
		return repos.findAll();
	}

	@Override
	public void delete(Long id) {
		repos.deleteById(id);		
	}

}

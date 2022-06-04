/**
 * 
 */
package com.flight.booking.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.booking.dao.AirportRepository;
import com.flight.booking.entity.Airport;
import com.flight.booking.service.AirportService;

/**
 * @author Navin
 *
 */
@Service
@Transactional
public class AirportServiceImpl implements AirportService {

	
	@Autowired AirportRepository repos;
	
	
	public AirportServiceImpl() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void save(Airport a) {
		repos.save(a);
		
	}

	@Override
	public void update(Airport a) {
		repos.save(a);
		
	}

	@Override
	public List<Airport> findAll() {
		
		return repos.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repos.deleteById(id);		
	}

	@Override
	public Airport findById(Long id) {
		
		return repos.findById(id).orElse(null);
	}


	@Override
	public void delete(Long id) {
		repos.deleteById(id);		
	}

}

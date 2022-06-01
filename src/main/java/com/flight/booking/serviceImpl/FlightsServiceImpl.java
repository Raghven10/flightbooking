/**
 * 
 */
package com.flight.booking.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.booking.dao.FlightsRepository;
import com.flight.booking.entity.Flights;
import com.flight.booking.service.FlightService;

/**
 * @author Navin
 *
 */

@Service
@Transactional
public class FlightsServiceImpl implements FlightService {

	@Autowired FlightsRepository repos;
	
	
	public FlightsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Flights a) {
		repos.save(a);
	}

	@Override
	public void update(Flights a) {
		repos.save(a);
	}

	@Override
	public List<Flights> findAll() {
		
		List<Flights> flights = repos.findAll();
		
		return flights;
	}

	@Override
	public List<Flights> findAllByOrigin(String origin) {
		
		List<Flights> flights = repos.findAllByOrigin(origin);
		
		return flights;
	}

	@Override
	public List<Flights> findAllByDestination(String destination) {
		
		List<Flights> flights = repos.findAllByDestination(destination);
		
		return flights;
	}

	@Override
	public List<Flights> findAllByOriginAndDestination(String origin, String detsination) {
		
		List<Flights> flights = repos.findAllByOriginAndDestination(origin, detsination);
		
		return flights;
	}

	@Override
	public List<Flights> findAllByOriginAndDestinationAndDateOfFlight(String origin, String detsination, Date dof) {


		List<Flights> flights = repos.findAllByOriginAndDestinationAndDateOfFlight(origin, detsination, dof);
		
		return flights;
	}

	@Override
	public void deleteById(Long id) {
		repos.deleteById(id);
		
	}

	@Override
	public Flights findById(Long id) {
		
		return  repos.findById(id).orElse(null);
	}

}

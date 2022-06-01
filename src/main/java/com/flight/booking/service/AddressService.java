/**
 * 
 */
package com.flight.booking.service;

import java.util.List;

import com.flight.booking.entity.Address;
import com.flight.booking.entity.AppUser;


/**
 * @author navin
 *
 */
public interface AddressService {
	
	void save(Address a);

	void update(Address a);

	List<Address> findAll();
	
	void deleteById(Long id);
	
	Address findById(Long id);

	Address findByUserId(AppUser user);

}

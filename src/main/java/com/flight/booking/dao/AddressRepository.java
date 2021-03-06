/**
 * 
 */
package com.flight.booking.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flight.booking.entity.Address;
import com.flight.booking.entity.AppUser;

/**
 * @author Navin
 *
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

	
	List<Address> findAllByAppUser(AppUser appUser);


}

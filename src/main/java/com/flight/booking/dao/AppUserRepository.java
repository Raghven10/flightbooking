/**
 * 
 */
package com.flight.booking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flight.booking.entity.AppUser;
import com.flight.booking.entity.Role;



/**
 * @author Navin
 *
 */
@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {

		
	AppUser findByEmail(String email);

	
	AppUser findByMobileNo(String mobileNo);

	
	AppUser findByEmailAndActiveFlag(String email, boolean activeFlag);

	
	AppUser findByEmailAndRoles(String email, Role role);

}

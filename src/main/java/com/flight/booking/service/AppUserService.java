/**
 * 
 */
package com.flight.booking.service;

import java.util.List;

import com.flight.booking.entity.AppUser;
import com.flight.booking.entity.Role;


/**
 * @author navin
 *
 */
public interface AppUserService {
	
	void save(AppUser a);

	AppUser findByEmail(String email);
	
	AppUser findByMobileNo(String mobileNo);	

	void update(AppUser a);

	List<AppUser> findAll();
	
	void deleteById(Long id);
	
	AppUser findById(Long id);
	
	void deactivateUser(Long id);
	
	String activateUser(Long id);

	/**
	 * @param email
	 * @return
	 */
	AppUser findByEmailAndRoles(String email, Role role);

	void updateDob(AppUser appUser);

}

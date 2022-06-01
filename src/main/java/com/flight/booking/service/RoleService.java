/**
 * 
 */
package com.flight.booking.service;

import java.util.List;

import com.flight.booking.entity.Role;

/**
 * @author navin
 *
 */

public interface RoleService {
	
	void save (Role a);

	void update(Role a);

	List<Role> findAll();
	
	void deleteById(Long id);
	
	Role findById(Long id);

	
	void cancelById(Long id);
	
	

}

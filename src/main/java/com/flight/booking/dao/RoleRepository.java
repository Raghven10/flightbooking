/**
 * 
 */
package com.flight.booking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flight.booking.entity.Role;


/**
 * @author navin
 *
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	
	Role findByRoleName(String roleName);

}

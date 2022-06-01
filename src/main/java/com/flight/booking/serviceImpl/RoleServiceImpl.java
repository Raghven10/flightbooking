/**
 * 
 */
package com.flight.booking.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.booking.dao.RoleRepository;
import com.flight.booking.entity.Role;
import com.flight.booking.service.RoleService;

/**
 * @author navin
 *
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService{

	@Autowired RoleRepository roleRepos;
	
	@Override
	public void save(Role a) {
		
		
		roleRepos.save(a);
		
	}

	@Override
	public void update(Role a) {
		
		roleRepos.save(a);
		
	}

	@Override
	public List<Role> findAll() {
		
		List<Role> roles = (List<Role>) roleRepos.findAll();
		return roles;
	}

	@Override
	public void deleteById(Long id) {
		
		roleRepos.deleteById(id);
		
	}

	@Override
	public Role findById(Long id) {
		
		return  roleRepos.findById(id).orElse(null);
		
	}
	
	@Override
	public void cancelById(Long id) {
		
		Role role = roleRepos.findById(id).orElse(null);
		role.setActiveFlag(false);
		this.update(role);
		
	}
	
	

}

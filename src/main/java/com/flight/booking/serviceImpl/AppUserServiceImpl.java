/**
 * 
 */
package com.flight.booking.serviceImpl;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.flight.booking.dao.AppUserRepository;
import com.flight.booking.entity.AppUser;
import com.flight.booking.entity.Role;
import com.flight.booking.service.AppUserService;
import com.flight.booking.util.PasswordUtil;



/**
 * @author navin
 *
 */
@Service
@Transactional
public class AppUserServiceImpl implements AppUserService{

	@Autowired AppUserRepository  userRepository;
	
	@Override
	public void save(AppUser appUser) {		
		
		if(StringUtils.hasText(appUser.getPassword())) {
			appUser.setPassword(PasswordUtil.getEncodePassword(appUser.getPassword()));
		}				
		
		appUser.setActiveFlag(true);
		appUser.setJoiningDate(new Date());
		userRepository.save(appUser);		
	}
	
	@Override
	public void update(AppUser appUser) {	
		
		AppUser user = userRepository.findById(appUser.getId()).orElse(null);
		user.setDateOfBirth(appUser.getDateOfBirth());
		user.setEmail(appUser.getEmail());
		user.setFirstName(appUser.getFirstName());
		user.setLastName(appUser.getLastName());
		user.setMobileNo(appUser.getMobileNo());
		
		userRepository.save(user);	
	}
	
	@Override
	public void updateDob(AppUser appUser) {	
		
		Principal principal = SecurityContextHolder.getContext().getAuthentication();
		AppUser user = this.findByEmail(principal.getName());
		user.setDateOfBirth(appUser.getDateOfBirth());			
		userRepository.save(user);	
	}

	@Override
	public AppUser findByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	@Override
	public AppUser findByMobileNo(String mobileNo) {		

		return userRepository.findByMobileNo(mobileNo);
	}

	
	@Override
	public List<AppUser> findAll() {
		
		List<AppUser> appUsers = (List<AppUser>) userRepository.findAll();		
		return appUsers;
	}

	@Override
	public void deleteById(Long id) {
		
		userRepository.deleteById(id);
		
	}
	
	@Override
	public String activateUser(Long id) {
		
		AppUser appUser = userRepository.findById(id).orElse(null);
		if(appUser!=null) {
			appUser.setActiveFlag(true);
			appUser.setReleaseDate(null);
			userRepository.save(appUser);
			return "User with Email id: "+appUser.getEmail()+" activated successfully.";
		}		
		return "User with id: "+id+" Not Found!";
		
	}
	
	@Override
	public void deactivateUser(Long id) {
		
		AppUser appUser = userRepository.findById(id).orElse(null);
		if(appUser!=null) {
			appUser.setActiveFlag(false);
			appUser.setReleaseDate(new Date());
			userRepository.save(appUser);
		}		
		
	}

	@Override
	public AppUser findById(Long id) {
		
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public AppUser findByEmailAndRoles(String email, Role role) {
		
		return userRepository.findByEmailAndRoles(email,role);
	}

}

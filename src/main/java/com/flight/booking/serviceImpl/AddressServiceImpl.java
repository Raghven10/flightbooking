/**
 * 
 */
package com.flight.booking.serviceImpl;

import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.flight.booking.dao.AddressRepository;
import com.flight.booking.dao.AppUserRepository;
import com.flight.booking.entity.Address;
import com.flight.booking.entity.AppUser;
import com.flight.booking.service.AddressService;
import com.flight.booking.service.AppUserService;


/**
 * @author navin
 *
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired AddressRepository addressRepository;
	@Autowired AppUserRepository appUserRepos;
	@Autowired AppUserService userService;
	
	@Override
	public void save(Address address) {
		
		Principal principal = SecurityContextHolder.getContext().getAuthentication();
		
		AppUser user = userService.findByEmail(principal.getName());	
		address.setAppUser(user);
		addressRepository.save(address);
		
		
	}

	@Override
	public void update(Address address) {
		
		addressRepository.save(address);
		
	}

	@Override
	public List<Address> findAll() {
		
		List<Address> addresses = (List<Address>) addressRepository.findAll();		
		return addresses;
	}

	@Override
	public void deleteById(Long id) {
		
		addressRepository.deleteById(id);
		
	}

	@Override
	public Address findById(Long id) {		

		return addressRepository.findById(id).orElse(null);
	}

	@Override
	public Address findByUserId(AppUser appUser) {
		
		return addressRepository.findByAppUser(appUser);
	}

}

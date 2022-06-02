package com.flight.booking.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.booking.entity.Address;
import com.flight.booking.entity.AppUser;
import com.flight.booking.service.AddressService;
import com.flight.booking.service.AppUserService;


@RestController
@CrossOrigin
public class AddressController {

	@Autowired AddressService service;
	
	@Autowired AppUserService userService;
	
	@GetMapping(path="/address-user")
	public List<Address> addressAll(Principal principal) {
		
		AppUser user = userService.findByEmail(principal.getName());
		
	    return service.findByUserId(user);
	}
	
	@PostMapping(path="/saveuseraddress")
	public Address saveAddress(@RequestBody Address address, Principal principal) {
		
		AppUser user = userService.findByEmail(principal.getName());
		address.setAppUser(user);
		service.save(address);
		
	    return address;
	}
		
}

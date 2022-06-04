/**
 * 
 */
package com.flight.booking.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.booking.entity.AppUser;
import com.flight.booking.entity.Role;
import com.flight.booking.service.AppUserService;

/**
 * @author navin
 *
 */
@RestController
@CrossOrigin
public class AdminController {
	
@Autowired private AppUserService userService;


	//Proposed APIs - Admin login 
	

	@GetMapping(path="/api/v1.0/flight/admin/login")
	public AppUser adminLogin(Principal principal, HttpSession session) throws Exception{	
		
		AppUser user = userService.findByEmail(principal.getName());		
		return user;		
	}


	
	@GetMapping(value="/dashboard")
	private String adminDashboard(Principal principal, Model model,HttpSession session) {		
		
		
		AppUser dbUser = userService.findByEmail(principal.getName());
		
		session.setAttribute("firstName", dbUser.getFirstName());
		session.setAttribute("lastName", dbUser.getLastName());
		List<Role> roles = dbUser.getRoles();
		session.setAttribute("imageUrl", dbUser.getImageUrl());
		session.setAttribute("roles", roles);
		
		model.addAttribute("user",dbUser);
		return "samplePage";
		
	}
	
	@GetMapping("/users-list")
	public String usersAll(Model model) {
		
		List<AppUser> users = userService.findAll();
		model.addAttribute("users",users);
	    return "/admin/AllUsersList";
	}
	

	
	
	
	
	

}

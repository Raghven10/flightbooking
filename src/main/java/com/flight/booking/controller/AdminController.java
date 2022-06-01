/**
 * 
 */
package com.flight.booking.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flight.booking.entity.AppUser;
import com.flight.booking.entity.Role;
import com.flight.booking.service.AppUserService;

/**
 * @author navin
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
@Autowired private AppUserService userService;

	
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


package com.flight.booking.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.flight.booking.entity.AppUser;
import com.flight.booking.service.AppUserService;
import com.flight.booking.service.RoleService;

/**
 * @author navin
 *
 */
@Controller
@CrossOrigin(origins="*")
public class HomeController {
	

	
	
	@Autowired AppUserService userService;
	
	@Autowired RoleService roleService;
	
	

	@GetMapping("/")
	public String homepage(Model model) {
		
		
		return "index";	
	}
	
	
	
	
	@GetMapping("/logintest")
	public String testpage(Model model) {		
			
		return "samplePage";
		
	}
	
	@GetMapping(value="/redirectDashboard")
	public String redirectDashboard(Principal principal, Model model, HttpSession session) throws Exception{
		
		AppUser user = userService.findByEmail(principal.getName());		
		
		
		session.setAttribute("firstName", user.getFirstName());
		session.setAttribute("lastName", user.getLastName());
		session.setAttribute("imageUrl", user.getImageUrl());
		session.setAttribute("role", user.getRoles().get(0).getRoleName());
		System.out.println(session.getAttribute("role"));
		model.addAttribute("user",user);
		return "samplePage";
	}
	
	@GetMapping("/restapilogin")
	public AppUser restapilogin(Principal principal, HttpSession session) throws Exception{
		
		AppUser user = userService.findByEmail(principal.getName());					
		return user;
	}
	
	@GetMapping("/profile-settings")
	public String userProfile(Model model) {		
		
		AppUser appUser= userService.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("user", appUser);
		return"common/user-profile";
	}
}

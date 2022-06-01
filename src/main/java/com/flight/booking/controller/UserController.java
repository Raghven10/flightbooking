/**
 * 
 */
package com.flight.booking.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flight.booking.entity.AppUser;
import com.flight.booking.entity.Role;
import com.flight.booking.service.AddressService;
import com.flight.booking.service.AppUserService;


/**
 * @author Navin
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired private AppUserService userService;
	@Autowired AddressService addressService;
	@Autowired ServletContext context;
	
	@GetMapping(value="/dashboard")
	private String userDashboard(Principal principal, Model model, HttpSession session) {		
		
		
		AppUser dbUser = userService.findByEmail(principal.getName());
		
		session.setAttribute("firstName", dbUser.getFirstName());
		session.setAttribute("lastName", dbUser.getLastName());
		session.setAttribute("imageUrl", dbUser.getImageUrl());
		session.setAttribute("roles", dbUser.getRoles());
		
		model.addAttribute("user",dbUser);
		return "index";
		
	}
	
	@ResponseBody
	@PostMapping("/saveuser")
	private AppUser saveuser(@RequestBody AppUser user) {
		
		userService.save(user);	
		return user;
	}	
	
	@ResponseBody
	@GetMapping("/getuserroles")
	private List<Role> findroles(Principal principal) {
		
		AppUser dbUser = userService.findByEmail(principal.getName());
		return dbUser.getRoles();
	}
	
	@Secured("ROLE_ADMIN")
	@ResponseBody
	@GetMapping("/getallusers")
	private List<AppUser> getallusers() {
		
		List<AppUser> users = userService.findAll();
		return users;
	}
	
	@ResponseBody
	@GetMapping("/getuserdetails")
	private AppUser finduser(Principal principal) {
		
		AppUser dbUser = userService.findByEmail(principal.getName());
		return dbUser;
	}
	
	@Secured("ROLE_ADMIN")
	@ResponseBody
	@GetMapping("/activateuser/{id}")
	public String activateUser(@PathVariable ("id") Long id, RedirectAttributes redirectAttr, Model model) {
		
		userService.activateUser(id);		
		redirectAttr.addFlashAttribute("message","User with User id: "+ id +" activated successfully!");

    return "activated";
	}
	
	@Secured("ROLE_ADMIN")
	@ResponseBody
	@GetMapping("/deactivateuser/{id}")
	public String deactivateUser(@PathVariable ("id")  Long id, RedirectAttributes redirectAttr, Model model) {
		
		userService.deactivateUser(id);
		
		redirectAttr.addFlashAttribute("message","User with User id: "+ id +" deactivated successfully!");
		
		return "activated";
	}
	
	@Secured("ROLE_ADMIN")
	@ResponseBody
	@DeleteMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable ("id")  Long id) {
		
		userService.deleteById(id);
		return "deleted successfully.";
	}
	
	
	
	
	@ResponseBody
	@PutMapping("/updateuser")
	private AppUser updateuser(@RequestBody AppUser user) {
		
		userService.update(user);;		
		return user;
	}
	
	@ResponseBody
	@PostMapping("/updateuserdob")
	private AppUser updateuserdob(@RequestBody AppUser user) {
		
		userService.updateDob(user);		
		return user;
	}
	
	
	@GetMapping("/deactivateaccount")
	public ResponseEntity<ResponseMessage> deactivateaccount() {
		
		Principal principal = SecurityContextHolder.getContext().getAuthentication();
		AppUser user = userService.findByEmail(principal.getName());
		
		userService.deactivateUser(user.getId());
		
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Deactivated Successfully."),HttpStatus.OK);

	}
	
	
	
	
	
	
}

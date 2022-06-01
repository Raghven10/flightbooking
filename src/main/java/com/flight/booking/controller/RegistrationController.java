/**
 * 
 */

package com.flight.booking.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flight.booking.dao.RoleRepository;
import com.flight.booking.entity.AppUser;
import com.flight.booking.entity.Role;
import com.flight.booking.service.AppUserService;
import com.flight.booking.service.RoleService;
import com.flight.booking.service.SecurityService;

/**
 * @author navin
 *
 */
@Controller
@CrossOrigin
public class RegistrationController {
	
	@Autowired AppUserService userService;
	
	@Autowired SecurityService securityService;
	
	@Autowired RoleService roleService;
	@Autowired RoleRepository roleRepository;
	
	
		
	@ResponseBody
	@PostMapping(value="/register/{role}")
	public AppUser registration(@RequestBody AppUser userInfo, @PathVariable("role") String roleName,
			HttpServletRequest request, Model model, RedirectAttributes redirectAttr) throws Exception
	{
		
		String password = userInfo.getPassword();			
		AppUser dbUser = userService.findByEmail(userInfo.getEmail());
		
		
		if(dbUser != null) 
			
		{
			if(dbUser.getRoles().contains(roleRepository.findByRoleName(roleName))) 
				{
				
				redirectAttr.addFlashAttribute("msgType","alert alert-danger alert-dismissible fade show");
				redirectAttr.addFlashAttribute("message","User  with email Id " + userInfo.getEmail() +
						  " already registerd as " + roleName );						  
				return dbUser; 
				}
			
				
			List<Role> roles = dbUser.getRoles();
			roles.add(roleRepository.findByRoleName(roleName));
			dbUser.setRoles(roles);				
			userService.update(dbUser);
			
			
			securityService.autoLogin(dbUser.getEmail(),password,dbUser.getRoles(),request);
			model.addAttribute("user",dbUser);

			String name = SecurityContextHolder.getContext().getAuthentication().getName();
			Collection<? extends GrantedAuthority> grantedAuthorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			Iterator <? extends GrantedAuthority> iterator = grantedAuthorities.iterator();
			
			return dbUser;
			
		}	  
		
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.findByRoleName(roleName));
		userInfo.setRoles(roles);				
		userService.save(userInfo);		
		
		dbUser = userService.findByEmail(userInfo.getEmail());		
		
				
		// AutoLogin after register methods	
		
		securityService.autoLogin(dbUser.getEmail(),password,dbUser.getRoles(),request);
		model.addAttribute("user",dbUser);
		
		//String name = SecurityContextHolder.getContext().getAuthentication().getName();
		//Collection<? extends GrantedAuthority> grantedAuthorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		//Iterator <? extends GrantedAuthority> iterator = grantedAuthorities.iterator();
		
		return dbUser;		
	}
}

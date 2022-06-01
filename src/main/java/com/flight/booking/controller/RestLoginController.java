/**
 * 
 */

package com.flight.booking.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flight.booking.entity.AppUser;
import com.flight.booking.service.AppUserService;


/**
 * @author navin
 *
 */

@RestController
@CrossOrigin
public class RestLoginController {
	
	@Autowired AppUserService userService;
	

	
	@GetMapping(path="/restauth")
	public AppUser basicAuthBean(Principal principal, HttpSession session) throws Exception{	
		
		AppUser user = userService.findByEmail(principal.getName());
		//user.getRoles().forEach(item->System.out.println("User Roles from authbean: "+item.getRoleName()));	
		
		System.out.println(session.getAttribute("sessionId"));
		return user;		
	}
	
	
	
    @GetMapping("/session-logout")
    public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response, 
    		RedirectAttributes redirectAttr,HttpSession session, Principal principal) {     	
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
          if (auth != null) {
              new SecurityContextLogoutHandler().logout(request, response, auth);	
              return "redirect:/";
  	  		
          }
          return "redirect:/";          
    }
    
 
}

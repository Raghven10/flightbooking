/**
 * 
 */

package com.flight.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



/**
 * @author navin
 *
 */
@Controller
@CrossOrigin(origins="*")
public class LoginController {
	
	@GetMapping("/loginFailure")
	public String loginError(RedirectAttributes redirectAttr) {		
		
		redirectAttr.addFlashAttribute("message","Invalid Username or Password.");
		return "redirect:/";
	}
	
	 @GetMapping("/forgot-password")
	    public String forgotPassword() {
	       
	       return "common/recover-password";
	    }
	   
	    

}

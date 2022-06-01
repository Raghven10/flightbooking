/**
 * 
 */
package com.flight.booking.serviceImpl;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flight.booking.dao.AppUserRepository;
import com.flight.booking.entity.AppUser;
import com.flight.booking.service.AppUserService;
import com.flight.booking.service.LoginService;

/**
 * @author navin
 *
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired AppUserService userService;
	
	@Autowired AppUserRepository appUserRepos;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		System.out.println("Inside loginService- loadUserByUserName");
		System.out.println("UserName : "+userName);
		
		AppUser user = appUserRepos.findByEmailAndActiveFlag(userName, true);
		if(user!=null) {System.out.println("User Details exist ");}
		
		if (user == null) 
		{
			System.out.println("Username not found!");
			throw new UsernameNotFoundException("Username not found for "+userName);
			
		}
		System.out.println("Exiting  user Details...");
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),getAuthorities(user));
		
	}

	private Collection<? extends GrantedAuthority> getAuthorities(AppUser user) {
		
		String[] userRoles = user.getRoles().stream().map((role)->role.getRoleName()).toArray(String[]::new);
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println(grantedAuthority);
			
		}
		return authorities;
	}

}

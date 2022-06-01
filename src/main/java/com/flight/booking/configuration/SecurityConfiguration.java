/**
 * 
 */
package com.flight.booking.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.flight.booking.service.LoginService;




/**
 * @author navin
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private LoginService loginService;
	
	@Bean
	public WebMvcConfigurer configurer() {
		
		return new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("*");
				
			}
			
		};
	}
	
	
	 @Bean
	 public PasswordEncoder passwordEncoder() {
	    	return new BCryptPasswordEncoder();
	    }
	 

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
    	
	   authenticationManagerBuilder.userDetailsService(this.loginService).passwordEncoder(passwordEncoder());
    	
    } 
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
    	
    	return super.authenticationManager();
		
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    	.csrf().disable() 
    	.authorizeRequests()   	
    	.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
				.antMatchers("/sysadmin/*").hasAnyRole("SYSADMIN")
				.antMatchers("/admin/*").hasAnyRole("ADMIN","SYSADMIN")
				.antMatchers("/sales/*").hasAnyRole("SALES","MANAGER","MARKETING_EXECUTIVE",
				"ADMIN","SYSADMIN")
				.antMatchers("/student/*").hasAnyRole("STUDENT","ADMIN","SYSADMIN")
				.antMatchers("/user/**").hasAnyRole("USER","ADMIN","SYSADMIN")
				 
				 .antMatchers("/","/assets/**","/register/**","/css/**","/img/**","/js/**",
				 "/lib/**","/error","/teacher/**").permitAll()
				 
        .anyRequest().authenticated()           

				.and() .formLogin() .loginPage("/") .loginProcessingUrl("/login")
			.usernameParameter("email") .passwordParameter("password")
			 .defaultSuccessUrl("/redirectDashboard").failureUrl("/loginFailure")
			
       
		.and() 
		.logout()/* .logoutUrl("session-logout") */
		.deleteCookies("JSESSIONID")
		.clearAuthentication(true) .invalidateHttpSession(true) .permitAll()
		
		.and()
		.httpBasic()
   		 
		.and()
        	.exceptionHandling()
        	.accessDeniedPage("/error");  	
    	
    }
	
	

}

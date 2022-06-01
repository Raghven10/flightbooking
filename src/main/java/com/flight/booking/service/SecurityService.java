package com.flight.booking.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.flight.booking.entity.Role;



public interface SecurityService {

	void autoLogin(String email, String password, List<Role> role, HttpServletRequest request);

}

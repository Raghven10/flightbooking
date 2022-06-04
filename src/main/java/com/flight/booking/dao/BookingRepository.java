/**
 * 
 */
package com.flight.booking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.booking.entity.AppUser;
import com.flight.booking.entity.Booking;

/**
 * @author Navin
 *
 */

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	List<Booking> findAllByAppUser(AppUser user);	
	
	List<Booking> findAllByAppUserAndStatus(AppUser user, String status);

}

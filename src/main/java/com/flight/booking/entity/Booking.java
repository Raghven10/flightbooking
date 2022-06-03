/**
 * 
 */
package com.flight.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Navin
 *
 */
@Entity
@Table
@Data
public class Booking{

	
	
	@Id
	@Column  //Booking PNR no
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pnr_id;  
	
	@Column
	private String status; // Pending/Booked/Cancelled
	
	@Column
	private Integer noOfSeatsBooked;
	
	@ManyToOne
	@JoinColumn(name="APP_USER_ID")
	private AppUser appUser;
		
	@OneToOne
	@JoinColumn(name="FLIGHT_ID") // Booked Flight 
	private Flights flight;
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}

}

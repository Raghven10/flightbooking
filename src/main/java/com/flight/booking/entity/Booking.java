/**
 * 
 */
package com.flight.booking.entity;

import java.io.Serializable;

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
public class Booking implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column  //Booking PNR no
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pnr_id;  
	
	@Column
	private String status; // Pending/Booked/Cancelled
	
	@ManyToOne
	@JoinColumn(name="APP_USER_ID")
	private AppUser appUser;
	
	@OneToOne
	@JoinColumn(name="ADDRESS_ID")
	private Address address;
	
	@OneToOne
	@JoinColumn(name="FLIGHT_ID") // Booked Flight 
	private Flights flight;
	
	@OneToOne
	@JoinColumn(name="Transaction_ID")
	private Payment payment;

	public Booking() {
		// TODO Auto-generated constructor stub
	}

}

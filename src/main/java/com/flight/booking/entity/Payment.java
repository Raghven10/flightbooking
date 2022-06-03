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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Raghven
 *
 */

@Data
@Entity
@Table(name="Payment")
public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column  //Payment Transaction Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private int amount;
	
	@Column
	private String payment_method; // Cash/ Credit Card/ UPI / NetBanking etc
	
	@Column
	private String payment_gateway; // VISA/MASTER/BANKS/ GPAY etc
	
	@OneToOne
	@JoinColumn(name="BOOKING_ID")
	private Booking booking;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

}

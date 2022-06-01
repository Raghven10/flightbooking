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
 * @author Navin
 * 
 ####################################################################################
 * ########### This Class intends to store address of all users #####################
 * ####################################################################################
 *
 */
@Data
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String street1;
	
	@Column
	private String street2;
	
	@Column
	private String city;
	
	@Column
	private String pinCode;
	
	@Column
	private String state;
	
	@Column
	private String country;
	
	@OneToOne
	@JoinColumn(name="APP_USER_ID")
	private AppUser appUser;


}

package com.flight.booking.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name="Flights")
public class Flights implements Serializable {
	
private static final long serialVersionUID = 1L;
	

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String origin;
	
	@Column
	private String destination;
	
	@Column	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dateOfFlight;	
	
	@Column
	private int noOfSeats;
	
	@Column
	private int price;
	
	@Column
	@Temporal(TemporalType.DATE)	
	private Date timeOfFlight;
	
	@Column
	private String remarks;
	
	@Column
	private String airline;	

	public Flights() {
		// TODO Auto-generated constructor stub
	}

}

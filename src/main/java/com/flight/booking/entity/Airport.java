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
import javax.persistence.Table;

import lombok.Data;

/**
 * @author navin
 *
 */

@Data
@Entity
@Table
public class Airport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
		
	@Column
	private String code;
	
	@Column
	private String state;
	
	public Airport() {
		// TODO Auto-generated constructor stub
	}

}

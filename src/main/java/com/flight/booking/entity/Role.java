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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Navin
 * 
 * ####################################################################################
 * ########### THIS CLASS INTENDS TO DEFINE USER TYPE EG. REGISTERED , UNREGISTERED ### 
 * ####################################################################################
 *
 */


@Data
@Entity
@Table(name = "ROLE_TYPES")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String roleName;
	
	@Column
	private String roleDesc;	
	
	@Column
	private Boolean activeFlag;	
	
	

}

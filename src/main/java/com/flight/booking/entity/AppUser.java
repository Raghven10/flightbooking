package com.flight.booking.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


/**
 * @author Navin
 * 
 * ####################################################################################
 * ########### THIS CLASS INTENDS TO STORE APP USER DATA ################# 
 * ####################################################################################
 */

@Data
@Entity
@Table(name = "APP_USER")
public class AppUser implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;	
	
	@Column(name="EMAIL_ID")
	private String email;
	
	@Column(name="MOBILE_NO")
	private String mobileNo;
	
	@Column(name="USER_DOB")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;	
	
	@Column
	private String imageUrl;
	
    @Lob
    @Column(name = "pic")
    private byte[] pic;
	
	@Column
	private String password;
	
	@Column
	private Boolean activeFlag;
	
	@Column
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name="LRNO_APP_USER_ROLES",
			joinColumns = {
		            @JoinColumn(name = "app_user_id", referencedColumnName = "id")
		        },
		        inverseJoinColumns = {
		            @JoinColumn(name = "role_id", referencedColumnName = "id")
		        })
	public List<Role> roles;
	
	

	public AppUser(String firstName, String lastName) {
		
	}


	public AppUser(String firstName, String lastName, String imageUrl) {
		firstName = this.firstName;
		lastName = this.lastName;
		imageUrl = this.lastName;
	}


	/**
	 * @param id2
	 * @param email2
	 * @param compressBytes
	 */
	public AppUser(Long id2, String email2, byte[] compressBytes) {
		this.id=id2;
		this.email = email2;
		this.pic=compressBytes;
	}


	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}

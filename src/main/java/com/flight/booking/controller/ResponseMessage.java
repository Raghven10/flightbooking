/**
 * 
 */

package com.flight.booking.controller;

import lombok.Data;

/**
 * @author navin
 *
 */
@Data
public class ResponseMessage {

	private String message;
	
	
	public ResponseMessage(String message) {
		super();
		this.message = message;
	}
	
}

package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.NFRegistrationExceptions;

import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects.CollegeDetails;

import lombok.Data;

@Data
public class ErrorObject {
	
	private Integer statusCode;
	private String message;
	private long timestamp;

}

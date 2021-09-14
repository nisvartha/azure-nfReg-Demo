package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.operations.commands;

import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.entities.User;

import lombok.Data;

@Data
public class RegistrationUserCommand {
	
	
    private String applicationFormNumber;
	private User applicationform;
	private String applicationStatus;
	
	
	public RegistrationUserCommand(String applicationFormNumber, User applicationform, String applicationStatus) {
		super();
		this.applicationFormNumber = applicationFormNumber;
		this.applicationform = applicationform;
	}


}

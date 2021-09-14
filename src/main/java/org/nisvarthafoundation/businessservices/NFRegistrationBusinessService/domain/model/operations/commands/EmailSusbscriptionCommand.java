package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.operations.commands;


import lombok.Data;

@Data
public class EmailSusbscriptionCommand {
	
		
	private String firstName;
	private String lastName;
	private String emailId;	
	
	public EmailSusbscriptionCommand(String firstName, String lastName, String emailId) {
		super();		
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId= emailId;
	}
}


package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "genericEmailSubscription")
public class Subscription {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String emailId;
	
	public Subscription(String firstName, String lastName, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}

}

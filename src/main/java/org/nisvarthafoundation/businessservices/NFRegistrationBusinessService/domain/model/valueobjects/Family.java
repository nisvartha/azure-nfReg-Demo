package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects;


import lombok.Data;
@Data
public class Family {
	
	private String familyAnnualIncome;
	private String currency;
	private String totalFamilyMembers;
	private String documentsPath;
	private String fatherName;
	private String motherName;
	private String fatherOccupation;
	private String motherOccupation;
	private Contact contact;	
	
}

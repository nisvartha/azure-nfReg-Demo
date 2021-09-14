package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects;

import lombok.Data;

@Data
public class StudentEducationDetails {
	private String course;
	private String accademicyear;
	private String semester;
	private String status;

}

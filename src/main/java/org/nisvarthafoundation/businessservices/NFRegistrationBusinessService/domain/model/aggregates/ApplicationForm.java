package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.aggregates;

import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.entities.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="registration")
@TypeAlias("CandidateRegistrationForm")
public class ApplicationForm {
	
	@Id
    private String applicationFormNumber;
	private User applicationform;
	private String applicationStatus;
	private String applicationYear;

}
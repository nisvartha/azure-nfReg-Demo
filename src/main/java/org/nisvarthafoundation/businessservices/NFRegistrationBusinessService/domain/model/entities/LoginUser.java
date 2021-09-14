package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.entities;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="credentials")
@TypeAlias("CandidateCredentials")
@JsonIgnoreProperties(ignoreUnknown=true)
public class LoginUser {
	

	private String userName;
	private String password;
	private String active;
	private String updatedBy;
	private String updatedDate;
	private String roles[];

}

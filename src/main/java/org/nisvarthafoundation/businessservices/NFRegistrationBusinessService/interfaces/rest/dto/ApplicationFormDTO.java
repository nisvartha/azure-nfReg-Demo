package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.interfaces.rest.dto;


import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.entities.User;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class ApplicationFormDTO {
	
    private String applicationFormNumber;
	private User applicationform;
	private String applicationStatus;

}
package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.entities;



import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects.NisvarthaFinanceRecord;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects.NisvarthaMentorRecord;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects.NisvarthaStudentDocumentsRecord;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects.NisvarthaStudentRecord;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects.Sponsorshiprecord;
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
@Document(collection="students")
public class NisvarthaRecord {
	
	private String applicationFormNumber;
	private String nisvarthaStudentID;
	private NisvarthaStudentRecord NisvarthaStudentRecord;
	private NisvarthaMentorRecord NisvarthaMentorRecord;
	private NisvarthaFinanceRecord NisvarthaFinanceRecord;
	private Sponsorshiprecord sponsorshiprecord;
	private NisvarthaStudentDocumentsRecord NisvarthaDocumentsRecord;

}
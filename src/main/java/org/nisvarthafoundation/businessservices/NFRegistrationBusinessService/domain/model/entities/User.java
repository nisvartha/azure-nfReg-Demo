package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.entities;


import org.bson.types.Binary;



import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects.EducationDetails;

import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects.Family;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects.IdentificationDetails;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects.PersonalDetails;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class User {

@Id
private String id;
private IdentificationDetails identificationDetails;
private Family familyDetails;
private PersonalDetails personalDetails;
private EducationDetails educationDetails;
private Binary casteProof;
private String casteProofSubmitted;
private Binary incomeProof;
private String incomeProofSubmitted;
private Binary passbookProof;
private String passbookProofSubmitted;
private Binary housephotoProof;
private String housephotoProofSubmitted;
private Binary studentwriteupProof;
private String studentwriteupProofSubmitted;
private Binary parentwriteupProof;
private String parentwriteupProofSubmitted;
private Binary bplcardProof;
private String bplcardProofSubmitted;
private Binary markscardProof;
private String markscardProofSubmitted;
private Binary signedapplicationformProof;
private String signedapplicationformProofSubmitted;


}
package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects;

import org.bson.types.Binary;

import lombok.Data;

@Data
public class NisvarthaStudentDocumentsRecord {
	
	private Binary casteProof;
	private Binary incomeProof;
	private Binary passbookProof;
	private Binary houseProof;
	private Binary studentWriteupProof;
	private Binary parentsWriteupProof;
	private Binary bplCardProof;
	private Binary markscardProof;
	private Binary signedcopyofApplicaitonFormProof;
	
}

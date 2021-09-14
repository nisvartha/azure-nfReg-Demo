package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class candidatePendingFormDTO {
	
	private String nisvarthaTANId;
	private String candidateEmailId;
	private String casteProofFileStatus;
	private String bplcardProofFileStatus;
	private String incomeProofFileStatus;
	private String passbookProofFileStatus;
	private String housephotoProofFileStatus;
	private String studentwriteupProofFileStatus;
	private String parentwriteupProofFileStatus;
	private String markscardProofFileStatus;
	private String signedapplicationformProofFileStatus;

}

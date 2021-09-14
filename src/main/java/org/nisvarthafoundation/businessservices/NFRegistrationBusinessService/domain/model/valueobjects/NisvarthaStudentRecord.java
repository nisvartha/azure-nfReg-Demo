package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects;

import lombok.Data;

@Data
public class NisvarthaStudentRecord {
	private String fatherName;
	private String fatherStatus;
	private String motherName;
	private String motherStatus;
	private String primaryphone;
	private String secondaryphone;
	private String emailId;
	private String studentName;
	private String photo;
	private String religion;
	private String caste;
	private String age;
	private String sex;
	private String dateofBirth;
	private Address primaryAddress;
	private Address secondaryAddress;
	private EducationRecord educationRecord;
	private NisvarthaStudentDocumentsRecord documentrecord;
	}

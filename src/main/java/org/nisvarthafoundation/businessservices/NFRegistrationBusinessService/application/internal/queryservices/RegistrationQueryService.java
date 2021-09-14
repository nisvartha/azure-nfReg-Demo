package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.application.internal.queryservices;

import java.util.List;

import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.aggregates.ApplicationForm;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.entities.LoginUser;


public interface RegistrationQueryService {
	
	public ApplicationForm getTempApplicationFormDetails(String applicationNumber);
	public boolean isAValidNFTAN(LoginUser validateLoginUserDetails);
	public long getCountofApplicationForms();
	public long getNisvarthaStudentsCount();
	public List<ApplicationForm> getPendingFormsList();

}

package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.interfaces.rest.tranform;

import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.operations.commands.RegistrationUserCommand;

import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.interfaces.rest.dto.ApplicationFormDTO;

public class RegistrationDTOAssembler {

	
	    public static RegistrationUserCommand toCommandFromDTO(ApplicationFormDTO applicationFormDTO){
	    	
	    
	        return new RegistrationUserCommand(applicationFormDTO.getApplicationFormNumber(),
	        		applicationFormDTO.getApplicationform(),
	        		applicationFormDTO.getApplicationStatus());
	                                    
	        
	        
	    }
	}

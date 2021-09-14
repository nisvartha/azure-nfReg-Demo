package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.interfaces.rest.tranform;

import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.operations.commands.EmailSusbscriptionCommand;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.interfaces.rest.dto.SubscriptionDTO;

public class EmailSubscriptionDTOAssembler {
	
	
    public static EmailSusbscriptionCommand toCommandFromDTO(SubscriptionDTO subscriptionDTO){    
    

        return new EmailSusbscriptionCommand(subscriptionDTO.getFirstName(),subscriptionDTO.getLastName(),subscriptionDTO.getEmailId());

    }
}

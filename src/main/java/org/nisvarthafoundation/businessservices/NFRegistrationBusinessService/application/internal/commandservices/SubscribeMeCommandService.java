package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.application.internal.commandservices;

import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.operations.commands.EmailSusbscriptionCommand;

import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.valueobjects.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubscribeMeCommandService {
	
	
	// creating mongodb template for query
    @Autowired
	MongoTemplate mongoTemplate;
   
	
    public void subscribeUserforEmail(EmailSusbscriptionCommand emailSusbscriptionCommand){    	
  
        Subscription subscription = new Subscription(emailSusbscriptionCommand.getFirstName(),emailSusbscriptionCommand.getLastName(),emailSusbscriptionCommand.getEmailId());
        mongoTemplate.save(subscription);
    
    }


}

package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.interfaces.rest;


import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.application.internal.commandservices.SubscribeMeCommandService;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.interfaces.rest.dto.SubscriptionDTO;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.interfaces.rest.tranform.EmailSubscriptionDTOAssembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = { "http://localhost:4200" })
@Controller    // This means that this class is a Controller
@RequestMapping("/GenericEmailSubscription")
public class EmailSubscripitonController {
	
	
	@Autowired
    private SubscribeMeCommandService subscribeMeCommandService;


    @PostMapping("/surscribeUser")
    @ResponseBody
    public void subscribeUser(@RequestBody  SubscriptionDTO susbscriptionDTO){	
    	
    	subscribeMeCommandService.subscribeUserforEmail(EmailSubscriptionDTOAssembler.toCommandFromDTO(susbscriptionDTO));
    	        
    }

}

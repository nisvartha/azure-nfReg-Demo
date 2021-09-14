package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.interfaces.rest;


import java.io.IOException;
import java.util.List;

import org.bson.types.Binary;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.NFRegistrationExceptions.WrongInputException;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.application.internal.commandservices.RegistrationCommandService;




import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.application.internal.queryservices.RegistrationQueryService;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.aggregates.ApplicationForm;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.aggregates.ApplicationFormNumber;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.entities.LoginUser;

import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.interfaces.rest.dto.ApplicationFormDTO;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.interfaces.rest.tranform.RegistrationDTOAssembler;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins = { "http://localhost:4200" })
@Controller    // This means that this class is a Controller
@RequestMapping("/Registration")
@Slf4j
public class RegistrationController {

@Autowired
   private RegistrationCommandService registrationCommandService;
@Autowired
   private RegistrationQueryService registrationQueryService;

final private String PROOF_SUBMITED="Yes";
final private String PROOF_NOT_SUBMITED="No";

@PostMapping("/registerUser")
   @ResponseBody
   public ApplicationFormNumber saveUserApplicationForm(
    @RequestPart(value="formData") String formData,    
    @RequestPart(value="casteProofFile",required = false) final MultipartFile casteProofFileReceived,
    @RequestPart(value="bplcardProofFile",required = false) final MultipartFile bplcardProofFileReceived,
    @RequestPart(value="incomeProofFile",required = false) final MultipartFile incomeProofFileReceived,
    @RequestPart(value="passbookProofFile",required = false) final MultipartFile passbookProofFileReceived,
    @RequestPart(value="housephotoProofFile",required = false) final MultipartFile housephotoProofFileReceived,
    @RequestPart(value="studentwriteupProofFile",required = false) final MultipartFile studentwriteupProofFileReceived,
    @RequestPart(value="parentwriteupProofFile",required = false) final MultipartFile parentwriteupProofFileReceived,
    @RequestPart(value="markscardProofFile",required = false) final MultipartFile markscardProofFileReceived,
    @RequestPart(value="signedapplicationformProofFile",required = false) final MultipartFile signedapplicationformProofFileReceived
                        
    
    ){
	

   
    ObjectMapper mapper = new ObjectMapper();
    ApplicationFormDTO applicationFormDTO = new ApplicationFormDTO();
   
       
    try {
    applicationFormDTO =  mapper.readValue(formData, ApplicationFormDTO.class);
    
   System.out.println("signedapplicationformProofFile size of the file "+signedapplicationformProofFileReceived.getSize());
   
    if(casteProofFileReceived!=null)
    {

    Binary casteProofFileReceivedBinary = new Binary(casteProofFileReceived.getBytes());
    applicationFormDTO.getApplicationform().setCasteProof(casteProofFileReceivedBinary);
    applicationFormDTO.getApplicationform().setCasteProofSubmitted(this.PROOF_SUBMITED);
   
    }
    else
    {
    applicationFormDTO.getApplicationform().setCasteProofSubmitted(this.PROOF_NOT_SUBMITED);
    }
    
    if(bplcardProofFileReceived!=null)
    {
    
    Binary bplcardProofFileReceivedBinary = new Binary(bplcardProofFileReceived.getBytes());
    applicationFormDTO.getApplicationform().setBplcardProof(bplcardProofFileReceivedBinary);;
    applicationFormDTO.getApplicationform().setBplcardProofSubmitted(this.PROOF_SUBMITED);
    }
    else
    {
  
    applicationFormDTO.getApplicationform().setBplcardProofSubmitted(this.PROOF_NOT_SUBMITED);
    }
    
    if(incomeProofFileReceived!=null)
    {
    
    Binary incomeProofFileReceivedBinary = new Binary(incomeProofFileReceived.getBytes());
    applicationFormDTO.getApplicationform().setIncomeProof(incomeProofFileReceivedBinary);
    applicationFormDTO.getApplicationform().setIncomeProofSubmitted(this.PROOF_SUBMITED);
    }
    else
    {
  
    applicationFormDTO.getApplicationform().setIncomeProofSubmitted(this.PROOF_NOT_SUBMITED);
    }
    
   
 if(passbookProofFileReceived!=null)
 {
     Binary passbookProofFileReceivedBinary = new Binary(passbookProofFileReceived.getBytes());
     applicationFormDTO.getApplicationform().setPassbookProof(passbookProofFileReceivedBinary);
     applicationFormDTO.getApplicationform().setPassbookProofSubmitted(this.PROOF_SUBMITED);
 }
 else
 {
	 applicationFormDTO.getApplicationform().setPassbookProofSubmitted(this.PROOF_NOT_SUBMITED);
 }
    
 if(housephotoProofFileReceived!=null)
 {
     Binary housephotoProofFileReceivedBinary = new Binary(housephotoProofFileReceived.getBytes());
     applicationFormDTO.getApplicationform().setHousephotoProof(housephotoProofFileReceivedBinary);
     applicationFormDTO.getApplicationform().setHousephotoProofSubmitted(this.PROOF_SUBMITED);
 }
 else
 {
	 applicationFormDTO.getApplicationform().setHousephotoProofSubmitted(this.PROOF_NOT_SUBMITED);
 }
    
 if(studentwriteupProofFileReceived!=null)
 {
     Binary studentwriteupProofFileReceivedBinary = new Binary(studentwriteupProofFileReceived.getBytes());
     applicationFormDTO.getApplicationform().setStudentwriteupProof(studentwriteupProofFileReceivedBinary);
     applicationFormDTO.getApplicationform().setStudentwriteupProofSubmitted(this.PROOF_SUBMITED);
 }
 else
 {
	 applicationFormDTO.getApplicationform().setStudentwriteupProofSubmitted(this.PROOF_NOT_SUBMITED);
 }
 
 if(parentwriteupProofFileReceived!=null)
 {
    
     Binary parentwriteupProofFileReceivedBinary = new Binary(parentwriteupProofFileReceived.getBytes());
     applicationFormDTO.getApplicationform().setParentwriteupProof(parentwriteupProofFileReceivedBinary);
     applicationFormDTO.getApplicationform().setParentwriteupProofSubmitted(this.PROOF_SUBMITED);
 }
 else
 {
	 applicationFormDTO.getApplicationform().setParentwriteupProofSubmitted(this.PROOF_NOT_SUBMITED);
 }
    
    if(markscardProofFileReceived!=null)
    {
     Binary markscardProofFileReceivedBinary = new Binary(markscardProofFileReceived.getBytes());
     applicationFormDTO.getApplicationform().setMarkscardProof(markscardProofFileReceivedBinary);
     applicationFormDTO.getApplicationform().setMarkscardProofSubmitted(this.PROOF_SUBMITED);
    }
    else
    {
    	applicationFormDTO.getApplicationform().setMarkscardProofSubmitted(this.PROOF_NOT_SUBMITED);
    }
    
    if(signedapplicationformProofFileReceived!=null)
    {
    	System.out.println("Inside signed applicaiton");
     Binary signedapplicationformProofFileReceivedBinary = new Binary(signedapplicationformProofFileReceived.getBytes());
     applicationFormDTO.getApplicationform().setSignedapplicationformProof(signedapplicationformProofFileReceivedBinary);
     applicationFormDTO.getApplicationform().setSignedapplicationformProofSubmitted(this.PROOF_SUBMITED);
    }
    else
    {
    	System.out.println("signed application is not submitted and in else loop");
    	applicationFormDTO.getApplicationform().setSignedapplicationformProofSubmitted(this.PROOF_NOT_SUBMITED);
    }
   
} catch (IOException e1) {

e1.printStackTrace();
}
   
   
   
    ApplicationFormNumber applicationFormNumber  = registrationCommandService.registerUser(RegistrationDTOAssembler.toCommandFromDTO(applicationFormDTO));
   
    return applicationFormNumber;
       
   }
   
   
   @GetMapping("/allApplictionForm/count")
   @ResponseBody
   public long getCountofApplicationForms(){
   
    return registrationQueryService.getCountofApplicationForms();
 
   }
   
   @GetMapping("/NisvarthaStudent/count")
   @ResponseBody
   public long getNisvarthaStudentsCount(){
    return registrationQueryService.getNisvarthaStudentsCount();
 
   }
   
   @GetMapping("/NisvarthaStudent/pendingForms")
   @ResponseBody
   public List<ApplicationForm> getPendingFormsList(){
    return registrationQueryService.getPendingFormsList();
 
   }
   
   @GetMapping("/getTAFDetails/{applicationNumber}")
   @ResponseBody
   public ApplicationForm getTempApplicationFormDetails(@PathVariable String applicationNumber){
	   
	   if(applicationNumber==null || applicationNumber.isEmpty() || applicationNumber.isBlank())
	   {
		   throw new WrongInputException("Please provide valid applicaiton form Number"); 
		   
	   }
	   return registrationQueryService.getTempApplicationFormDetails( applicationNumber);

 
   }

@PostMapping("/Auth/isValidNFTAN")
@ResponseBody
   public boolean isAValidNFTAN(@RequestPart(value="formData") String formData) {
	
	
	ObjectMapper mapper = new ObjectMapper();
    LoginUser lu = new LoginUser();
  
    try {
    	
    	if(lu!=null) {
    		lu =  mapper.readValue(formData, LoginUser.class);
    	}
    	else
    	{
    		log.info("Something went wrong while parsing login form object");
    	}
		
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 String theUserName= lu.getUserName();
	 String thePassword = lu.getPassword();
			 
	if(theUserName==null || theUserName.isBlank() || theUserName.isEmpty()) {
		
		throw new WrongInputException("Please provide valid userName : " + theUserName); 
		
	}
	else if(thePassword==null || thePassword.isBlank() || thePassword.isEmpty()) {
		
		throw new WrongInputException("Please provide valid password for the user "+ theUserName); 
		
	}

	else return registrationQueryService.isAValidNFTAN(lu);
}


 
   
}



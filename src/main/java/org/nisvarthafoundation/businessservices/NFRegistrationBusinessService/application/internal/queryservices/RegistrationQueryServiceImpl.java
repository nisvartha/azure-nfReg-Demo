package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.application.internal.queryservices;


import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.NFRegistrationExceptions.ResourceNotFoundException;


import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.aggregates.ApplicationForm;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.entities.LoginUser;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.entities.NisvarthaRecord;


import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators.Or;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;


/**
 * Application Service which caters to all queries related to the Booking Bounded Context
 */
@Service
public class RegistrationQueryServiceImpl implements RegistrationQueryService  {
	
	boolean status=false;

    
    // creating mongodb template for query
    @Autowired
	MongoTemplate mongoTemplate;
    
    @Autowired
    RestTemplate restTemplate;  


    public long getCountofApplicationForms(){
    Query query = new Query();
    return mongoTemplate.count(query, ApplicationForm.class);
    }
    

    public long getNisvarthaStudentsCount(){    	
    Query query = new Query();
    return mongoTemplate.count(query, NisvarthaRecord.class);
    }

  	
	@Override
	public ApplicationForm getTempApplicationFormDetails(String applicationNumber) {	
		
		Query query = new Query();
		query.addCriteria(Criteria.where("applicationFormNumber").is(applicationNumber));
		ApplicationForm theApplicationForm = mongoTemplate.findOne(query, ApplicationForm.class);
		if(theApplicationForm!=null)
	   	{
	   		return theApplicationForm;
	   	}
	   	throw new ResourceNotFoundException("No applicaiton form found for the given id : " + applicationNumber);
	 
	   }
	
	@Override
	public List<ApplicationForm> getPendingFormsList() {	
		
		Query query = new Query();
		int currentYear = Year.now().getValue();
		
		
		query.addCriteria(
			    new Criteria().andOperator(
			    		Criteria.where("applicationYear").is(String.valueOf(currentYear)),
			    		Criteria.where("applicationStatus").is("PENDING")
			    )
			);
		query.fields().include("_id");
		query.fields().include("applicationform.personalDetails.contact.emailId");
        query.fields().include("applicationform.casteProofSubmitted");
        query.fields().include("applicationform.incomeProofSubmitted");
        query.fields().include("applicationform.passbookProofSubmitted");
        query.fields().include("applicationform.housephotoProofSubmitted");
        query.fields().include("applicationform.studentwriteupProofSubmitted");
        query.fields().include("applicationform.parentwriteupProofSubmitted");
        query.fields().include("applicationform.bplcardProofSubmitted");
        query.fields().include("applicationform.markscardProofSubmitted");
        query.fields().include("applicationform.signedapplicationformProofSubmitted");
        

		
       List <ApplicationForm> filteredApplicationForm =  mongoTemplate.find(query, ApplicationForm.class);
  
       filteredApplicationForm = filteredApplicationForm.stream()
    			    .filter(
    			            p -> p.getApplicationform().getCasteProofSubmitted().equals("No") ||  
    			                 p.getApplicationform().getBplcardProofSubmitted().equals("No") ||
    			                 p.getApplicationform().getIncomeProofSubmitted().equals("No") ||
    			                 p.getApplicationform().getPassbookProofSubmitted().equals("No") ||
    			                 p.getApplicationform().getHousephotoProofSubmitted().equals("No") ||
    			                 p.getApplicationform().getStudentwriteupProofSubmitted().equals("No") ||
    			                 p.getApplicationform().getParentwriteupProofSubmitted().equals("No") ||
    			                 p.getApplicationform().getMarkscardProofSubmitted().equals("No") ||
    			                 p.getApplicationform().getSignedapplicationformProofSubmitted().equals("No")
    			        
    			           )
    			    .collect(Collectors.toList());

       return filteredApplicationForm;
	   }


	
	@Override
	public boolean isAValidNFTAN(LoginUser validateLoginUserDetails) {

		    status=false;
		    Query query = new Query();
		    query.addCriteria(Criteria.where("userName").is(validateLoginUserDetails.getUserName()));
		    String sha256hex = DigestUtils.sha256Hex(validateLoginUserDetails.getPassword());
		    LoginUser lu = mongoTemplate.findOne(query, LoginUser.class);
		    System.out.println("User name:" + validateLoginUserDetails.getUserName());
	    	System.out.println("password sha engrypted from react:"+sha256hex);
	    	
	    	System.out.println("password fetched from database   :"+lu.getPassword());
	    	 
		    if(lu!=null)
		    {
		    	
		    		if(sha256hex.equals(lu.getPassword()))	  	    	  
			         {   
		    	
			  	         status=true;
			  	        
			         }

		    }
		    else
		    {
		    	System.out.println("Something went wrong during login for -->"+validateLoginUserDetails.getUserName());
		    	status=false;
		    }
		    
		 return status;
	           
			    		        
			  }

   }

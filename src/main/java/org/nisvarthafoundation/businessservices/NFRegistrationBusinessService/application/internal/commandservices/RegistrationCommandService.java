package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.application.internal.commandservices;


import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.aggregates.ApplicationForm;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.aggregates.ApplicationFormNumber;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.entities.LoginUser;

import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.operations.commands.RegistrationUserCommand;
import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.rules.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.domain.model.rules.Constants;

@Slf4j
@Service
public class RegistrationCommandService {	
	// creating mongodb template for query
    @Autowired
	MongoTemplate mongoTemplate;  	
    public ApplicationFormNumber registerUser(RegistrationUserCommand registrationUserCommand){
    	
    	String theApplicationFormNumber = registrationUserCommand.getApplicationFormNumber();
    	System.out.println("Application form number already present--> "+theApplicationFormNumber);
    	System.out.println("************* "+registrationUserCommand.getApplicationStatus() );
    	
    	if(theApplicationFormNumber!=null)
    	{
    		Query query = new Query();
    		query.addCriteria(Criteria.where("_id").is(theApplicationFormNumber));
    		
    		ApplicationForm theapplicationform = mongoTemplate.findOne(query, ApplicationForm.class);
    		System.out.println("Exising data fetcheed for candaite before updates-->" + theapplicationform.toString());
    		if(theapplicationform!=null) {
    			
    		 theapplicationform = new ApplicationForm(registrationUserCommand.getApplicationFormNumber(),
    				 registrationUserCommand.getApplicationform(), 
    				 Constants.status,
    				 Year.now().toString());
       	     System.out.println("EXISTING USER AND UPDATEING THE DATA" + theapplicationform.toString());
       	     //Update update = new Update();
       	     //mongoTemplate.findAndModify(query, update, ApplicationForm.class);
       	     
       	     theapplicationform= mongoTemplate.save(theapplicationform);
    	
    		}
    		
    	}
    	else
    	{
    		
    		System.out.println("NEW CANDIDATE REGISTRAITON STARTS--");
    		theApplicationFormNumber = "NFTAN-"+ Year.now()+"-"+RandomStringUtils.random(6, "WWA11233455677899ABBCCDDEEFFGGKKMMMLLVVEEKKAARRNNAATTAAKKAANNSSVVAARRTTHANDA223334444555556666666777777778888888889999999990"+System.currentTimeMillis()).toUpperCase();
    		System.out.println("NEW NISVARTHA ID CREATED  ->"+theApplicationFormNumber);
            registrationUserCommand.setApplicationFormNumber(theApplicationFormNumber);
            registrationUserCommand.setApplicationStatus(Constants.status);
            String studentdoj = registrationUserCommand.getApplicationform().getPersonalDetails().getDateofBirth();
            if(studentdoj!=null || studentdoj.isEmpty() || studentdoj.isBlank())
            {
            	 String [] dateParts = studentdoj.split("-");
                 String year = dateParts[0];
                 String month = dateParts[1];
                 String day = dateParts[2];    
           
                 LocalDate today = LocalDate.now();                   //Today's date         
                 LocalDate birthday = LocalDate.of(Integer.parseInt(year) , Integer.parseInt(month), Integer.parseInt(day)); //Birth date         
                 Period period = Period.between(birthday, today);
                 registrationUserCommand.getApplicationform().getPersonalDetails().setAge(period.getYears()); 
            
            }
            else
            {
            	log.info("Failed during creating of candidate Application form, please check the Date of Birth : " +studentdoj);
            
            }
              
            ApplicationForm theapplicationform = new ApplicationForm(registrationUserCommand.getApplicationFormNumber(),registrationUserCommand.getApplicationform(), registrationUserCommand.getApplicationStatus(),Year.now().toString());
            theapplicationform= mongoTemplate.save(theapplicationform);
          if(theapplicationform!=null)
          {
              
        	  String tempPassword = RandomStringUtils.random(6, "WWVVXXYYKKMPRSTULOVENDA23334444555556666666LOVENSVARTHA2777777778888888889999999990").toUpperCase();
              System.out.println("candidate PLAIN TEXT password -->"+tempPassword);
        	  LoginUser theCandidateCredentials= new LoginUser();
              theCandidateCredentials.setUserName(theApplicationFormNumber);
              String encodedPassword_base_64 = Base64.getEncoder().encodeToString(tempPassword.getBytes(StandardCharsets.UTF_8));
              System.out.println("BASE 64 Encoded Password-->"+encodedPassword_base_64);
              String hashedPassword = DigestUtils.sha256Hex(encodedPassword_base_64);
              theCandidateCredentials.setPassword(hashedPassword);
              Date date = Calendar.getInstance().getTime();
              DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
              String strDate = dateFormat.format(date);
              theCandidateCredentials.setUpdatedDate(strDate);
              theCandidateCredentials.setActive("Active");
              String[] candidateRole = new String[] {"Candidate"};
              theCandidateCredentials.setRoles(candidateRole);
              theCandidateCredentials= mongoTemplate.save(theCandidateCredentials);
              if(theCandidateCredentials!=null)
              {
            	  System.out.println("PLEASE PLUG IN NOFICIAITON COMPONET HERE");
              }
              else
              {
            	  System.out.println("SEND EMAIL ASKING FOR USER NAME AND PASSWORD FROM NISVARTHA");
              }
              
        	  
          }
          else
          {
        	  log.info("Application form failed, please verify"+ System.currentTimeMillis());
        	  System.out.println("YOU NEED TO SEND APPLICAITON FORM FAILERU EMAIL");
        	  return new ApplicationFormNumber("000000");
        	 
          }
          
        }
	
    	
    	return new ApplicationFormNumber(theApplicationFormNumber);
    }
}
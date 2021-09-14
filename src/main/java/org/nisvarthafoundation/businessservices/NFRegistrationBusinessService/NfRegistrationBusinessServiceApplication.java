package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NfRegistrationBusinessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NfRegistrationBusinessServiceApplication.class, args);
		final Logger LOGGER=LoggerFactory.getLogger(NfRegistrationBusinessServiceApplication.class);		
		LOGGER.info("<<---------------------------Nisvartha Student Registrtion  Business Service Started----------------------------->>");
	}
	
	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }

}

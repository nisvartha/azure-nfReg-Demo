package org.nisvarthafoundation.businessservices.NFRegistrationBusinessService.NFRegistrationExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleResourceNotFoundException(ResourceNotFoundException rnfex)
	{
		ErrorObject eObject= new ErrorObject();
		eObject.setStatusCode(HttpStatus.NOT_FOUND.value());
		eObject.setMessage(rnfex.getMessage());
		eObject.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(eObject,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleNoDataFoundException(NoDataFoundException ndfex)
	{
		ErrorObject eObject= new ErrorObject();
		eObject.setStatusCode(HttpStatus.NO_CONTENT.value());
		eObject.setMessage(ndfex.getMessage());
		eObject.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(eObject,HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorObject> handleWrongInputException(WrongInputException ndfex)
	{
		ErrorObject eObject= new ErrorObject();
		eObject.setStatusCode(HttpStatus.PRECONDITION_FAILED.value());
		eObject.setMessage(ndfex.getMessage());
		eObject.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(eObject,HttpStatus.OK);
	}

}

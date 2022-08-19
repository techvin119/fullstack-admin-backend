package com.fse.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidCriteriaException.class)
		public ResponseEntity<?> handleCriteriaException(InvalidCriteriaException Ex){
			
			return new ResponseEntity<>("Invalid Criteria. Valid Criteria are - prefix, AssociateId and skill",HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(InvalidSkillTypeException.class)
	public ResponseEntity<?> handleSkillException(InvalidSkillTypeException Ex){
		
		return new ResponseEntity<>("Invalid Skill in Criteria Value",HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ProfileNotFoundException.class)
	public ResponseEntity<?> handleNoProfileException(ProfileNotFoundException Ex){
		
		return new ResponseEntity<>("No Profile found for this request",HttpStatus.OK);
	}
	
	
}

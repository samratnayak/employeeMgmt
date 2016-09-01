package com.project.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;


public class ValidEmailImpl implements ConstraintValidator<ValidEmail,String> {

	private int minLen;
	private int maxLen;
	@Override
	public void initialize(ValidEmail validMail) {
		// TODO Auto-generated method stub
		
		minLen = validMail.min();
		maxLen = validMail.max();
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext con) {
		// TODO Auto-generated method stub
		if(email.length()<minLen||email.length()>maxLen){
			return false;
		}
		else if(!EmailValidator.getInstance().isValid(email)){
			return false;
		}
		return true;
	}
	
}

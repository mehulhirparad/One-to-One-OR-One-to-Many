package com.hrms.system.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringValidConstrainValidation implements ConstraintValidator<StringValid, String>
{
	
	private int lenghtCount;
	
	@Override
	public void initialize(StringValid theStringValid)
	{
		lenghtCount = theStringValid.value();
	}	
	
	@Override
	public boolean isValid(String firstName, ConstraintValidatorContext theConstraintValidatorContext) {
		int a=firstName.length();
		boolean result=(a<=lenghtCount);
		System.out.println("no");
			
		return result;
	}
		
}

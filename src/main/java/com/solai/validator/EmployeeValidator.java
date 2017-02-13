package com.solai.validator;

import com.solai.exception.ValidatorException;
import com.solai.model.Employee;
import com.solai.util.Validator;

public class EmployeeValidator 
{
	Validator validator=new Validator();
	public void save (Employee employee) throws ValidatorException
	{
		validator.isInvalid(employee.getName(), "NAME");
		validator.isInvalid(employee.getEmailId(), "EMAILID");
		validator.isInvalid(employee.getPassword(),"PAASWORD");
	}
}





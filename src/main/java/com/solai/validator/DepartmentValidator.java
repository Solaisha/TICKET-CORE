package com.solai.validator;

import com.solai.exception.ValidatorException;
import com.solai.model.Department;
import com.solai.util.Validator;

public class DepartmentValidator 
{
	Validator validator =new Validator();
	public void save(Department department) throws ValidatorException
	{
		validator.isInvalid(department.getName(), "NAME");
	}
}

package com.solai.validator;

import com.solai.exception.ValidatorException;
import com.solai.model.User;
import com.solai.util.Validator;

public class UserValidator {
	Validator validator=new Validator();
	public void save(User user) throws ValidatorException
	{

		validator.isInvalid(user.getName(), "NAME");
		validator.isInvalid(user.getEmailId(),"EMAIL_ID");
		validator.isInvalid(user.getPassword(), "PASSWORD");

	}
}
package com.solai.dao;

import com.solai.exception.PersistenceException;

public class UserLoginDAO {

	UserDAO userDAO=new UserDAO();
	EmployeeDAO employeeDAO=new EmployeeDAO();
	public boolean userLogin(String emailId,String password) throws PersistenceException  
	{
			userDAO.findOne(emailId,password).getId();
							return true;

	}
	
	
	public boolean employeeLogin(String emailId,String password) throws PersistenceException  
	{
			employeeDAO.findOne(emailId,password).getId();

						return true;
	
	
}

}
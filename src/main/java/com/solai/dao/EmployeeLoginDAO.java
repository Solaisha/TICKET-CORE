package com.solai.dao;

import com.solai.exception.PersistenceException;

public class EmployeeLoginDAO 
{
EmployeeDAO employeeDAO=new EmployeeDAO();

	public boolean employeeLogin(String emailId,String password) throws PersistenceException  
	{
			employeeDAO.findOne(emailId,password).getId();

						return true;
	
	
}
}

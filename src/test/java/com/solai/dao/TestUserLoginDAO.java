package com.solai.dao;

import com.solai.exception.PersistenceException;

public class TestUserLoginDAO {

	public static void main(String[] args) throws PersistenceException 
	{
		UserLoginDAO userLoginDAO=new UserLoginDAO();
//		System.out.println(userLoginDAO.userLogin("SARA@GMAIL.COM","sara"));
		
		EmployeeDAO employeeDAO=new EmployeeDAO();
		System.out.println(userLoginDAO.employeeLogin("SHAM@gmail.COM","sham*"));
	}

}

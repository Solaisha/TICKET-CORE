package com.solai.dao;

import com.solai.exception.PersistenceException;

public class TestEmployeeLoginDAO {

	public static void main(String[] args) throws PersistenceException 
	{
		EmployeeLoginDAO employeeLoginDAO=new EmployeeLoginDAO();
		System.out.println(employeeLoginDAO.employeeLogin("SHAM@GMAIL.COM", "sham*"));
	}

}

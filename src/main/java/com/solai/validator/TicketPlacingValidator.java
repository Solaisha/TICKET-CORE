package com.solai.validator;

import com.solai.exception.ValidatorException;
import com.solai.util.Validator;

public class TicketPlacingValidator 
{
	Validator validator=new Validator();
	
	public void userRegistration(String name, String emailId, String password) throws ValidatorException 
	{
		validator.isInvalid(name, "NAME");
		validator.isInvalid(emailId, "EMAILID");
		validator.isInvalid(password, "PASSWORD");
	}
	
	
	public void findOne(int id) throws ValidatorException
	{
		validator.isInvalid(id, "ID");
		
	}
	
	public void userLogin(String emailId,String password) throws ValidatorException
	{
		validator.isInvalid(emailId,"EMAILID");
		validator.isInvalid(password, "PASSWORD");
	}
 
	
	public void employeeLogin(String emailId,String password) throws ValidatorException
	{
		validator.isInvalid(emailId,"EMAILID");
		validator.isInvalid(password, "PASSWORD");
	}
 
	
public void creatingTicket(String emailId,String password,String subject,String description,String name,String priority) throws ValidatorException{
	
	validator.isInvalid(emailId, "EMAILID");
	validator.isInvalid(password, "PASSWORD");
	validator.isInvalid(subject, "SUBJECT");
	validator.isInvalid(description, "DESCRIPTION");
	validator.isInvalid(name, "NAME");
	validator.isInvalid(priority, "PRIORITY");
}

public void updatingTicket(String emailId,String password,int issueId,String updateDescription) throws ValidatorException{
	
	validator.isInvalid(emailId, "EMAILID");
	validator.isInvalid(password, "PASSWORD");
	validator.isInvalid(issueId, "ISSUE_ID");
	validator.isInvalid(updateDescription, "DESCRIPTION");
}

public void updateTicketClose(String emailId,String password,int issueId) throws ValidatorException{
	
	validator.isInvalid(emailId, "EMAILID");
	validator.isInvalid(password, "PASSWORD");
	validator.isInvalid(issueId, "ISSUE_ID");
	
}

public void findUserRecords(String emailId,String password) throws ValidatorException{
	
	validator.isInvalid(emailId, "EMAILID");
	validator.isInvalid(password, "PASSWORD");
	
}

public void assigningEmployee(String emailId, String password, int issueId, int employeeId) throws ValidatorException{
	
	validator.isInvalid(emailId, "EMAILID");
	validator.isInvalid(password, "PASSWORD");
	validator.isInvalid(issueId, "S_ISSUE_ID");
	validator.isInvalid(employeeId, "S_EMPLOYEE_ID");
}

public void ticketSolution(String emailId, String password, int issueId,String ticketSolution) throws ValidatorException{
	
	validator.isInvalid(emailId, "EMAILID");
	validator.isInvalid(password, "PASSWORD");
	validator.isInvalid(issueId, "S_ISSUE_ID");
	validator.isInvalid(ticketSolution, "SOLUTION_DESCRIPTION");
}

public void deleteTickets(String emailId, String password, int issueId) throws ValidatorException{
	validator.isInvalid(emailId, "EMAILID");
	validator.isInvalid(password, "PASSWORD");
	validator.isInvalid(issueId, "ISSUE_ID");
}

public void findEmployeeTickets(String emailId, String password) throws ValidatorException{
	validator.isInvalid(emailId, "EMAILID");
	validator.isInvalid(password, "PASSWORD");
}

}








package com.solai.service;

import com.solai.dao.CreatingTicketDAO;
import com.solai.exception.PersistenceException;
import com.solai.exception.ServiceException;
import com.solai.exception.ValidatorException;
import com.solai.model.User;
import com.solai.validator.TicketPlacingValidator;

public class TicketPlacingService 
{
	TicketPlacingValidator ticketPlacingValidator=new TicketPlacingValidator();
	CreatingTicketDAO creatingTicketDAO=new CreatingTicketDAO();
	
	
	public void userRegistration(String name,String emailId,String password) throws ServiceException
	{
		try
		{
			ticketPlacingValidator.userRegistration(name,emailId,password);
			creatingTicketDAO.userRegistration(name,emailId,password);
		}
		catch(ValidatorException|PersistenceException e)
		{
			throw new ServiceException("User Registration is denied",e);
		}

		
	}
	public Object findOne(User user) 
	{
		try {
			ticketPlacingValidator.findOne(user.getId());
			 return creatingTicketDAO.findOne(user.getId());


		} catch (ValidatorException e) {
			e.printStackTrace();
		}
		return creatingTicketDAO;

	} 
	
	public void userLogin(String emailId,String password) throws ServiceException
	{
		try
		{
			ticketPlacingValidator.userLogin(emailId, password);
			creatingTicketDAO.userLogin(emailId, password);
		}
		catch(ValidatorException|PersistenceException e)
		{
			throw new ServiceException("User Login is denied",e);

		}
	}
	public void creatingTicket(String emailId, String password, String subject, String description, String departmentName,
			String priority) throws ServiceException {

		try {
			ticketPlacingValidator.creatingTicket(emailId, password, subject, description, departmentName,priority);
			creatingTicketDAO.creatingTicket(emailId, password, subject, description, departmentName,priority);
		} catch (ValidatorException | PersistenceException e) {
			throw new ServiceException("Can't able to Create Ticket", e);

		}
	}

	public void updatingTicket(String name,String emailId, String password, int issueId, String updateDescription)
			throws ServiceException {

		try {
			ticketPlacingValidator.updatingTicket(name,emailId, password, issueId, updateDescription);
			creatingTicketDAO.updatingTicket(name,emailId, password, issueId, updateDescription);
		} catch (ValidatorException | PersistenceException e) {
			throw new ServiceException("Cannot Update Ticket", e);

		}
	}

	public void updateTicketClose(String name,String emailId, String password, int issueId) throws ServiceException {

		try {
			ticketPlacingValidator.updateTicketClose(name,emailId, password, issueId);
			creatingTicketDAO.updateTicketClose(name,emailId, password, issueId);
		} catch (ValidatorException | PersistenceException e) {
			throw new ServiceException("Cannot Close Ticket", e);

		}
	}

	public void findUserRecords(String emailId, String password) throws ServiceException {

		try {
			ticketPlacingValidator.findUserRecords(emailId, password);
			creatingTicketDAO.findUserRecords(emailId, password);
		} catch (ValidatorException | PersistenceException e) {
			throw new ServiceException("Cannot View Ticket", e);

		}
	}
	public void assigningEmployee(String emailId, String password, int issueId, int employeeId) throws ServiceException {

		try {
			ticketPlacingValidator.assigningEmployee(emailId, password, issueId, employeeId);
			creatingTicketDAO.assigningEmployee(emailId, password, issueId, employeeId);
		} catch (ValidatorException | PersistenceException e) {
			throw new ServiceException("Cannot Assign Ticket", e);

		}
	}

	public void ticketSolution(String emailId, String password, int issueId, String ticketSolution)
			throws ServiceException {

		try {
			ticketPlacingValidator.ticketSolution(emailId, password, issueId, ticketSolution);
			creatingTicketDAO.ticketSolution(emailId, password, issueId, ticketSolution);
		} catch (ValidatorException | PersistenceException e) {
			throw new ServiceException("Cannot Create Ticket Solution", e);

		}
	}
	
	public void deleteTickets(String emailId, String password, int issueId) throws ServiceException{
		
		try {
			ticketPlacingValidator.deleteTickets(emailId, password, issueId);
			creatingTicketDAO.deleteTickets(emailId, password, issueId);
		} catch (ValidatorException | PersistenceException e) {
			throw new ServiceException("Cannot Delete Ticket", e);

		}
		
	}

	public void findEmployeeTickets(String emailId, String password) throws ServiceException{
		
		try {
			ticketPlacingValidator.findEmployeeTickets(emailId,password);
			creatingTicketDAO.findEmployeeTickets(emailId,password);
		} catch (ValidatorException | PersistenceException e) {
			throw new ServiceException("Cannot View Tickets", e);

		}
		
	}
}



	
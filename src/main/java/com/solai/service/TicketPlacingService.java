package com.solai.service;

import java.util.List;

import com.solai.dao.CreatingTicketDAO;
import com.solai.exception.PersistenceException;
import com.solai.exception.ServiceException;
import com.solai.exception.ValidatorException;
import com.solai.model.Issue;
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
	
	
	public void employeeLogin(String emailId,String password) throws ServiceException 
	{
		try
		{
			ticketPlacingValidator.employeeLogin(emailId,password);
			creatingTicketDAO.employeeLogin(emailId, password);
		}
		catch(ValidatorException|PersistenceException e)
		{
			throw new ServiceException("Employee Login is denied",e);
		}
	}
	public void creatingTicket(String emailId, String password, String subject, String description, String name,
			String priority) throws ServiceException {

		try {
			ticketPlacingValidator.creatingTicket(emailId, password, subject, description, name,priority);
			creatingTicketDAO.creatingTicket(emailId, password, subject, description, name,priority);
		} catch (ValidatorException | PersistenceException e) {
			throw new ServiceException("Can't able to Create Ticket", e);

		}
	}

	public void updatingTicket(String emailId, String password, int issueId, String updateDescription)
			throws ServiceException {

		try {
			ticketPlacingValidator.updatingTicket(emailId, password, issueId, updateDescription);
			creatingTicketDAO.updatingTicket(emailId, password, issueId, updateDescription);
		} catch (ValidatorException | PersistenceException e) {
			throw new ServiceException("Cannot Update Ticket", e);

		}
	}

	public void updateTicketClose(String emailId, String password, int issueId) throws ServiceException {

		try {
			ticketPlacingValidator.updateTicketClose(emailId, password, issueId);
			creatingTicketDAO.updateTicketClose(emailId, password, issueId);
		} catch (ValidatorException | PersistenceException e) {
			throw new ServiceException("Cannot Close Ticket", e);

		}
	}

	public List<Issue> findUserRecords(String emailId, String password) throws ServiceException {

		try {
			ticketPlacingValidator.findUserRecords(emailId, password);
			return creatingTicketDAO.findUserRecords(emailId, password);
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

	public List<Issue> findEmployeeTickets(String emailId, String password) throws ServiceException{
		
		try {
			ticketPlacingValidator.findEmployeeTickets(emailId,password);
			return creatingTicketDAO.findEmployeeTickets(emailId,password);
		} catch (ValidatorException | PersistenceException e) {
			throw new ServiceException("Cannot View Tickets", e);

		}
		
	}
}



	
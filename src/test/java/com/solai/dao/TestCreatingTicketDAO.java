package com.solai.dao;

import com.solai.exception.PersistenceException;
import com.solai.exception.ServiceException;
import com.solai.model.User;

public class TestCreatingTicketDAO {

	public static void main(String[] args) throws ServiceException,PersistenceException
	{
		CreatingTicketDAO creatingTicketDAO= new CreatingTicketDAO();
		User user =new User();
		
		user.setEmailId("SARA@GMAIL.COM");
		user.setPassword("sara*");
//		
//		String subject="Keyboard Problem";
//		String description="Could'nt find any other";
//		String departmentName="HR";
//		String priority="MEDIUM";
////		String updateDescription="Find it";
//		String ticketSolution="New keyboard is replaced";
//		
		
//		creatingTicketDAO.userRegistration("SHRI", "SHRI@GMAIL.COM", "shri*");
//		creatingTicketDAO.userLogin(user.getEmailId(), user.getPassword());
//		creatingTicketDAO.creatingTicket(user.getEmailId(),user.getPassword(),subject,description,departmentName,priority);
//		creatingTicketDAO.updatingTicket("SARA", "SARA@GMAIL.COM", "sara*", 1, updateDescription);
//		creatingTicketDAO.updateTicketClose("SHRINY", "SHRINY@GMAIL.COM", "shriny*", 5);
		/*creatingTicketDAO.findUserRecords("RUDHRA", "rudhra*");*/
//		creatingTicketDAO.assigningEmployee("MAYA@GMAIL.COM", "maya**", 8, 5);
//		creatingTicketDAO.ticketSolution("MAYA@GMAIL.COM", "maya**", 9, ticketSolution);
//		creatingTicketDAO.deleteTickets("JAYA@GMAIL.COM", "jaya**", 9);
		
		
		
		
	}

}

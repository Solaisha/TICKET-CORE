package com.solai.dao;

import java.util.Iterator;
import java.util.List;

import com.solai.exception.PersistenceException;
import com.solai.exception.ServiceException;
import com.solai.model.Issue;
import com.solai.model.User;

public class TestCreatingTicketDAO {

	public static void main(String[] args) throws ServiceException,PersistenceException
	{
		CreatingTicketDAO creatingTicketDAO= new CreatingTicketDAO();
		User user =new User();
		
//		user.setEmailId("RUDHRA@GMAIL.COM");
//		user.setPassword("rudhra*");
//		
		String subject="Wifi Problem";
		String description="Could'nt find any other";
		String name="HR";
		String priority="MEDIUM";
//		String updateDescription="Find it";
		String ticketSolution="LAN Problem Solved";
//		
		
//		creatingTicketDAO.userRegistration("SHRI", "SHRI@GMAIL.COM", "shri*");
//		creatingTicketDAO.employeeRegistration("MALAR", "MALAR@GMAIL.COM", "malar**");
//		creatingTicketDAO.employeeLogin("MAYA@GMAIL.COM", "maya**");
//		creatingTicketDAO.userLogin(user.getEmailId(), user.getPassword());
//		creatingTicketDAO.creatingTicket("TOONY@GMAIL.COM","toony*",subject,description,name,priority);
//		creatingTicketDAO.updatingTicket("SARA@GMAIL.COM", "sara*", 1, updateDescription);
//		creatingTicketDAO.updateTicketClose("SHRINY@GMAIL.COM", "shriny*", 22);
//		creatingTicketDAO.findUserRecords("SARA@GMAIL.COM", "sara*");
//		creatingTicketDAO.assigningEmployee("SHAM@GMAIL.COM", "sham*", 11, 5);
		creatingTicketDAO.ticketSolution("SHAM@GMAIL.COM", "sham*", 38, ticketSolution);
//		creatingTicketDAO.deleteTickets("JAYA@GMAIL.COM", "jaya**", 9);
//    List<Issue>	list=creatingTicketDAO.findEmployeeTickets("SHAM@GMAIL.COM", "sham*");
//    Iterator<Issue> i=list.iterator();
//    while(i.hasNext())
//    {
//    	Issue issue=i.next();
//    	System.out.println(issue.getDescription());
//    	
//	}}
//    	
    }
}
		
		
		
	



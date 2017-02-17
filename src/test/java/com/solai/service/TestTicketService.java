package com.solai.service;

import com.solai.dao.UserDAO;
import com.solai.exception.PersistenceException;
import com.solai.exception.ServiceException;
import com.solai.exception.ValidatorException;
import com.solai.model.Employee;
import com.solai.model.Issue;
import com.solai.model.User;

public class TestTicketService {

	public static void main(String[] args) throws ServiceException, PersistenceException, ValidatorException {
		TicketPlacingService tps = new TicketPlacingService();
		User user = new User();
user.setId(1);
		user.setName("RITHI");
		user.setPassword("rithi*");
		user.setEmailId("RITHI@GMAIL.COM");
		String subject = "LAN";
		String description = "Connection problem";
		String name = "IT";
		String priority = "HIGH";
////		System.out.println(user.getEmailId());
////		
//		Employee employee=new Employee();
//		employee.setId(2);
//		int employeeId=employee.getId();
//		employee.setEmailId("SHAM@GMAIL.COM");
//		employee.setPassword("sham*");
//		
//		Issue issue=new Issue();
//		issue.setId(29);
//		int issueId=issue.getId();
//		String updateDescription="Connection is not good";
//		String ticketSolution="LAN is provided";
//		
		
//		tps.userRegistration(user.getName(), user.getEmailId(), user.getPassword());
//		tps.userLogin(user.getEmailId(), user.getPassword());
//		tps.employeeLogin(employee.getEmailId(), employee.getPassword());
//		System.out.println(tps.findOne(user));
		tps.creatingTicket(user.getEmailId(), user.getPassword(), subject, description,
				name, priority);
//		tps.updatingTicket(user.getEmailId(), user.getPassword(), issueId, updateDescription);
		
//		tps.updateTicketClose(user.getName(), user.getEmailId(), user.getPassword(), issueId);
//		tps.findUserRecords(user.getEmailId(), user.getPassword());
//		tps.assigningEmployee(employee.getEmailId(), employee.getPassword(), 15, 2);
//		tps.ticketSolution(employee.getEmailId(), employee.getPassword(), issueId, ticketSolution);
//		tps.findEmployeeTickets(employee.getEmailId(), employee.getPassword());
//		tps.deleteTickets(employee.getEmailId(), employee.getPassword(), issueId);
		
	}

}

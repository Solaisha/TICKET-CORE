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
		user.setName("RAI");
		user.setPassword("rai*");
		user.setEmailId("RAI@GMAIL.COM");
		String subject = "money";
		String description = "no stipend";
		String departmentName = "HR";
		String priority = "HIGH";
//		System.out.println(user.getEmailId());
//		
		Employee employee=new Employee();
		employee.setId(5);
		int employeeId=employee.getId();
		employee.setEmailId("MAYA@GMAIL.COM");
		employee.setPassword("maya**");
		
		Issue issue=new Issue();
		issue.setId(9);
		int issueId=issue.getId();
		String updateDescription="Allowance will be planned to give";
		String ticketSolution="LAN is provided";
		
		
//		tps.userRegistration(user.getName(), user.getEmailId(), user.getPassword());
//		tps.userLogin(user.getEmailId(), user.getPassword());
		System.out.println(tps.findOne(user));
		//		tps.creatingTicket(user.getEmailId(), user.getPassword(), subject, description,
//				departmentName, priority);
//		tps.updatingTicket(user.getName(), user.getEmailId(), user.getPassword(), issueId, updateDescription);
		
//		tps.updateTicketClose(user.getName(), user.getEmailId(), user.getPassword(), issueId);
		//tps.findUserRecords(user.getEmailId(), user.getPassword());
//		tps.assigningEmployee(employee.getEmailId(), employee.getPassword(), issueId, employeeId);
//		tps.ticketSolution(employee.getEmailId(), employee.getPassword(), issueId, ticketSolution);
//		tps.findEmployeeTickets(employee.getEmailId(), employee.getPassword());
//		tps.deleteTickets(employee.getEmailId(), employee.getPassword(), issueId);
		
	}

}

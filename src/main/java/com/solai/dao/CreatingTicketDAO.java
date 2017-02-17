package com.solai.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.solai.exception.PersistenceException;
import com.solai.model.Department;
import com.solai.model.Employee;
import com.solai.model.Issue;
import com.solai.model.Role;
import com.solai.model.Solution;
import com.solai.model.User;
import com.solai.util.ConnectionUtil;

public class CreatingTicketDAO 
{

	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	User user = new User();
	UserDAO userDAO = new UserDAO();
	UserLoginDAO userloginDAO = new UserLoginDAO();
	
	Issue issue = new Issue();
	IssueDAO issueDAO = new IssueDAO();
	
	Department department= new Department();
	DepartmentDAO departmentDAO = new DepartmentDAO();
	
	Solution solution = new Solution();
	SolutionDAO solutionDAO = new SolutionDAO();
	
	Employee employee = new Employee();
	EmployeeDAO employeeDAO = new EmployeeDAO();
	EmployeeLoginDAO employeeLoginDAO=new EmployeeLoginDAO();
	
	Role role=new Role();
	RoleDAO roleDAO=new RoleDAO();


	
										/*UserLogin*/
	public void userRegistration(String name, String emailId, String password) throws PersistenceException 
	{
		
		user.setName(name);
		user.setEmailId(emailId);
		user.setPassword(password);

		userDAO.save(user);
	}
	
	public void userLogin(String emailId,String password) throws PersistenceException
	{
		user.setEmailId(emailId);
		user.setPassword(password);
		userloginDAO.userLogin(emailId, password);
	}
	
										/*EmployeeLogin*/

	
	public void employeeRegistration(String name,String emailId,String password) throws PersistenceException
	{
		employee.setName(name);
		employee.setEmailId(emailId);
		employee.setPassword(password);
		employee.setRole(role);
//		employee.setEmployee();
		employeeDAO.save(employee);
	}
	
	public void employeeLogin(String emailId,String password) throws PersistenceException
	{
		employee.setEmailId(emailId);
		employee.setPassword(password);
		employeeLoginDAO.employeeLogin(emailId, password);
	}
	
	
	
	
	public Object findOne(int id)
	{
		user.setId(id);
		return user;
		
	}
		

										/*Ticket Creation*/
	public void creatingTicket(String emailId, String password, String subject, String description,String name,String priority) throws PersistenceException {
		
		
		try {
			if (userloginDAO.userLogin(emailId, password)) 
			{


				int userId = userDAO.findUserId(emailId).getId();
				user.setId(userId);
				issue.setUserId(user);

				issue.setSubject(subject);
				issue.setDescription(description);

				
				int id = departmentDAO.findId(name).getId();
				department.setId(id);
				issue.setDepartmentId(department);
				issue.setPriority(priority);
				issueDAO.save(issue);
				
			}

		} catch (PersistenceException e) 
		{
			throw new PersistenceException("Login is currently Failed,Please try again later", e);
		}

	}

	
												/*Ticket Updation*/
	public void updatingTicket(String emailId, String password, int issueId, String updateDescription)throws PersistenceException 
	{
		
		try {
			if (userloginDAO.userLogin(emailId, password)) 
			{
				
				int userId = userDAO.findUserId(emailId).getId();
				user.setId(userId);
				issue.setUserId(user);

				if ("CLOSED".equals(issueDAO.findStatus(userId, issueId).getStatus())
						|| "Closed".equals(issueDAO.findStatus(userId, issueId).getStatus())) 
				{

					System.out.println("Sorry due to Closed Status You cant able to update your records right now!");
				} else 
				{
					issue.setUserId(user);

					issue.setId(issueId);
					issue.setStatus("Inprogress");
					issue.setDescription(updateDescription);

					issueDAO.updateDescription(issue);
				}
			}
		}

		catch (PersistenceException e) 
		{
			throw new PersistenceException("User is Login Failed due to Invalid inputs", e);
		}
	}
	
	
												/*Ticket Closing*/
	public void updateTicketClose( String emailId, String password, int issueId) throws PersistenceException 
	{
		try 
		{
			if (userloginDAO.userLogin(emailId, password)) 
	
			{
				int userId = userDAO.findUserId(emailId).getId();
				user.setId(userId);
				issue.setUserId(user);

				issue.setId(issueId);

				issueDAO.updateClose(issue);
			}
		} 
		catch (PersistenceException e) 
		{
			throw new PersistenceException("User Login is Failed due to Invalid inputs", e);
		}
	}

	
											/*Maintaining User Records*/
	public List<Issue> findUserRecords(String emailId, String password) throws PersistenceException 
	{
		
		UserLoginDAO userLoginDAO = new UserLoginDAO();
		IssueDAO issueDAO=new IssueDAO(); 

		try {
			if (userLoginDAO.userLogin(emailId, password)) 
			{
				int userId = userDAO.findUserId(emailId).getId();
				user.setId(userId);
				issueDAO.findUserRecords(user.getId());

				List<Issue> list = issueDAO.findUserRecords(userId);

				return list;
			}

		} catch (PersistenceException e) 
		{
			throw new PersistenceException("Login Error Occured", e);
		}
return null;
	}
	
	
	
									/*Assigning Employee*/
	public void assigningEmployee(String emailId, String password, int issueId, int employeeId)throws PersistenceException 
	{
		try 
		{
			if (employeeLoginDAO.employeeLogin(emailId, password)) 
			{
				employee.setEmailId(emailId);
				employee.setPassword(password);
				int existingEmployeeDepartmentId = employeeDAO.findEmployeeDepartmentId(emailId, password)
						.getEmployee().getId();
				int givenEmployeeDepartmentId = employeeDAO.findDepartmentId(emailId,password).getEmployee().getId();

				if (existingEmployeeDepartmentId == givenEmployeeDepartmentId) 
				{
					
					issue.setId(issueId);
					solution.setIssueId(issue);

					employee.setId(employeeId);
					solution.setEmployeeId(employee);

//					solutionDAO.updateEmployeeId(solution);

					issueDAO.updateStatus(issue);       	/*Status will be in resolved state*/
				} else 
				{
					System.out.println("Sorry there is some problem with assigning the employee");
				}

			}
		} catch (PersistenceException e) 
		{
			throw new PersistenceException("Login Failed due to Invalid Department Name", e);
		}

	}
	
	
										/*Giving Solution for User*/
	public void ticketSolution(String emailId, String password, int issueId, String ticketSolution)throws PersistenceException 
	{
		EmployeeLoginDAO employeeLoginDAO = new EmployeeLoginDAO();
		try 
		{
			if (employeeLoginDAO.employeeLogin(emailId, password)) 
			{
				employee.setEmailId(emailId);
				employee.setPassword(password);

//			if(employeeDAO.findOne(emailId, password).getId()==solutionDAO.findEmployeeId(issueId).getEmployeeId().getId()){

				issue.setId(issueId);
				solution.setIssueId(issue);
				solution.setSolutionDescription(ticketSolution);

				solutionDAO.updateSolution(solution);

			issueDAO.updateSolutionStatus(issue);
			System.out.println("hai");

			}
			else
			{
				System.out.println("You are not assigned to this solution of issue");
			}
		
		}
		catch (PersistenceException e) 
		{
			throw new PersistenceException("Login Failed due to invalid DATA", e);
		}
	}
	
	
	
											/*Ticket Deletion*/
	public void deleteTickets(String emailId, String password, int issueId) throws PersistenceException 
	{
		EmployeeLoginDAO employeeLoginDAO = new EmployeeLoginDAO();
		try 
		{
			if (employeeLoginDAO.employeeLogin(emailId, password)) 
			{
				employee.setEmailId(emailId);
				employee.setPassword(password);
				int employeeRoleId=employeeDAO.findRoleId(emailId, password).getRole().getId();
				
				role.setName("ADMIN");
				int roleIdAdmin=roleDAO.findRoleId(role).getId();

				if(employeeRoleId==roleIdAdmin){
					SolutionDAO solutionDAO=new SolutionDAO();
					IssueDAO issueDAO=new IssueDAO();
					solutionDAO.delete(issueId);
					issueDAO.delete(issueId);
				}
				else
				{
					System.out.println("Sorry You dont have that much access to delete");
				}
			}

	}
		catch (PersistenceException e) 
		{
			throw new PersistenceException("Login Denied", e);
		}

}

	
									/*Finding Employee's Ticket*/
	public List<Issue> findEmployeeTickets(String emailId, String password) throws PersistenceException
	{
		List<Issue> list = null;
		try 
		{
		       employeeLoginDAO.employeeLogin(emailId, password);
			
				
				
				employee.setEmailId(emailId);
				employee.setPassword(password);
				int employeeId=employeeDAO.findOne(emailId, password).getId();
				list=issueDAO.findEmployeeTickets(employeeId);
				
			
		}
			catch (PersistenceException e) 
		{
			throw new PersistenceException("Login Failed", e);
		}
		return list;
		
	}
}



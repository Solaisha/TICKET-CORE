package com.solai.dao;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import com.solai.model.Department;
import com.solai.model.Issue;
import com.solai.model.User;

public class TestIssueDAO {

	public static void main(String[] args) 
	{
		Issue issue=new Issue();
		
		issue.setId(5);
//		User user=new User();
//		user.setId( 5);
//		issue.setUserId(user);
//		
//		issue.setSubject("WiFi Problem");
//		issue.setDescription("Problem Somewhat solved");
//		
//		Department department=new Department();
//		department.setId(1);
//		issue.setDepartmentId(department);
//		
//		issue.setPriority("HIGH");
////		issue.setCreatedDate(LocalDate.parse("2017-02-07"));
		issue.setResolvedDate(LocalDate.parse("2017-02-08"));
		issue.setStatus("RESOLVED");
		
		IssueDAO issueDAO=new IssueDAO();
//		issueDAO.save(issue);
//		issueDAO.delete(2);
		/*issueDAO.update(issue);*/
//		issueDAO.updateStatus(issue);
//		issueDAO.updateDescription(issue);
		issueDAO.updateSolutionStatus(issue);
//		issueDAO.updateClose(issue);
//		System.out.println(issueDAO.findEmployeeTickets(1));
//		System.out.println(issueDAO.findOne(1));
		
		
		
		
		
		
		
		
		
		
//		
//		List<Issue> list = issueDAO.findAll();
//		Iterator<Issue> i = list.iterator();
//		while (i.hasNext()) {
//			Issue issues = (Issue) i.next();
//			System.out.println(issues.getId()+"\t"+issues.getUserId().getId()+"\t"+issues.getDepartmentId().getId()
//					+"\t"+issues.getSubject()+"\t"+issues.getDescription()+"\t"+issues.getCreatedDate()+"\t"
//					+issues.getResolvedDate()+"\t"+issues.getStatus());
		
		}
		
	}

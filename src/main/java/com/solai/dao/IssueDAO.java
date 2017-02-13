package com.solai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.solai.model.Department;
import com.solai.model.Issue;
import com.solai.model.User;
import com.solai.util.ConnectionUtil;

public class IssueDAO 
{
JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(Issue issue)
	{
		String sql="INSERT INTO ISSUE_RECORDS (I_USER_ID,I_DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY) VALUES(?,?,?,?,?)";
		Object[] params={issue.getUserId().getId(),issue.getDepartmentId().getId(),issue.getSubject(),issue.getDescription(),issue.getPriority()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	
	public void delete(int id)
	{
		String sql="DELETE FROM ISSUE_RECORDS WHERE ID=?";
		Object[] params={id};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	
	public void update(Issue issue)
	{
		String sql="UPDATE ISSUE_RECORDS SET I_USER_ID,I_DEPARTMENT_ID,SUBJECT,DESCRIPTION,RESOLVED_DATE WHERE ID=?";
		Object[]params={issue.getUserId().getId(),issue.getDepartmentId().getId(),issue.getSubject(),issue.getDescription(),issue.getResolvedDate(),issue.getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	
	public void updateEmployeeName(Issue issue)
	{
		String sql="UPDATE ISSUE_RECORDS SET EMPLOYEE_NAME=?";
		Object[] params={issue.getEmployeeName()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	
	public void updateStatus(Issue issue) {
		String sql = "UPDATE ISSUE_RECORDS SET STATUS='IN PROGRESS' AND EMPLOYEE_NAME=? WHERE ID=?";
		Object[] params = {issue.getEmployeeName(), issue.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);

	}

	public void updateDescription(Issue issue) {
		String sql = "UPDATE ISSUE_RECORDS SET DESCRIPTION=?,STATUS=? WHERE ID=? AND I_USER_ID=?";
		Object[] params = { issue.getDescription(), issue.getStatus(), issue.getId(), issue.getUserId().getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);

	}
	
	public void updateSolutionStatus(Issue issue) {
		String sql = "UPDATE ISSUE_RECORDS SET STATUS='RESOLVED',RESOLVED_DATE=NOW() WHERE ID=?";
		Object[] params = { issue.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);

	}
	
	public void updateClose(Issue issue) {
		String sql = "UPDATE ISSUE_RECORDS SET STATUS='CLOSED' WHERE ID=? AND I_USER_ID=?";
		Object[] params = { issue.getId(), issue.getUserId().getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);

	}
		
	public List<Issue> findAll() {
		String sql = "SELECT ID,I_USER_ID,I_DEPARTMENT_ID,SUBJECT,DESCRIPTION,CREATED_DATE,RESOLVED_DATE,STATUS,PRIORITY FROM ISSUE_RECORDS";
		return jdbcTemplate.query(sql, (rs, rowNo) -> convert(rs));

	}

public Issue findStatus(int userId, int id) {
	String sql = "SELECT STATUS FROM ISSUE_RECORDS WHERE I_USER_ID=? AND ID = ?";
	Object[] params = { userId, id };
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
		Issue issue = new Issue();
		issue.setStatus(rs.getString("Status"));
		return issue;

	});

}


public List<Issue> findUserRecords(int userId) {
	String sql = "SELECT ID,I_USER_ID,SUBJECT,DESCRIPTION,STATUS,PRIORITY FROM ISSUE_RECORDS WHERE I_USER_ID=?";
	Object[] params = { userId };
	return jdbcTemplate.query(sql, params, (rs, rowNo) -> {
		Issue issue = new Issue();
		issue.setId(rs.getInt("ID"));

		User user = new User();
		user.setId(rs.getInt("I_USER_ID"));
		issue.setUserId(user);

		issue.setSubject(rs.getString("SUBJECT"));
		issue.setDescription(rs.getString("DESCRIPTION"));
		issue.setStatus(rs.getString("STATUS"));
		issue.setPriority(rs.getString("PRIORITY"));
		return issue;

	});

}


public Issue findIssueId(int userId, String subject, String description) {
	String sql = "SELECT ID FROM ISSUE_RECORDS WHERE I_USER_ID=? AND SUBJECT=? AND DESCRIPTION=?";
	Object[] params = { userId, subject, description };
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
		Issue issue = new Issue();
		issue.setId(rs.getInt("ID"));
		return issue;

	});

}

public List <Issue> list(int userId)
{
	String sql = "SELECT ID,I_USER_ID,SUBJECT,DESCRIPTION,STATUS,PRIORITY,FROM ISSUE_RECORDS WHERE ID=?";
	Object[] params = {userId };
	return jdbcTemplate.query(sql, params, (rs, rowNo) -> {
		Issue issue = new Issue();
		issue.setId(rs.getInt("ID"));

		User user = new User();
		user.setId(rs.getInt("I_USER_ID"));
		issue.setUserId(user);
		
		

		issue.setSubject(rs.getString("SUBJECT"));
		issue.setDescription(rs.getString("DESCRIPTION"));
		issue.setStatus(rs.getString("STATUS"));
		issue.setPriority(rs.getString("PRIORITY"));
		
		
		return issue;

	});

}

public List<Issue> findEmployeeTickets(int empId) {
	String sql = "SELECT ISSUE_RECORDS.ID,SUBJECT,DESCRIPTION,STATUS,PRIORITY FROM ISSUE_RECORDS,SOLUTION_RECORDS WHERE ISSUE_RECORDS.ID = SOLUTION_RECORDS.S_ISSUE_ID  AND SOLUTION_RECORDS.S_EMPLOYEE_ID = ?";
	Object[] params = { empId };
	return jdbcTemplate.query(sql, params, (rs, rowNo) -> {
		Issue issue = new Issue();

		issue.setId(rs.getInt("ID"));
		issue.setSubject(rs.getString("SUBJECT"));
		issue.setDescription(rs.getString("DESCRIPTION"));
		issue.setStatus(rs.getString("STATUS"));
		issue.setPriority(rs.getString("PRIORITY"));

		return issue;

	});

}

public Issue findOne(int id) {
	String sql = "SELECT ID,I_USER_ID,I_DEPARTMENT_ID,SUBJECT,DESCRIPTION,CREATED_DATE,RESOLVED_DATE,STATUS,PRIORITY FROM ISSUE_RECORDS WHERE ID = ?";
	Object[] params = { id };
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));

}


private Issue convert(ResultSet rs) throws SQLException {
	Issue issue = new Issue();
	issue.setId(rs.getInt("ID"));

	User user = new User();
	user.setId(rs.getInt("I_USER_ID"));
	issue.setUserId(user);

	Department department = new Department();
	department.setId(rs.getInt("I_DEPARTMENT_ID"));
	issue.setDepartmentId(department);

	issue.setSubject(rs.getString("SUBJECT"));
	issue.setDescription(rs.getString("DESCRIPTION"));
	issue.setCreatedDate(rs.getDate("CREATED_DATE").toLocalDate());
	issue.setResolvedDate(rs.getDate("RESOLVED_DATE").toLocalDate());
	issue.setStatus(rs.getString("STATUS"));
	issue.setPriority(rs.getString("PRIORITY"));
	return issue;
}

}





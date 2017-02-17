package com.solai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.solai.model.Employee;
import com.solai.model.Issue;
import com.solai.model.Solution;
import com.solai.util.ConnectionUtil;

public class SolutionDAO {
	
	private JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	public void save(Solution solution) {
	String sql = "INSERT INTO SOLUTION_RECORDS(S_ISSUE_ID,S_EMPLOYEE_ID,SOLUTION_DESCRIPTION)VALUES(?,?,?)";
	Object[] params = {solution.getIssueId().getId(),solution.getEmployeeId().getId(),solution.getSolutionDescription()};
	int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);
}
public void update(Solution solution) {
	String sql = "UPDATE SOLUTION_RECORDS SET S_ISSUE_ID=?,S_EMPLOYEE_ID=?,SOLUTION_DESCRIPTION=? WHERE ID=?";
	Object[] params = {solution.getIssueId().getId(),solution.getEmployeeId().getId(),solution.getSolutionDescription(),solution.getId()};
	int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);

}
	
	public void updateEmployeeId(Solution solution) {
		String sql = "UPDATE SOLUTION_RECORDS SET S_EMPLOYEE_ID=? WHERE S_ISSUE_ID=?";
		Object[] params = {solution.getEmployeeId().getId(),solution.getIssueId().getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);

	}
	
	public void updateSolution(Solution solution) {
		String sql = "UPDATE SOLUTION_RECORDS SET SOLUTION_DESCRIPTION=? WHERE S_ISSUE_ID=?";
		Object[] params = {solution.getSolutionDescription(),solution.getIssueId().getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println(rows);

	}
	
	
public void delete(int issueId) {
	String sql = "DELETE FROM SOLUTION_RECORDS WHERE S_ISSUE_ID=?";
	Object params = issueId;
	int rows = jdbcTemplate.update(sql, params);
	System.out.println(rows);

}

	public Solution findEmployeeId(int issueId) {
		String sql = "SELECT S_EMPLOYEE_ID FROM SOLUTION_RECORDS WHERE S_ISSUE_ID = ?";
		Object[] params = { issueId };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			Solution solution = new Solution();
			
			Employee employee=new Employee();
			employee.setId(rs.getInt("S_EMPLOYEE_ID"));
			solution.setEmployeeId(employee);
				
			return solution;
		});
	}
	
public List<Solution> findAll() {
	String sql = "SELECT * FROM SOLUTION_RECORDS";
	return jdbcTemplate.query(sql, (rs, rowNo) -> convert(rs));

}

public Solution findOne(int id) {
	String sql = "SELECT ID,S_ISSUE_ID,S_EMPLOYEE_ID,SOLUTION_DESCRIPTION FROM SOLUTION_RECORDS WHERE ID = ?";
	Object[] params = { id };
	return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));

}

private Solution convert(ResultSet rs) throws SQLException {
	Solution solution = new Solution();
	solution.setId(rs.getInt("ID"));
	
	Issue issue=new Issue();
	issue.setId( rs.getInt("S_ISSUE_ID"));
	solution.setIssueId(issue);
	
	Employee employee=new Employee();
	employee.setId(rs.getInt("S_EMPLOYEE_ID"));
	solution.setEmployeeId(employee);
	
	solution.setSolutionDescription(rs.getString("SOLUTION_DESCRIPTION"));
	
	return solution;
}

}
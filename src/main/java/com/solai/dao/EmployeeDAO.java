package com.solai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.solai.exception.PersistenceException;
import com.solai.model.Department;
import com.solai.model.Employee;
import com.solai.model.Role;
import com.solai.util.ConnectionUtil;

public class EmployeeDAO 
{
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	public void save(Employee employee)
	{
		String sql="INSERT INTO EMPLOYEE_RECORDS(NAME,ROLE_ID,PASSWORD,DEPARTMENT_ID,EMAILID)VALUES(?,?,?,?,?)";
		Object[]params={employee.getName(),employee.getRole().getId(),employee.getPassword(),employee.getEmployee().getId(),employee.getEmailId()};
		int rows = jdbcTemplate.update(sql,params);
		System.out.println("Number of rows inserted:" +rows);
	}
	
	public void delete(int id)
	{
		String sql="DELETE FROM EMPLOYEE_RECORDS WHERE ID=?";
		Object[]params={id};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows deleted:" +rows);
	}
	
	public void update(Employee employee)
	{
		String sql="UPDATE EMPLOYEE_RECORDS SET NAME=?,EMAILID=?,PASSWORD=?,ROLE_ID=?,DEPARTMENT_ID=?,ACTIVE=? WHERE ID=?";
		Object[]params={employee.getName(),employee.getEmailId(),employee.getPassword(),employee.getRole().getId(),employee.getEmployee().getId(),employee.isActive(),employee.getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows updated" +rows);
	}
	
	public Employee findEmployeeeName(int id ,String emailId)
	{
		String sql="SELECT NAME FROM EMPLOYEE_RECORDS WHERE DEPARTMENT_ID=? AND EMAILID=?";
		Object[]params={id,emailId};
		return jdbcTemplate.queryForObject(sql,params,(rs,rowNum)->{
		Employee employee=new Employee();
		employee.setName(rs.getString("NAME"));
		return employee;
	});
	}
	
	
	public void employeeRegistration(Employee employee)
	{
		String sql="INSERT INTO EMPLOYEE_RECORDS(NAME,EMAILID,PASSWORD) VALUES(?,?,?)";
		Object[] params={employee.getName(),employee.getEmailId(),employee.getPassword()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows updated" +rows);
		
	}
	
	public List<Employee> findAll() {
		String sql = "SELECT ID,DEPARTMENT_ID,ROLE_ID,NAME,EMAILID,ACTIVE FROM EMPLOYEE_RECORDS";
		return jdbcTemplate.query(sql, (rs, rowNo) -> convert(rs));

	}
	
	public Employee findOne(int id) {
		String sql = "SELECT ID,DEPARTMENT_ID,ROLE_ID,NAME,EMAILID,ACTIVE FROM EMPLOYEE_RECORDS WHERE ID = ?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));

	}
	
	public Employee findEmployeeId(int roleId,int departmentId)
	{
		String sql="SELECT ID FROM EMPLOYEE_RECORDS WHERE ROLE_ID=? AND DEPARTMENT_ID=? AND ACTIVE=1";
		Object[] params={roleId,departmentId};
		return jdbcTemplate.queryForObject(sql,params,(rs,rowNum)->{
		Employee employee =new Employee();
		employee.setId(rs.getInt("ID"));
		return employee;
	});
	}
	
	public Employee findOne(String emailId,String password) throws PersistenceException
	{
		try
		{
			
		String sql="SELECT DEPARTMENT_ID FROM EMPLOYEE_RECORDS WHERE EMAILID=? AND PASSWORD=? AND ACTIVE=1" ;
		Object[] params={emailId,password};
		return jdbcTemplate.queryForObject(sql,params, (rs, rowNum)->
		{
			Employee employee=new Employee();
			employee.setId(rs.getInt("DEPARTMENT_ID"));
			return employee;
		});
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new PersistenceException("Unknown Email_Id and Passworrd");
			
		}
	}
	
	
	public Employee findDepartmentId(String emailId,String password)
	{
		String sql="SELECT DEPARTMENT_ID FROM EMPLOYEE_RECORDS WHERE EMAILID=? AND PASSWORD=? AND ACTIVE=1";
		Object[] params={emailId,password};
		return jdbcTemplate.queryForObject(sql,params, (rs, rowNum)->{
			Employee employee=new Employee();
			Department department=new Department();
			department.setId(rs.getInt("DEPARTMENT_ID"));
			employee.setEmployee(department);
			return employee;
		});

	}
	
	
	public Employee findRoleId(String emailId,String password)
	{
		String sql="SELECT ROLE_ID FROM EMPLOYEE_RECORDS WHERE EMAILID=? AND PASSWORD=? AND ACTIVE=1";
		Object[] params={emailId,password};
		return jdbcTemplate.queryForObject(sql,params, (rs, rowNum)->{
			Employee employee=new Employee();
			Role role=new Role();
			role.setId(rs.getInt("ROLE_ID"));
			employee.setRole(role);
			return employee;
	});
}
	
	public Employee findEmployeeDepartmentId(String emailId,String password) {
		String sql = "SELECT DEPARTMENT_ID FROM EMPLOYEE_RECORDS WHERE EMAILID = ? AND PASSWORD=? AND ACTIVE=1";
		Object[] params = {emailId,password};
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			Employee employee=new Employee();
			Department department=new Department();
			department.setId(rs.getInt("DEPARTMENT_ID"));
			employee.setEmployee(department);
			return employee;
		});
	}	
	
	public List<Employee>list()
	{
		String sql="SELECT * FROM EMPLOYEE_RECORDS";
		List<Employee> list=jdbcTemplate.query(sql, (rs,params)->{
			Employee employee=new Employee();
			employee.setId(rs.getInt("ID"));
			employee.setName(rs.getString("NAME"));
			employee.setPassword(rs.getString("PASSWORD"));
			employee.setEmailId(rs.getString("EMAILID"));
			
			Role role=new Role();
			role.setId(rs.getInt("ROLE_ID"));
			employee.setRole(role);
			
			Department department=new Department();
			department.setId(rs.getInt("DEPARTMENT_ID"));
			employee.setEmployee(department);
			
			employee.setActive(rs.getBoolean("ACTIVE"));
			return employee;
		});
		return list;
	}




private Employee convert(ResultSet rs) throws SQLException {
	Employee employee = new Employee();
	employee.setId(rs.getInt("ID"));
	
	Department department=new Department();
	department.setId(rs.getInt("DEPARTMENT_ID"));
	employee.setEmployee(department);
	
	Role role=new Role();
	role.setId(rs.getInt("ROLE_ID"));
	employee.setRole(role);
	
	employee.setName(rs.getString("NAME"));
	employee.setEmailId(rs.getString("EMAILID"));
	employee.setActive(rs.getBoolean("ACTIVE"));
	
	return employee;
}

}
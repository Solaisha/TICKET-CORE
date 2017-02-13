package com.solai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.solai.model.Department;
import com.solai.util.ConnectionUtil;

public class DepartmentDAO 
{
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(Department department)
	{
		String sql="INSERT INTO DEPARTMENT_RECORDS(NAME) VALUES(?)";
		Object[]params={department.getName()};
		int rows = jdbcTemplate.update(sql,params);
		System.out.println("Number of rows inserted:" +rows);
	}
	
	public void delete(int id)
	{
		String sql="DELETE FROM DEPARTMENT_RECORDS WHERE ID=?";
		Object[]params={id};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows deleted:" +rows);
	}
	
	public void update(Department department)
	{
		String sql="UPDATE DEPARTMENT_RECORDS SET NAME=?,ACTIVE=? WHERE ID=?";
		Object[]params={department.getName(),department.isActive(),department.getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows updated" +rows);
	}
	
	public List<Department> findAll() {
		String sql = "SELECT ID, NAME,ACTIVE FROM DEPARTMENT_RECORDS";
		return jdbcTemplate.query(sql, (rs, rowNo) -> convert(rs));

	}

	public Department findOne(int id) {
		String sql = "SELECT ID, NAME,ACTIVE FROM DEPARTMENT_RECORDS WHERE ID = ?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> convert(rs));

	}
	
	

	public Department findId(String name )
	{
		String sql="SELECT ID FROM DEPARTMENT_RECORDS WHERE NAME=? ";
		Object[]params={name};
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			Department department = new Department();
			department.setId(rs.getInt("ID"));
			return department;	
		});
		
	}
	
	
	private Department convert(ResultSet rs) throws SQLException {
		Department department = new Department();
		
		department.setId(rs.getInt("ID"));
		department.setName(rs.getString("NAME"));
		department.setActive(rs.getBoolean("ACTIVE"));
		
		return department;
	}
	
	
	List <Department> list()
	{
		String sql="SELECT * FROM DEPARTMENT_RECORDS";
		return jdbcTemplate.query(sql,( rs,params)->{
			Department department=new Department();
			department.setId(rs.getInt("ID"));
			department.setName(rs.getString("NAME"));
		
		return department;
	});
}
}



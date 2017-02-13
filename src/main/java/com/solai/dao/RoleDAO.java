package com.solai.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.solai.model.Role;
import com.solai.util.ConnectionUtil;

public class RoleDAO 
{
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	public void save(Role role)
	{
		String sql="INSERT INTO ROLE_RECORDS (ID,NAME) VALUES(?,?)";
		Object[] params={role.getId(),role.getName()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void delete(int id)
	{
		String sql="DELETE FROM ROLE_RECORDS WHERE ID =?";
		Object[]params={id};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void update(Role role)
	{
		String sql="UPDATE ROLE_RECORDS SET NAME=? WHERE ID=?";
		Object[]params={role.getName(),role.getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	
	public Role findRoleId(Role role)
	{
		String sql = "SELECT ID FROM ROLE_RECORDS WHERE NAME = ? AND ACTIVE=1";
		Object[] params = {role.getName()};
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
			Role roles=new Role();
			roles.setId(rs.getInt("ID"));
			return roles;
		});
	}

	
	public List<Role> list()
	{
		String sql="SELECT * FROM ROLE_RECORDS";
		Role role=new Role();
		List<Role>list=jdbcTemplate.query(sql,( rs,params)->{
			role.setId(rs.getInt("ID"));
			role.setName(rs.getString("NAME"));
			return role;
		});
		return list;
	}
}

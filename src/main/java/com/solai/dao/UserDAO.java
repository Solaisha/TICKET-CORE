package com.solai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.solai.exception.PersistenceException;
import com.solai.model.User;
import com.solai.util.ConnectionUtil;

public class UserDAO 
{
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(User user) throws PersistenceException
	{
		try
	{
		String sql="INSERT INTO USER_RECORDS(NAME,EMAILID,PASSWORD)VALUES(?,?,?)";
		Object[]params={user.getName(),user.getEmailId(),user.getPassword()};
		int rows = jdbcTemplate.update(sql,params);
		System.out.println("Number of rows inserted:" +rows);
	}
		catch(DuplicateKeyException e)
		{
			throw new PersistenceException(" You have entered an Unknown E-mail id",e);
		}
	
	}
	
	public void update(User user)
	{
		String sql="UPDATE USER_RECORDS SET NAME=?,PASSWORD=?,EMAILID=?,ACTIVE=? WHERE ID=?";
		Object[]params={user.getName(),user.getPassword(),user.getEmailId(),user.isActive(),user.getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows updated" +rows);
				
	}
	
	public void delete(int id)
	{
		String sql="DELETE FROM USER_RECORDS WHERE ID=?";
		Object[]params={id};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("Number of rows deleted:" +rows);
	}
	
	
	public List<User> findAll() {
		String sql = "SELECT ID, NAME,EMAILID,PASSWORD,ACTIVE FROM USER_RECORDS";
		return jdbcTemplate.query(sql, (rs, rowNo) -> convert(rs));

	}
	
	
	
	public Object findOne(int id)
	{
		String sql ="SELECT ID,NAME,EMAILID,PASSWORD,ACTIVE FROM USER_RECORDS WHERE ID=?";
		Object []params={id};
		return jdbcTemplate.queryForObject(sql, params,(rs,rowNum)->convert(rs));
	}
	
	public User findOne(String password)
	{
		String sql="SELECT EMAILID FROM USER_RECORDS WHERE PASSWORD=?";
		Object[] params={password};
		return jdbcTemplate.queryForObject(sql,params,(rs,rowNum)->{
		User user=new User();
		user.setPassword(rs.getString("EMAILID"));
		return user;
		});
	}

		public User findOne(String emailId,String password) throws PersistenceException
	{
		try
	{
			String sql="SELECT ID FROM USER_RECORDS WHERE EMAILID=? AND PASSWORD=?";
			Object[] params={emailId,password};
			return jdbcTemplate.queryForObject(sql, params,(rs,rowNum)->{
			User user=new User();
			user.setId(rs.getInt("ID"));
			return user;
			});
	}
			catch(EmptyResultDataAccessException e)
			{
				throw new PersistenceException("Unknown Email-Id or Password Entered",e);
			}
	
	}	

		
		public User findUserId(String emailId)
		{
			String sql="SELECT ID FROM USER_RECORDS WHERE EMAILID=?";
			Object[] params={emailId};
			return jdbcTemplate.queryForObject(sql, params,(rs,rowNum)->{
			User user=new User();
			user.setId(rs.getInt("ID"));
			return user;
			});
			}
		
		

private User convert(ResultSet rs) throws SQLException
{
	User user=new User();
	user.setId(rs.getInt("ID"));
	user.setName(rs.getString("NAME"));
	user.setEmailId(rs.getString("EMAILID"));
	user.setPassword(rs.getString("PASSWORD"));
	user.setActive(rs.getBoolean("ACTIVE"));
	return user;
}


public List<User> list()
{
	String sql="SELECT * FROM USER_RECORDS";
	List <User> list=jdbcTemplate.query(sql, (rs,params)->{
		User user= new User();
		user.setId(rs.getInt("ID"));
		user.setName(rs.getString("NAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setEmailId(rs.getString("EMAILID"));
		user.setActive(rs.getBoolean("ACTIVE"));
	
	
		return user;
	});
return list;
}
}
package com.solai.dao;

import java.util.List;

import com.solai.model.Role;

public class TestRoleDAO {

	public static void main(String[] args) 
	{
		Role role=new Role();
//		role.setId(4);
//		role.setName("DEVELOPER");
		role.setName("ADMIN");
		
		RoleDAO roleDAO=new RoleDAO();
//		roleDAO.save(role);
		
//		roleDAO.delete(4);
//		roleDAO.update(role);
		roleDAO.findRoleId(role);
		
//		List<Role>list=roleDAO.list();
//		for(Role r:list)
//		{
//			System.out.println(r);
//		}
	}

}

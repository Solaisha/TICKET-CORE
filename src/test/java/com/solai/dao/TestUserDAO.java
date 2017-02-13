package com.solai.dao;

import java.util.Iterator;
import java.util.List;

import com.solai.exception.PersistenceException;
import com.solai.model.User;

public class TestUserDAO {

	public static void main(String[] args) throws PersistenceException 
	{
//		User user=new User();
//		user.setId( 11);
//		user.setName("SAAJI");
//		user.setPassword("saaji*");
//		user.setEmailId("SAAJI@GMAIL.COM");
//		user.setActive(false);
//		user.setActive(true);
//		
		UserDAO userDAO=new UserDAO();
//		userDAO.save(user);
//		userDAO.update(user);
//		userDAO.delete(8);
//		userDAO.findAll();
//		System.out.println( userDAO.findOne(3));
//		System.out.println(userDAO.findAll());
//		System.out.println(userDAO.findOne("maya*"));
//		System.out.println(userDAO.findOne("MAYA@GMAIL.COM","maya*"));
//		System.out.println(userDAO.findUserId("SARA@GMAIL.COM"));
		System.out.println(userDAO.findOne(1));
		
		
		
		
		
		
		
		
		
		
		
		
			
		
		
		
		

//		List<User> list = userDAO.findAll();
//		Iterator<User> i = list.iterator();
//		while (i.hasNext()) {
//			User users = (User) i.next();
//			System.out.println(users.getId()+ "\t" +users.getName() + "\t"
//					+ users.getEmailId() + "\t" + users.isActive());
//		}
		
//		user = userDAO.findOne("SARA@gmail.com");
//		System.out.println(user.getPassword());
	
	
	
	
	
	
	}

}


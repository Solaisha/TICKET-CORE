package com.solai.model;

import lombok.Data;

@Data
public class Employee 
{
	private int id;
	
	private String name;
	private Role role;
	private String password;
	private Department employee;
	private String emailId;
	private boolean active;
}

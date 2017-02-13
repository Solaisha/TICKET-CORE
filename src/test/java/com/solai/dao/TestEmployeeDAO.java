package com.solai.dao;

import java.util.List;

import com.solai.exception.PersistenceException;
import com.solai.model.Department;
import com.solai.model.Employee;
import com.solai.model.Role;

public class TestEmployeeDAO {

	public static void main(String[] args) throws PersistenceException 
	{
		Employee employee =new Employee();
//		employee.setId(3);
//		employee.setName("jAYA");
//		employee.setPassword("jaya**");
//		employee.setActive(true);
//		
//		Role role=new Role();
//		role.setId(1);														/*1.ADMIN,2.AUTHOR,3.USER*/
//		employee.setRole(role);
//		
//		employee.setEmailId("JAYA@GMAIL.COM");
//		
//		Department department =new Department();
//		department.setId(2);													/*1.IT,2.HR*/
//		employee.setEmployee(department);
//		
		EmployeeDAO employeeDAO=new EmployeeDAO();
//		employeeDAO.save(employee);
//		employeeDAO.update(employee);
//		employeeDAO.delete(3);
//		System.out.println(employeeDAO.findAll());
//		System.out.println(employeeDAO.findOne(2));
//		System.out.println(employeeDAO.findEmployeeId(1, 2));
//		System.out.println(employeeDAO.findOne("SHAM@GMAIL.COM", "sham*"));
//		System.out.println(employeeDAO.findDepartmentId("SHAM@GMAIL.COM", "sham*"));
//		System.out.println(employeeDAO.findRoleId("SHAM@GMAIL.COM", "sham*"));
//		System.out.println(employeeDAO.findEmployeeDepartmentId("SHAM@GMAIL.COM", "sham*"));
		System.out.println(employeeDAO.findEmployeeeName(2,"SHAM@GMAIL.COM"));

		
	
		
		
		
		
		
		
		
		
		
//		List <Employee> list=employeeDAO.list();
//		for(Employee e:list)
//		{
//			System.out.println(e);
//		}
	}

}

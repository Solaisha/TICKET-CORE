package com.solai.dao;

import java.util.List;

import com.solai.model.Department;

public class TestDepartmentDAO {

	public static void main(String[] args) 
	{
		Department department=new Department();
		department.setId(3);
		department.setName("TESTING");
		department.setActive(false);
//		
		DepartmentDAO departmentDAO=new DepartmentDAO();
//		departmentDAO.save(department);
//		departmentDAO.update(department);
//		System.out.println(departmentDAO.findOne(1));
//		System.out.println(departmentDAO.findId("HR"));
		
		
		
//		List <Department> list=departmentDAO.list();
//		for(Department d:list)
//		{
//			System.out.println(d);
//		}
	}

}

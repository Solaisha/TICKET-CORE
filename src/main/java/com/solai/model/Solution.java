package com.solai.model;

import lombok.Data;
@Data
public class Solution 
{
	private int id;
	private Issue issueId;
	private Employee employeeId;
	private String solutionDescription;

}

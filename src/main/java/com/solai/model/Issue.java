package com.solai.model;

import java.time.LocalDate;
import lombok.Data;
@Data
public class Issue 
{
	private int id;
	private User userId;
	private String subject;
	private String description;
	private LocalDate createdDate;
	private LocalDate resolvedDate;
	private String status;
	private Department departmentId;
	private String Priority;
	private String employeeName;
}

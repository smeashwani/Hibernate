package hibernate.training.entity;

import lombok.Data;

@Data
public class Employee {
	private int id;  
	private String firstName,lastName;
	public Employee() {}
} 
 
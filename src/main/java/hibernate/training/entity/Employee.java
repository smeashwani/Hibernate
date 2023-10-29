package hibernate.training.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="emp")
@Data
public class Employee {
	@Id
	private int id;
	@Column(name="first_Name")
	private String firstName;
	private String lastName;
	public Employee() {}
	
} 
 
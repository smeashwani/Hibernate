package hibernate.training.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;


@Entity
@Table(name="emp")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name="first_Name")
	private String firstName;
	private String lastName;
	@Version
	public Integer version;
	public Employee() {}
} 
 
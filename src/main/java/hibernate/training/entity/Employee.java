package hibernate.training.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;
@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "findEmployeeByName",  
	        query = "from Employee e where e.firstName = :name"  
	        )
	    }  
)
@Entity
@Table(name="emp")
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column(name="first_Name")
	private String firstName;
	private String lastName;
	public Employee() {}
	
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

} 
 
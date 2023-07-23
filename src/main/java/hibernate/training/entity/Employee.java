package hibernate.training.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="emp")
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_Name")
	private String firstName;
	
	private String lastName; 
	
	public Employee() {}
	
	@Embedded
	private Contract_Employee contract;
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name = "bonus", column = @Column(name = "bonusAmount", length = 11))
	})
	private Regular_Employee regular;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Contract_Employee getContract() {
		return contract;
	}
	public void setContract(Contract_Employee contract) {
		this.contract = contract;
	}
	public Regular_Employee getRegular() {
		return regular;
	}
	public void setRegular(Regular_Employee regular) {
		this.regular = regular;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contract=" + contract
				+ ", regular=" + regular + "]";
	}
	

} 
 
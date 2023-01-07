package hibernate.training;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;

import hibernate.training.entity.Employee;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class Runner {
	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>>>>>>>");
		Session session = HibernateUtil.getSessionFactory().openSession();
		
			save(session);
			fetchAll(session);
		
		System.out.println("..............Close Session .............");
		session.close();
		System.out.println("<<<<<<<<<<<");
	}

	@SuppressWarnings("deprecation")
	private static void fetchAll(Session session) {
		List<Employee> resultList = session.createQuery("From Employee",Employee.class).getResultList();
		resultList.forEach(System.out::println);
		
		
	}

	private static void save(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Employee e = new Employee();
		e.setFirstName("First");
		//e.setLastName("last");
		if(validate(e)) {
			session.persist(e);
		}
		transaction.commit();
	}
	
	static public boolean validate(Employee e1) {
	      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	      //It validates bean instances
	      Validator validator = factory.getValidator();
	      Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(e1);
	      if (constraintViolations.size() > 0) {
	            for (ConstraintViolation<Employee> violation : constraintViolations) {
	                System.err.println(violation.getMessage());
	            }
	            return false;
	       }
	      return true;
	}
}

package hibernate.training;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.training.entity.Contract_Employee;
import hibernate.training.entity.Employee;
import hibernate.training.entity.Regular_Employee;

public class Runner {
	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>>>>>>>");
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("..............Open Session .............");
		
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
		e.setLastName("last");
		e.setPassword("Welcome");
		session.persist(e);
		
		transaction.commit();
	}
}

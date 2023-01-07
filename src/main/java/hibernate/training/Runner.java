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
		Contract_Employee contract = new Contract_Employee();
		contract.setContract_duration("100");
		contract.setPay_per_hour(50);
		e.setContract(contract);
		Regular_Employee regular = new Regular_Employee();
		regular.setBonus(100);
		regular.setSalary(50_000);
		e.setRegular(regular);
		session.persist(e);
		
		
		
		transaction.commit();
	}
}

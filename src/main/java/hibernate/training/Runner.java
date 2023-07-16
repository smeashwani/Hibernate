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
		System.out.println("..............open Session .............");
			save(session);
			fetchAll(session);
		
		System.out.println("..............Close Session .............");
		session.close();
		System.out.println("<<<<<<<<<<<");
	}

	private static void fetchAll(Session session) {
		System.out.println("...........FETCHING...............");
		List<Employee> resultList = session.createQuery("From Employee",Employee.class).getResultList();
		resultList.forEach(System.out::println);
	}

	private static void save(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Employee e = new Employee();
		e.setFirstName("First");
		e.setLastName("last");
		session.persist(e);
		
		Regular_Employee re = new Regular_Employee();
		re.setFirstName("regular");
		re.setLastName("emp");
		re.setBonus(10_000);
		re.setSalary(50_000);
		session.persist(re);
		
		Contract_Employee ce = new Contract_Employee();
		ce.setFirstName("contract");
		ce.setLastName("employeee");
		ce.setPay_per_hour(5.5f);
		ce.setContract_duration("100");
		session.persist(ce);
		
		transaction.commit();
	}
}

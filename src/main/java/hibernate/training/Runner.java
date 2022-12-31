package hibernate.training;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import hibernate.training.entity.Employee;

public class Runner {
	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>>>>>>>");
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("..............Open Session .............");
			//save(session);
			//fetchAll(session);
		fetchGet(session);
		fetchLoad(session);
		System.out.println("..............Close Session .............");
		session.close();
		System.out.println("<<<<<<<<<<<");
	}
	
	private static void fetchGet(Session session) {
		System.out.println("GET....");
		Employee employee = session.get(Employee.class, -1);
		System.out.println("GET from DB");
		System.out.println(employee);
	}
	
	private static void fetchLoad(Session session) {
		System.out.println("LOAD....");
		Employee employee = session.load(Employee.class, -1);
		System.out.println("Load from DB");
		System.out.println(employee);
	}

	private static void fetchAll(Session session) {
		Query<Employee> query = session.createQuery("From Employee", Employee.class);
		List<Employee> resultList = query.getResultList();
		resultList.forEach(System.out::println);
	}

	private static void save(Session session) {
		// @formatter:off
		Transaction tx = session.beginTransaction();
			Employee e1 = new Employee();
			e1.setFirstName("Guest_1");
			e1.setLastName("DUCAT_1");
			session.persist(e1);
		tx.commit();
		System.out.println("successfully saved : "+ e1);
		
		tx = session.beginTransaction();
			e1 = new Employee();
			e1.setFirstName("Guest_2");
			e1.setLastName("DUCAT_2");
			session.persist(e1);
		tx.commit();
		System.out.println("successfully saved: "+ e1);
		
		
		tx = session.beginTransaction();
			e1 = new Employee();
			e1.setFirstName("Guest_3");
			e1.setLastName("DUCAT_3");
			session.persist(e1);
		tx.commit();
		System.out.println("successfully saved: "+ e1);
	
		tx = session.beginTransaction();
			e1 = new Employee();
			e1.setFirstName("Guest_4");
			e1.setLastName("DUCAT_4");
			session.persist(e1);
		tx.commit();
		System.out.println("successfully saved: "+ e1);
		
		
		// @formatter:on
		
		System.out.println("successfully operation completed");
		
	}
}

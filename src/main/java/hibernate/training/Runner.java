package hibernate.training;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.training.entity.Employee;

public class Runner {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		save(session);
		fetch(session);
		
		session.close();
	}

	private static void fetch(Session session) {
		Employee emp = session.get(Employee.class, 1);
		System.out.println(emp);
		session.close();
	}

	private static void save(Session session) {
		// State - transient
		Employee e1 = new Employee();
		//e1.setId(101);
		e1.setFirstName("Gaurav");
		e1.setFirstName("Gaurav1");
		System.out.println("transient ....");
		
		// @formatter:off
		Transaction tx = session.beginTransaction();
			System.out.println("persistent ....");
			//System.out.println(session.save(e1));
			session.persist(e1);
			// e1.setFirstName("Gaurav1"); //No operation perform as object is not dirty. 
			e1.setFirstName("Gaurav2");
			System.out.println("successfully saved");
		tx.commit();
		// @formatter:on
		
		System.out.println("successfully operation completed");
		
	}
}

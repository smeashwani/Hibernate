package hibernate.training;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.training.entity.Employee;

public class Runner {
	public static void main(String[] args) {
		// Create typesafe ServiceRegistry object
		try (Session session = HibernateUtil.getSessionFactory().openSession()){

			// @formatter:off
			Transaction tx = session.beginTransaction();
				Employee e1 = new Employee();
				e1.setId(101);
				e1.setFirstName("Guest");
				session.persist(e1);
				System.out.println("successfully saved");
			tx.commit();
			
	
			tx = session.beginTransaction();
				e1 = new Employee();
				e1.setId(102);
				e1.setFirstName("Guest_2");
				session.persist(e1);
				System.out.println("successfully saved");
			tx.commit();
			
			tx = session.beginTransaction();
				e1 = new Employee();
				e1.setId(103);
				e1.setFirstName("Guest_3");
				session.persist(e1);
				System.out.println("successfully saved");
			tx.commit();
			
			tx = session.beginTransaction();
				e1 = new Employee();
				e1 = new Employee();
				e1.setId(104);
				e1.setFirstName("Guest_4");
				session.persist(e1);
				System.out.println("successfully saved");
			tx.commit();
			// @formatter:on
		}
		System.out.println("successfully operation completed");
	}
}

package hibernate.training;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.training.entity.Employee;

public class Runner {
	public static void main(String[] args) {
		saveMethod();
		//persistMehtod();
	}

	
	private static void persistMehtod() {
			Employee e1 = new Employee();
			e1.setFirstName("Gaurav");
			try (Session session = HibernateUtil.getSessionFactory().openSession()){
				// @formatter:off
				Transaction tx = session.beginTransaction();
					session.persist(e1); 
				tx.commit();
				System.out.println("successfully saved : "+ e1);

				session.evict(e1); // detached entity
				tx = session.beginTransaction();
					session.persist(e1); // generate exception for detached entity
				tx.commit();
				System.out.println("successfully saved : "+ e1);
				
				// @formatter:on
			}
			System.out.println("successfully operation completed");		
	}


	private static void saveMethod() {
		Employee e1 = new Employee();
		e1.setFirstName("Gaurav");
		try (Session session = HibernateUtil.getSessionFactory().openSession()){

			// @formatter:off
			Transaction tx = session.beginTransaction();
				session.save(e1);
			tx.commit();
			System.out.println("successfully saved : "+ e1);

			session.evict(e1); // detached Entity
			tx = session.beginTransaction();
				session.save(e1); // save the object and generate the another ID
			tx.commit(); 
			System.out.println("successfully saved : "+ e1);
			
			// @formatter:on
		}
		System.out.println("successfully operation completed");		
	}
}

package hibernate.training;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.training.entity.Employee;

public class Runner {
	public static void main(String[] args) {
		save();
		fetch();
	}

	private static void fetch() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			System.out.println("Fetching");
			Employee emp = session.load(Employee.class, 1);
			System.out.println("Fetching");
			System.out.println(emp);
		}
	}

	private static void save() {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			// State - transient
			Employee e1 = new Employee();
			e1.setFirstName("Gaurav");
			e1.setFirstName("Gaurav1");
			System.out.println("transient ....");
			
			// @formatter:off
			Transaction tx = session.beginTransaction();
				System.out.println("persistent ....");
				//System.out.println(session.save(e1));
				session.persist(e1);
				//e1.setFirstName("Gaurav1"); //No operation perform as object is not dirty. 
				e1.setFirstName("Gaurav2");
				System.out.println("successfully saved");
			tx.commit();
			// @formatter:on
		}
		System.out.println("successfully operation completed");
		
	}
}

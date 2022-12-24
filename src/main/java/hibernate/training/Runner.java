package hibernate.training;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hibernate.training.entity.Employee;

public class Runner {
	public static void main(String[] args) {
		// Create typesafe ServiceRegistry object
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Employee e1 = new Employee();
		e1.setId(101);
		e1.setFirstName("Gaurav");
		session.save(e1);
		System.out.println("successfully saved");
		
		e1 = new Employee();
		e1.setId(102);
		e1.setFirstName("Gaurav_2");
		session.save(e1);
		System.out.println("successfully saved");
		
		e1 = new Employee();
		e1.setId(103);
		e1.setFirstName("Gaurav_3");
		session.save(e1);
		System.out.println("successfully saved");
		
		e1 = new Employee();
		e1.setId(104);
		e1.setFirstName("Gaurav_4");
		session.save(e1);
		System.out.println("successfully saved");
		
		t.commit();
		
		session.close();
		factory.close();
	}
}

package hibernate.training;

import org.hibernate.Session;
import org.hibernate.query.Query;

import hibernate.training.entity.Employee;

public class Runner {
	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>>>>>>>");
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		System.out.println("..............Open Session .............");
		
			fetchAll1(session1);
			fetchAll2(session2);
		
		System.out.println("..............Close Session .............");
		session1.close();
		session2.close();
		System.out.println("<<<<<<<<<<<");
	}

	private static void fetchAll1(Session session) {
		System.out.println("GET Session1()");
		Query<Employee> createQuery = session.createQuery("from Employee as employee where employee.id =?1",Employee.class);
		createQuery.setParameter(1, Integer.valueOf(-1));
		//createQuery.setCacheable(true);
		//createQuery.setCacheRegion("employee");

		System.out.println("GET Session1...");
		System.out.println(createQuery.getSingleResult());
		
		System.out.println("GET Session1");
		createQuery = session.createQuery("from Employee as employee where employee.id =?1",Employee.class);
		//createQuery.setCacheable(true);
		//createQuery.setCacheRegion("employee");
		createQuery.setParameter(1, Integer.valueOf(-1));
		
		System.out.println("GET Session1");
		System.out.println(createQuery.getSingleResult());
	}
	
	private static void fetchAll2(Session session) {
		System.out.println("GET Session2()");
		Query<Employee> createQuery = session.createQuery("from Employee as employee where employee.id =?1",Employee.class);
		//createQuery.setCacheable(true);
		//createQuery.setCacheRegion("employee");
		createQuery.setParameter(1, Integer.valueOf(-1));
		System.out.println("GET Session2...");
		System.out.println(createQuery.getSingleResult());
		
		System.out.println("GET Session2");
		createQuery = session.createQuery("from Employee as employee where employee.id =?1",Employee.class);
		//createQuery.setCacheable(true);
		//createQuery.setCacheRegion("employee");
		createQuery.setParameter(1, Integer.valueOf(-1));
		System.out.println("GET Session2");
		System.out.println(createQuery.getSingleResult());
	}
}

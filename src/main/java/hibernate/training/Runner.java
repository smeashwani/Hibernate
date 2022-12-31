package hibernate.training;

import org.hibernate.Session;

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
		Employee employee = session.get(Employee.class, -1);
		System.out.println("GET Session1...");
		System.out.println(employee);
		
		System.out.println("GET Session1");
		employee = session.get(Employee.class, -1);
		System.out.println("GET Session1");
		System.out.println(employee);
	}
	
	private static void fetchAll2(Session session) {
		System.out.println("GET Session2()");
		Employee employee = session.get(Employee.class, -1);
		System.out.println("GET Session2...");
		System.out.println(employee);
		
		System.out.println("GET Session2");
		employee = session.get(Employee.class, -1);
		System.out.println("GET Session2");
		System.out.println(employee);
	}
	
	



	
}

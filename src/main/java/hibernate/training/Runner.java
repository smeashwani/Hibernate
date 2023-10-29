package hibernate.training;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import hibernate.training.entity.Employee;

public class Runner {
	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>>>>>>>");
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("..............Open Session .............");
		
			fetchAll(session);
		
		System.out.println("..............Close Session .............");
		session.close();
		System.out.println("<<<<<<<<<<<");
	}

	private static void fetchAll(Session session) {
		String sql = "SELECT id, first_Name, lastName FROM emp";
		NativeQuery query = session.createNativeQuery(sql,Employee.class);
		List employees = query.list();
		 employees.forEach(System.out::println);
	}
}

package hibernate.training;

import java.util.List;

import org.hibernate.Session;

import hibernate.training.entity.Employee;
import jakarta.persistence.TypedQuery;

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
		 TypedQuery query =session.getNamedQuery("findEmployeeByName");    
		 query.setParameter("name","Script_GUEST1");      
		 List<Employee> employees=query.getResultList();
		 employees.forEach(System.out::println);
	}
	
	



	
}

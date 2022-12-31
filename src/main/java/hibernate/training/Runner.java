package hibernate.training;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.AliasToEntityMapResultTransformer;

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

	@SuppressWarnings("deprecation")
	private static void fetchAll(Session session) {
		String sql = "SELECT first_name as firstName, lastName FROM emp";
		NativeQuery query = session.createNativeQuery(sql);
		query.setResultTransformer(new AliasToBeanResultTransformer(Employee.class));
		List employees = query.list();
		 employees.forEach(System.out::println);
	}
	
	



	
}

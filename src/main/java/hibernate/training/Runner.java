package hibernate.training;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.training.entity.Address;
import hibernate.training.entity.Employee;

public class Runner {
	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>>>>>>>");
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		System.out.println("..............Open Session .............");
			
			save(session1);
			fetchAllEmployees(session1);
			fetchAllAddress(session2);
		
		System.out.println("..............Close Session .............");
		session1.close();
		session2.close();
		System.out.println("<<<<<<<<<<<");
	}

	@SuppressWarnings("deprecation")
	private static void fetchAllEmployees(Session session) {
		System.out.println("...............Employees Fetching...........");
		List<Employee> resultList = session.createQuery("From Employee",Employee.class).getResultList();
		resultList.forEach(e -> {
		System.out.println(e);
		System.out.println(e.address);
		});
		//System.out.println(resultList.get(0).address);
		System.out.println("...............Employees end...........");
	}
	
	@SuppressWarnings("deprecation")
	private static void fetchAllAddress(Session session) {
		System.out.println("...............Address Fetching..........");
		List<Address> resultList = session.createQuery("From Address",Address.class).getResultList();
		resultList.forEach(add -> {
		System.out.println(add);
		System.out.println(add.employee);
		});
		
		System.out.println("...............Address end...........");
	}

	private static void save(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Address address1 = new Address("Street","City");
		session.persist(address1);
		Address address2 = new Address("Street2","City2");
		session.persist(address2);
		
		Employee e = new Employee();
		e.setFirstName("First");
		e.setLastName("last");
		e.address = List.of(address1, address2);
		session.persist(e);
		transaction.commit();
	}
	
}

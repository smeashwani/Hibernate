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
		
			//save(session1);
			//List<Employee> allEmp = fetchAllEmployees(session1);
			//remove(session1,allEmp.get(0));
			//fetchAllEmployees(session1);
			fetchAllAddress(session2);
		
		System.out.println("..............Close Session .............");
		session1.close();
		session2.close();
		System.out.println("<<<<<<<<<<<");
	}

	@SuppressWarnings("deprecation")
	private static List<Employee> fetchAllEmployees(Session session) {
		System.out.println("...............Employees Fetching...........");
		List<Employee> resultList = session.createQuery("From Employee",Employee.class).getResultList();
		resultList.forEach(e -> {
		System.out.println(e);
		});
		System.out.println(resultList.get(1).address);
		System.out.println("...............Employees end...........");
		return resultList;
	}
	
	private static void remove(Session session, Employee e) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		System.out.println("...............Employees removing...........");
		session.remove(e);
		System.out.println("...............Employees removed...........");
		transaction.commit();
	}
	
	@SuppressWarnings("deprecation")
	private static void fetchAllAddress(Session session) {
		System.out.println("...............Address Fetching..........");
		List<Address> resultList = session.createQuery("From Address",Address.class).getResultList();
		resultList.forEach(add -> {
		System.out.println(add);
		});
		System.out.println(resultList.get(1).employee);
		System.out.println("...............Address end...........");
	}

	private static void save(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Address address = new Address("Street","City");
		session.persist(address);
		Employee e = new Employee();
		e.setFirstName("First");
		e.setLastName("last");
		e.address = address;
		session.persist(e);
		transaction.commit();
	}
	
}

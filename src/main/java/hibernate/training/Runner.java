package hibernate.training;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.training.entity.Employee;

public class Runner {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		IntStream stream = IntStream.of(1,2);
		stream.parallel().forEach(item -> {
			task(sessionFactory,item);
		});
	}
	
	public static void task(SessionFactory sessionFactory,int number) {
		System.out.println("Task "+ number+">>>>>>>>>>>>>>>>>>");
		Session session = sessionFactory.openSession();
		System.out.println("Task "+ number+" Session Created....");
			fetchAll(session,number);
			fetchAndSave(session, number);
		System.out.println("Task "+ number+" ..............Close Session .............");
		session.close();
		System.out.println("Task "+ number+" <<<<<<<<<<<");
	}
	
	private static void fetchAll(Session session,int number) {
		List<Employee> resultList = session.createQuery("From Employee",Employee.class).getResultList();
		resultList.forEach(System.out::println);
		System.out.println("Task "+ number+"....... FETCHING DONE............");
	}

	private static void fetchAndSave(Session session,int number) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
			List<Employee> resultList = session.createQuery("From Employee where id=-1",Employee.class).getResultList();
			Employee e =resultList.get(0);
			e.setFirstName("Update Value "+ number);
			session.persist(e);
		transaction.commit();
	}
}

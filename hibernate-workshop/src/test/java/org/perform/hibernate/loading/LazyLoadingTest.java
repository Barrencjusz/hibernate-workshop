package org.perform.hibernate.loading;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.perform.hibernate.TestBase;
import org.perform.hibernate.model.Address;
import org.perform.hibernate.model.Coach;
import org.perform.hibernate.model.Organisation;

public class LazyLoadingTest extends TestBase {

	@Resource
	private SessionFactory sessionFactory;

	@Test
	public void test() {
		Address homeAddress = new Address("Korwina 1", "Warszawa", "04-76");
		Address workAddress = new Address("Ukrytych Skarbów 2", "Wałbrzych", "66-666");

		Coach coach = new Coach();
		coach.setId(1);
		coach.setName("Adi");
		coach.getAddresses().add(homeAddress);
		coach.getAddresses().add(workAddress);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(coach);
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		coach = session.get(Coach.class, 1);
		//session.close();
		System.out.println(coach.getAddresses().size());
	}

	@Override
	protected Class<?> getTestClass() {
		// TODO Auto-generated method stub
		return LazyLoadingTest.class;
	}

}

package org.perform.hibernate.override;

import java.util.Calendar;
import java.util.Date;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.perform.hibernate.TestBase;
import org.perform.hibernate.model.Contract;
import org.perform.hibernate.model.Referee;

public class AttrOverrideTest extends TestBase {

	@Resource
	private SessionFactory sessionFactory;

	@Test
	public void test() {

		Referee referee = new Referee();
		referee.setId(1L);
		referee.setName("Howard Webb");

		Calendar calendar = Calendar.getInstance();
		calendar.set(2000, 1, 10);
		Date startDate = calendar.getTime();

		calendar.set(2005, 1, 10);
		Date endDate = calendar.getTime();

		referee.setFirstContract(new Contract(100000, startDate, endDate));
		//referee.setSecondContract(new Contract(200000, startDate, endDate));

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(referee);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	protected Class<?> getTestClass() {
		return AttrOverrideTest.class;
	}

}

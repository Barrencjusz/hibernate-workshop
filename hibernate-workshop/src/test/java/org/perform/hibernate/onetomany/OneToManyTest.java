package org.perform.hibernate.onetomany;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.perform.hibernate.TestBase;
import org.perform.hibernate.model.Country;
import org.perform.hibernate.model.Organisation;

public class OneToManyTest extends TestBase {

	@Resource
	private SessionFactory sessionFactory;

	@Test
	public void test() {
		Organisation organisation = new Organisation();
		organisation.setName("FIFA");

		Country poland = new Country("Poland");
		Country italy = new Country("Italy");
		
		poland.setOrganisation(organisation);
		italy.setOrganisation(organisation);
		
		organisation.getCountries().add(poland);
		organisation.getCountries().add(italy);
		
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(organisation);
		session.save(poland);
		session.save(italy);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	protected Class<?> getTestClass() {
		return OneToManyTest.class;
	}

}

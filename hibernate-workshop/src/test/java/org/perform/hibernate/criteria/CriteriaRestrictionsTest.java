package org.perform.hibernate.criteria;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.perform.hibernate.TestBase;
import org.perform.hibernate.misc.PopulatingExecutionListener;
import org.perform.hibernate.model.Game;
import org.perform.hibernate.model.Team;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.transaction.annotation.Transactional;

@TestExecutionListeners(CriteriaRestrictionsTest.Populator.class)
public class CriteriaRestrictionsTest extends TestBase {

  @Test
  @Transactional
  public void testFullResponse() {
    Criteria criteria = dao.getSession().createCriteria(Game.class);
    criteria.createAlias("guest", "guest");
    criteria.add(Restrictions.and(Restrictions.gt("guestScore", (short) 4), Restrictions.ilike("guest.naming.name", "manchester", MatchMode.ANYWHERE)));
    criteria.setProjection(Projections.property("guest.value"));
    BigDecimal value = (BigDecimal) criteria.uniqueResult();
    logger.info(value);
  }

  @Override
  protected Class<?> getTestClass() {
    return CriteriaRestrictionsTest.class;
  }

  public static class Populator extends PopulatingExecutionListener {

    @Override
    protected void populate() {
      Team manUnited = new Team();
      manUnited.getNaming().setName("Manchester United");
      manUnited.getNaming().setShortName("MUFC");
      manUnited.getNicknames().add("The Red Devils");
      manUnited.setValue(new BigDecimal(52151555));
      dao.save(manUnited);

      Team manCity = new Team();
      manCity.getNaming().setName("Manchester City");
      manCity.getNaming().setShortName("MCFC");
      manCity.getNicknames().add("City");
      manCity.getNicknames().add("The Sky Blues");
      manCity.setValue(new BigDecimal(535253));
      dao.save(manCity);

      Game firstGame = new Game();
      firstGame.setDate(new Date());
      firstGame.setGuestScore((short) 5);
      firstGame.setHostScore((short) 3);
      firstGame.setHost(manUnited);
      firstGame.setGuest(manCity);
      dao.save(firstGame);
      
      Game secondGame = new Game();
      secondGame.setDate(new Date());
      secondGame.setGuestScore((short) 4);
      secondGame.setHostScore((short) 2);
      secondGame.setHost(manCity);
      secondGame.setGuest(manUnited);
      dao.save(secondGame);
    }

    @Override
    protected void depopulate() {

    }
  }
}

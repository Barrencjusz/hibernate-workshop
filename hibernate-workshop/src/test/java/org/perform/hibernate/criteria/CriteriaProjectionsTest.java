package org.perform.hibernate.criteria;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.junit.Test;
import org.perform.hibernate.TestBase;
import org.perform.hibernate.misc.PopulatingExecutionListener;
import org.perform.hibernate.model.Game;
import org.perform.hibernate.model.Team;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.transaction.annotation.Transactional;

@TestExecutionListeners(CriteriaProjectionsTest.Populator.class)
public class CriteriaProjectionsTest extends TestBase {

  @Test
  @Transactional
  public void testFullResponse() {
    Criteria criteria = dao.getSession().createCriteria(Game.class);
    Game game = (Game) criteria.uniqueResult();
    logger.info(game);
  }
  
  @Test
  @Transactional
  public void testOneProperty() {
    Criteria criteria = dao.getSession().createCriteria(Game.class);
    ProjectionList projections = Projections.projectionList();
    projections.add(Projections.property("date"));
    criteria.setProjection(projections);
    Date date = (Date) criteria.uniqueResult();
    logger.info(date);
  }
  
  @Test
  @Transactional
  public void testProjectedResponse() {
    Criteria criteria = dao.getSession().createCriteria(Game.class);
    ProjectionList projections = Projections.projectionList();
    projections.add(Projections.property("date"), "date");
    projections.add(Projections.property("guestScore"), "guestScore");
    projections.add(Projections.property("hostScore"), "hostScore");
    criteria.setProjection(projections);
    criteria.setResultTransformer(Transformers.aliasToBean(Game.class));
    Game game = (Game) criteria.uniqueResult();
    logger.info(game);
  }
  
  @Override
  protected Class<?> getTestClass() {
    return CriteriaProjectionsTest.class;
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
      
      Game game = new Game();
      game.setDate(new Date());
      game.setGuestScore((short) 2);
      game.setHostScore((short) 1);
      game.setHost(manCity);
      game.setGuest(manUnited);
      dao.save(game);
    }

    @Override
    protected void depopulate() {
      
    }
  }
}

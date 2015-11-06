package org.perform.hibernate.criteria;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.junit.Test;
import org.perform.hibernate.TestBase;
import org.perform.hibernate.misc.PopulatingExecutionListener;
import org.perform.hibernate.model.Game;
import org.perform.hibernate.model.Player;
import org.perform.hibernate.model.Sponsor;
import org.perform.hibernate.model.enumeration.Position;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.transaction.annotation.Transactional;

@TestExecutionListeners(CriteriaFetchOverridingTest.Populator.class)
public class CriteriaFetchOverridingTest extends TestBase {

  @Test
  @Transactional
  public void testDefault() {
    Criteria criteria = dao.getSession().createCriteria(Player.class);
    Player player = (Player) criteria.uniqueResult();
    logger.info(player.getSponsors().toString());
  }

  @Test
  @Transactional
  public void testEager() {
    Criteria criteria = dao.getSession().createCriteria(Player.class);
    criteria.setFetchMode("sponsors", FetchMode.JOIN);
    criteria.setFetchMode("team", FetchMode.SELECT);
    criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
    Player player = (Player) criteria.uniqueResult();
    logger.info(player.getSponsors().toString());
  }

  @Override
  protected Class<?> getTestClass() {
    return CriteriaFetchOverridingTest.class;
  }

  public static class Populator extends PopulatingExecutionListener {

    List<Game> games = new ArrayList<>();

    @Override
    protected void populate() {
      Player player = new Player();
      player.getNaming().setName("Lewandowski");
      player.setPosition(Position.GOALKEEPER);
      dao.save(player);
      for (int i = 0; i < 10; i++) {
        Sponsor sponsor = new Sponsor();
        sponsor.setName("sponsor" + i);
        sponsor.getPlayers().add(player);
        dao.save(sponsor);
      }

    }

    @Override
    protected void depopulate() {
    }

  }
}

package org.perform.hibernate.criteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.hibernate.Criteria;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.perform.hibernate.TestBase;
import org.perform.hibernate.misc.PopulatingExecutionListener;
import org.perform.hibernate.misc.Safe;
import org.perform.hibernate.model.Game;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.transaction.annotation.Transactional;

@TestExecutionListeners(CriteriaPaginationTest.Populator.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CriteriaPaginationTest extends TestBase {

  private StopWatch stopWatch = new StopWatch();

  @Test
  @Transactional
  public void test1Warmup() {
    Criteria criteria = dao.getSession().createCriteria(Game.class);

    stopWatch.start();
    List<Game> list = Safe.cast(criteria.list());
    logger.info("took: " + stopWatch.getTime() + " ms");
    logger.info(list.toString());
  }
  
  @Test
  @Transactional
  public void test2Paginate() {
    Criteria criteria = dao.getSession().createCriteria(Game.class);
    criteria.setFirstResult(0);
    criteria.setMaxResults(10);
    stopWatch.start();
    List<Game> list = Safe.cast(criteria.list());
    logger.info("took: " + stopWatch.getTime() + " ms");
    logger.info(list.toString());
  }

  @Test
  @Transactional
  public void test3listAll() {
    Criteria criteria = dao.getSession().createCriteria(Game.class);

    stopWatch.start();
    List<Game> list = Safe.cast(criteria.list());
    logger.info("took: " + stopWatch.getTime() + " ms");
    logger.info(list.toString());
  }

  @After
  public void after() {
    stopWatch.reset();
  }

  @Override
  protected Class<?> getTestClass() {
    return CriteriaPaginationTest.class;
  }

  public static class Populator extends PopulatingExecutionListener {

    List<Game> games = new ArrayList<>();

    @Override
    protected void populate() {
      for (int i = 0; i < 1000; i++) {
        Game game = new Game();
        game.setDate(new Date());
        game.setGuestScore((short) 2);
        game.setHostScore((short) 1);
        games.add(game);
        dao.save(game);
      }
    }

    @Override
    protected void depopulate() {
//      games.forEach(game -> dao.delete(game));
    }

  }
}

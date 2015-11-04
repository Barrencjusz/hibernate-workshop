package org.perform.hibernate.criteria;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.time.StopWatch;
import org.hibernate.Criteria;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.perform.hibernate.TestBase;
import org.perform.hibernate.misc.Safe;
import org.perform.hibernate.model.Game;
import org.springframework.transaction.annotation.Transactional;

public class CriteriaPaginationTest extends TestBase {

  private static final Logger LOGGER = Logger.getLogger(CriteriaPaginationTest.class.getName());

  private StopWatch stopWatch = new StopWatch();

  @Before
  @Transactional
  public void before() {
    insertTestGames();
  }

  @Test
  @Transactional
  public void listAll() {
    Criteria criteria = dao.getSession().createCriteria(Game.class);

    stopWatch.start();
    List<Game> list = Safe.cast(criteria.list());
    LOGGER.info("took: " + stopWatch.getTime() + " ms");
    LOGGER.info(list.toString());
  }

  @Test
  @Transactional
  public void paginate() {
    Criteria criteria = dao.getSession().createCriteria(Game.class);
    criteria.setFirstResult(0);
    criteria.setFetchSize(10);
    stopWatch.start();
    List<Game> list = Safe.cast(criteria.list());
    LOGGER.info("took: " + stopWatch.getTime() + " ms");
    LOGGER.info(list.toString());
  }

  @After
  public void after() {
    stopWatch.reset();
  }

  public void insertTestGames() {
    for (int i = 0; i < 10; i++) {
      Game game = new Game();
      game.setDate(new Date());
      game.setGuestScore((short) 2);
      game.setHostScore((short) 1);
      dao.save(game);
    }
  }
}

package org.perform.hibernate.cascade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.perform.hibernate.TestBase;
import org.perform.hibernate.misc.PopulatingExecutionListener;
import org.perform.hibernate.model.Game;
import org.perform.hibernate.model.enumeration.Side;
import org.perform.hibernate.model.events.Corner;
import org.perform.hibernate.model.events.Goal;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.transaction.annotation.Transactional;

@TestExecutionListeners(CascadeTest.Populator.class)
public class CascadeTest extends TestBase {

  @Test
  @Transactional
  public void testCascade() {
    Game game = createGame();

    dao.save(game);
    dao.getSession().flush();
  }

  @Test
  @Transactional
  public void testDelete() {
    Game game = createGame();

    dao.save(game);
    dao.getSession().flush();

    dao.delete(game);
    dao.getSession().flush();
  }

  private Game createGame() {
    Game game = new Game();
    game.setDate(new Date());
    game.setGuestScore((short) 2);
    game.setHostScore((short) 2);

    Goal goal = new Goal();
    goal.setDate(new Date());
    goal.setDescription("GOOOOOOOOOOOOOAAAAAAAAL!");

    Corner corner = new Corner();
    corner.setDate(new Date());
    corner.setSide(Side.LEFT);

    game.getEvents().add(goal);
    game.getEvents().add(corner);
    return game;
  }

  @Override
  protected Class<?> getTestClass() {
    return CascadeTest.class;
  }

  public static class Populator extends PopulatingExecutionListener {

    List<Game> games = new ArrayList<>();

    @Override
    protected void populate() {

    }

    @Override
    protected void depopulate() {
    }

  }
}

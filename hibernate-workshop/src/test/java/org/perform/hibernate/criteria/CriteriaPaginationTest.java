package org.perform.hibernate.criteria;

import org.junit.BeforeClass;
import org.junit.Test;
import org.perform.hibernate.TestBase;
import org.perform.hibernate.model.Player;
import org.perform.hibernate.model.enumeration.Position;
import org.springframework.transaction.annotation.Transactional;

public class CriteriaPaginationTest extends TestBase {

  @BeforeClass
  public static void setupClass() {

  }

  @Test
  @Transactional
  public void test() {
    Player player = new Player();
    player.setId(1L);
    player.setPosition(Position.DEFENDER);
    player.getNaming().setName("yolo");
    dao.save(player);
    System.out.println(dao.load(Player.class, 1L).getNaming().getName());
  }
}

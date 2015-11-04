package org.perform.hibernate;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.perform.hibernate.config.ContextConfig;
import org.perform.hibernate.dao.Dao;
import org.perform.hibernate.model.Player;
import org.perform.hibernate.model.enumeration.Position;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({ "postgresql" })
@ContextConfiguration(classes = { ContextConfig.class })
public class AppTest {

	@Resource
	private Dao dao;

	@Test
	@Transactional
	public void test() {
		Player player = new Player();
		player.setId(1L);
		player.setPosition(Position.DEFENDER);
		player.getNaming().setName("yolo");;
		dao.save(player);
		System.out.println(dao.load(Player.class, 1L).getNaming().getName());
	}
}

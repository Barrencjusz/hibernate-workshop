package org.perform.hibernate;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.perform.hibernate.config.ContextConfig;
import org.perform.hibernate.dao.Dao;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({ "javadb" })
@ContextConfiguration(classes = { ContextConfig.class })
public class TestBase {

  @Resource
  protected Dao dao;
}

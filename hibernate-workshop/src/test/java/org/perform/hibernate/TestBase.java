package org.perform.hibernate;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.perform.hibernate.config.ContextConfig;
import org.perform.hibernate.dao.Dao;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({ "javadb" })
@ContextConfiguration(classes = { ContextConfig.class })
@TestExecutionListeners({ TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class })
public abstract class TestBase {

  protected final Logger logger = Logger.getLogger(getTestClass());

  @Resource
  protected Dao dao;

  protected abstract Class<?> getTestClass();
}

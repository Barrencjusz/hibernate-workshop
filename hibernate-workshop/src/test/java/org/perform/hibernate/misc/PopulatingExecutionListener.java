package org.perform.hibernate.misc;

import org.perform.hibernate.dao.Dao;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public abstract class PopulatingExecutionListener extends AbstractTestExecutionListener {

  protected Dao dao;

  @Override
  public void beforeTestClass(TestContext testContext) throws Exception {
    dao = testContext.getApplicationContext().getBean(Dao.class);
    populate();
  }

  @Override
  public void afterTestClass(TestContext testContext) throws Exception {
    depopulate();
  }

  protected abstract void populate();

  protected abstract void depopulate();
}

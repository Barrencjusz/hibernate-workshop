package org.perform.hibernate.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Event {

  @Temporal(TemporalType.TIMESTAMP)
  private Date date;
}

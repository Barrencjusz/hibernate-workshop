package org.perform.hibernate.model.events;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.perform.hibernate.model.Event;
import org.perform.hibernate.model.Team;

@Entity
public class Corner extends Event {

  @OneToOne
  private Team team;
}

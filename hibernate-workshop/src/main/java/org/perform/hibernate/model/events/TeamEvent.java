package org.perform.hibernate.model.events;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.perform.hibernate.model.Event;
import org.perform.hibernate.model.Player;
import org.perform.hibernate.model.Team;

@MappedSuperclass
public abstract class TeamEvent extends Event {

  @ManyToOne
  private Player player;

  @ManyToOne
  private Team team;
}

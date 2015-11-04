package org.perform.hibernate.model.events;

import javax.persistence.*;

import org.perform.hibernate.model.Player;

@Entity
public class Goal extends TeamEvent {

  @ManyToOne
  private Player goalkeeper;

  public Player getGoalkeeper() {
    return this.goalkeeper;
  }

  public void setGoalkeeper(Player goalkeeper) {
    this.goalkeeper = goalkeeper;
  }
}

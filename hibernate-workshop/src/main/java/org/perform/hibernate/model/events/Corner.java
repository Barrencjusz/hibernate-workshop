package org.perform.hibernate.model.events;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

import org.perform.hibernate.model.enumeration.Side;

@Entity
public class Corner extends TeamEvent {
  
  @Enumerated
  private Side side;

  public Side getSide() {
    return this.side;
  }

  public void setSide(Side side) {
    this.side = side;
  }
}

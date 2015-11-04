package org.perform.hibernate.model.events;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PenaltyKick extends TeamEvent {

  @Column(nullable = false)
  private Boolean scored;

  public Boolean getScored() {
    return this.scored;
  }

  public void setScored(Boolean scored) {
    this.scored = scored;
  }
}

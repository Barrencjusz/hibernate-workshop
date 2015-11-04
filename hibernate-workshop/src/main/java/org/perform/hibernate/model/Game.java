package org.perform.hibernate.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Game {

  @Id
  private Long id;

  @Temporal(TemporalType.DATE)
  private Date date;

  @ManyToOne
  private Team host;
  
  @ManyToOne
  private Team guest;
  
  @OneToMany
  private Set<Event> events;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}

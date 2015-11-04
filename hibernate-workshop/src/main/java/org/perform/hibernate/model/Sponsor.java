package org.perform.hibernate.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Sponsor {

  @Id
  private String name;

  @ManyToMany
  private Set<Player> players;
}

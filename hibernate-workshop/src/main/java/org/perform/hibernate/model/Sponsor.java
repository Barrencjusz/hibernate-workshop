package org.perform.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Sponsor {

  @Id
  private String name;

  @ManyToMany
  @JoinTable(name = "players_sponsors")
  private Set<Player> players = new HashSet<>(0);

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Player> getPlayers() {
    return this.players;
  }

  public void setPlayers(Set<Player> players) {
    this.players = players;
  }
}

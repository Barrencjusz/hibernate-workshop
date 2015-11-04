package org.perform.hibernate.model;

import java.util.Set;

import javax.persistence.*;

import org.perform.hibernate.model.embeddable.Naming;

@Entity
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Embedded
  private Naming naming = new Naming();

  @OneToMany(mappedBy = "team")
  private Set<Player> players;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<Player> getPlayers() {
    return players;
  }

  public void setPlayers(Set<Player> players) {
    this.players = players;
  }
}

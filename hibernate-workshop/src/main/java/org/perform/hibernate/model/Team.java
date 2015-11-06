package org.perform.hibernate.model;

import java.math.BigDecimal;
import java.util.HashSet;
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

  private BigDecimal value;
  
  @OneToMany(mappedBy = "team")
  private Set<Player> players;

  @ElementCollection
  @CollectionTable
  private Set<String> nicknames = new HashSet<>();
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Naming getNaming() {
    return this.naming;
  }

  public void setNaming(Naming naming) {
    this.naming = naming;
  }

  public Set<Player> getPlayers() {
    return players;
  }

  public void setPlayers(Set<Player> players) {
    this.players = players;
  }

  public Set<String> getNicknames() {
    return this.nicknames;
  }

  public void setNicknames(Set<String> nicknames) {
    this.nicknames = nicknames;
  }

  public BigDecimal getValue() {
    return this.value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }
}

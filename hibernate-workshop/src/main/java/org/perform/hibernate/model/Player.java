package org.perform.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.perform.hibernate.model.embeddable.Naming;
import org.perform.hibernate.model.enumeration.Position;

@Entity
public class Player {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE)
  private Long id;

  @Embedded
  private Naming naming = new Naming();

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Position position;

  @ManyToOne
  @PrimaryKeyJoinColumn
  private Team team;

  @ManyToMany(mappedBy = "players", cascade=CascadeType.ALL)
  private Set<Sponsor> sponsors = new HashSet<>(0);

  public Long getId() {
    return this.id;
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

  public Position getPosition() {
    return this.position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Team getTeam() {
    return this.team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public Set<Sponsor> getSponsors() {
    return this.sponsors;
  }

  public void setSponsors(Set<Sponsor> sponsors) {
    this.sponsors = sponsors;
  }

}

package org.perform.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.perform.hibernate.model.enumeration.Position;

@Entity
public class Player {

  @Id
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String surname;

  private String nickname;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Position position;

  @ManyToOne
  @PrimaryKeyJoinColumn
  private Team team;

  @ManyToMany
  private Set<Sponsor> sponsors = new HashSet<>(0);

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
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

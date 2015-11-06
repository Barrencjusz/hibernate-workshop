package org.perform.hibernate.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Temporal(TemporalType.DATE)
  private Date date;

  @Column(nullable = false)
  private Short hostScore;

  @Column(nullable = false)
  private Short guestScore;

  @ManyToOne
  private Team host;

  @ManyToOne
  private Team guest;

  @OneToMany(mappedBy = "game", cascade = { CascadeType.ALL }, orphanRemoval = true)
  private Set<Event> events = new HashSet<>(0);

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Short getHostScore() {
    return this.hostScore;
  }

  public void setHostScore(Short hostScore) {
    this.hostScore = hostScore;
  }

  public Short getGuestScore() {
    return this.guestScore;
  }

  public void setGuestScore(Short guestScore) {
    this.guestScore = guestScore;
  }

  public Team getHost() {
    return this.host;
  }

  public void setHost(Team host) {
    this.host = host;
  }

  public Team getGuest() {
    return this.guest;
  }

  public void setGuest(Team guest) {
    this.guest = guest;
  }

  public Set<Event> getEvents() {
    return this.events;
  }

  public void setEvents(Set<Event> events) {
    this.events = events;
  }
}

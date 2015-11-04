package org.perform.hibernate.model;

import javax.persistence.*;

@Entity
public class Season {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(scale = 4, precision = 0)
  private Short year;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Short getYear() {
    return this.year;
  }

  public void setYear(Short year) {
    this.year = year;
  }
}

package org.perform.hibernate.model;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
public class Season {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(precision = 4, scale = 0, name="calendars_year")
  private BigDecimal year;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigDecimal getYear() {
    return this.year;
  }

  public void setYear(BigDecimal year) {
    this.year = year;
  }
}

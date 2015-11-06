package org.perform.hibernate.model.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Naming {

  @Column(nullable = false)
  private String name;

  private String shortName;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getShortName() {
    return this.shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }
}

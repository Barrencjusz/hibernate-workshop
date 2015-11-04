package org.perform.hibernate.model.embeddable;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Embeddable
public class Naming {

  @Column(nullable = false)
  private String name;

  @ElementCollection
  @CollectionTable(name = "nicknames")
  private Set<String> nicknames;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<String> getNicknames() {
    return this.nicknames;
  }

  public void setNicknames(Set<String> nicknames) {
    this.nicknames = nicknames;
  }
}

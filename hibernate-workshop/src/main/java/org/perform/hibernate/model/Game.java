package org.perform.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game {

	@Id
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

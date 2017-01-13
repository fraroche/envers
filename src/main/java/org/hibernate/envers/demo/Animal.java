package org.hibernate.envers.demo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.envers.Audited;

@Audited
@Entity
public class Animal {
	@EmbeddedId 
	private AnimalId id;
	private String race;
	
	public Animal() {
		super();
	}

	public Animal(AnimalId id) {
		super();
		this.id = id;
	}
	
	public AnimalId getId() {return this.id;}
	public String getRace() {return this.race;}
	
//	public void setId(AnimalId id) {this.id = id;}
	public void setRace(String race) {this.race = race;}
}

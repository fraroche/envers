package org.hibernate.envers.demo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AnimalId implements Serializable {
	public AnimalId(String name, Person owner) {
		super();
		this.name = name;
		this.owner = owner.getId();
	}
	public AnimalId() {
		super();
	}
	private String name;
	private int owner;
	
	

	@Override
	public boolean equals(Object o) {
		if (this == o) { return true; }
		if (!(o instanceof AnimalId)) { return false; }

		AnimalId id = (AnimalId) o;

		if (this.owner != owner) {
			return false;
		}
		if (this.name != null ? !this.name.equals(id.name) : id.name != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		result = this.owner;
		result = (31 * result) + (this.name != null ? this.name.hashCode() : 0);
		return result;
	}
}

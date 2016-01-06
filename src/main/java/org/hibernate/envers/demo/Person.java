/*
 * Envers. http://www.jboss.org/envers
 *
 * Copyright 2008  Red Hat Middleware, LLC. All rights reserved.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT A WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License, v.2.1 along with this distribution; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 *
 * Red Hat Author(s): Adam Warski
 */
package org.hibernate.envers.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;

/**
 * @author Adam Warski (adam at warski dot org)
 */
@Entity
public class Person {

	@Entity(name="Pet")
	@IdClass(PetId.class)
	public static class Pet {
		@Id String name;
		@Id @ManyToOne @JoinColumn(name="OWNER_ID") 
		Person owner;
	}

	public class PetId implements Serializable {
		String name;
		int owner;
	}

	@Id
	@GeneratedValue
	//	@TableGenerator(name = "person_gen",
	//	table = "U_SEQUENCES",
	//	pkColumnName = "S_ID",
	//	valueColumnName = "S_NEXTNUM",
	//	pkColumnValue = "personPk",
	//	allocationSize = 50)
	//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "person_gen")
	private int		id_person;

	@Audited
	private String	name;

	@Audited
	private String	surname;

	@Audited(withModifiedFlag=false)
	@ManyToOne
	private Address	address;

	public int getId() {
		return this.id_person;
	}

	public void setId(int id) {
		this.id_person = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Person)) {
			return false;
		}

		Person person = (Person) o;

		if (this.id_person != person.id_person) {
			return false;
		}
		if (this.name != null ? !this.name.equals(person.name) : person.name != null) {
			return false;
		}
		if (this.surname != null ? !this.surname.equals(person.surname) : person.surname != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		result = this.id_person;
		result = (31 * result) + (this.name != null ? this.name.hashCode() : 0);
		result = (31 * result) + (this.surname != null ? this.surname.hashCode() : 0);
		return result;
	}
}

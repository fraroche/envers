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
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import org.hibernate.envers.Audited;

/**
 * @author Adam Warski (adam at warski dot org)
 */
@Entity
public class Address {

	@Embeddable
	public static class ZipCode {
		protected String zip;
		/**
		 * @return Renvoie zip.
		 */
		public String getZip() {
			return this.zip;
		}
		/**
		 * @param pZip zip à définir.
		 */
		public void setZip(String pZip) {
			this.zip = pZip;
		}
		protected String plusFour;
	}

	@Entity(name = "Phone_Line")
	public static class PhoneLine {
		@EmbeddedId 
		protected PhoneLinePK id;

		@Audited
		protected String areaCode;

		@Audited
		protected String localNumber;

		@Audited
		@MapsId("idAddress")
		@ManyToOne 
		protected Address address;
	}

	@Embeddable
	public static class PhoneLinePK implements Serializable {
		int numOrdre;
		int idAddress;
	}


	@Id
	@GeneratedValue
	//	@TableGenerator(name = "address_gen",
	//	table = "U_SEQUENCES",
	//	pkColumnName = "S_ID",
	//	valueColumnName = "S_NEXTNUM",
	//	pkColumnValue = "addressPk",
	//	allocationSize = 50)
	//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "address_gen")
	private int			id_address;

	@Audited
	private String		streetName;

	@Audited
	@Column
	private Integer		houseNumber;

	@Audited
	@Column(name = "FLAT_NUMBER")
	private Integer		flatNumber;

	@Embedded
	@Audited
	protected Address.ZipCode zipcode;

	@Audited
	@OneToMany
	protected Set<Address.PhoneLine> phoneLines;

	/**
	 * @return Renvoie zipcode.
	 */
	public Address.ZipCode getZipcode() {
		return this.zipcode;
	}

	/**
	 * @param pZipcode zipcode à définir.
	 */
	public void setZipcode(Address.ZipCode pZipcode) {
		this.zipcode = pZipcode;
	}

	/**
	 * @return Renvoie phoneLines.
	 */
	public Set<Address.PhoneLine> getPhoneLines() {
		return this.phoneLines;
	}

	/**
	 * @param pPhoneLines phoneLines à définir.
	 */
	public void setPhoneLines(Set<Address.PhoneLine> pPhoneLines) {
		this.phoneLines = pPhoneLines;
	}

	@Audited
	@OneToMany(mappedBy = "address")
	private Set<Person>	persons;

	public int getId() {
		return this.id_address;
	}

	public void setId(int id) {
		this.id_address = id;
	}

	public String getStreetName() {
		return this.streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Integer getHouseNumber() {
		return this.houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public Integer getFlatNumber() {
		return this.flatNumber;
	}

	public void setFlatNumber(Integer flatNumber) {
		this.flatNumber = flatNumber;
	}

	public Set<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Address)) {
			return false;
		}

		Address address = (Address) o;

		if (this.id_address != address.id_address) {
			return false;
		}
		if (this.flatNumber != null ? !this.flatNumber.equals(address.flatNumber) : address.flatNumber != null) {
			return false;
		}
		if (this.houseNumber != null ? !this.houseNumber.equals(address.houseNumber) : address.houseNumber != null) {
			return false;
		}
		if (this.streetName != null ? !this.streetName.equals(address.streetName) : address.streetName != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		result = this.id_address;
		result = (31 * result) + (this.streetName != null ? this.streetName.hashCode() : 0);
		result = (31 * result) + (this.houseNumber != null ? this.houseNumber.hashCode() : 0);
		result = (31 * result) + (this.flatNumber != null ? this.flatNumber.hashCode() : 0);
		return result;
	}
}

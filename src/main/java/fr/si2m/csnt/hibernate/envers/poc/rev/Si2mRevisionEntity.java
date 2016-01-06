package fr.si2m.csnt.hibernate.envers.poc.rev;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Entity(name="Revision")
@RevisionEntity(Si2mRevisionListener.class)
public class Si2mRevisionEntity {
	@Id
	@GeneratedValue
	@RevisionNumber
	@Column(name="id_revision")
	private long revId;

	@Column(name="id_version", nullable=true, updatable=false)
	private long idVersion;

	@RevisionTimestamp
	@Column(name="revTmStmp")
	private long timestamp;

	@Column(name="userName")
	private String username;

	/**
	 * @return Renvoie idVersion.
	 */
	public long getIdVersion() {
		return this.idVersion;
	}

	/**
	 * @param pIdVersion idVersion à définir.
	 */
	public void setIdVersion(int pIdVersion) {
		this.idVersion = pIdVersion;
	}

	/**
	 * @return Renvoie timestamp.
	 */
	public long getTimestamp() {
		return this.timestamp;
	}

	/**
	 * @param pTimestamp timestamp à définir.
	 */
	public void setTimestamp(long pTimestamp) {
		this.timestamp = pTimestamp;
	}

	/**
	 * @return Renvoie revId.
	 */
	public long getRevId() {
		return this.revId;
	}

	/**
	 * @param pRevId revId à définir.
	 */
	public void setRevId(long pRevId) {
		this.revId = pRevId;
	}

	/**
	 * @return Renvoie username.
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @param pUsername username à définir.
	 */
	public void setUsername(final String pUsername) {
		this.username = pUsername;
	}
}

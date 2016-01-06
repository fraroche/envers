package fr.si2m.csnt.dsn.orm.dsnVersion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the DSN_62 database table.
 * 
 */
@Entity
@Table(name = "DSN_62")
public class Dsn62 implements Serializable {
	private static final long	serialVersionUID	= 1L;

	@Version
	@Column(nullable = false)
	private int				optimLock;

	@Id
	@Column(name = "id_finContrat", unique=true, nullable=false)
	private long					idFinContrat;

	//	@Audited
	@Column(name = "_001", nullable=false, length = 8)
	private String				_001;

	//	@Audited
	@Column(name = "_002", nullable=false, length = 3)
	private String				_002;

	//	@Audited
	@Column(name = "_009", length = 2)
	private String				_009;

	//bi-directional one-to-one association to Dsn40
	//	@Audited
	// optional = false because corresponding "contrat" entity is always present
	@OneToOne(fetch=FetchType.EAGER, optional = false)
	//	@MapsId(value = "idFinContrat")
	@PrimaryKeyJoinColumn
	private Dsn40 contrat;

	public Dsn62() {
	}

	public long getId_finContrat() {
		return this.idFinContrat;
	}

	public void setId_finContrat(long id_finContrat) {
		this.idFinContrat = id_finContrat;
	}

	public String get_001() {
		return this._001;
	}

	public void set_001(String _001) {
		this._001 = _001;
	}

	public String get_002() {
		return this._002;
	}

	public void set_002(String _002) {
		this._002 = _002;
	}

	public String get_009() {
		return this._009;
	}

	public void set_009(String _009) {
		this._009 = _009;
	}

	public int getOptimLock() {
		return this.optimLock;
	}

	public void setOptimLock(int optimLock) {
		this.optimLock = optimLock;
	}

	public Dsn40 getContrat() {
		return this.contrat;
	}

	public void setContrat(Dsn40 contrat) {
		this.contrat = contrat;
	}

}
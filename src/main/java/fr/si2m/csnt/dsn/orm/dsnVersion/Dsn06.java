package fr.si2m.csnt.dsn.orm.dsnVersion;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the DSN_06 database table.
 * 
 */
@Entity
@Table(name="DSN_06")
public class Dsn06 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	@Column(nullable=false)
	private int optimLock;

	// this technical data must not be versionned
	@Temporal( TemporalType.DATE)
	@Column(name="dtDernierPassage", nullable=false)
	private Date dtDernierPassage;

	@Id
	@Column(name="id_entreprise", unique=true, nullable=false)
	private long idEntreprise;

	@Audited
	@Column(name="_001", nullable=false, length=9)
	private String _001;

	@Audited
	@Column(name="_002", length=5)
	private String _002;

	@Audited
	@Column(name="_003", length=5)
	private String _003;

	@Audited
	@Column(name="_004", length=50)
	private String _004;

	@Audited
	@Column(name="_005", length=5)
	private String _005;

	@Audited
	@Column(name="_006", length=50)
	private String _006;

	@Audited
	@Column(name="_007", length=50)
	private String _007;

	@Audited
	@Column(name="_008", length=50)
	private String _008;

	//bi-directional many-to-one association to Dsn11
	@Audited
	@OneToMany(mappedBy="entreprise")
	private List<Dsn11> etablissementList;

	public Dsn06() {
	}

	public long getIdEntreprise() {
		return this.idEntreprise;
	}

	public void setIdEntreprise(long idEntreprise) {
		this.idEntreprise = idEntreprise;
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

	public String get_003() {
		return this._003;
	}

	public void set_003(String _003) {
		this._003 = _003;
	}

	public String get_004() {
		return this._004;
	}

	public void set_004(String _004) {
		this._004 = _004;
	}

	public String get_005() {
		return this._005;
	}

	public void set_005(String _005) {
		this._005 = _005;
	}

	public String get_006() {
		return this._006;
	}

	public void set_006(String _006) {
		this._006 = _006;
	}

	public String get_007() {
		return this._007;
	}

	public void set_007(String _007) {
		this._007 = _007;
	}

	public String get_008() {
		return this._008;
	}

	public void set_008(String _008) {
		this._008 = _008;
	}

	public Date getDtDernierPassage() {
		return this.dtDernierPassage;
	}

	public void setDtDernierPassage(Date dtDernierPassage) {
		this.dtDernierPassage = dtDernierPassage;
	}

	public int getOptimLock() {
		return this.optimLock;
	}

	public void setOptimLock(int optimLock) {
		this.optimLock = optimLock;
	}

	public List<Dsn11> getEtablissementList() {
		return this.etablissementList;
	}

	public void setEtablissementList(List<Dsn11> etablissementList) {
		this.etablissementList = etablissementList;
	}

}
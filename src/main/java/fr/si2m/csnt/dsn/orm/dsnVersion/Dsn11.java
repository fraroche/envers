package fr.si2m.csnt.dsn.orm.dsnVersion;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the DSN_11 database table.
 * 
 */
@Entity
@Table(name="DSN_11")
public class Dsn11 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	@Column(nullable=false)
	private int optimLock;

	// this technical data must not be versionned
	@Temporal( TemporalType.DATE)
	@Column(name="dtDernierPassage", nullable=false)
	private Date dtDernierPassage;

	@Id
	@Column(name="id_etablissement", unique=true, nullable=false)
	private long idEtablissement;

	//bi-directional many-to-one association to Dsn06
	@Audited
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_entreprise", nullable=false)
	private Dsn06 entreprise;

	@Audited
	@Column(name="_001", nullable=false, length=5)
	private String _001;

	@Audited
	@Column(name="_002", length=5)
	private String _002;

	@Audited
	@Column(name="_003", nullable=false, length=50)
	private String _003;

	@Audited
	@Column(name="_004", nullable=false, length=5)
	private String _004;

	@Audited
	@Column(name="_005", nullable=false, length=50)
	private String _005;

	@Audited
	@Column(name="_006", length=50)
	private String _006;

	@Audited
	@Column(name="_007", length=50)
	private String _007;

	//bi-directional many-to-one association to Dsn05
	@OneToMany(mappedBy="etablissement")
	private List<Dsn05> declarationList;

	//bi-directional many-to-one association to Dsn30
	@Audited
	@OneToMany(mappedBy="etablissement")
	private List<Dsn30> individuList;

	public Dsn11() {
	}

	public long getIdEtablissement() {
		return this.idEtablissement;
	}

	public void setIdEtablissement(long idEtablissement) {
		this.idEtablissement = idEtablissement;
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

	public Dsn06 getEntreprise() {
		return this.entreprise;
	}

	public void setEntreprise(Dsn06 entreprise) {
		this.entreprise = entreprise;
	}

	public List<Dsn30> getIndividuList() {
		return this.individuList;
	}

	public void setIndividuList(List<Dsn30> individuList) {
		this.individuList = individuList;
	}

	public List<Dsn05> getDeclarationList() {
		return this.declarationList;
	}

	public void setDeclarationList(List<Dsn05> declarationList) {
		this.declarationList = declarationList;
	}
}
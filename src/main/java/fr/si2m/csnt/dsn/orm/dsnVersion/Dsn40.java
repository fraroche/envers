package fr.si2m.csnt.dsn.orm.dsnVersion;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the DSN_40 database table.
 * 
 */
@Entity
@Table(name="DSN_40")
public class Dsn40 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	@Column(nullable=false)
	private int optimLock;

	@Id
	@Column(name="id_contrat", unique=true, nullable=false)
	private long idContrat;

	//bi-directional many-to-one association to Dsn30
	@Audited
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_individu", nullable=false)
	private Dsn30 individu;

	@Audited
	@Column(name="_001", nullable=false, length=8)
	private String _001;

	@Audited
	@Column(name="_002", length=2)
	private String _002;

	@Audited
	@Column(name="_003", length=2)
	private String _003;

	@Audited
	@Column(name="_004", length=4)
	private String _004;

	@Audited
	@Column(name="_005", length=6)
	private String _005;

	@Audited
	@Column(name="_006", length=120)
	private String _006;

	@Audited
	@Column(name="_007", length=2)
	private String _007;

	@Audited
	@Column(name="_008", length=2)
	private String _008;

	@Audited
	@Column(name="_009", nullable=false, length=20)
	private String _009;

	@Audited
	@Column(name="_010", length=8)
	private String _010;

	@Audited
	@Column(name="_011", length=2)
	private String _011;

	@Audited
	@Column(name="_012", length=7)
	private String _012;

	@Audited
	@Column(name="_013", length=7)
	private String _013;

	@Audited
	@Column(name="_014", length=2)
	private String _014;

	@Audited
	@Column(name="_016", length=2)
	private String _016;

	@Audited
	@Column(name="_017", length=4)
	private String _017;

	@Audited
	@Column(name="_018", length=3)
	private String _018;

	@Audited
	@Column(name="_019", length=14)
	private String _019;

	//bi-directional one-to-one association to Dsn62
	//	@Audited
	@OneToOne(mappedBy="contrat", fetch=FetchType.LAZY, optional = true)
	private Dsn62 finContrat;

	//bi-directional many-to-one association to Dsn70
	@Audited
	@OneToMany(mappedBy="contrat")
	private List<Dsn70> affiliationPrevList;

	public Dsn40() {
	}

	public long getIdContrat() {
		return this.idContrat;
	}

	public void setIdContrat(long idContrat) {
		this.idContrat = idContrat;
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

	public String get_009() {
		return this._009;
	}

	public void set_009(String _009) {
		this._009 = _009;
	}

	public String get_010() {
		return this._010;
	}

	public void set_010(String _010) {
		this._010 = _010;
	}

	public String get_011() {
		return this._011;
	}

	public void set_011(String _011) {
		this._011 = _011;
	}

	public String get_012() {
		return this._012;
	}

	public void set_012(String _012) {
		this._012 = _012;
	}

	public String get_013() {
		return this._013;
	}

	public void set_013(String _013) {
		this._013 = _013;
	}

	public String get_014() {
		return this._014;
	}

	public void set_014(String _014) {
		this._014 = _014;
	}

	public String get_016() {
		return this._016;
	}

	public void set_016(String _016) {
		this._016 = _016;
	}

	public String get_017() {
		return this._017;
	}

	public void set_017(String _017) {
		this._017 = _017;
	}

	public String get_018() {
		return this._018;
	}

	public void set_018(String _018) {
		this._018 = _018;
	}

	public String get_019() {
		return this._019;
	}

	public void set_019(String _019) {
		this._019 = _019;
	}

	public int getOptimLock() {
		return this.optimLock;
	}

	public void setOptimLock(int optimLock) {
		this.optimLock = optimLock;
	}

	public Dsn30 getIndividu() {
		return this.individu;
	}

	public void setIndividu(Dsn30 individu) {
		this.individu = individu;
	}

	public Dsn62 getFinContrat() {
		return this.finContrat;
	}

	public void setFinContrat(Dsn62 finContrat) {
		this.finContrat = finContrat;
	}

	public List<Dsn70> getAffiliationPrevList() {
		return this.affiliationPrevList;
	}

	public void setAffiliationPrevList(List<Dsn70> affiliationPrevList) {
		this.affiliationPrevList = affiliationPrevList;
	}

}
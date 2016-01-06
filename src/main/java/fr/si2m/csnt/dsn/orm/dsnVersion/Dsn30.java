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
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the DSN_30 database table.
 * 
 */
@Entity
@Table(name="DSN_30")
public class Dsn30 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	@Column(nullable=false)
	private int optimLock;

	@Id
	@Column(name="id_individu", unique=true, nullable=false)
	private long idIndividu;

	//bi-directional many-to-one association to Dsn11
	@Audited
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_etablissement", nullable=false)
	private Dsn11 etablissement;

	@Audited
	@Column(name="_001", length=13)
	private String _001;

	@Audited
	@Column(name="_002", nullable=false, length=80)
	private String _002;

	@Audited
	@Column(name="_003", length=80)
	private String _003;

	@Audited
	@Column(name="_004", nullable=false, length=80)
	private String _004;

	@Audited
	@Column(name="_005", length=2)
	private String _005;

	@Audited
	@Column(name="_006", nullable=false, length=8)
	private String _006;

	@Audited
	@Column(name="_007", length=30)
	private String _007;

	@Audited
	@Column(name="_008", length=50)
	private String _008;

	@Audited
	@Column(name="_009", length=5)
	private String _009;

	@Audited
	@Column(name="_010", length=50)
	private String _010;

	@Audited
	@Column(name="_011", length=2)
	private String _011;

	@Audited
	@Column(name="_012", length=50)
	private String _012;

	@Audited
	@Column(name="_014", length=2)
	private String _014;

	@Audited
	@Column(name="_015", length=2)
	private String _015;

	@Audited
	@Column(name="_016", length=50)
	private String _016;

	@Audited
	@Column(name="_017", length=50)
	private String _017;

	@Audited
	@Column(name="_018", length=100)
	private String _018;

	@Audited
	@Column(name="_019", length=30)
	private String _019;

	@Audited
	@Column(name="_020", length=39)
	private String _020;

	//bi-directional many-to-one association to Dsn40
	@Audited
	@OneToMany(mappedBy="individu")
	private List<Dsn40> contratList;

	public Dsn30() {
	}

	public long getIdIndividu() {
		return this.idIndividu;
	}

	public void setIdIndividu(long idIndividu) {
		this.idIndividu = idIndividu;
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

	public String get_014() {
		return this._014;
	}

	public void set_014(String _014) {
		this._014 = _014;
	}

	public String get_015() {
		return this._015;
	}

	public void set_015(String _015) {
		this._015 = _015;
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

	public String get_020() {
		return this._020;
	}

	public void set_020(String _020) {
		this._020 = _020;
	}

	public int getOptimLock() {
		return this.optimLock;
	}

	public void setOptimLock(int optimLock) {
		this.optimLock = optimLock;
	}

	public Dsn11 getEtablissement() {
		return this.etablissement;
	}

	public void setEtablissement(Dsn11 etablissement) {
		this.etablissement = etablissement;
	}

	public List<Dsn40> getContratList() {
		return this.contratList;
	}

	public void setContratList(List<Dsn40> contratList) {
		this.contratList = contratList;
	}

}
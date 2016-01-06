package fr.si2m.csnt.dsn.orm.dsnVersion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the DSN_05 database table.
 * 
 */
@Entity
@Table(name="DSN_05")
public class Dsn05 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_envoi", unique=true, nullable=false)
	private long idEnvoi;

	@Column(name="_001", nullable=false, length=10)
	private String _01;

	@Column(name="_002", nullable=false, length=10)
	private String _02;

	@Column(name="_003", nullable=false, length=10)
	private String _03;

	@Column(name="_004", nullable=false, length=15)
	private String _04;

	@Column(name="_005", length=8)
	private String _05;

	@Column(name="_006", length=50)
	private String _06;

	@Column(name="_007", nullable=false, length=8)
	private String _07;

	@Column(name="_008", length=10)
	private String _08;

	@Column(name="_009", length=15)
	private String _09;

	@Column(nullable=false)
	private int optimLock;

	//bi-directional many-to-one association to Dsn11
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_etablissement", nullable=false)
	private Dsn11 etablissement;

	public Dsn05() {
	}

	public long getIdEnvoi() {
		return this.idEnvoi;
	}

	public void setIdEnvoi(long idEnvoi) {
		this.idEnvoi = idEnvoi;
	}

	public String get_01() {
		return this._01;
	}

	public void set_01(String _01) {
		this._01 = _01;
	}

	public String get_02() {
		return this._02;
	}

	public void set_02(String _02) {
		this._02 = _02;
	}

	public String get_03() {
		return this._03;
	}

	public void set_03(String _03) {
		this._03 = _03;
	}

	public String get_04() {
		return this._04;
	}

	public void set_04(String _04) {
		this._04 = _04;
	}

	public String get_05() {
		return this._05;
	}

	public void set_05(String _05) {
		this._05 = _05;
	}

	public String get_06() {
		return this._06;
	}

	public void set_06(String _06) {
		this._06 = _06;
	}

	public String get_07() {
		return this._07;
	}

	public void set_07(String _07) {
		this._07 = _07;
	}

	public String get_08() {
		return this._08;
	}

	public void set_08(String _08) {
		this._08 = _08;
	}

	public String get_09() {
		return this._09;
	}

	public void set_09(String _09) {
		this._09 = _09;
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

}
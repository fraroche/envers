package fr.si2m.csnt.dsn.orm.dsnVersion;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import fr.si2m.csnt.dsn.orm.imageRef.IrContrat;


/**
 * The persistent class for the DSN_70 database table.
 * 
 */
@Entity
@Table(name="DSN_70")
public class Dsn70 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	@Column(nullable=false)
	private int optimLock;

	@Id
	@Column(name="id_affil", unique=true, nullable=false)
	private long idAffil;

	//bi-directional many-to-one association to Dsn40
	@Audited
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_contrat", nullable=false)
	private Dsn40 contrat;

	//bi-directional many-to-one association to IrContrat
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.LAZY)
	//		@JoinColumn(name="_001", nullable=false)
	@JoinColumn(name="_001", referencedColumnName="NUC", nullable=false)
	private IrContrat _001;

	@Audited
	@Column(name="_002", nullable=false, length=9)
	private String _002;

	@Audited
	@Column(name="_003", length=6)
	private String _003;

	@Audited
	@Column(name="_004", length=30)
	private String _004;

	@Audited
	@Column(name="_005", length=30)
	private String _005;

	@Audited
	@Column(name="_006", nullable=false, length=8)
	private String _006;

	public Dsn70() {
	}

	public long getIdAffil() {
		return this.idAffil;
	}

	public void setIdAffil(long idAffil) {
		this.idAffil = idAffil;
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

	public IrContrat get_001() {
		return this._001;
	}

	public void set_001(IrContrat _001) {
		this._001 = _001;
	}

}
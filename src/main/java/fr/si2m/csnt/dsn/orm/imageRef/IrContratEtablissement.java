package fr.si2m.csnt.dsn.orm.imageRef;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the IR_Contrat_Etablissement database table.
 * 
 */
@Entity
@Table(name="IR_Contrat_Etablissement")
public class IrContratEtablissement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	@Column(nullable=false)
	private int optimLock;

	@EmbeddedId
	private IrContratEtablissementPK id;

	//bi-directional many-to-one association to IrContrat
	@Audited
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NUC", nullable=false, insertable=false, updatable=false)
	private IrContrat irContrat;

	//bi-directional many-to-one association to IrEtablissement
	@Audited
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEtablissement", nullable=false, insertable=false, updatable=false)
	private IrEtablissement irEtablissement;

	public IrContratEtablissement() {
	}

	public IrContratEtablissementPK getId() {
		return this.id;
	}

	public void setId(IrContratEtablissementPK id) {
		this.id = id;
	}

	public int getOptimLock() {
		return this.optimLock;
	}

	public void setOptimLock(int optimLock) {
		this.optimLock = optimLock;
	}

	public IrContrat getIrContrat() {
		return this.irContrat;
	}

	public void setIrContrat(IrContrat irContrat) {
		this.irContrat = irContrat;
	}

	public IrEtablissement getIrEtablissement() {
		return this.irEtablissement;
	}

	public void setIrEtablissement(IrEtablissement irEtablissement) {
		this.irEtablissement = irEtablissement;
	}

}
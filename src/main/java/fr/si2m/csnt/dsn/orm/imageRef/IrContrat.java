package fr.si2m.csnt.dsn.orm.imageRef;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import fr.si2m.csnt.dsn.orm.dsnVersion.Dsn70;


/**
 * The persistent class for the IR_Contrat database table.
 * 
 */
@Entity
@Table(name="IR_Contrat")
public class IrContrat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	@Column(nullable=false)
	private int optimLock;

	@Id
	@Column(name="NUC", unique=true, nullable=false, length=20)
	private String nuc;

	//bi-directional many-to-one association to IrEntreprise
	@Audited
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEntreprise", nullable=false)
	private IrEntreprise irEntreprise;

	@Audited
	@Column(length=6)
	private String cdOrgaDelegataireCotis;

	@Audited
	@Column(length=5)
	private String cdOrgaPorteurRisque;

	@Audited
	@Column(length=16)
	private String cdProduit;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtEffet;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtRadiation;

	@Column(length=1)
	private String indicateurCtrtCCFI;

	@Audited
	@Column(length=30)
	private String libproduit;

	@Audited
	@Column(nullable=false)
	private short numSequence;

	@Audited
	@Column(length=30)
	private String typeCtrt;

	//bi-directional many-to-one association to IrContratEtablissement
	@Audited
	@OneToMany(mappedBy="irContrat")
	private List<IrContratEtablissement> irContratEtablissementsList;

	//bi-directional many-to-one association to IrOption
	@Audited
	@OneToMany(mappedBy="irContrat")
	private List<IrOption> irOptionsList;

	//bi-directional many-to-one association to IrPopulationPVC
	@Audited
	@OneToMany(mappedBy="irContrat")
	private List<IrPopulationPVC> irPopulationPvcsList;

	//bi-directional many-to-one association to IrRisqueDelegue
	@Audited
	@OneToMany(mappedBy="irContrat")
	private List<IrRisqueDelegue> irRisqueDeleguesList;
	//bi-directional many-to-one association to Dsn70
	@Audited
	@OneToMany(mappedBy="_001", cascade={CascadeType.REFRESH})
	private List<Dsn70> affiliationPrevList;

	public IrContrat() {
	}

	public String getNuc() {
		return this.nuc;
	}

	public void setNuc(String nuc) {
		this.nuc = nuc;
	}

	public String getCdOrgaDelegataireCotis() {
		return this.cdOrgaDelegataireCotis;
	}

	public void setCdOrgaDelegataireCotis(String cdOrgaDelegataireCotis) {
		this.cdOrgaDelegataireCotis = cdOrgaDelegataireCotis;
	}

	public String getCdOrgaPorteurRisque() {
		return this.cdOrgaPorteurRisque;
	}

	public void setCdOrgaPorteurRisque(String cdOrgaPorteurRisque) {
		this.cdOrgaPorteurRisque = cdOrgaPorteurRisque;
	}

	public String getCdProduit() {
		return this.cdProduit;
	}

	public void setCdProduit(String cdProduit) {
		this.cdProduit = cdProduit;
	}

	public Date getDtEffet() {
		return this.dtEffet;
	}

	public void setDtEffet(Date dtEffet) {
		this.dtEffet = dtEffet;
	}

	public Date getDtRadiation() {
		return this.dtRadiation;
	}

	public void setDtRadiation(Date dtRadiation) {
		this.dtRadiation = dtRadiation;
	}

	public String getIndicateurCtrtCCFI() {
		return this.indicateurCtrtCCFI;
	}

	public void setIndicateurCtrtCCFI(String indicateurCtrtCCFI) {
		this.indicateurCtrtCCFI = indicateurCtrtCCFI;
	}

	public String getLibproduit() {
		return this.libproduit;
	}

	public void setLibproduit(String libproduit) {
		this.libproduit = libproduit;
	}

	public short getNumSequence() {
		return this.numSequence;
	}

	public void setNumSequence(short numSequence) {
		this.numSequence = numSequence;
	}

	public int getOptimLock() {
		return this.optimLock;
	}

	public void setOptimLock(int optimLock) {
		this.optimLock = optimLock;
	}

	public String getTypeCtrt() {
		return this.typeCtrt;
	}

	public void setTypeCtrt(String typeCtrt) {
		this.typeCtrt = typeCtrt;
	}

	public IrEntreprise getIrEntreprise() {
		return this.irEntreprise;
	}

	public void setIrEntreprise(IrEntreprise irEntreprise) {
		this.irEntreprise = irEntreprise;
	}

	public List<IrContratEtablissement> getIrContratEtablissementsList() {
		return this.irContratEtablissementsList;
	}

	public void setIrContratEtablissementsList(List<IrContratEtablissement> irContratEtablissementsList) {
		this.irContratEtablissementsList = irContratEtablissementsList;
	}

	public List<IrOption> getIrOptionsList() {
		return this.irOptionsList;
	}

	public void setIrOptionsList(List<IrOption> irOptionsList) {
		this.irOptionsList = irOptionsList;
	}

	public List<IrPopulationPVC> getIrPopulationPvcsList() {
		return this.irPopulationPvcsList;
	}

	public void setIrPopulationPvcsList(List<IrPopulationPVC> irPopulationPvcsList) {
		this.irPopulationPvcsList = irPopulationPvcsList;
	}

	public List<IrRisqueDelegue> getIrRisqueDeleguesList() {
		return this.irRisqueDeleguesList;
	}

	public void setIrRisqueDeleguesList(List<IrRisqueDelegue> irRisqueDeleguesList) {
		this.irRisqueDeleguesList = irRisqueDeleguesList;
	}

}
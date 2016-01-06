package fr.si2m.csnt.dsn.orm.imageRef;

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
 * The persistent class for the IR_Entreprise database table.
 * 
 */
@Entity
@Table(name="IR_Entreprise")
public class IrEntreprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	@Column(nullable=false)
	private int optimLock;

	@Id
	@Column(unique=true, nullable=false, length=8)
	private String idEntreprise;

	@Column(length=5)
	private String cdAPEN;

	@Audited
	@Column(length=1)
	private String cdEntrepriseVIP;

	@Audited
	@Column(length=1)
	private String cdIndicateurCession;

	@Audited
	@Column(length=2)
	private String cdMotifRadiation;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtCessationActivite;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtConnaissanceGroupe;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtCreation;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtDebApplicationCdAPE;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtDebApplicationDecalPaie;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtDebSommeil;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtDissolution;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtEffetRaisonSociale;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtFinApplicationCdAPE;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtFinApplicationDecalPaie;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtFinCessionPartielle;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtFinContinuation;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtFinSommeil;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtPremiereEmbauche;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtPrimExploitation;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtRadiation;

	@Audited
	private int numIdDansOrganisme;

	@Audited
	@Column(length=9)
	private String numSIREN;

	@Audited
	@Column(length=1)
	private String optionDecalPaie;

	@Audited
	@Column(length=100)
	private String raisonSociale;

	@Audited
	@Column(length=38)
	private String raisonSocialeAbregee;

	@Audited
	@Column(length=32)
	private String sigle;

	@Audited
	@Column(length=1)
	private String typeDecalageUtilise;

	//bi-directional many-to-one association to IrContrat
	@Audited
	@OneToMany(mappedBy="irEntreprise")
	private List<IrContrat> irContratsList;

	//bi-directional many-to-one association to IrEtablissement
	@Audited
	@OneToMany(mappedBy="irEntreprise")
	private List<IrEtablissement> irEtablissementsList;

	public IrEntreprise() {
	}

	public String getIdEntreprise() {
		return this.idEntreprise;
	}

	public void setIdEntreprise(String idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	public String getCdAPEN() {
		return this.cdAPEN;
	}

	public void setCdAPEN(String cdAPEN) {
		this.cdAPEN = cdAPEN;
	}

	public String getCdEntrepriseVIP() {
		return this.cdEntrepriseVIP;
	}

	public void setCdEntrepriseVIP(String cdEntrepriseVIP) {
		this.cdEntrepriseVIP = cdEntrepriseVIP;
	}

	public String getCdIndicateurCession() {
		return this.cdIndicateurCession;
	}

	public void setCdIndicateurCession(String cdIndicateurCession) {
		this.cdIndicateurCession = cdIndicateurCession;
	}

	public String getCdMotifRadiation() {
		return this.cdMotifRadiation;
	}

	public void setCdMotifRadiation(String cdMotifRadiation) {
		this.cdMotifRadiation = cdMotifRadiation;
	}

	public Date getDtCessationActivite() {
		return this.dtCessationActivite;
	}

	public void setDtCessationActivite(Date dtCessationActivite) {
		this.dtCessationActivite = dtCessationActivite;
	}

	public Date getDtConnaissanceGroupe() {
		return this.dtConnaissanceGroupe;
	}

	public void setDtConnaissanceGroupe(Date dtConnaissanceGroupe) {
		this.dtConnaissanceGroupe = dtConnaissanceGroupe;
	}

	public Date getDtCreation() {
		return this.dtCreation;
	}

	public void setDtCreation(Date dtCreation) {
		this.dtCreation = dtCreation;
	}

	public Date getDtDebApplicationCdAPE() {
		return this.dtDebApplicationCdAPE;
	}

	public void setDtDebApplicationCdAPE(Date dtDebApplicationCdAPE) {
		this.dtDebApplicationCdAPE = dtDebApplicationCdAPE;
	}

	public Date getDtDebApplicationDecalPaie() {
		return this.dtDebApplicationDecalPaie;
	}

	public void setDtDebApplicationDecalPaie(Date dtDebApplicationDecalPaie) {
		this.dtDebApplicationDecalPaie = dtDebApplicationDecalPaie;
	}

	public Date getDtDebSommeil() {
		return this.dtDebSommeil;
	}

	public void setDtDebSommeil(Date dtDebSommeil) {
		this.dtDebSommeil = dtDebSommeil;
	}

	public Date getDtDissolution() {
		return this.dtDissolution;
	}

	public void setDtDissolution(Date dtDissolution) {
		this.dtDissolution = dtDissolution;
	}

	public Date getDtEffetRaisonSociale() {
		return this.dtEffetRaisonSociale;
	}

	public void setDtEffetRaisonSociale(Date dtEffetRaisonSociale) {
		this.dtEffetRaisonSociale = dtEffetRaisonSociale;
	}

	public Date getDtFinApplicationCdAPE() {
		return this.dtFinApplicationCdAPE;
	}

	public void setDtFinApplicationCdAPE(Date dtFinApplicationCdAPE) {
		this.dtFinApplicationCdAPE = dtFinApplicationCdAPE;
	}

	public Date getDtFinApplicationDecalPaie() {
		return this.dtFinApplicationDecalPaie;
	}

	public void setDtFinApplicationDecalPaie(Date dtFinApplicationDecalPaie) {
		this.dtFinApplicationDecalPaie = dtFinApplicationDecalPaie;
	}

	public Date getDtFinCessionPartielle() {
		return this.dtFinCessionPartielle;
	}

	public void setDtFinCessionPartielle(Date dtFinCessionPartielle) {
		this.dtFinCessionPartielle = dtFinCessionPartielle;
	}

	public Date getDtFinContinuation() {
		return this.dtFinContinuation;
	}

	public void setDtFinContinuation(Date dtFinContinuation) {
		this.dtFinContinuation = dtFinContinuation;
	}

	public Date getDtFinSommeil() {
		return this.dtFinSommeil;
	}

	public void setDtFinSommeil(Date dtFinSommeil) {
		this.dtFinSommeil = dtFinSommeil;
	}

	public Date getDtPremiereEmbauche() {
		return this.dtPremiereEmbauche;
	}

	public void setDtPremiereEmbauche(Date dtPremiereEmbauche) {
		this.dtPremiereEmbauche = dtPremiereEmbauche;
	}

	public Date getDtPrimExploitation() {
		return this.dtPrimExploitation;
	}

	public void setDtPrimExploitation(Date dtPrimExploitation) {
		this.dtPrimExploitation = dtPrimExploitation;
	}

	public Date getDtRadiation() {
		return this.dtRadiation;
	}

	public void setDtRadiation(Date dtRadiation) {
		this.dtRadiation = dtRadiation;
	}

	public int getNumIdDansOrganisme() {
		return this.numIdDansOrganisme;
	}

	public void setNumIdDansOrganisme(int numIdDansOrganisme) {
		this.numIdDansOrganisme = numIdDansOrganisme;
	}

	public String getNumSIREN() {
		return this.numSIREN;
	}

	public void setNumSIREN(String numSIREN) {
		this.numSIREN = numSIREN;
	}

	public int getOptimLock() {
		return this.optimLock;
	}

	public void setOptimLock(int optimLock) {
		this.optimLock = optimLock;
	}

	public String getOptionDecalPaie() {
		return this.optionDecalPaie;
	}

	public void setOptionDecalPaie(String optionDecalPaie) {
		this.optionDecalPaie = optionDecalPaie;
	}

	public String getRaisonSociale() {
		return this.raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getRaisonSocialeAbregee() {
		return this.raisonSocialeAbregee;
	}

	public void setRaisonSocialeAbregee(String raisonSocialeAbregee) {
		this.raisonSocialeAbregee = raisonSocialeAbregee;
	}

	public String getSigle() {
		return this.sigle;
	}

	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	public String getTypeDecalageUtilise() {
		return this.typeDecalageUtilise;
	}

	public void setTypeDecalageUtilise(String typeDecalageUtilise) {
		this.typeDecalageUtilise = typeDecalageUtilise;
	}

	public List<IrContrat> getIrContratsList() {
		return this.irContratsList;
	}

	public void setIrContratsList(List<IrContrat> irContratsList) {
		this.irContratsList = irContratsList;
	}

	public List<IrEtablissement> getIrEtablissementsList() {
		return this.irEtablissementsList;
	}

	public void setIrEtablissementsList(List<IrEtablissement> irEtablissementsList) {
		this.irEtablissementsList = irEtablissementsList;
	}

}
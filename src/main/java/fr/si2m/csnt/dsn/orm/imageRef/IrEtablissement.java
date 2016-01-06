package fr.si2m.csnt.dsn.orm.imageRef;

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
 * The persistent class for the IR_Etablissement database table.
 * 
 */
@Entity
@Table(name="IR_Etablissement")
public class IrEtablissement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	@Column(nullable=false)
	private int optimLock;

	@Id
	@Column(unique=true, nullable=false, length=8)
	private String idEtablissement;

	//bi-directional many-to-one association to IrEntreprise
	@Audited
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idEntreprise", nullable=false)
	private IrEntreprise irEntreprise;

	@Audited
	@Column(length=100)
	private String activitePrincipaleEtablissement;

	@Audited
	@Column(length=5)
	private String cdFonctionnelActivitePrincipale;

	@Audited
	@Column(length=1)
	private String cdIndEtablissementPrincipal;

	@Audited
	@Column(length=1)
	private String cdIndicateurCessionActivite;

	@Audited
	@Column(length=1)
	private String cdIndicateurSiegeSocial;

	@Audited
	@Column(length=2)
	private String cdMotifFinActivite;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtCessationActivite;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtCreation;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtDebApplicationCdAPE;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtDebDecalagePaie;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtDebEffetEnseigne;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtDebEtablissementPrincipal;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtDebMiseSommeil;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtFinEffetEnseigne;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtFinMiseSommeil;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtPrimEmbauche;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtPrimExploitation;

	@Audited
	@Column(length=35)
	private String enseigne;

	@Audited
	@Column(length=65)
	private String libActivite;

	@Audited
	@Column(name="NIC", length=5)
	private String nic;

	@Audited
	private short numIdEtablissementDansOrgaEntreprise;

	@Audited
	@Column(length=1)
	private String optDecalagePaie;

	@Audited
	@Column(length=1)
	private String typeDecalagePaie;

	//bi-directional many-to-one association to IrContratEtablissement
	@Audited
	@OneToMany(mappedBy="irEtablissement")
	private List<IrContratEtablissement> irContratEtablissementsList;

	public IrEtablissement() {
	}

	public String getIdEtablissement() {
		return this.idEtablissement;
	}

	public void setIdEtablissement(String idEtablissement) {
		this.idEtablissement = idEtablissement;
	}

	public String getActivitePrincipaleEtablissement() {
		return this.activitePrincipaleEtablissement;
	}

	public void setActivitePrincipaleEtablissement(String activitePrincipaleEtablissement) {
		this.activitePrincipaleEtablissement = activitePrincipaleEtablissement;
	}

	public String getCdFonctionnelActivitePrincipale() {
		return this.cdFonctionnelActivitePrincipale;
	}

	public void setCdFonctionnelActivitePrincipale(String cdFonctionnelActivitePrincipale) {
		this.cdFonctionnelActivitePrincipale = cdFonctionnelActivitePrincipale;
	}

	public String getCdIndEtablissementPrincipal() {
		return this.cdIndEtablissementPrincipal;
	}

	public void setCdIndEtablissementPrincipal(String cdIndEtablissementPrincipal) {
		this.cdIndEtablissementPrincipal = cdIndEtablissementPrincipal;
	}

	public String getCdIndicateurCessionActivite() {
		return this.cdIndicateurCessionActivite;
	}

	public void setCdIndicateurCessionActivite(String cdIndicateurCessionActivite) {
		this.cdIndicateurCessionActivite = cdIndicateurCessionActivite;
	}

	public String getCdIndicateurSiegeSocial() {
		return this.cdIndicateurSiegeSocial;
	}

	public void setCdIndicateurSiegeSocial(String cdIndicateurSiegeSocial) {
		this.cdIndicateurSiegeSocial = cdIndicateurSiegeSocial;
	}

	public String getCdMotifFinActivite() {
		return this.cdMotifFinActivite;
	}

	public void setCdMotifFinActivite(String cdMotifFinActivite) {
		this.cdMotifFinActivite = cdMotifFinActivite;
	}

	public Date getDtCessationActivite() {
		return this.dtCessationActivite;
	}

	public void setDtCessationActivite(Date dtCessationActivite) {
		this.dtCessationActivite = dtCessationActivite;
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

	public Date getDtDebDecalagePaie() {
		return this.dtDebDecalagePaie;
	}

	public void setDtDebDecalagePaie(Date dtDebDecalagePaie) {
		this.dtDebDecalagePaie = dtDebDecalagePaie;
	}

	public Date getDtDebEffetEnseigne() {
		return this.dtDebEffetEnseigne;
	}

	public void setDtDebEffetEnseigne(Date dtDebEffetEnseigne) {
		this.dtDebEffetEnseigne = dtDebEffetEnseigne;
	}

	public Date getDtDebEtablissementPrincipal() {
		return this.dtDebEtablissementPrincipal;
	}

	public void setDtDebEtablissementPrincipal(Date dtDebEtablissementPrincipal) {
		this.dtDebEtablissementPrincipal = dtDebEtablissementPrincipal;
	}

	public Date getDtDebMiseSommeil() {
		return this.dtDebMiseSommeil;
	}

	public void setDtDebMiseSommeil(Date dtDebMiseSommeil) {
		this.dtDebMiseSommeil = dtDebMiseSommeil;
	}

	public Date getDtFinEffetEnseigne() {
		return this.dtFinEffetEnseigne;
	}

	public void setDtFinEffetEnseigne(Date dtFinEffetEnseigne) {
		this.dtFinEffetEnseigne = dtFinEffetEnseigne;
	}

	public Date getDtFinMiseSommeil() {
		return this.dtFinMiseSommeil;
	}

	public void setDtFinMiseSommeil(Date dtFinMiseSommeil) {
		this.dtFinMiseSommeil = dtFinMiseSommeil;
	}

	public Date getDtPrimEmbauche() {
		return this.dtPrimEmbauche;
	}

	public void setDtPrimEmbauche(Date dtPrimEmbauche) {
		this.dtPrimEmbauche = dtPrimEmbauche;
	}

	public Date getDtPrimExploitation() {
		return this.dtPrimExploitation;
	}

	public void setDtPrimExploitation(Date dtPrimExploitation) {
		this.dtPrimExploitation = dtPrimExploitation;
	}

	public String getEnseigne() {
		return this.enseigne;
	}

	public void setEnseigne(String enseigne) {
		this.enseigne = enseigne;
	}

	public String getLibActivite() {
		return this.libActivite;
	}

	public void setLibActivite(String libActivite) {
		this.libActivite = libActivite;
	}

	public String getNic() {
		return this.nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public short getNumIdEtablissementDansOrgaEntreprise() {
		return this.numIdEtablissementDansOrgaEntreprise;
	}

	public void setNumIdEtablissementDansOrgaEntreprise(short numIdEtablissementDansOrgaEntreprise) {
		this.numIdEtablissementDansOrgaEntreprise = numIdEtablissementDansOrgaEntreprise;
	}

	public String getOptDecalagePaie() {
		return this.optDecalagePaie;
	}

	public void setOptDecalagePaie(String optDecalagePaie) {
		this.optDecalagePaie = optDecalagePaie;
	}

	public int getOptimLock() {
		return this.optimLock;
	}

	public void setOptimLock(int optimLock) {
		this.optimLock = optimLock;
	}

	public String getTypeDecalagePaie() {
		return this.typeDecalagePaie;
	}

	public void setTypeDecalagePaie(String typeDecalagePaie) {
		this.typeDecalagePaie = typeDecalagePaie;
	}

	public List<IrContratEtablissement> getIrContratEtablissementsList() {
		return this.irContratEtablissementsList;
	}

	public void setIrContratEtablissementsList(List<IrContratEtablissement> irContratEtablissementsList) {
		this.irContratEtablissementsList = irContratEtablissementsList;
	}
	
	public IrEntreprise getIrEntreprise() {
		return this.irEntreprise;
	}

	public void setIrEntreprise(IrEntreprise irEntreprise) {
		this.irEntreprise = irEntreprise;
	}
	
}
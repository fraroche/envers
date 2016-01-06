package fr.si2m.csnt.dsn.orm.imageRef;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the IR_RisqueDelegue database table.
 * 
 */
@Embeddable
public class IrRisqueDeleguePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, length=50)
	private String riskDelegataire;

	@Column(unique=true, nullable=false, length=50)
	private String cdOrgaDelegatairePrest;

	@Column(name="NUC", unique=true, nullable=false, length=20)
	private String nuc;

    public IrRisqueDeleguePK() {
    }
	public String getRiskDelegataire() {
		return this.riskDelegataire;
	}
	public void setRiskDelegataire(String riskDelegataire) {
		this.riskDelegataire = riskDelegataire;
	}
	public String getCdOrgaDelegatairePrest() {
		return this.cdOrgaDelegatairePrest;
	}
	public void setCdOrgaDelegatairePrest(String cdOrgaDelegatairePrest) {
		this.cdOrgaDelegatairePrest = cdOrgaDelegatairePrest;
	}
	public String getNuc() {
		return this.nuc;
	}
	public void setNuc(String nuc) {
		this.nuc = nuc;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IrRisqueDeleguePK)) {
			return false;
		}
		IrRisqueDeleguePK castOther = (IrRisqueDeleguePK)other;
		return 
			this.riskDelegataire.equals(castOther.riskDelegataire)
			&& this.cdOrgaDelegatairePrest.equals(castOther.cdOrgaDelegatairePrest)
			&& this.nuc.equals(castOther.nuc);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.riskDelegataire.hashCode();
		hash = hash * prime + this.cdOrgaDelegatairePrest.hashCode();
		hash = hash * prime + this.nuc.hashCode();
		
		return hash;
    }
}
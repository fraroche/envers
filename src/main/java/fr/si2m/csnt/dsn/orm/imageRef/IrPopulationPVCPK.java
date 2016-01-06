package fr.si2m.csnt.dsn.orm.imageRef;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the IR_PopulationPVC database table.
 * 
 */
@Embeddable
public class IrPopulationPVCPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private short cdPopulation;

	@Column(name="NUC", unique=true, nullable=false, length=20)
	private String nuc;

    public IrPopulationPVCPK() {
    }
	public short getCdPopulation() {
		return this.cdPopulation;
	}
	public void setCdPopulation(short cdPopulation) {
		this.cdPopulation = cdPopulation;
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
		if (!(other instanceof IrPopulationPVCPK)) {
			return false;
		}
		IrPopulationPVCPK castOther = (IrPopulationPVCPK)other;
		return 
			(this.cdPopulation == castOther.cdPopulation)
			&& this.nuc.equals(castOther.nuc);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.cdPopulation);
		hash = hash * prime + this.nuc.hashCode();
		
		return hash;
    }
}
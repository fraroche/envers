package fr.si2m.csnt.dsn.orm.imageRef;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the IR_Option database table.
 * 
 */
@Embeddable
public class IrOptionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private short cdOption;

	@Column(name="NUC", unique=true, nullable=false, length=20)
	private String nuc;

	@Column(unique=true, nullable=false)
	private short cdPopulation;

    public IrOptionPK() {
    }
	public short getCdOption() {
		return this.cdOption;
	}
	public void setCdOption(short cdOption) {
		this.cdOption = cdOption;
	}
	public String getNuc() {
		return this.nuc;
	}
	public void setNuc(String nuc) {
		this.nuc = nuc;
	}
	public short getCdPopulation() {
		return this.cdPopulation;
	}
	public void setCdPopulation(short cdPopulation) {
		this.cdPopulation = cdPopulation;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IrOptionPK)) {
			return false;
		}
		IrOptionPK castOther = (IrOptionPK)other;
		return 
			(this.cdOption == castOther.cdOption)
			&& this.nuc.equals(castOther.nuc)
			&& (this.cdPopulation == castOther.cdPopulation);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.cdOption);
		hash = hash * prime + this.nuc.hashCode();
		hash = hash * prime + ((int) this.cdPopulation);
		
		return hash;
    }
}
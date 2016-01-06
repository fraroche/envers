package fr.si2m.csnt.dsn.orm.imageRef;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the IR_Contrat_Etablissement database table.
 * 
 */
@Embeddable
public class IrContratEtablissementPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUC", unique=true, nullable=false, length=20)
	private String nuc;

	@Column(unique=true, nullable=false, length=8)
	private String idEtablissement;

	public IrContratEtablissementPK() {
	}
	public String getNuc() {
		return this.nuc;
	}
	public void setNuc(String nuc) {
		this.nuc = nuc;
	}
	public String getIdEtablissement() {
		return this.idEtablissement;
	}
	public void setIdEtablissement(String idEtablissement) {
		this.idEtablissement = idEtablissement;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IrContratEtablissementPK)) {
			return false;
		}
		IrContratEtablissementPK castOther = (IrContratEtablissementPK)other;
		return 
			this.nuc.equals(castOther.nuc)
			&& this.idEtablissement.equals(castOther.idEtablissement);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.nuc.hashCode();
		hash = hash * prime + this.idEtablissement.hashCode();

		return hash;
	}
}
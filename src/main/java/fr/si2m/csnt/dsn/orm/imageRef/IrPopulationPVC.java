package fr.si2m.csnt.dsn.orm.imageRef;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the IR_PopulationPVC database table.
 * 
 */
@Entity
@Table(name="IR_PopulationPVC")
public class IrPopulationPVC implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	@Column(nullable=false)
	private int optimLock;

	@EmbeddedId
	private IrPopulationPVCPK id;

	//bi-directional many-to-one association to IrContrat
	@Audited
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NUC", nullable=false, insertable=false, updatable=false)
	private IrContrat irContrat;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtDebApplication;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtFinApplication;

	@Audited
	@Column(length=100)
	private String libPopLong;

	@Audited
	@Column(length=30)
	private String libPopulation;

	//bi-directional many-to-one association to IrOption
	@Audited
	@OneToMany(mappedBy="irPopulationPvc")
	private List<IrOption> irOptionsList;

	public IrPopulationPVC() {
	}

	public IrPopulationPVCPK getId() {
		return this.id;
	}

	public void setId(IrPopulationPVCPK id) {
		this.id = id;
	}

	public Date getDtDebApplication() {
		return this.dtDebApplication;
	}

	public void setDtDebApplication(Date dtDebApplication) {
		this.dtDebApplication = dtDebApplication;
	}

	public Date getDtFinApplication() {
		return this.dtFinApplication;
	}

	public void setDtFinApplication(Date dtFinApplication) {
		this.dtFinApplication = dtFinApplication;
	}

	public String getLibPopLong() {
		return this.libPopLong;
	}

	public void setLibPopLong(String libPopLong) {
		this.libPopLong = libPopLong;
	}

	public String getLibPopulation() {
		return this.libPopulation;
	}

	public void setLibPopulation(String libPopulation) {
		this.libPopulation = libPopulation;
	}

	public int getOptimLock() {
		return this.optimLock;
	}

	public void setOptimLock(int optimLock) {
		this.optimLock = optimLock;
	}

	public List<IrOption> getIrOptionsList() {
		return this.irOptionsList;
	}

	public void setIrOptionsList(List<IrOption> irOptionsList) {
		this.irOptionsList = irOptionsList;
	}

	public IrContrat getIrContrat() {
		return this.irContrat;
	}

	public void setIrContrat(IrContrat irContrat) {
		this.irContrat = irContrat;
	}

}
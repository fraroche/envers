package fr.si2m.csnt.dsn.orm.imageRef;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.envers.Audited;


/**
 * The persistent class for the IR_Option database table.
 * 
 */
@Entity
@Table(name="IR_Option")
public class IrOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Version
	@Column(nullable=false)
	private int optimLock;

	@EmbeddedId
	private IrOptionPK id;

	//bi-directional many-to-one association to IrContrat
	@Audited
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NUC", nullable=false, insertable=false, updatable=false)
	private IrContrat irContrat;

	//bi-directional many-to-one association to IrPopulationPVC
	@Audited
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="cdPopulation", referencedColumnName="NUC", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="NUC", referencedColumnName="cdPopulation", nullable=false, insertable=false, updatable=false)
		})
	private IrPopulationPVC irPopulationPvc;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtDebApplication;

	@Audited
	@Temporal( TemporalType.DATE)
	private Date dtFinApplication;

	@Audited
	@Column(length=30)
	private String libOption;

	public IrOption() {
	}

	public IrOptionPK getId() {
		return this.id;
	}

	public void setId(IrOptionPK id) {
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

	public String getLibOption() {
		return this.libOption;
	}

	public void setLibOption(String libOption) {
		this.libOption = libOption;
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
	
	public IrPopulationPVC getIrPopulationPvc() {
		return this.irPopulationPvc;
	}

	public void setIrPopulationPvc(IrPopulationPVC irPopulationPvc) {
		this.irPopulationPvc = irPopulationPvc;
	}
	
}
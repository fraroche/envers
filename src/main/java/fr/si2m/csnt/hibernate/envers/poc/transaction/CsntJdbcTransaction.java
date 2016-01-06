package fr.si2m.csnt.hibernate.envers.poc.transaction;

import javax.transaction.Synchronization;

import org.hibernate.HibernateException;
import org.hibernate.TransactionException;
import org.hibernate.engine.transaction.internal.jdbc.JdbcTransaction;
import org.hibernate.engine.transaction.spi.IsolationDelegate;
import org.hibernate.engine.transaction.spi.JoinStatus;
import org.hibernate.engine.transaction.spi.LocalStatus;
import org.hibernate.engine.transaction.spi.TransactionCoordinator;
import org.hibernate.service.jta.platform.spi.JtaPlatform;

public class CsntJdbcTransaction extends JdbcTransaction {

	protected CsntJdbcTransaction(TransactionCoordinator pTransactionCoordinator) {
		super(pTransactionCoordinator);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doBegin() {
		super.doBegin();
	}
	@Override
	protected void afterTransactionBegin() {
		super.afterTransactionBegin();
	}
	@Override
	protected void beforeTransactionCommit() {
		super.beforeTransactionCommit();
	}
	@Override
	protected void doCommit() throws TransactionException {
		super.doCommit();
	}
	@Override
	protected void afterTransactionCompletion(int pStatus) {
		super.afterTransactionCompletion(pStatus);
	}
	@Override
	protected void afterAfterCompletion() {
		super.afterAfterCompletion();
	}
	@Override
	protected void beforeTransactionRollBack() {
		super.beforeTransactionRollBack();
	}
	@Override
	protected void doRollback() throws TransactionException {
		super.doRollback();
	}
	@Override
	public boolean isInitiator() {
		return super.isInitiator();
	}
	@Override
	public IsolationDelegate createIsolationDelegate() {
		return super.createIsolationDelegate();
	}
	@Override
	public JoinStatus getJoinStatus() {
		return super.getJoinStatus();
	}
	@Override
	public void markRollbackOnly() {
		super.markRollbackOnly();
	}
	@Override
	public void join() {
		super.join();
	}
	@Override
	public void resetJoinStatus() {
		super.resetJoinStatus();
	}
	@Override
	public boolean isActive() throws HibernateException {
		return super.isActive();
	}
	@Override
	public void invalidate() {
		super.invalidate();
	}
	@Override
	protected TransactionCoordinator transactionCoordinator() {
		return super.transactionCoordinator();
	}
	@Override
	protected JtaPlatform jtaPlatform() {
		return super.jtaPlatform();
	}
	@Override
	public void registerSynchronization(Synchronization pSynchronization) {
		super.registerSynchronization(pSynchronization);
	}
	@Override
	public LocalStatus getLocalStatus() {
		return super.getLocalStatus();
	}
	@Override
	public boolean isParticipating() {
		return super.isParticipating();
	}
	@Override
	public boolean wasCommitted() {
		return super.wasCommitted();
	}
	@Override
	public boolean wasRolledBack() throws HibernateException {
		return super.wasRolledBack();
	}
	@Override
	protected boolean doExtendedActiveCheck() {
		return super.doExtendedActiveCheck();
	}
	@Override
	public void begin() throws HibernateException {
		super.begin();
	}
	@Override
	public void commit() throws HibernateException {
		super.commit();
	}
	@Override
	protected boolean allowFailedCommitToPhysicallyRollback() {
		return super.allowFailedCommitToPhysicallyRollback();
	}
	@Override
	public void rollback() throws HibernateException {
		super.rollback();
	}
	@Override
	public void setTimeout(int pSeconds) {
		super.setTimeout(pSeconds);
	}
	@Override
	public int getTimeout() {
		return super.getTimeout();
	}
	@Override
	public void markForJoin() {
		super.markForJoin();
	}

}

package fr.si2m.csnt.hibernate.envers.poc.dialect;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.lock.LockingStrategy;
import org.hibernate.persister.entity.Lockable;

public class CsntMySQL5InnoDBDialect extends MySQL5InnoDBDialect {
	public CsntMySQL5InnoDBDialect() {
		super();
		this.registerColumnType( java.sql.Types.BOOLEAN, "bit" );
	}

	@Override
	public String getForUpdateString(String aliases, LockOptions lockOptions) {
		return super.getForUpdateString(aliases, lockOptions);
	}

	@Override
	public String getForUpdateString(LockOptions lockOptions) {
		String a = super.getForUpdateString(lockOptions);
		return a;
	}

	@Override
	public String getForUpdateString(LockMode lockMode){
		return super.getForUpdateString(lockMode);
	}

	@Override
	public String getForUpdateString(){
		return super.getForUpdateString();
	}

	@Override
	public LockingStrategy getLockingStrategy(Lockable lockable,
			LockMode lockMode){
		LockingStrategy lckStratgy = super.getLockingStrategy(lockable, lockMode);
		return lckStratgy;
	}
}

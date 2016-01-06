package fr.si2m.csnt.hibernate.envers.poc.rev;

import org.hibernate.envers.RevisionListener;

public class Si2mRevisionListener implements RevisionListener {

	@Override
	public void newRevision(Object pRevisionEntity) {
		Si2mRevisionEntity revEntity = (Si2mRevisionEntity) pRevisionEntity;
		revEntity.setUsername("toto");
	}

}

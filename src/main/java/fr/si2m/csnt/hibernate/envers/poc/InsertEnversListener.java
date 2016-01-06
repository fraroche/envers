package fr.si2m.csnt.hibernate.envers.poc;

import org.hibernate.envers.configuration.AuditConfiguration;
import org.hibernate.envers.event.EnversPostInsertEventListenerImpl;
import org.hibernate.event.spi.PostInsertEvent;



//public class InsertEnversListener{
//}

public class InsertEnversListener extends EnversPostInsertEventListenerImpl {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long	serialVersionUID	= 1L;

	protected InsertEnversListener(AuditConfiguration pEnversConfiguration) {
		super(pEnversConfiguration);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.envers.event.spi.EnversPostInsertEventListenerImpl#onPostInsert(org.hibernate.event.spi.PostInsertEvent)
	 */
	@Override
	public void onPostInsert(PostInsertEvent pEvent) {
		System.out.print("InsertEnversListener.onPostInsert() - ");
		System.out.println("!!! just logging entity !! " + pEvent.getEntity());
		super.onPostInsert(pEvent);
	}

}

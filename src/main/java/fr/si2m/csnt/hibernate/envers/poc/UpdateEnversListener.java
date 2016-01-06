package fr.si2m.csnt.hibernate.envers.poc;

import org.hibernate.envers.configuration.AuditConfiguration;
import org.hibernate.envers.event.EnversPostUpdateEventListenerImpl;
import org.hibernate.event.spi.PostUpdateEvent;


//public class UpdateEnversListener{
//}

public class UpdateEnversListener extends EnversPostUpdateEventListenerImpl {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long	serialVersionUID	= 1L;

	protected UpdateEnversListener(AuditConfiguration pEnversConfiguration) {
		super(pEnversConfiguration);
	}

	/* (non-Javadoc)
	 * @see org.hibernate.envers.event.spi.EnversPostUpdateEventListenerImpl#onPostUpdate(org.hibernate.event.spi.PostUpdateEvent)
	 */
	@Override
	public void onPostUpdate(PostUpdateEvent pEvent) {
		System.out.print("UpdateEnversListener.onPostUpdate() - ");
		System.out.println("!!! just logging entity !! " + pEvent.getEntity());
		super.onPostUpdate(pEvent);
	}

}

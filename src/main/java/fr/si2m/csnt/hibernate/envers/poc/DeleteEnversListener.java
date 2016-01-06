package fr.si2m.csnt.hibernate.envers.poc;

import org.hibernate.envers.configuration.AuditConfiguration;
import org.hibernate.envers.event.EnversPostDeleteEventListenerImpl;
import org.hibernate.event.spi.PostDeleteEvent;


//public class DeleteEnversListener {
//}

public class DeleteEnversListener extends EnversPostDeleteEventListenerImpl {
	private static final long	serialVersionUID	= 5906427978349712224L;

	public DeleteEnversListener(AuditConfiguration enversConfiguration) {
		super(enversConfiguration);
	}

	@Override
	public void onPostDelete(PostDeleteEvent event) {
		System.out.print("DeleteEnversListener.onPostDelete() - ");
		System.out.println("!!! just logging entity !! " + event.getEntity());
		super.onPostDelete(event);
	}
}

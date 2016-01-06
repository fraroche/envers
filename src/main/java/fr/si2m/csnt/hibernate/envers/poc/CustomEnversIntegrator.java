package fr.si2m.csnt.hibernate.envers.poc;

import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.envers.configuration.AuditConfiguration;
import org.hibernate.envers.event.EnversIntegrator;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.service.classloading.spi.ClassLoaderService;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;


//public class CustomEnversIntegrator {}


public class CustomEnversIntegrator extends EnversIntegrator {

	@Override
	public void integrate(Configuration configuration, SessionFactoryImplementor sessionFactory, SessionFactoryServiceRegistry serviceRegistry) {

		super.integrate(configuration, sessionFactory, serviceRegistry);
		final AuditConfiguration enversConfiguration = AuditConfiguration.getFor(configuration, serviceRegistry.getService(ClassLoaderService.class));
		EventListenerRegistry listenerRegistry = serviceRegistry.getService(EventListenerRegistry.class);

		System.out.println("Registering event listeners");
		if (enversConfiguration.getEntCfg().hasAuditedEntities()) {
			listenerRegistry.appendListeners(EventType.POST_INSERT, new InsertEnversListener(enversConfiguration));
			listenerRegistry.appendListeners(EventType.POST_UPDATE, new UpdateEnversListener(enversConfiguration));
			listenerRegistry.appendListeners(EventType.POST_DELETE, new DeleteEnversListener(enversConfiguration));
			//			listenerRegistry.appendListeners(EventType.POST_COLLECTION_RECREATE, new CollectionRecreateEnversListener(enversConfiguration));
			//			listenerRegistry.appendListeners(EventType.PRE_COLLECTION_REMOVE, new PreCollectionRemoveEnversListener(enversConfiguration));
			//			listenerRegistry.appendListeners(EventType.PRE_COLLECTION_UPDATE, new PreCollectionUpdateEnversListener(enversConfiguration));
		}

	}
}

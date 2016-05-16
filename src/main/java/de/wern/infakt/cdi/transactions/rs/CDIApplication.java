package de.wern.infakt.cdi.transactions.rs;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessBean;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import de.wern.infakt.cdi.transactions.KundenServiceImpl;

@ApplicationPath("/")
public class CDIApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classe = new HashSet<>();
		classe.add(RestfulKundenServiceFacade.class);
		return classe;
	}

}

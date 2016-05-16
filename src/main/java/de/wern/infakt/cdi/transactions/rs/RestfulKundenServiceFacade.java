package de.wern.infakt.cdi.transactions.rs;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import de.wern.infakt.cdi.transactions.Kunde;
import de.wern.infakt.cdi.transactions.KundenService;
import de.wern.infakt.cdi.transactions.KundenServiceException;

@RequestScoped
@Path("/kunden")
public class RestfulKundenServiceFacade {
	@Inject
	KundenService kundenService;

	@POST
	@Produces("text/plain")
	public long erzeugeKunde(@QueryParam("vorname") String vorname,
			@QueryParam("nachname") String nachname) throws KundenServiceException{
		return kundenService.erzeugeKunde(vorname, nachname);
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Kunde findeKunde(@PathParam("id") String kundennummer) {
		return kundenService.findeKunde(Long.parseLong(kundennummer));
	}

}

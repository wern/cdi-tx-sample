package de.wern.infakt.cdi.transactions;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import de.wern.infakt.cdi.transactions.stereotype.SingletonService;

@SingletonService
public class KundenServiceImpl implements KundenService {

	@Inject
	private EntityManager em;

	@Inject
	private Event<Kunde> kundenEvent;

	@Override
	@Transactional(rollbackOn = KundenServiceException.class)
	public long erzeugeKunde(String vorname, String nachname) throws KundenServiceException {

		Kunde kunde = new Kunde(vorname, nachname);
		em.persist(kunde);
		kundenEvent.fire(kunde);

		johnDoeIstNichtErlaubt(vorname, nachname); // Moeglicher Rollback nach em.persist(...) und Event.fire()

		return kunde.getId();
	}

	@Override
	@Transactional(Transactional.TxType.SUPPORTS)
	public Kunde findeKunde(long kundennummer) {
		return em.find(Kunde.class, kundennummer);
	}

	private void johnDoeIstNichtErlaubt(String vorname, String nachname)
			throws KundenServiceException {
		if ("John".equals(vorname) && "Doe".equals(nachname)) {
			throw new KundenServiceException(
					"John Doe wollen wir hier nicht ,) ...");
		}
	}

}

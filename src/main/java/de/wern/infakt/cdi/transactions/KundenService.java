package de.wern.infakt.cdi.transactions;


public interface KundenService {

	public abstract long erzeugeKunde(String vorname, String nachname)
			throws KundenServiceException;

	public abstract Kunde findeKunde(long kundennummer);

}
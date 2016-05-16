package de.wern.infakt.cdi.transactions;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

@ApplicationScoped
public class KundenObserver {
	public void neuerKundeErzeugt(@Observes(during=TransactionPhase.AFTER_SUCCESS) Kunde kunde){
		System.out.println("Neuer Kunde erzeugt !");
	}
	
	public void keinKundeErzeugt(@Observes(during=TransactionPhase.AFTER_FAILURE) Kunde kunde){
		System.out.println("Kunde konnte nicht erzeugt werden !");
	}

}

package de.wern.infakt.cdi.transactions;

@SuppressWarnings("serial")
public class KundenServiceException extends Exception {

	public KundenServiceException() {
	}

	public KundenServiceException(String message) {
		super(message);
	}

}

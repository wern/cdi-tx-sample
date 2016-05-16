package de.wern.infakt.cdi.transactions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@SequenceGenerator(name="kd_seq", sequenceName="kdseq")
public class Kunde {

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="kd_seq")
	private long id;

	private String vorname;

	private String nachname;

	public Kunde(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public Kunde() {
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public long getId() {
		return id;
	}

}

package de.wern.infakt.cdi.transactions;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.TransactionScoped;

import de.wern.infakt.cdi.transactions.qualifier.ApplicationManaged;
import de.wern.infakt.cdi.transactions.qualifier.ContainerManaged;

/**
* Zentrale Factory fuer container-managed und application-managed EntityManager.
* Die verwendeten technischen Qualifier dienen der Verdeutlichung und waeren 
* normalerweise fachlich getrieben. 
* 
* Der @Default EntityManager ist container-managed.
*/
@ApplicationScoped
public class EntityManagerProducer {

	@Produces
	@Default
	@ContainerManaged
	@PersistenceContext(unitName="kunde")
	private EntityManager em;
	
	@PersistenceUnit(unitName="kunde_app")
	private EntityManagerFactory emf;
	
	@Produces 
	@ApplicationManaged
	@TransactionScoped
	public EntityManager erzeugeEntityManager(){
	//	return Persistence.createEntityManagerFactory("kunde_app").createEntityManager();
		return emf.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes @ApplicationManaged EntityManager em){
		em.close();
	}
}

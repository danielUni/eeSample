package ejb.eeSample.jar.beans;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ejb.eeSample.jar.entities.Visitor;

@Stateless
@Named
public class SampleEJB {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	// TEST

	public SampleEJB() {

	}

	public Visitor createUser(Visitor user) {
		em.persist(user);
		return user;
	}

}

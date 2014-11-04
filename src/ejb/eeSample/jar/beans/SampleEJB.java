package ejb.eeSample.jar.beans;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ejb.eeSample.jar.entities.User;

@Stateless
@Named
public class SampleEJB {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	public SampleEJB() {

	}

	public User createUser(User user) {
		em.persist(user);
		return user;
	}

}

package ejb.eeSample.jar.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ejb.eeSample.jar.entities.Visitor;

@Stateless
@Named
public class VisitorEJB {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	public VisitorEJB() {

	}

	public Visitor createUser(Visitor user) {
		em.persist(user);
		return user;
	}

	public List<Visitor> getVisitors() {
		List<Visitor> visitors = em.createNamedQuery("findAllVisitors")
				.getResultList();
		return visitors;
	}

}

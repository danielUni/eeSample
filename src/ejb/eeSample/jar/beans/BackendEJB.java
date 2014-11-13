package ejb.eeSample.jar.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ejb.eeSample.jar.entities.BeverageEntity;
import ejb.eeSample.jar.entities.IncentiveEntity;
import ejb.eeSample.jar.entities.ManufacturerEntity;

@Stateless
@Named
public class BackendEJB {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	EntityManager em;

	public BackendEJB() {

	}

	public BeverageEntity addBeverage(BeverageEntity b) {
		em.persist(b);
		return b;
	}

	public IncentiveEntity addIncentive(IncentiveEntity i) {
		em.persist(i);
		return i;
	}

	public ManufacturerEntity addManufacturer(ManufacturerEntity m) {
		em.persist(m);
		return m;
	}

	@SuppressWarnings("unchecked")
	public List<ManufacturerEntity> getManufactures() {
		return em.createNamedQuery("getManufacturers").getResultList();
	}
}

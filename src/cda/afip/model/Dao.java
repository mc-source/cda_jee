package cda.afip.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

public class Dao<T> implements IDao<T> {
	private static final Logger logger = Logger.getLogger(Dao.class);
	private static final String PERSISTENCE_UNIT_NAME = "cda_jee";
	
	EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;
    
	Class<T> entityClass;
	public Dao(Class<T> entityClass) {	
		try {
	        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	        entityManager = entityManagerFactory.createEntityManager();          
	    }catch(Exception e) {
	    	logger.info("Error (BD) : "+e);
	    }
		this.entityClass=entityClass;
	}

	@Override
	public List<T> getAll() {
		//requete en JPQL 	
		List<T> items = entityManager.createQuery("from "+entityClass.getSimpleName(), entityClass).getResultList();
		return items;
	}

	@Override
	public T getById(int id) {
		entityManager.getTransaction().begin();
		T item= entityManager.find(entityClass, id);
		entityManager.getTransaction().commit();
		return item;
	}

	@Override
	public T add(T item) {
		entityManager.getTransaction().begin();
		entityManager.persist(item);
		entityManager.getTransaction().commit();
		return item;
	}

	@Override
	public T update(T item) {
		entityManager.getTransaction().begin();
		entityManager.merge(item);
		entityManager.getTransaction().commit();
		return item;
	}

	@Override
	public boolean delete(T item) {
		entityManager.getTransaction().begin();
		entityManager.remove(item);
		entityManager.getTransaction().commit();
		return true;		
	}

	/*
	 * custom query..
	 */
	public List<T> getFiltred(String sql_query) {
		@SuppressWarnings("unchecked")
		List<T> items = entityManager.createNativeQuery(sql_query, entityClass).getResultList();  
		return items;
	}
}

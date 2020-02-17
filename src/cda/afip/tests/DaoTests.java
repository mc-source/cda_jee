package cda.afip.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import cda.afip.model.User;

public class DaoTests {
	private static final Logger logger = Logger.getLogger(DaoTests.class);
	private static final String PERSISTENCE_UNIT_NAME = "cda_jee";
    EntityManager em = null;
    
	Class<?> entityClass;
	public DaoTests() {	
		try {
	        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	        em = entityManagerFactory.createEntityManager();          
	    }catch(Exception e) {
	    	logger.info("Error (BD) : "+e);
	    }
	}
	
	public void Select() {
		
		TypedQuery<String> query = em.createQuery("SELECT DISTINCT u.lastname FROM User u", String.class);
		List<String> users =  query.getResultList();
		
		logger.info("=============================");
		users.forEach(logger::info);
		logger.info("=============================");
		
		List<User> items = em.createNamedQuery("User.findAll", User.class).getResultList();
		logger.info("=============================");
		items.forEach(logger::info);
		logger.info("=============================");
	}
}

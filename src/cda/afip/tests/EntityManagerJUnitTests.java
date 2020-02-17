package cda.afip.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Test;

public class EntityManagerJUnitTests {
	private static final String PERSISTENCE_UNIT_NAME = "cda_jee"; 
	// persistence-unit name="cda_jee" : dans persistence.xml

	@Test
	public void test() {
		//Assert.assertEquals(3, 2+1);
		
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		Assert.assertNotNull(entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();   
		//Assert.assertNotNull(entityManager);		
		Assert.assertEquals(true,  entityManager.isOpen());
		
		System.out.println(entityManager);


	}

}

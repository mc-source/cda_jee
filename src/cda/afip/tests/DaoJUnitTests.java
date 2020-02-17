package cda.afip.tests;

import org.junit.Test;

public class DaoJUnitTests {
	@Test
	public void test() {
		//		Dao<User> dao = new Dao<>(User.class);
		//		
		//		List<User> users = dao.getAll();
		//		Assert.assertEquals(2, users.size());
		//		
		//		users.forEach(
		//			u -> System.out.println(u)
		//		);		
		
		DaoTests dao= new DaoTests();
		dao.Select();
	}
}

package cda.afip.model;

import java.util.List;

public class UserManager extends Dao<User>{
	public UserManager() {
		super(User.class); 
	}
	public User login(String login, String password) {	
		String jpa_query="FROM User u WHERE u.login='"+login+"' "
				+ "AND u.password='"+password+"'";
		List<User> found = entityManager.createQuery(jpa_query,User.class)
				.getResultList();

		return found.size()>0?found.get(0):null;
	}
}

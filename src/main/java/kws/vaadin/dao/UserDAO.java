package kws.vaadin.dao;

import java.util.ArrayList;

import kws.vaadin.models.DbUser;

/**
 * Representation of a DAO for users.
 * @author Decker108 (modifications)
 * @author Mark Serrano, (original, http://krams915.blogspot.se/2010/12/spring-security-mvc-integration_18.html)
*/
public class UserDAO {

	private ArrayList<DbUser> users;

	public UserDAO() {
		users = new ArrayList<DbUser>();
		users.add(new DbUser("jimi", "0cc175b9c0f1b6a831c399e269772661", 0)); //password: a
		users.add(new DbUser("bob", "92eb5ffee6ae2fec3ad71c777531578f", 1)); //password: b
	}

	public DbUser findUserByName(String username) {
		if (username.equals("admin") || username.equals("test")) {
			return new DbUser(username, "098f6bcd4621d373cade4e832627b4f6", 1); //password: test
		} else {
			for (DbUser user : users) {
				if (user.getUsername().equals(username)) {
					return user;
				}
			}
		}
		return null;
	}

}

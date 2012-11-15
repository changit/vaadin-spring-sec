package kws.vaadin.models;

/**
 * Representation of a user in a database.
 * @author Decker108 (modifications)
 * @author Mark Serrano, (original, http://krams915.blogspot.se/2010/12/spring-security-mvc-integration_18.html)
*/
public class DbUser {

	private final String username;
	private final String password;
	private Integer access;

	public DbUser(String username, String password, Integer access) {
		this.username = username;
		this.password = password;
		this.access = access;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Integer getAccess() {
		return access;
	}

}

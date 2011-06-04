package kws.vaadin.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component("securedService")
public class SecuredServiceImpl implements SecuredService{

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void securedMethod1() {
		System.out.println("You are executing secured method1");
	}

	public void securedMethod2() {

	}

}

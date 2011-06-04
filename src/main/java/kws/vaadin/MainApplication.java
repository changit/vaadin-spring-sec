
package kws.vaadin;

import java.util.Collection;

import kws.vaadin.security.Roles;
import kws.vaadin.service.SecuredService;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Component("applicationBean")
@Scope("prototype")
public class MainApplication extends Application {

	@Autowired
	private SecuredService securedService;
	
	public WebApplicationContext appContext;

	@Override
	public void init() {
		Window window;
		window = new Window("My Vaadin Application");
		window.addComponent(new HeaderWindow(this));
		window.addComponent(new BodyWindow(this));
		window.addComponent(new FooterWindow(this));
		setMainWindow(window);
	}

	public boolean hasAnyRole(String ... roles){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<GrantedAuthority> authorities = authentication.getAuthorities();
		for(GrantedAuthority authority: authorities){
			for(String role: roles){
				if(role.equals(authority.getAuthority())){
					return true;
				}
			}
		}
		return false;
	}
	
	public void setWebApplicationContext(WebApplicationContext appContext){
		this.appContext = appContext;
	}
	
}


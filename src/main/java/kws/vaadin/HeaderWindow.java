package kws.vaadin;

import kws.vaadin.security.Roles;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

public class HeaderWindow extends HorizontalLayout{
	
	private MainApplication mainApp;

	public HeaderWindow(MainApplication mainApp) {
		this.mainApp = mainApp;
		addComponents();
	}

	private void addComponents() {
		if(mainApp.hasAnyRole(Roles.ROLE_ADMIN)){
			addComponent(new Label("You have admin previliges, That is why you see this"));
		} else {
			addComponent(new Label("You Have limited previlges here. So You will not many components."));
		}
	}
	
	
}

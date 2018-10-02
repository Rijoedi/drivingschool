package com.drivingschool.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import com.drivingschool.model.User;

public class Authorizer implements PhaseListener {

	private static final long serialVersionUID = 1L;

	public void afterPhase(PhaseEvent event) {	

		FacesContext context = event.getFacesContext();
		String namePage = context.getViewRoot().getViewId();
		
		System.out.println(namePage);
		
		if("/login.xhtml".equals(namePage)) {
			return;
		}
		
		User userLogged = (User) context.getExternalContext().getSessionMap().get("userLogged");
		
		if(userLogged != null) {
			return;
		}
		
		//Redirect to login.xhtml//
		
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, "/login?faces-redirect=true");
		context.renderResponse();
		
		
	}

	public void beforePhase(PhaseEvent event) {
	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}

package com.drivingschool.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.drivingschool.dao.UserDao;
import com.drivingschool.model.User;

@ManagedBean
@ViewScoped
public class LoginBean {
	
	private User user = new User();

	public User getUser() {
		return user;
	}

	public String signIn() {
		System.out.println("Sign in " + this.user.getUser());
		
		FacesContext context = FacesContext.getCurrentInstance();
		boolean exist = new UserDao().exist(this.user);
		if(exist) {
			System.out.println("login found");
			context.getExternalContext().getSessionMap().put("userLogged", this.user);
			return "customer?faces-redirect=true";
		}
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuário não encontrado"));
		
		return "/login?faces-redirect=true";	
	}
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("userLogged");
		return "/login?faces-redirect=true";	
	}
	
	

}

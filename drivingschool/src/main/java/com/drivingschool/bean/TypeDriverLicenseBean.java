package com.drivingschool.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.drivingschool.dao.DAO;
import com.drivingschool.model.TypeDriverLicense;

@ManagedBean
@ViewScoped
public class TypeDriverLicenseBean {
	
	private TypeDriverLicense typerDriverLicense = new TypeDriverLicense();
	
	private Integer typeDriverLicenseId;
	
	//Method//
	
	public List<TypeDriverLicense> getTyperDriverLicenses(){
		System.out.println("chamando metodo DAO no licenseBean");
		return new DAO<TypeDriverLicense>(TypeDriverLicense.class).listAll();
	}
	
	public void loadTypeDriverLicenseById() {
		this.typerDriverLicense = new DAO<TypeDriverLicense>(TypeDriverLicense.class).searchForId(typeDriverLicenseId);
	}
	
	//Get && Set//

	public TypeDriverLicense getTyperDriverLicense() {
		return typerDriverLicense;
	}


	public void setTyperDriverLicense(TypeDriverLicense typerDriverLicense) {
		this.typerDriverLicense = typerDriverLicense;
	}
		
}

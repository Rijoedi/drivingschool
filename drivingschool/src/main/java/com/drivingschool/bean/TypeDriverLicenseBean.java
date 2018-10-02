package com.drivingschool.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.drivingschool.dao.DAO;
import com.drivingschool.model.TypeDriverLicense;

@ManagedBean
public class TypeDriverLicenseBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private TypeDriverLicense typeDriverLicense = new TypeDriverLicense();
	
	public List<TypeDriverLicense> getTypeDriverLicense(){
		return new DAO<TypeDriverLicense>(TypeDriverLicense.class).listAll();
	}

}

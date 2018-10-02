package com.drivingschool.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.drivingschool.model.TypeDriverLicense;

@Component("typeDriverLicenseConverter")
public class TypeDriverLicenseConverter implements Converter {

    @Autowired
    private TypeDriverLicense typeDriverLicense;
    
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	System.out.println("chamando getAsObject");
        if(value == null || value.isEmpty() || value.equals(""))
            return null;

        TypeDriverLicense typeDriverLicense = TypeDriverLicense.findById(Long.parseLong(value));
        
        return typeDriverLicense;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
    	System.out.println("chamando getAsString");
        if(value == null || value.equals("")) {
            return "";
        }
        TypeDriverLicense typeDriverLicense = (TypeDriverLicense) value;
        
        return String.valueOf(typeDriverLicense.getId());
    }
    
    // Get && Set//

	public TypeDriverLicense getTypeDriverLicense() {
		return typeDriverLicense;
	}

	public void setTypeDriverLicense(TypeDriverLicense typeDriverLicense) {
		this.typeDriverLicense = typeDriverLicense;
	}

}

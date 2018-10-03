package com.drivingschool.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.drivingschool.dao.DAO;
import com.drivingschool.model.Customer;
import com.drivingschool.model.TypeDriverLicense;

@ManagedBean
@ViewScoped
public class CustomerBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Customer customer = new Customer();

	private Integer typeDriverLicenseId;	

	//Methods//

	public List<TypeDriverLicense> getTypeDriverLicenses(){
		return new DAO<TypeDriverLicense>(TypeDriverLicense.class).listAll();
	}
	
	
	
	public void save() {
		System.out.println("Saving customer " + this.customer.getName());

		if(this.customer.getId() == null) {
		System.out.println("Saving customer " + this.customer.getName());
		new DAO<Customer>(Customer.class).add(this.customer);
		} else {
			System.out.println("Editing customer " + this.customer.getId());
			new DAO<Customer>(Customer.class).update(this.customer);
		}
		this.customer = new Customer();
}
	
	public void load(Customer customer) {
		System.out.println("Loading customer " + customer.getId());
		this.customer = customer;
	}
	
	public void remove(Customer customer) {
		System.out.println("Removing Customer");
		new DAO<Customer>(Customer.class).remove(customer);;
	}
	
	
	//Gets && Sets//
	
	public List<Customer> getCustomers(){
		return new DAO<Customer>(Customer.class).listAll();
	}

	public Integer getTypeDriverLicenseId() {
		return typeDriverLicenseId;
	}

	public void setTypeDriverLicenseId(Integer typeDriverLicenseId) {
		this.typeDriverLicenseId = typeDriverLicenseId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}

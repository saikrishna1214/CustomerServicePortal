package org.imaginea.requesttracking.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Login {
	
	@Id
	@Column(name="USERNAME")
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(mappedBy="employee")
	private Collection<ServiceRequest> servicerequest = new ArrayList<ServiceRequest>();

	public Collection<ServiceRequest> getServicerequest() {
		return servicerequest;
	}

	public void setServicerequest(Collection<ServiceRequest> servicerequest) {
		this.servicerequest = servicerequest;
	}

}

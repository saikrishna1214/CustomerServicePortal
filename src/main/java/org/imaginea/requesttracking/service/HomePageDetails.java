package org.imaginea.requesttracking.service;

import java.util.Collection;

import org.imaginea.requesttracking.entity.Login;
import org.imaginea.requesttracking.entity.ServiceRequest;

public interface HomePageDetails {
	
	public void setServiceRequests(String email,ServiceRequest servicerequest);
	
	Collection<ServiceRequest> getServiceRequests(String email);

}

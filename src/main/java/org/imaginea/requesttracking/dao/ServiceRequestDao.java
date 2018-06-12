package org.imaginea.requesttracking.dao;

import java.util.Collection;

import org.imaginea.requesttracking.entity.ServiceRequest;

public interface ServiceRequestDao {

	public void createServiceRequest(ServiceRequest serviceReq);
	
	public void updateServiceRequest(ServiceRequest serviceReq);
	
	public ServiceRequest getServiceRequest(int srnumber);
	
	public Collection<ServiceRequest> getAllServiceRequests();
	
}

package org.imaginea.requesttracking.dao;

import org.imaginea.requesttracking.entity.ServiceRequest;

public interface ServiceRequestDao {

	public void createServiceRequest(ServiceRequest serviceReq);
	
	public ServiceRequest getServiceRequest(String srnumber);
	
}

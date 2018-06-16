package org.imaginea.requesttracking.service.impl;

import java.util.Collection;

import org.imaginea.requesttracking.dao.ServiceRequestDao;
import org.imaginea.requesttracking.dao.impl.LoginDaoImpl;
import org.imaginea.requesttracking.entity.Login;
import org.imaginea.requesttracking.entity.ServiceRequest;
import org.imaginea.requesttracking.service.HomePageDetails;
import org.springframework.beans.factory.annotation.Autowired;

public class HomepageDetailsImpl implements HomePageDetails {
	
	@Autowired
	private ServiceRequestDao serviceRequestDao;
	
	public void setServiceRequests(String email,ServiceRequest servicerequest)
	{
		//Login login = logindao.getLogin(email);
		//login.getServicerequest().add(servicerequest);
	}

	public Collection<ServiceRequest> getServiceRequests(String email) {
		
		return serviceRequestDao.getUserServiceRequests(email);
	}	
}

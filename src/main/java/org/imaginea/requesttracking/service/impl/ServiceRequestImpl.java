package org.imaginea.requesttracking.service.impl;

import java.util.Collection;
import java.util.Date;

import org.imaginea.requesttracking.dao.impl.AccountDaoImpl;
import org.imaginea.requesttracking.dao.impl.LoginDaoImpl;
import org.imaginea.requesttracking.dao.impl.ServiceRequestDaoImpl;
import org.imaginea.requesttracking.entity.Account;
import org.imaginea.requesttracking.entity.Login;
import org.imaginea.requesttracking.entity.ServiceRequest;
import org.imaginea.requesttracking.service.ActivityService;
import org.imaginea.requesttracking.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;


public class ServiceRequestImpl implements ServiceRequestService {

	@Autowired
	private ServiceRequestDaoImpl serviceRequestDao;

	@Autowired
	private AccountDaoImpl accountdao;

	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private LoginDaoImpl logindao;

	

	public ServiceRequest createServiceRequest(int accountid, int contactid, String title, String description,String employee) {
		
		ServiceRequest serviceReq = new ServiceRequest();
		serviceReq.setTitle(title);
		serviceReq.setStatus("Active");
		serviceReq.setOpendate(new Date());
		serviceReq.setDescription(description);
		Account account = accountdao.getAccount(accountid);
		serviceReq.setAccount(account);
		serviceReq.setContactid(contactid);
		Login login = logindao.getLogin(employee);
		serviceReq.setEmployee(login);
		serviceRequestDao.createServiceRequest(serviceReq);
		return serviceReq;
	}


	public Collection<ServiceRequest> getAllServiceRequests() {
		
		return serviceRequestDao.getAllServiceRequests();
	}


	public ServiceRequest updateServiceRequest(int srnumber, String status, String description,String email) {
		
		ServiceRequest servicereq =  serviceRequestDao.getServiceRequest(srnumber);
		servicereq.setDescription(description);
		servicereq.setStatus(status);
		serviceRequestDao.updateServiceRequest(servicereq);
		return servicereq;
	}

}

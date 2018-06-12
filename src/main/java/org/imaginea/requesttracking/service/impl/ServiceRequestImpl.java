package org.imaginea.requesttracking.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.hibernate.cfg.CreateKeySecondPass;
import org.imaginea.requesttracking.dao.impl.AccountDaoImpl;
import org.imaginea.requesttracking.dao.impl.ActivityDaoImpl;
import org.imaginea.requesttracking.dao.impl.LoginDaoImpl;
import org.imaginea.requesttracking.dao.impl.ServiceRequestDaoImpl;
import org.imaginea.requesttracking.entity.Account;
import org.imaginea.requesttracking.entity.Activities;
import org.imaginea.requesttracking.entity.Contact;
import org.imaginea.requesttracking.entity.Login;
import org.imaginea.requesttracking.entity.ServiceRequest;
import org.imaginea.requesttracking.service.ActivityService;
import org.imaginea.requesttracking.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


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
		Login login = logindao.getLogin(employee);
		serviceReq.setTitle(title);
		serviceReq.setStatus("Active");
		serviceReq.setOpendate(java.time.LocalDate.now());
		serviceReq.setDescription(description);
		Account account = accountdao.getAccount(accountid);
		serviceReq.setAccount(account);
		serviceReq.setContactid(contactid);
		serviceReq.setEmployee(login);
		serviceRequestDao.createServiceRequest(serviceReq);
		login.getServicerequest().add(serviceReq);
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
		Login login = logindao.getLogin(email);
		login.getServicerequest().add(serviceRequestDao.getServiceRequest(srnumber));
		return servicereq;
	}

}

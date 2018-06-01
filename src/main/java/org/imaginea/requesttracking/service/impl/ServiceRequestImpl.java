package org.imaginea.requesttracking.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.hibernate.cfg.CreateKeySecondPass;
import org.imaginea.requesttracking.dao.impl.AccountDaoImpl;
import org.imaginea.requesttracking.dao.impl.ActivityDaoImpl;
import org.imaginea.requesttracking.dao.impl.ServiceRequestDaoImpl;
import org.imaginea.requesttracking.entity.Account;
import org.imaginea.requesttracking.entity.Activity;
import org.imaginea.requesttracking.entity.Contact;
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


	public void createServiceRequest(int accountid, int contactid, String title, String description) {

		ServiceRequest serviceReq = new ServiceRequest();
/*		serviceReq.setAccountid(accountid);*/
		serviceReq.setTitle(title);
		serviceReq.setStatus("Active");
		Account account = accountdao.getAccount(accountid);
		serviceReq.setAccount(account);
		serviceReq.setContactid(contactid);
		serviceRequestDao.createServiceRequest(serviceReq);
	}

}

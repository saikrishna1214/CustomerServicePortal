package org.imaginea.requesttracking.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.imaginea.requesttracking.dao.ServiceRequestDao;
import org.imaginea.requesttracking.entity.Account;
import org.imaginea.requesttracking.entity.ServiceRequest;
import org.imaginea.requesttracking.util.SessionUtils;
import org.springframework.stereotype.Repository;

/**
 * creates a row in ServiceRequest table by Connecting the 
 * given ServiceRequest type object to database by Session class.
 * @author saikrishnak
 *
 */

@Repository("servicereqimpl")
public class ServiceRequestDaoImpl implements ServiceRequestDao {
	
	/**
	 * takes object of ServiceRequest as parameter and places given
	 * data in ServiceRequest table
	 * @param serviceReq will have details of ServiceRequest entity.
	 */
	
	public void createServiceRequest(ServiceRequest serviceReq) {
		Session session = SessionUtils.getSession();
		session.beginTransaction();
		session.save(serviceReq);
		session.getTransaction().commit();				
		SessionUtils.closeSession(session);
	}
	
	/**
	 * gives account object which maps a row in ServiceRequest
	 * table in database by ServiceNumber. 
	 * @param srnumber has service number to map with required row.
	 * @return ServiceRquest object of given service number 
	 */
	
	public void updateServiceRequest(ServiceRequest serviceReq) {
		Session session = SessionUtils.getSession();
		session.beginTransaction();
		session.merge(serviceReq);
		session.getTransaction().commit();	
		SessionUtils.closeSession(session);
	}
	
	public ServiceRequest getServiceRequest(int srnumber)
	{
		Session session = SessionUtils.getSession();
		session.beginTransaction();
		return (ServiceRequest) session.get(ServiceRequest.class, srnumber);
	}

	public Collection<ServiceRequest> getAllServiceRequests() {
		Session session = SessionUtils.getSession();
		session.beginTransaction();
		Collection<ServiceRequest> servicerequests = session.createQuery("from ServiceRequest").list();
		return servicerequests;
	}
	
	public Collection<ServiceRequest> getUserServiceRequests(String emailid)
	{
		Session session = SessionUtils.getSession();
		session.beginTransaction();
		Collection<ServiceRequest> servicerequests = session.createQuery("from ServiceRequest where USERNAME=" +"'" + emailid + "'").list();
		return servicerequests;
	}

}

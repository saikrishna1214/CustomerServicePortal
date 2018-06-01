package org.imaginea.requesttracking.dao.impl;

import org.hibernate.Session;
import org.imaginea.requesttracking.dao.ServiceRequestDao;
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
	
	public ServiceRequest getServiceRequest(String srnumber)
	{
		Session session = SessionUtils.getSession();
		session.beginTransaction();
		return (ServiceRequest) session.get(ServiceRequest.class, srnumber);
	}

}

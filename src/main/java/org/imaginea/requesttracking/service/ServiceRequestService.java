package org.imaginea.requesttracking.service;

import java.util.Collection;

import org.imaginea.requesttracking.entity.ServiceRequest;
import org.springframework.context.ApplicationContext;

/**
* provides services of Servicerequest entity and
* maps it to a row in ServiceRequest table in 
* database
* @author saikrishnak
*
*/


public interface ServiceRequestService {
	
	/**
	 * creates ServiceRequest and maps it to a entity in
	 * table in database. it calls a Sessionutil method 
	 * which opens a session for it 
	 *  @param contaxt gives ApplicationContext object to it
	 */
		
	public ServiceRequest createServiceRequest(int accountid,int contactid,String title,String description,String email);
	
	public Collection<ServiceRequest> getAllServiceRequests();
	
	public ServiceRequest updateServiceRequest(int srnumber,String status,String description,String email);

}

package org.imaginea.requesttracking.service;

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
		
	public void createServiceRequest(int accountid,int contactid,String title,String description);
}

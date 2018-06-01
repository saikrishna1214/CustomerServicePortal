package org.imaginea.requesttracking.service;

import java.util.List;

import org.imaginea.requesttracking.entity.Activity;
import org.imaginea.requesttracking.entity.ServiceRequest;

/**
 * provides services of activity entity and
 * maps it to a row in Activity table in 
 * database
 * @author saikrishnak
 *
 */

public interface ActivityService {
	
	/**
	 * creates activity and maps it to a entity in
	 * table in database. it calls a Sessionutil method 
	 * which opens a session for it 
	 *  @param serviceRequest gives service request object to it
	 */

	
	public void createActivity(ServiceRequest serviceRequest);

}

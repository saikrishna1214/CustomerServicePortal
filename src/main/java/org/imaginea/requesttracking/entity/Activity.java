package org.imaginea.requesttracking.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * contains details od an Activity
 * each serviceRequest will contain a record in activity table. 
 * @author saikrishnak
 *
 */

@Entity
public class Activity {


	@Id
	@Column(name = "CREATEDATE")
	private String createdate;
	
	@Column(name = "STATUSUPDATE")
	private String statusUpdate;
	
	@ManyToOne
	@JoinColumn(name = "SRNUMBER")
	private ServiceRequest servicerequest;

	/**
	 * gives servicerequest object
	 * @return servicerequestobject
	 */
	public ServiceRequest getServicerequest() {
		return servicerequest;
	}

	/**
	 * sets service request object
	 * @param servicerequest will give service request object
	 * which is assigned to present servicerequest variable.
	 */
	public void setServicerequest(ServiceRequest servicerequest) {
		this.servicerequest = servicerequest;
	}

	/**
	 * gives date and time of creation of Activity
	 * @return createdate of string type.
	 */
	public String getCreatedate() {
		return createdate;
	}

	/**
	 * sets the date and time of creation of present
	 * Activity
	 * @param string conatins date and time in String type. 
	 */
	public void setCreatedate(String string) {
		this.createdate = string;
	}

	/**
	 * gives status update
	 * @return String contains status update details.
	 */
	public String getStatusUpdate() {
		return statusUpdate;
	}

	/**
	 * sets the status update for present activity
	 * @param statusUpdate contains status update 
	 * details of String type. 
	 */
	public void setStatusUpdate(String statusUpdate) {
		this.statusUpdate = statusUpdate;
	}

}

package org.imaginea.requesttracking.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * contains details od an Activity each serviceRequest will contain a record in
 * activity table.
 * 
 * @author saikrishnak
 *
 */

@Entity
public class Activities {

	@Id
	@GeneratedValue
	private int activityid;

	@Column(name = "UPDATEDDATE")
	private LocalDate updateddate;

	@Column(name = "STATUSUPDATE")
	private String statusUpdate;

	@ManyToOne
	@JoinColumn(name = "SRNUMBER")
	private ServiceRequest servicerequest;
	
	@Column(name = "UPDATEDBY")
	private String updatedemployee;
	
	
	public String getUpdatedemployee() {
		return updatedemployee;
	}

	public void setUpdatedemployee(String updatedemployee) {
		this.updatedemployee = updatedemployee;
	}

	public int getActivityid() {
		return activityid;
	}

	public void setActivityid(int activityid) {
		this.activityid = activityid;
	}

	public LocalDate getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(LocalDate updateddate) {
		this.updateddate = updateddate;
	}

	/**
	 * gives servicerequest object
	 * 
	 * @return servicerequestobject
	 */
	public ServiceRequest getServicerequest() {
		return servicerequest;
	}

	/**
	 * sets service request object
	 * 
	 * @param servicerequest
	 *            will give service request object which is assigned to present
	 *            servicerequest variable.
	 */
	public void setServicerequest(ServiceRequest servicerequest) {
		this.servicerequest = servicerequest;
	}

	/**
	 * gives status update
	 * 
	 * @return String contains status update details.
	 */
	public String getStatusUpdate() {
		return statusUpdate;
	}

	/**
	 * sets the status update for present activity
	 * 
	 * @param statusUpdate
	 *            contains status update details of String type.
	 */
	public void setStatusUpdate(String statusUpdate) {
		this.statusUpdate = statusUpdate;
	}

	@Column(name = "UPDATEDDESCRIPTION")
	private String updatedDescription;

	public String getUpdatedDescription() {
		return updatedDescription;
	}

	public void setUpdatedDescription(String updatedDescription) {
		this.updatedDescription = updatedDescription;
	}
}

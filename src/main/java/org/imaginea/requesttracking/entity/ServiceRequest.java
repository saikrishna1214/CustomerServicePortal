
package org.imaginea.requesttracking.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * contains details of a service request it maps with a row in service request
 * table in database
 * 
 * @author saikrishnak
 *
 */

@Entity
public class ServiceRequest {
	@Id
	@Column(name = "SRNUMBER")
	@GeneratedValue
	private int srnumber;

	@Column(name = "TITLE")
	private String title;

/*	@Column(name = "ACCOUNT_ID")
	private int accountid;*/

	@Column(name = "CONTATCT_ID")
	private int contactid;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "OPENDATE")
	private Date opendate;

	@Column(name = "CLOSEDATE")
	private Date closedate;

	@Lob
	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne 
	@JoinColumn(name="ACCOUNTID")
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@OneToMany(mappedBy = "servicerequest", cascade = CascadeType.PERSIST)
	private Collection<Activity> activity = new ArrayList<Activity>();

	/**
	 * gives collection of activities
	 * 
	 * @return activity of Collection type.
	 */
	public Collection<Activity> getActivity() {
		return activity;
	}

	/**
	 * adds activity into collection
	 * 
	 * @param activity
	 *            contains object of Collection type.
	 */
	public void setActivity(Collection<Activity> activity) {
		this.activity = activity;
	}

	/**
	 * gives service number of present service request
	 * 
	 * @return srnumber of String type.
	 */
	public int getSrnumber() {
		return srnumber;
	}

	/**
	 * sets service number for present Service Request object
	 * 
	 * @param srnumber
	 *            contains Service number of String type.
	 */
	public void setSrnumber(int srnumber) {
		this.srnumber = srnumber;
	}

	/**
	 * gives title of present service request
	 * 
	 * @return title of String type.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * sets title for present Service Request object
	 * 
	 * @param title
	 *            contains Service number of String type.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * gives Account id of present service request
	 * 
	 * @return accountid of Integer type.
	 */
/*	public int getAccountid() {
		return accountid;
	}
*/
	/**
	 * sets account id for present Service Request object
	 * 
	 * @param accountid
	 *            contains Service number of Integer type.
	 */
/*	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
*/
	/**
	 * gives contact id of present service request
	 * 
	 * @return contactid of Integer type.
	 */
	public int getContactid() {
		return contactid;
	}

	/**
	 * sets contact id for present Service Request object
	 * 
	 * @param contact
	 *            id contains Service number of Integer type.
	 */
	public void setContactid(int contactid) {
		this.contactid = contactid;
	}

	/**
	 * gives Status of present service request
	 * 
	 * @return status of String type.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * sets status for present Service Request object
	 * 
	 * @param status
	 *            contains Service number of String type.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * gives open date of present service request
	 * 
	 * @return opendate of Date type.
	 */
	public Date getOpendate() {
		return opendate;
	}

	/**
	 * sets open date of present Service Request object
	 * 
	 * @param opendate
	 *            contains Service number of Date type.
	 */
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	/**
	 * gives close date of present service request
	 * 
	 * @return close date of Date type.
	 */
	public Date getClosedateE() {
		return closedate;
	}

	/**
	 * sets close date for present Service Request object
	 * 
	 * @param closedate
	 *            contains Service number of Date type.
	 */
	public void setClosedateE(Date closedateE) {
		this.closedate = closedateE;
	}

	/**
	 * gives description of present service request
	 * 
	 * @return description of String type.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * sets description for present Service Request object
	 * 
	 * @param description
	 *            contains Service number of String type.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
package org.imaginea.requesttracking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * contains details of a contact 
 * an account can have multiple contacts.
 * hence a many to one relationship is maintained
 * by this contact object to an Account object.
 * @author saikrishnak
 *
 */
@Entity
public class Contact {
	@Id
	@Column (name="CONTATCID")
	@GeneratedValue
	private int contactid;
	@Column (name="LASTNAME")
	private String lastname;
	@Column (name="FIRSTNAME")
	private String firstname;
	@Column (name="PHONE")
	private String phone;
	@ManyToOne
	@JoinColumn(name="ACCOUNTID")
	private Account account;
	
	/**
	 * gives account object that was mapping 
	 * to current contact object.
	 * @return object of Account type.
	 */
	public Account getAccount() {
		return account;
	}
	
	/**
	 * sets Account object
	 * @param account contains account object details.
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	/**
	 * gives id of current contact
	 * @return contact id of integer type.
	 */
	public int getContactid() {
		return contactid;
	}
	
	/**
	 * sets contact id of present contact
	 * @param contactid contains integer value which
	 * represents contact id.
	 */
	public void setContactid(int contactid) {
		this.contactid = contactid;
	}
	
	/**
	 * gives last name of present contact
	 * @return last name of String type.
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * sets last name for present Contact object  
	 * @param lastname contains last name of String type.
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * gives first name of present contact
	 * @return first name of String type.
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * sets first name for present Contact object  
	 * @param first name contains last name of String type.
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * gives phone number of present contact
	 * @return phone number of String type.
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * sets phone number for present Contact object  
	 * @param phone number contains last name of String type.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * gives email of present contact
	 * @return email of String type.
	 */

}

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

	@Column (name="PHONE")
	private int phone;
	
	@Column(name = "ADDRESS1")
	private String address1;
	
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "ADDRESS2")
	private String address2;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "ZIPCODE")
	private int zipcode;
	
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
	 * gives phone number of present contact
	 * @return phone number of String type.
	 */
	public int getPhone() {
		return phone;
	}
	
	/**
	 * sets phone number for present Contact object  
	 * @param phone2 number contains last name of String type.
	 */
	public void setPhone(int phone2) {
		this.phone = phone2;
	}
	
	/**
	 * gives email of present contact
	 * @return email of String type.
	 */

}

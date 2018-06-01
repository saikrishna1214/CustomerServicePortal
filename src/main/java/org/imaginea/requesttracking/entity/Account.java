package org.imaginea.requesttracking.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Contains details of account table
 * setter and getter methods will set and 
 * return data respectively.
 * @author saikrishnak
 *
 */

@Entity
public class Account {

	/* @Id Represents that it is a primary key. */
	@Id
	@Column(name = "ACCOUNTID")
	@GeneratedValue
	private int accountid;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name="EMAILID")
	private String emailid;
	
	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Column(name = "ADDRESS1")
	private String address1;
	
	@Column(name = "ADDRESS2")
	private String address2;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "ZIPCODE")
	private int zipcode;

	@OneToMany(mappedBy="account")
	private Collection<ServiceRequest> servicereq = new ArrayList<ServiceRequest>();
	
	public Collection<ServiceRequest> getServicereq() {
		return servicereq;
	}

	public void setServicereq(Collection<ServiceRequest> servicereq) {
		this.servicereq = servicereq;
	}

	@OneToMany(mappedBy="account")
	private Collection<Contact> contact = new ArrayList<Contact>();

	/*
	 * returns collection of contacts
	 */
	public Collection<Contact> getContact() {
		return contact;
	}

	/**
	 * sets collection of contact
	 * @param contact is passed to map with 
	 * particular contact
	 */
	public void setContact(Collection<Contact> contact) {
		this.contact = contact;
	}

	/**
	 * returns account id.
	 * @return accountid
	 */
	public int getAccountid() {
		return accountid;
	}

	/**
	 * sets account id for an object
	 * @param accountid will have an integer value
	 * represents account id.
	 */
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	/**
	 * gives the name of Account holder.
	 * @return name of String data type 
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets name for a Account
	 * @param name of String type will have
	 * a name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gives address which of String type
	 * @return address1 of present account
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * sets address of account
	 * @param address1 will have addresss of present account.
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	/**
	 * gives city of present account
	 * @return city of String type.
	 */

	public String getCity() {
		return city;
	}

	/**
	 * sets city of present account
	 * @param city holds name of city of String type. 
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * gives state of present account
	 * @return state of string type
	 */
	public String getState() {
		return state;
	}

	/**
	 * sets state of present account object
	 * @param state holds state name of String type.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * returns Zipcode present account object 
	 * @return zipcode of string type
	 */
	public int getZipcode() {
		return zipcode;
	}
	
	/**
	 * sets zip code for present object of account type
	 * @param zipcode2 holds zipcode value of String type.
	 */

	public void setZipcode(int zipcode2) {
		this.zipcode = zipcode2;
	}
}

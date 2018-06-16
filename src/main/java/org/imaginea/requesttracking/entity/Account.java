package org.imaginea.requesttracking.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
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
	
	@Column(name="EMAILID")
	private String emailid;
	
	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Column(name="GENDER")
	private String gender;
	
	@Column (name="LASTNAME")
	private String lastname;
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column (name="FIRSTNAME")
	private String firstname;

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

}

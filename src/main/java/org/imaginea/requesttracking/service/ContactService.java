package org.imaginea.requesttracking.service;

import org.imaginea.requesttracking.entity.Account;
import org.imaginea.requesttracking.entity.Contact;

/**
 * provides services of contact entity and
 * maps it to a row in Contact table in 
 * database
 * @author saikrishnak
 *
 */

public interface ContactService {
	
	/**
	 * creates contact and maps it to a entity in
	 * table in database. it calls a Sessionutil method 
	 * which opens a session for it 
	 */
	
	public Contact createContact(int phone, String address1,String address2,String state ,String city,int Zipcode, Account account);
	
}

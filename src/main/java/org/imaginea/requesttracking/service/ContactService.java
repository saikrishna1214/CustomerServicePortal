package org.imaginea.requesttracking.service;

import org.imaginea.requesttracking.entity.Account;

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
	
	public void createContact(String phone,String firstname,String last,Account account);

}

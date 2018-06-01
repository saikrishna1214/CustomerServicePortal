package org.imaginea.requesttracking.service;

/**
 * provides services of account entity and
 * maps it to a row in Account table in 
 * database
 * @author saikrishnak
 *
 */

public interface AccountService {
	
	/**
	 * creates Account and maps it to a entity in
	 * table in database. it calls a Sessionutil method 
	 * which opens a session for it 
	 */
	public void createAccount();

}

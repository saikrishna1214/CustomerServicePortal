/**
 * 
 */
package org.imaginea.requesttracking.dao;

import org.imaginea.requesttracking.entity.Login;

/**
 * @author saikrishnak
 *
 */
public interface LoginDao {
	
	public void createLogin(Login login);
	
	public Login getLogin(String username);

}

/**
 * 
 */
package org.imaginea.requesttracking.dao;

import java.util.Collection;

import org.imaginea.requesttracking.entity.Login;
import org.imaginea.requesttracking.entity.ServiceRequest;

/**
 * @author saikrishnak
 *
 */
public interface LoginDao {
	
	public void createLogin(Login login);
	
	public Login getLogin(String username);

}

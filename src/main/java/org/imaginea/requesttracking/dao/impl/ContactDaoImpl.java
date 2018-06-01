package org.imaginea.requesttracking.dao.impl;

import org.hibernate.Session;
import org.imaginea.requesttracking.dao.ContactDao;
import org.imaginea.requesttracking.entity.Contact;
import org.imaginea.requesttracking.util.SessionUtils;
import org.springframework.stereotype.Repository;

/**
 * creates a row in Contact table by Connecting the 
 * given Contact type object to database by Session class.
 * @author saikrishnak
 *
 */

@Repository
public class ContactDaoImpl implements ContactDao{
	
	/**
	 * creates object of Contact type and places given
	 * data in Contact table
	 * @param contact
	 */
	
	public void createContactDao(Contact contact)
	{
		Session session = SessionUtils.getSession();
		session.beginTransaction();
		session.save(contact);
		session.getTransaction().commit();
		SessionUtils.closeSession(session);
	}
	


}

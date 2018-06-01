package org.imaginea.requesttracking.dao.impl;

import org.hibernate.Session;
import org.imaginea.requesttracking.dao.ActivityDao;
import org.imaginea.requesttracking.entity.Activity;
import org.imaginea.requesttracking.util.SessionUtils;
import org.springframework.stereotype.Repository;

/**
 * creates a row in Activity table by Connecting the 
 * given Activity type object to database by Session class.
 * @author saikrishnak
 *
 */

@Repository
public class ActivityDaoImpl implements ActivityDao{
	
	/**
	 * inserts data into Activity table by mapping 
	 * activity object with a row in table.
	 * @param activity is Object of type Activity 
	 * will have data about Activity.
	 */
	
	public void createActivityDao(Activity activity)
	{
		Session session = SessionUtils.getSession();
		session.beginTransaction();
		session.save(activity);
		session.getTransaction().commit();
		SessionUtils.closeSession(session);
	}

}

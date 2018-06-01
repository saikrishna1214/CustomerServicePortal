package org.imaginea.requesttracking.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtils {
	
	private static SessionFactory sessionFactory = null;
	
	public static Session getSession() {
		if(null == sessionFactory) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory.openSession();
	}
	
	public static void closeSession(Session session) {
		session.close();
	}

}

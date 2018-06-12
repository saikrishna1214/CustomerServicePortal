package org.imaginea.requesttracking.dao.impl;

import java.util.Collection;

import org.hibernate.Session;
import org.imaginea.requesttracking.dao.LoginDao;
import org.imaginea.requesttracking.entity.Login;
import org.imaginea.requesttracking.entity.ServiceRequest;
import org.imaginea.requesttracking.util.SessionUtils;
import org.springframework.stereotype.Repository;
@Repository (value="logindao")
public class LoginDaoImpl implements LoginDao {

	public void createLogin(Login login) {
		
		Session session = SessionUtils.getSession();
		session.beginTransaction();
		session.save(login);
		session.getTransaction().commit();
		SessionUtils.closeSession(session);

	}

	public Login getLogin(String username) {
		Session session = SessionUtils.getSession();
		session.beginTransaction();
		Login login = (Login)session.get(Login.class, username);
		return login;
	}


}

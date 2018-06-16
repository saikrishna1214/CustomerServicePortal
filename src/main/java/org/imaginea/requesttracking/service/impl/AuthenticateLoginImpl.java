package org.imaginea.requesttracking.service.impl;

import org.imaginea.requesttracking.dao.LoginDao;
import org.imaginea.requesttracking.entity.Login;
import org.imaginea.requesttracking.service.AuthenticateLogin;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticateLoginImpl implements AuthenticateLogin {

	@Autowired
	private LoginDao logindao;
	
	public boolean loginAuthentiction(String user, String password) {
		
		Login login = logindao.getLogin(user);
		if(login!=null)
		{
			if(login.getPassword().equals(password))
		return true;
		}
		return false;
	}

}

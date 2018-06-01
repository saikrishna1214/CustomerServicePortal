package org.imaginea.requesttracking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.imaginea.requesttracking.dao.LoginDao;
import org.imaginea.requesttracking.dao.impl.LoginDaoImpl;
import org.imaginea.requesttracking.entity.Login;
import org.imaginea.requesttracking.service.AuthenticateLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class HomePage
 */
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		AuthenticateLogin authenticate = (AuthenticateLogin) context.getBean("authenticatelogin");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		if (authenticate.loginAuthentiction(userName, password))
			resp.sendRedirect("home.html");
		else
			resp.sendRedirect("login.html");
	}

}

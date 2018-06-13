package org.imaginea.requesttracking.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.imaginea.requesttracking.entity.Login;
import org.imaginea.requesttracking.entity.ServiceRequest;
import org.imaginea.requesttracking.service.AuthenticateLogin;
import org.imaginea.requesttracking.service.HomePageDetails;
import org.imaginea.requesttracking.service.impl.HomepageDetailsImpl;
import org.imaginea.requesttracking.service.impl.ServiceRequestImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class LoginRedirect
 */
public class LoginRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		AuthenticateLogin authenticate = (AuthenticateLogin) context.getBean("authenticatelogin");
		HomepageDetailsImpl getservice = (HomepageDetailsImpl) context.getBean("homepagedetails");
 		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if (authenticate.loginAuthentiction(email, password))
		{	
			
			  HttpSession oldSession = request.getSession(false);
	            if (oldSession != null) {
	                oldSession.invalidate();
	            }
	            
	           HttpSession newSession = request.getSession();
				newSession.setAttribute("email", email);
	            Collection<ServiceRequest> servicerequests = getservice.getServiceRequests(email);
				newSession.setAttribute("servicerequest", servicerequests);
				

			response.sendRedirect("Home.jsp");
		}
		else
			response.sendRedirect("login.jsp");
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		AuthenticateLogin authenticate = (AuthenticateLogin) context.getBean("authenticatelogin");
		HomepageDetailsImpl getservice = (HomepageDetailsImpl) context.getBean("homepagedetails");
		if( req.getSession().getAttribute("email")==null)
		{
			resp.sendRedirect("login.jsp");
		}
		else {
		String email =  (String) req.getSession().getAttribute("email");
		Collection<ServiceRequest> servicerequests = getservice.getServiceRequests(email);
		req.getSession().setAttribute("servicerequest", servicerequests);
		if(servicerequests!=null)
		{
		resp.sendRedirect("Home.jsp");
		
		}
		else {
			resp.sendRedirect("ViewCustomers.jsp");
		}
		}
	}
}
